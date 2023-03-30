pipeline {

    agent any

    parameters {
        string(name: 'BUILD_NAME', defaultValue: '', description: 'Enter build name')
        extendedChoice( name: 'BROWSER', value: 'chrome,firefox', multiSelectDelimiter: ' ', description: 'Pls select browser to run tests.', type: 'PT_MULTI_SELECT', visibleItemCount: 5)
    }

    stages {
        stage("Add build name") {
            when {expression {params.BROWSER != null}}
            steps {
               script {
                   currentBuild.displayName = params.BUILD_NAME
               }
            }
        }

        stage("Start container") {
            when {expression {params.BROWSER != null}}
            steps {
                bat "docker-compose up -d selenium-hub ${params.BROWSER}"
            }
        }

        stage("Run test") {
            when {expression {params.BROWSER != null}}
            steps {
                script {
                    Map tests = [:]
                    params.BROWSER.split(" ").each{ browser ->
                        String br = browser
                        tests[br] = {
                            bat "gradle test -Dbrowser=${br} -Dorg.gradle.project.buildDir=\"/build-.${br}\""
                        }
                    }
                    parallel tests
                }
            }
        }
    }

    post{
        always{
            bat "docker-compose down"
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