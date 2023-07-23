package pl.bydgoszcz.guideme.jservice.model

data class Place (
    val id: Int,
    val lat: Double,
    val lon: Double,
    val name: String,
    val partnerId: String,
    val placeId: String,
    val wifiCheckingEnabled: Boolean,
    val wifis: List<WifiConfig>?,
    val zipCode: String?,
    val countryCode: String?,
    val features: List<String>?,
    val street: String?,
    val city: String?,
)