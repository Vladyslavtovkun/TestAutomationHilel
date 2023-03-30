pipeline {

    parameters {
        string(name: 'BUILD_NAME', defaultValue: '', description: 'Enter build name')
        extendedChoice(
                name: 'BROWSER',
                value: 'chrome, firefox',
                multiSelectDelimeter: ' ',
                description: 'Pls select browser to run tests.',
                type: 'PT_MULTI_SELECT',
                descriptionGroovyScript: valueNamesScript
        )
    }

    stages {
        stage("Add build name") {
            steps {
               currentBuild.displayName = params.BUILD_NAME
            }
        }

        stage("Start container") {
            steps {
                bat "docker-compose up -d selenium-hub ${params.BROWSER}"
            }
        }

        stage("Start container") {
            steps {
                scripts {
                    Map tests = [:]
                    params.BROWSER.split(" ").each{ browser ->
                        String br = browser
                        tests[br] = {
                            bat "gradlew test -Dbrowser=${br} -Dorg.gradle.project.buildDir=\"/build-.${br}\""
                        }
                    }
                    parallel tests
                }
            }
        }
    }

    post{
        always{
            bat "docker-compose down -d"
            archiveArtifacts(artifacts: "build*/**")

            allure([
                    includeProperties: false,
                    reportBuildPolicy: 'ALWAYS',
                    results          : [[path: "build-chrome/allure-results"],
                                        [path: "build-firefox/allure-results"]]
            ])
        }
    }
}