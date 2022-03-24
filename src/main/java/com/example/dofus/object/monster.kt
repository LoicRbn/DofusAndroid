package com.example.dofus.`object`
import com.google.gson.annotations.SerializedName

data class monster (
    @SerializedName("type")var type: String,
    @SerializedName("name") var name:String,
    @SerializedName("imgUrl")var imgUrl : String,
    @SerializedName("stats") var stat: List<Statistic>,
    var pvMin : Double,
    var pvMax: Double,
    var paMin : Double,
    var paMax: Double,
    var pmMin : Double,
    var pmMax: Double

)

data class DropPercent (
    val min: Double = 0.0,
    val max: Double = 0.0
)

data class Statistic (
    @SerializedName("PV")
    val pv: DropPercent? = null,

    @SerializedName("PA")
    val pa: DropPercent? = null,

    @SerializedName("PM")
    val pm: DropPercent? = null
)