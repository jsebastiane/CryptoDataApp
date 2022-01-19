package sebastian.company.cryptodataapp.data.repository

import sebastian.company.cryptodataapp.data.remote.CoinPaprikaApi
import sebastian.company.cryptodataapp.data.remote.dto.CoinDetailDto
import sebastian.company.cryptodataapp.data.remote.dto.CoinDto
import sebastian.company.cryptodataapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}