package us.vanderlugt.example.jenkins.library.gradle

import us.vanderlugt.example.jenkins.library.PipelineStage

class IntegrationTestGradleStage extends PipelineStage
{
    private final GradleCommand gradleCommand

    IntegrationTestGradleStage( String name = "Integration Test",
        List<String> tasks = ["integrationTest"],
        boolean useWrapper = true )
    {
        super( name )
        this.gradleCommand = new GradleCommand( tasks: tasks, useWrapper: useWrapper )
    }

    @Override
    void executeStage( script )
    {
        try
        {
            gradleCommand.execute( script )
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
