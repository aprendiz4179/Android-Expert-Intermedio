package com.alexanderdev.horoscapp.data.providers.network

import com.alexanderdev.horoscapp.BuildConfig.BASE_URL
import com.alexanderdev.horoscapp.data.providers.RepositoryImpl
import com.alexanderdev.horoscapp.data.providers.core.interceptors.AuthInterceptor
import com.alexanderdev.horoscapp.domain.model.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit{
       return Retrofit.
       Builder().
       baseUrl(BASE_URL)
           .client(okHttpClient)
           .addConverterFactory(GsonConverterFactory.create())
           .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor):OkHttpClient{

        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

       return OkHttpClient
           .Builder()
           .addInterceptor(interceptor)
           .addInterceptor(authInterceptor)
           .build()
    }

    @Provides
    fun provideHoroscopoApiService(retrofit: Retrofit):HoroscopoApiService{
        return     retrofit.create(HoroscopoApiService::class.java)
    }

    @Provides
    fun provideRepository(apiService: HoroscopoApiService): Repository {
        return RepositoryImpl(apiService)
    }
}