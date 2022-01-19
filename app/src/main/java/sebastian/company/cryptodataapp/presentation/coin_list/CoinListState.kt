package sebastian.company.cryptodataapp.presentation.coin_list

import sebastian.company.cryptodataapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""

)
