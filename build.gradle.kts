import com.seraphim.plugin.compileSdkVersion
import com.seraphim.plugin.minSdkVersion

plugins {
    alias(libs.plugins.seraphim.kotlin.multiplatform.library)
}
kotlin {
    androidLibrary {
        namespace = "com.seraphim.utils"
        compileSdk = project.compileSdkVersion
        minSdk = project.minSdkVersion
    }
    compilerOptions {
        freeCompilerArgs.addAll(
            listOf(
                "-Xopt-in=kotlin.RequiresOptIn",
                "-Xopt-in=kotlin.ExperimentalStdlibApi",
                "-Xopt-in=kotlin.time.ExperimentalTime",
                "-Xopt-in=kotlinx.serialization.ExperimentalSerializationApi",
                "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
                "-Xlint:-unused"
            )
        )
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                // 这里添加该 module 需要的依赖
                implementation(libs.mmkv.kotlin)
                implementation(libs.napier.logger)
                implementation(libs.kotlinx.datetime)
            }
        }
        // 其他 sourceSet 配置
    }
}
