package com.example.e_comerceApp.ui.models

import com.example.e_comerceApp.R

data class ElectronicsOffers(
    val title: String = "",
    val price: String = "",
    val discount: String = "",
    val image: Int,
    val description: String = ""
) {
    companion object {
        val productsList = listOf(
            ElectronicsOffers(
                "Iphone 15 pro Max ",
                "$1,199",
                "20%",
                R.drawable.iphone15_pro_max_1199
            ),
            ElectronicsOffers("Iphone 13 ", "$599", "10%", R.drawable.iphone13),
            ElectronicsOffers(
                "samsung galaxy A53 5g ",
                "$308",
                "40%",
                R.drawable.samsung_galaxy_a53_5g
            ),
            ElectronicsOffers("13-inch MacBook ", "$999", "22%", R.drawable.apple_laptop),
            ElectronicsOffers("playStation4", "$328.95.", "45%", R.drawable.play_station4),
            ElectronicsOffers("playStation 5", "$499.00", "15%", R.drawable.play_station5),
            ElectronicsOffers(
                "Samsung TV-65-inch",
                "$230",
                "20%",
                R.drawable.samsung_tv
            ),
            ElectronicsOffers("apple watch series 8", "$399", "40%", R.drawable.apple_watch8),
            ElectronicsOffers("Lg slim french423", "$3,599.", "40%", R.drawable.lg_slim_french423),
            ElectronicsOffers(
                "apple watch series9",
                "$499",
                "30%",
                R.drawable.apple_watch_series7_gps
            ),
        )
    }
}
