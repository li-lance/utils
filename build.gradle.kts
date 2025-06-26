import org.gradle.kotlin.dsl.support.kotlinCompilerOptions

plugins {
    alias(libs.plugins.seraphim.kotlin.multiplatform.library)
}
android {
    namespace = "com.seraphim.babydiary.shared"
}
kotlin {
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
            }
        }
        // 其他 sourceSet 配置
    }
}
