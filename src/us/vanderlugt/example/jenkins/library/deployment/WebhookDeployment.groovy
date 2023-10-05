package us.vanderlugt.example.jenkins.library.deployment

import us.vanderlugt.example.jenkins.library.PipelineStage

class WebhookDeployment implements PipelineStage
{
    @Override
    void execute( script )
    {
        script.stage( "Deployment" ) {
            script.echo "Waiting for CD to complete deployment"
        }
    }
}
