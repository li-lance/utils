package com.seraphim.utils.unitconversion

interface UnitsLocalized {
    /**
     * @param km A kilometers value
     * @return A string containing the value and units based on the unit settings and localization.
     * For example "60 km".
     */
    fun localizeKm(km: Int): String

    /**
     * @param km A kilometers value
     * @return A string containing the value and units based on the unit settings and localization.
     * For example "1.5 km"
     */
    fun localizeKm(km: Double): String

    /**
     * @param m A kilometers value
     * @return A string containing the value and units based on the unit settings and localization.
     * For example "600 m".
     */
    fun localizeMeters(m: Int): String

    /**
     * @param m A meters value
     * @return A [Pair] containing the converted value and the corresponding units according to the unit settings.
     */
    fun localizeMetersSeparateUnit(m: Int): Pair<Int, String>

    /**
     * @param km A kilometers value
     * @return A [Pair] containing the converted value and the corresponding units according to the unit settings.
     */
    fun localizeKmSeparateUnit(km: Int): Pair<Int, String>

    /**
     * @param km A kilometers value
     * @return A [Pair] containing the converted value and the corresponding units according to the unit settings.
     */
    fun localizeKmSeparateUnit(km: Double): Pair<Double, String>

    /**
     * @return A [String] containing the unit which is used for ranges.
     */
    fun localizeKmUnit(): String

    /**
     * @param kpl A kilometers per liter value
     * @return A string containing the value and units based on the unit settings and localization.
     * For example "13 mpg", "13 l / 100km" or "10 km / l".
     */
    fun localizeFuelConsumption(kpl: Float): String

    /**
     * @param kpl A kilometers per liter value
     * @return A pair containing the value and units based on the unit settings and localization.
     * For example `13 to "mpg"`, `13 to "l / 100km"` or `10 to "km / l"`.
     * A zero will be returned if [kpl] was zero.
     */
    fun localizeFuelConsumptionSeparateUnit(kpl: Float): Pair<Float, String>

    /**
     * @param kmPKwh A kilometers per kWh value
     * @return A string containing the value and units based on the unit settings and localization.
     * For example "12 kWh / 100 mi" or "14 mi / kWh".
     */
    fun localizeElectricConsumption(kmPKwh: Float): String

    /**
     * @param kmPKwh A kilometers per kWh value
     * @return A pair containing the value and units based on the unit settings and localization.
     * For example `12 to "kWh / 100 mi"` or `14 to "mi / kWh"`.
     * A zero will be returned if [kmPKwh] was zero.
     */
    fun localizeElectricConsumptionSeparateUnit(kmPKwh: Float): Pair<Float, String>

    /**
     * @return The charging rate units based on the unit settings and localization.
     * For example "km/min" or "mi/min".
     */
    fun localizeChargingRateUnit(): String

    /**
     * @param bar A pressure value in bar.
     * @return A string containing the value and units based on the unit settings and localization.
     * For example "2.31 psi".
     */
    fun localizePressure(bar: Double): String

    /**
     * @param percent The battery level percent value.
     * @return A string containing the value and units based on the unit settings and localization.
     * For example "12 %".
     */
    fun localizeBatteryLvl(percent: Int): String

    /**
     * @param percent The battery level percent value.
     * @return A [Pair] containing the converted value and the corresponding units according to the unit settings.
     */
    fun localizeBatteryLvlSeparateUnit(percent: Int): Pair<Int, String>

    /**
     * @return A [String] containing the unit which is used for battery levels.
     */
    fun localizeBatteryUnit(): String

    /**
     * @param percent The fuel level percent value.
     * @return A string containing the value and units based on the unit settings and localization.
     * For example "12 %".
     */
    fun localizeFuelLvl(percent: Int): String

    /**
     * @param percent The fuel level percent value.
     * @return A [Pair] containing the converted value and the corresponding units according to the unit settings.
     */
    fun localizeFuelLvlSeparateUnit(percent: Int): Pair<Int, String>

    /**
     * @return A [String] containing the unit which is used for fuel levels.
     */
    fun localizeFuelUnit(): String

    /**
     * @param celsius A temperature value in celsius.
     * @return A string containing the value and units based on the unit settings and localization.
     * For example "12.5°C" or "40°F".
     */
    fun localizeTemperature(celsius: Float): String

    /**
     * @param celsius A temperature value in celsius.
     * @return A string containing the value based on the unit settings and localization.
     * For example "12.5" or "40".
     */
    fun localizeTemperatureValue(celsius: Float): String

    /**
     * @param celsius A temperature value in celsius.
     * @return A float containing the value based on the unit settings and localization.
     * For example 12.5 or 40.
     */
    fun localizeTemperatureFloatValue(celsius: Float): Float

    /**
     * @return A string containing the unit based on the unit settings and localization.
     * For example "°C" or "°F".
     */
    fun localizeTemperatureUnit(): String

    /**
     * @return A float containing step based on units settings and localization.
     * For example 0.5 or 1.0.
     */
    fun localizeTemperatureStep(): Float

    /**
     * @param kmh A speed value in km/h.
     * @return A string containing the value and units based on the unit settings and localization.
     * For example "120 km/h" or "60 mph".
     */
    fun localizeSpeed(kmh: Int): String

    /**
     * @param kmh A speed value in km/h.
     * @return A [Pair] containing the value and unit based on the unit settings and localization.
     * For example <120, "km/h"> or <60, "mph">.
     */
    fun localizeSpeedSeparateUnit(kmh: Int): Pair<Int, String>

    /**
     * @param kmh A speed value in km/h.
     * @return An int containing the value based on the unit settings and localization.
     * For example 120 or 60.
     */
    fun localizeSpeedValue(kmh: Int): Int

    /**
     * @param kmh A speed value in km/h.
     * @return A float containing the value based on the unit settings and localization.
     * For example 120 or 60.
     */
    fun localizeSpeedValue(kmh: Float): Float

    /**
     * @return A string containing the unit based on the unit settings and localization.
     * For example "km/h" or "mph".
     */
    fun localizeSpeedUnit(): String

    /**
     * @return A string containing the hours unit based on localization.
     * For example "h".
     */
    fun localizeHoursUnit(): String

    /**
     * @return A string containing the minutes unit based on localization.
     * For example "min".
     */
    fun localizeMinutesUnit(): String

    /**
     * Returns UnitSystem that is currently chosen by the user
     */
    val currentUnitSystem: UnitSystem

    /**
     * Returns [TemperatureUnit] that is currently chosen by the user
     */
    val currentTemperatureUnit: TemperatureUnit
}

data class LocalizedValue(val value: String, val units: String)

enum class UnitSystem {
    METRIC,
    IMPERIAL_UK,
    IMPERIAL_US
}

enum class TemperatureUnit {
    CELSIUS, FAHRENHEIT
}