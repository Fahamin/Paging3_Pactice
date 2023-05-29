package kodi.tv.iptv.m3u.paging3_pactice.Retrofit

import kodi.tv.iptv.m3u.paging3_pactice.Model.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page: Int): QuoteList


}