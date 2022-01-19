package sebastian.company.cryptodataapp.domain.repository

import sebastian.company.cryptodataapp.data.remote.dto.CoinDetailDto
import sebastian.company.cryptodataapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto

}