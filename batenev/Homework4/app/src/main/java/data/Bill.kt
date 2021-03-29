package data

import data.BillType.*

data class Bill(
    val type: BillType,
    val data: String? = null
) {
    companion object {
        fun getExampleList(): List<Bill> {
            return listOf(
                Bill(BILL, "-40 080,55"),
                Bill(COUNTER, "Подайте показания"),
                Bill(INSTALLMENT, "25.02.2018"),
                Bill(INSURANCE, "12.01.2019"),
                Bill(INTERNET_AND_TV, "350"),
                Bill(INTERCOM, "Подключен"),
                Bill(SECURITY, "Нет"),
                Bill(UK_CONTACTS),
                Bill(MY_REQUESTS),
                Bill(ABOUT, "A101")
            )
        }
    }
}

enum class BillType {
    BILL,
    COUNTER,
    INSTALLMENT,
    INSURANCE,
    INTERNET_AND_TV,
    INTERCOM,
    SECURITY,
    UK_CONTACTS,
    MY_REQUESTS,
    ABOUT
}
