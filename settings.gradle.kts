pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral() {
            content { excludeGroup("com.github.haroldadmin") }
        }
        maven {
            setUrl("https://jitpack.io")
            content { includeGroup("com.github.haroldadmin") }
        }
    }
}

rootProject.name = "Featherly Spy"
include(":app")
