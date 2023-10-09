package us.vanderlugt.example.jenkins.library.deployment

import us.vanderlugt.example.jenkins.library.pipeline.PipelineStep

class WebhookDeploymentStep implements PipelineStep {

    @Override
    void execute(script) {
        script.echo "Waiting for CD to complete deployment"
    }
}
