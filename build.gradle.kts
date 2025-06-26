plugins {
    alias(libs.plugins.seraphim.kotlin.multiplatform.library)
}
android {
    namespace = "com.seraphim.babydiary.shared"
}
kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                // 这里添加该 module 需要的依赖
            }
        }
        // 其他 sourceSet 配置
    }
}