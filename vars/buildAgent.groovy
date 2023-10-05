import us.vanderlugt.example.jenkins.library.agents.DockerAgent
import us.vanderlugt.example.jenkins.library.agents.KubernetesAgent

def anyAvailable(Closure pipeline)
{
    node pipeline
}

def docker( String image, Closure pipeline )
{
    println(this.getBinding().variables)
    new DockerAgent( image ).execute( this, pipeline )
}

def kubernetes( String buildProfile )
{
    new KubernetesAgent( podSpec = buildProfile ).define( this )
}
