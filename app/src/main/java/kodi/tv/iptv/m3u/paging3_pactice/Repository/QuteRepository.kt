package kodi.tv.iptv.m3u.paging3_pactice.Repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import kodi.tv.iptv.m3u.paging3_pactice.Paging.QuotePagingSource
import kodi.tv.iptv.m3u.paging3_pactice.Retrofit.Api
import javax.inject.Inject

class QuteRepository @Inject constructor(private val api: Api) {

    fun getQuets() = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 80),
        pagingSourceFactory = { QuotePagingSource(api) }
    ).liveData
}