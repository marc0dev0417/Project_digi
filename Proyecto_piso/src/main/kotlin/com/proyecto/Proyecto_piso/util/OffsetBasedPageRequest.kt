package com.proyecto.Proyecto_piso.util

import org.apache.commons.lang3.builder.EqualsBuilder
import org.apache.commons.lang3.builder.HashCodeBuilder
import org.apache.commons.lang3.builder.ToStringBuilder
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import java.io.Serializable

class OffsetBasedPageRequest {
    /**
     * Created by Ergin
     * Modified by Marco Benegas
     */
    class OffsetBasedPageRequest @JvmOverloads constructor(offset: Int, limit: Int, sort: Sort = Sort.by(Sort.Direction.ASC, "id")) : Pageable, Serializable {
        private val limit: Int
        private val offset: Int
        private val sort: Sort

        /**
         * Creates a new [OffsetBasedPageRequest] with sort parameters applied.
         *
         * @param offset     zero-based offset.
         * @param limit      the size of the elements to be returned.
         * @param direction  the direction of the [Sort] to be specified, can be null.
         * @param properties the properties to sort by, must not be null or empty.
         */
        constructor(offset: Int, limit: Int, direction: Sort.Direction?, properties: String?) : this(offset, limit,
            direction?.let { Sort.by(it, properties!!) }!!) {}

        override fun getPageNumber(): Int {
            return offset / limit
        }

        override fun getPageSize(): Int {
            return limit
        }

        override fun getOffset(): Long {
            return offset.toLong()
        }

        override fun getSort(): Sort {
            return sort
        }

        override fun next(): Pageable {
            return OffsetBasedPageRequest((getOffset() + pageSize).toInt(), pageSize, getSort())
        }

        fun previous(): OffsetBasedPageRequest {
            return if (hasPrevious()) OffsetBasedPageRequest((getOffset() - pageSize).toInt(), pageSize, getSort()) else this
        }

        override fun previousOrFirst(): Pageable {
            return if (hasPrevious()) previous() else first()
        }

        override fun first(): Pageable {
            return OffsetBasedPageRequest(0, pageSize, getSort())
        }

        override fun withPage(pageNumber: Int): Pageable {
            return OffsetBasedPageRequest(pageNumber, pageSize, getSort())
        }

        override fun hasPrevious(): Boolean {
            return offset > limit
        }

        override fun equals(o: Any?): Boolean {
            if (this === o) return true
            if (o !is OffsetBasedPageRequest) return false
            val that = o
            return EqualsBuilder()
                .append(limit, that.limit)
                .append(offset, that.offset)
                .append(sort, that.sort)
                .isEquals
        }

        override fun hashCode(): Int {
            return HashCodeBuilder(17, 37)
                .append(limit)
                .append(offset)
                .append(sort)
                .toHashCode()
        }

        override fun toString(): String {
            return ToStringBuilder(this)
                .append("limit", limit)
                .append("offset", offset)
                .append("sort", sort)
                .toString()
        }

        companion object {
            private const val serialVersionUID = -25822477129613575L
        }
        /**
         * Creates a new [OffsetBasedPageRequest] with sort parameters applied.
         *
         * @param offset zero-based offset.
         * @param limit  the size of the elements to be returned.
         * @param sort   can be null.
         */
        /**
         * Creates a new [OffsetBasedPageRequest] with sort parameters applied.
         *
         * @param offset zero-based offset.
         * @param limit  the size of the elements to be returned.
         */
        init {
            require(offset >= 0) { "Offset index must not be less than zero!" }
            require(limit >= 1) { "Limit must not be less than one!" }
            this.limit = limit
            this.offset = offset
            this.sort = sort
        }
    }
}