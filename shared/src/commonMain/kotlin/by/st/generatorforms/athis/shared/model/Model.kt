package by.st.generatorforms.athis.shared.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Currency(
    @SerialName("Cur_ID")
    val curID: Int,

    @SerialName("Date")
    val date: String,

    @SerialName("Cur_Abbreviation")
    val curAbbreviation: String,

    @SerialName("Cur_Scale")
    val curScale: Int,

    @SerialName("Cur_Name")
    val curName: String,

    @SerialName("Cur_OfficialRate")
    val curOfficialRate: Double
)