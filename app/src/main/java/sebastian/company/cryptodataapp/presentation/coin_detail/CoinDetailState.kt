package sebastian.company.cryptodataapp.presentation.coin_detail

import sebastian.company.cryptodataapp.domain.model.Coin
import sebastian.company.cryptodataapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""

)
