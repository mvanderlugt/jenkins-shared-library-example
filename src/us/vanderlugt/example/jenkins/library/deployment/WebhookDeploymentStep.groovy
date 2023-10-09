package us.vanderlugt.example.jenkins.library.deployment

import us.vanderlugt.example.jenkins.library.checks.NoOpCheck
import us.vanderlugt.example.jenkins.library.pipeline.PipelineCheck
import us.vanderlugt.example.jenkins.library.pipeline.PipelineStep

class WebhookDeploymentStep implements PipelineStep {

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
        script.echo "Waiting for CD to complete deployment"
    }

    @Override
    void after(script) {

    }

    @Override
    void onFailure(Object script, Exception exception) {
        throw exception // todo should we eat this and exit gracefully `script.error(exception.message)`
    }
}
