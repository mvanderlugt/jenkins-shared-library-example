package us.vanderlugt.example.jenkins.library.gradle

class IntegrationTestGradleStage
{
    private final String name
    private final GradleCommand gradleCommand

    IntegrationTestGradleStage(String name = "Integration Test",
        List<String> tasks = ["integrationTest"],
        boolean useWrapper = true) {
        this.name = name
        this.gradleCommand = new GradleCommand(tasks, useWrapper)
    }

    void execute(Script script) {
        try
        {
            gradleCommand.execute(script)
        }
        finally
        {
            script.junit "build/test-results/integrationTest/*.xml"
            script.publishHTML( [
                allowMissing: true,
                alwaysLinkToLastBuild: false,
                keepAll: true,
                reportDir: 'build/reports/tests/integrationTest',
                reportFiles: 'index.html',
                reportName: "Integration Test Report"
            ] )
        }
    }
}