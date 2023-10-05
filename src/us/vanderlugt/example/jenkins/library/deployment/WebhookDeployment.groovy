package us.vanderlugt.example.jenkins.library.deployment

import us.vanderlugt.example.jenkins.library.PipelineStage

class WebhookDeployment implements PipelineStage
{
    @Override
    String name()
    {
        return "Deployment"
    }

    @Override
    void execute( script )
    {
        script.echo "Waiting for CD to complete deployment"
    }
}
