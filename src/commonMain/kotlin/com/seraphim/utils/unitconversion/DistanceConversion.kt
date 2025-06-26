package com.seraphim.utils.unitconversion

import kotlin.math.roundToInt

val Int.kmToMiles get() = (this * (1 / 1.609344)).roundToInt()
val Double.kmToMiles get() = this * (1 / 1.609344)
val Int.miToKm get() = (this * 1.609344).roundToInt()
val Int.miToM get() = (this * 1609.344).roundToInt()
val Int.mToKm get() = this.toDouble() / 1000
val Int.kmToM get() = this * 1000
val Int.mToFeet get() = (this / 0.3048).roundToInt()
val Int.feetToMiles get() = (this.toDouble() / 5280)