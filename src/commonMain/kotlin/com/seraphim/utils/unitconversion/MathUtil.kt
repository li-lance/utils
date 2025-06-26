package com.seraphim.utils.unitconversion

/**
 * If the divisor is zero, this function will return a zero as well. Otherwise a default division
 * will be performed.
 * I'm really sorry mathematicians, but this is required for parts of the UI.
 */
infix fun Float.zeroSaveDivision(divisor: Float) = if (divisor == 0f) 0f else this / divisor
