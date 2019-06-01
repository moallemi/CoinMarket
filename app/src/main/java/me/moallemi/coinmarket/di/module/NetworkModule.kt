package me.moallemi.coinmarket.di.module

import dagger.Module
import dagger.Provides
import me.moallemi.coinmarket.remote.api.CoinMarketService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideInterceptor(): Interceptor {
        return Interceptor { chain ->
            val original = chain.request()

            val requestBuilder = original.newBuilder()
                .header("X-CMC_PRO_API_KEY", "664ac797-4c03-4106-8dcd-ad1397c65790")

            val request = requestBuilder.build()
            chain.proceed(request)
        }
    }

    @Provides
    fun provideOkHttp(headerInterceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)
            .build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(CoinMarketService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideCoinMarketService(retrofit: Retrofit): CoinMarketService {
        return retrofit.create(CoinMarketService::class.java)
    }
}