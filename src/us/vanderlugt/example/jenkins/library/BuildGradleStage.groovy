class BuildGradleStage {
    private final Script script

    BuildGradleStage(Script script) {
        this.script = script
    }

    void execute(String name = "Build", String tasks = "clean build", boolean useWrapper = true) {
        var gradleCommand = useWrapper ? "./gradlew" : "gradle"

        script.stage( name ) {
            try
            {
                script.sh "${gradleCommand} ${tasks}"
                script.stash includes: 'build/libs/*.jar', name: 'gradleLibs'
            }
            finally
            {
                script.junit "build/test-results/test/*.xml"
                script.publishHTML( [
                    allowMissing: true,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: 'build/reports/tests/test',
                    reportFiles: 'index.html',
                    reportName: "Unit Test Report"
                ] )
                script.jacoco(
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
