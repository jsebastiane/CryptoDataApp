package sebastian.company.cryptodataapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sebastian.company.cryptodataapp.common.Constants
import sebastian.company.cryptodataapp.data.remote.CoinPaprikaApi
import sebastian.company.cryptodataapp.data.repository.CoinRepositoryImpl
import sebastian.company.cryptodataapp.domain.repository.CoinRepository
import javax.inject.Singleton

@Module
//Lives as long as the application
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    //Only single instance of what the function returns
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository{
        return CoinRepositoryImpl(api)
    }
}