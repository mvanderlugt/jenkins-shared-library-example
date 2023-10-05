import us.vanderlugt.example.jenkins.library.agents.DockerAgent
import us.vanderlugt.example.jenkins.library.agents.KubernetesAgent

def any(Closure pipeline)
{
    node pipeline
}

def docker( String image )
{
    new DockerAgent( image ).define( this )
}

def kubernetes( String buildProfile )
{
    new KubernetesAgent( podSpec = buildProfile ).define( this )
}
