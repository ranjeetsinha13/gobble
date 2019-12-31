package com.rs.gobble.di

import android.content.Context
import com.rs.gobble.BuildConfig
import com.rs.gobble.network.GobbleApi
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
object NetworkModule {
    private const val BASE_URL = "https://api.spoonacular.com"
    private const val GOBBLE_BASE_URL = "gobble_base_url"

    private const val API_KEY = "apiKey"

    @JvmStatic
    @Provides
    @Named(GOBBLE_BASE_URL)
    fun provideBaseUrlString() = BASE_URL

    @JvmStatic
    @Provides
    @Singleton
    fun provideGobbleApi(
        okHttpClient: OkHttpClient,
        @Named(GOBBLE_BASE_URL) baseUrl: String
    ): GobbleApi {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build().create(GobbleApi::class.java)
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) {
                level = HttpLoggingInterceptor.Level.BODY
            }
        }
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        cache: Cache
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor {
                var request = it.request()
                val url = it.request().url.newBuilder()
                    .addQueryParameter(API_KEY, BuildConfig.GOBBLE_API_KEY).build()
                request = request.newBuilder().url(url).build()
                it.proceed(request)
            }
            .cache(cache)
            .build()
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideCache(context: Context): Cache {
        val cacheSize = 5 * 1024 * 1024 // 5 MB
        return Cache(context.cacheDir, cacheSize.toLong())
    }
}