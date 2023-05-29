package kodi.tv.iptv.m3u.paging3_pactice.Paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kodi.tv.iptv.m3u.paging3_pactice.Model.Result
import kodi.tv.iptv.m3u.paging3_pactice.Retrofit.Api
import javax.inject.Inject

class QuotePagingSource (private val api: Api) : PagingSource<Int, Result>() {

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): PagingSource.LoadResult<Int, Result> {
        try {
            val position = params.key ?: 1
            val response = api.getQuotes(position)
            return PagingSource.LoadResult.Page(
                data = response.results,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (position == response.totalPages) null else position + 1
            )
        } catch (e: Exception) {
            return PagingSource.LoadResult.Error(e)
        }
    }
}