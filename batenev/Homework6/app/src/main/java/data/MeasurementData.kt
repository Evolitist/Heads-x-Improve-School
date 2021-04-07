package data

import com.example.homework6.R
import com.example.homework6.ui.common.StatisticsItemView

data class MeasurementData(
    val title: String,
    val serialNumber: String, //Как я понимаю этот параметр должен быть уникальным. Использую вместо ID
    val measurementInfo: MeasurementInfo,
    val iconResId: Int,
    val inputType: StatisticsItemView.ViewType
) {
    companion object {
        fun getSampleList() = listOf(
            MeasurementData(
                "Холодная вода",
                "54656553",
                MeasurementInfo.Warning("25.03.18"),
                R.drawable.ic_water_cold,
                StatisticsItemView.ViewType.SINGLE_EDIT_TEXT
            ),
            MeasurementData(
                "Горячая вода",
                "54656544",
                MeasurementInfo.Warning("25.03.18"),
                R.drawable.ic_water_hot,
                StatisticsItemView.ViewType.SINGLE_EDIT_TEXT
            ),
            MeasurementData(
                "Электроэнергия",
                "54656553",
                MeasurementInfo.Correct("16.02.18", "25.02.18"),
                R.drawable.ic_electro,
                StatisticsItemView.ViewType.TRIPLE_EDIT_TEXT
            )
        )
    }
}

sealed class MeasurementInfo {
    data class Warning(val data: String) : MeasurementInfo()
    data class Correct(
        val firstDate: String,
        val secondDate: String
    ) : MeasurementInfo()
}