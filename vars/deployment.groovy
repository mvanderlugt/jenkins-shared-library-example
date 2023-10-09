import us.vanderlugt.example.jenkins.library.deployment.WebhookDeploymentStep

import static us.vanderlugt.example.jenkins.library.PipelineManager.addStage
import static us.vanderlugt.example.jenkins.library.pipeline.PipelineSteps.of

def webhook() {
    addStage("Deployment", of(new WebhookDeploymentStep()))
}
