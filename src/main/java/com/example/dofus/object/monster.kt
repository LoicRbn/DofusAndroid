package com.example.dofus.`object`
import com.google.gson.annotations.SerializedName

data class monster (
    @SerializedName("type")var type: String,
    @SerializedName("name") var name:String,
    @SerializedName("imgUrl")var imgUrl : String,
    @SerializedName("statistics") var stat: List<Statistic>,
    var pvMin : Double,
    var pvMax: Double,
    var paMin : Double,
    var paMax: Double,
    var pmMin : Double,
    var pmMax: Double

)

data class Define (
    val min: Double = 0.0,
    val max: Double = 0.0
)

data class Statistic (
    @SerializedName("PV")
    val pv: Define? = null,

    @SerializedName("PA")
    val pa: Define? = null,

    @SerializedName("PM")
    val pm: Define? = null
)