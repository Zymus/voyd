plugins {
    alias(libs.plugins.kotlinMultiplatform)
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

kotlin {
    js {
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
            }
            testTask {
                useKarma {
                    useFirefox()
                }
            }
        }
        binaries.executable()
    }

    sourceSets {
        jsMain.dependencies {
            implementation(libs.kotlin.wrappers.emotion.react)
            implementation(libs.kotlin.wrappers.react)
            implementation(libs.kotlin.wrappers.react.dom)
            implementation(libs.kotlin.wrappers.react.router)
            implementation(libs.kotlinx.serialization.core)
            implementation(project(":modules:core"))
            implementation(project(":modules:resources"))
        }

        jsTest.dependencies {
            implementation(kotlin("test"))
            implementation(libs.kotlin.wrappers.react.dom.test.utils)
        }
    }
}
