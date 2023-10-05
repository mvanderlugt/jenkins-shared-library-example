import us.vanderlugt.example.jenkins.library.agents.DockerAgent
import us.vanderlugt.example.jenkins.library.agents.KubernetesAgent

def anyAvailable( Closure pipeline )
{
    node {
        pipeline()
    }
}

def byLabel( String label, Closure pipeline )
{
    node( label ) {
        pipeline()
    }
}

def docker( String image, Closure pipeline )
{
    new DockerAgent( image: image ).execute( this, pipeline )
}

def kubernetes( String buildProfile, Closure pipeline )
{
    new KubernetesAgent( podSpec: buildProfile ).execute( this, pipeline )
}
