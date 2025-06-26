package com.seraphim.utils.unitconversion

import kotlin.math.roundToInt

val Float.kmhToMph get() = this / 1.609344f
val Int.mphToKmh get() = (this * 1.609344f).roundToInt()