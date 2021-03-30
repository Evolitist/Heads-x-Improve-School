package data

import data.BillType.*

data class Bill(
    val type: BillType,
    val data: BillData
) {
    companion object {
        fun getExampleList(): List<Bill> {
            return listOf(
                Bill(BILL, BillData.Data(-40080.55)),
                Bill(COUNTER, BillData.Data(true)),
                Bill(INSTALLMENT, BillData.Data("25.02.2018")),
                Bill(INSURANCE, BillData.Data("12.01.2019")),
                Bill(INTERNET_AND_TV, BillData.Data("350")),
                Bill(INTERCOM, BillData.Data("Подключен")),
                Bill(SECURITY, BillData.Data("Нет")),
                Bill(UK_CONTACTS, BillData.Empty),
                Bill(MY_REQUESTS, BillData.Empty),
                Bill(ABOUT, BillData.Data("A101"))
            )
        }
    }
}

sealed class BillData {
    object Empty : BillData()
    data class Data<out T>(val data: T) : BillData() {
        fun getString() = data as String
        fun getDouble() = data as Double
        fun getBoolean() = data as Boolean
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
