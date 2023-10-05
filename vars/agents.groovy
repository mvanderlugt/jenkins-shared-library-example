import us.vanderlugt.example.jenkins.library.agents.DockerAgent
import us.vanderlugt.example.jenkins.library.agents.KubernetesAgent

def any()
{
    agent any
}

def docker( String image )
{
    new DockerAgent( image ).define( this )
}

def kubernetes( String buildProfile )
{
    new KubernetesAgent( podSpec = buildProfile ).define( this )
}
