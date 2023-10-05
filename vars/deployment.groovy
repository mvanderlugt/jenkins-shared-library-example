import us.vanderlugt.example.jenkins.library.Pipeline
import us.vanderlugt.example.jenkins.library.deployment.WebhookDeployment

def webhook()
{
    Pipeline.addStep( new WebhookDeployment() )
}