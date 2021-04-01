package data

import java.util.*

data class ServiceDiscount(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val discountText: String,
    val addressText: String,
    val imageUrl: String,
) {
    companion object {
        fun getSampleList() = listOf(
            ServiceDiscount(
                title = "Царь пышка",
                discountText = "Скидка 10% на выпечку по коду",
                addressText = "Лермонтовский пр, 52, МО №1",
                imageUrl = ""
            ),
            ServiceDiscount(
                title = "Химчистка «МАЙ?»",
                discountText = "Скидка 5% на чистку пальто",
                addressText = "Лермонтовский пр, 48",
                imageUrl = ""
            ),
            ServiceDiscount(
                title = "Шаверма У Ашота",
                discountText = "При покупке шавермы, фалафель бесплатно",
                addressText = "Лермонтовский пр, 52, МО №1",
                imageUrl = ""
            )
        )

        fun getEmpty() = ServiceDiscount(
            title = "",
            discountText = "",
            addressText = "",
            imageUrl = ""
        )
    }
}