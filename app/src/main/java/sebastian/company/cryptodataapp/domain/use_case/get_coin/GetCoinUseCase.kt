package sebastian.company.cryptodataapp.domain.use_case.get_coin

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import sebastian.company.cryptodataapp.common.Resource
import sebastian.company.cryptodataapp.data.remote.dto.toCoin
import sebastian.company.cryptodataapp.data.remote.dto.toCoinDetail
import sebastian.company.cryptodataapp.domain.model.Coin
import sebastian.company.cryptodataapp.domain.model.CoinDetail
import sebastian.company.cryptodataapp.domain.repository.CoinRepository
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try{
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        }catch(e: HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred"))
        }catch(e: IOException){
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection"))
        }
    }
}