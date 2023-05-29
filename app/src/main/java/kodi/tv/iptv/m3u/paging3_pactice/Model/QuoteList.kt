package kodi.tv.iptv.m3u.paging3_pactice.Model

data class QuoteList(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<Result>,
    val totalCount: Int,
    val totalPages: Int
)