package us.vanderlugt.example.jenkins.library

class BuildGradleStage {
    private final String name
    private final GradleCommand gradleCommand

    BuildGradleStage(String name = "Build", List<String> tasks = ["clean", "build"], boolean useWrapper = true) {
        this.name = name
        this.gradleCommand = new GradleCommand(tasks, useWrapper)
    }

    void execute(Script script) {
        script.stage( name ) {
            try
            {
                gradleCommand.execute(script)
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
