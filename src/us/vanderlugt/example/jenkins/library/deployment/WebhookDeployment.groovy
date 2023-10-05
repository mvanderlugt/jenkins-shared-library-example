package us.vanderlugt.example.jenkins.library.deployment

import us.vanderlugt.example.jenkins.library.PipelineStage

class WebhookDeployment extends PipelineStage
{
    WebhookDeployment()
    {
        super( "Deployment" )
    }

    @Override
    void executeStage( script )
    {
        script.echo "Waiting for CD to complete deployment"
    }
}
