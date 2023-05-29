package kodi.tv.iptv.m3u.paging3_pactice.DI

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kodi.tv.iptv.m3u.paging3_pactice.Retrofit.Api
import kodi.tv.iptv.m3u.paging3_pactice.Uitls.Constance.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiClient(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }
}