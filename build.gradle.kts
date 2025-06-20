plugins {
    alias(libs.plugins.seraphim.kotlin.multiplatform.library)
}
android {
    namespace = "com.seraphim.utils"
}
kotlin {
    jvmToolchain(21)
}