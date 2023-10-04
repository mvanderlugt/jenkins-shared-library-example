def call(Map pipelineParams)
{
    Map defaultParams = [
        name: "Build",
        tasks: "clean build",
        useWrapper: true
    ]

    params = defaultParams + pipelineParams

    gradleCommand = params.useWrapper ? "./gradlew" : "gradle"

    stage( params.name ) {
        steps {
            sh "${gradleCommand} ${params.tasks}"
            stash includes: 'build/libs/*.jar', name: 'gradleLibs'
        }
        post {
            always {
                junit "build/test-results/test/*.xml"
                publishHTML( [
                    allowMissing: true,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: 'build/reports/tests/test',
                    reportFiles: 'index.html',
                    reportName: "Unit Test Report"
                ] )
                jacoco(
                    execPattern: "build/jacoco/*.exec",
                    classPattern: "build/classes/kotlin/main",
                    sourcePattern: "src/main/kotlin",
                    sourceInclusionPattern: "**/*.kt",
                    exclusionPattern: "src/test"
                )
            }
        }
    }
}