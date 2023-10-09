package us.vanderlugt.example.jenkins.library.gradle

import us.vanderlugt.example.jenkins.library.checks.NoOpCheck
import us.vanderlugt.example.jenkins.library.pipeline.PipelineCheck
import us.vanderlugt.example.jenkins.library.pipeline.PipelineStep

class IntegrationTestGradleStep implements PipelineStep {
    private final GradleCommand gradleCommand

    IntegrationTestGradleStep(List<String> tasks = ["integrationTest"],
                              boolean useWrapper = true) {
        this.gradleCommand = new GradleCommand(tasks: tasks, useWrapper: useWrapper)
    }

    @Override
    PipelineCheck getCheck() {
        return NoOpCheck.INSTANCE
    }

    @Override
    void initialize(script) {

    }

    @Override
    void before(script) {

    }


    @Override
    void execute(script) {
        gradleCommand.execute(script)
    }

    @Override
    void after(script) {
        script.junit "build/test-results/integrationTest/*.xml"
        script.publishHTML([
                allowMissing         : true,
                alwaysLinkToLastBuild: false,
                keepAll              : true,
                reportDir            : 'build/reports/tests/integrationTest',
                reportFiles          : 'index.html',
                reportName           : "Integration Test Report"
        ])
    }

    @Override
    void onFailure(script, Exception exception) {
        throw exception // todo should we eat this and exit gracefully `script.error(exception.message)`
    }
}
