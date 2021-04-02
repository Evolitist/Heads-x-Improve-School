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
        //Возвращаю mutableList т.к после оверрайда submitList в адаптере он принимает только его
        fun getSampleList() = mutableListOf(
            ServiceDiscount(
                title = "Царь пышка",
                discountText = "Скидка 10% на выпечку по коду",
                addressText = "Лермонтовский пр, 52, МО №1",
                imageUrl = "https://www.chefmarket.ru/blog/wp-content/uploads/2019/02/croissant-hjme-e1549211717301.jpg"
            ),
            ServiceDiscount(
                title = "Химчистка «МАЙ?»",
                discountText = "Скидка 5% на чистку пальто",
                addressText = "Лермонтовский пр, 48",
                imageUrl = "https://memepedia.ru/wp-content/uploads/2019/11/honklhonk.jpg"
            ),
            ServiceDiscount(
                title = "Шаверма У Ашота",
                discountText = "При покупке шавермы, фалафель бесплатно",
                addressText = "Лермонтовский пр, 52, МО №1",
                imageUrl = "https://peterburg.center/sites/default/files/styles/long_image/public/0-shavatime_1_0.jpg?itok=SXimUBWW"
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