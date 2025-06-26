package com.seraphim.utils.unitconversion

// Combustion
val Float.kplToLp100km get() = 100f zeroSaveDivision this
val Float.kplToMpgUS get() = this * KPL_PER_MPG_US
val Float.kplToMpgUK get() = this * KPL_PER_MPG_UK
val Float.mpgUSToKpl get() = this zeroSaveDivision KPL_PER_MPG_US
val Float.mpgUKToKpl get() = this zeroSaveDivision KPL_PER_MPG_UK

private const val KPL_PER_MPG_US = 2.35215f
private const val KPL_PER_MPG_UK = 2.82481f

// Electric
val Float.kmpKwhToKwhp100km get() = 100f zeroSaveDivision this
val Float.kmpKwhToMipKwh get() = this zeroSaveDivision MIPKWH_PER_KMPKWH
val Float.kmpKwhToKwhpMi get() = 1f zeroSaveDivision this.kmpKwhToMipKwh
val Float.kmpKwhToKwhp100Mi get() = 100f zeroSaveDivision this.kmpKwhToMipKwh

private const val MIPKWH_PER_KMPKWH = 1.60934f