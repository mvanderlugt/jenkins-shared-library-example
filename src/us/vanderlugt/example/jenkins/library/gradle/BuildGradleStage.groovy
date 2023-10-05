package us.vanderlugt.example.jenkins.library.gradle

class BuildGradleStage {
    private final String name
    private final GradleCommand gradleCommand

    BuildGradleStage(String name = "Build", List<String> tasks = ["clean", "build"], boolean useWrapper = true) {
        this.name = name
        this.gradleCommand = new GradleCommand(tasks: tasks, useWrapper: useWrapper)
    }

    void execute(steps) {
        steps.stage( name ) {
            try
            {
                gradleCommand.execute(steps)
                steps.stash includes: 'build/libs/*.jar', name: 'gradleLibs'
            }
            finally
            {
                steps.junit "build/test-results/test/*.xml"
                steps.publishHTML( [
                    allowMissing: true,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: 'build/reports/tests/test',
                    reportFiles: 'index.html',
                    reportName: "Unit Test Report"
                ] )
                steps.jacoco(
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
