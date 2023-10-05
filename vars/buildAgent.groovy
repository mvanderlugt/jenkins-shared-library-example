import us.vanderlugt.example.jenkins.library.Pipeline
import us.vanderlugt.example.jenkins.library.agents.DockerAgent
import us.vanderlugt.example.jenkins.library.agents.KubernetesAgent
import us.vanderlugt.example.jenkins.library.agents.NodeLabelAgent

def anyAvailable()
{
    Pipeline.getInstance().agent = new NodeLabelAgent()
}

def byLabel( String label )
{
    Pipeline.getInstance().agent = new NodeLabelAgent( label: label )
}

def docker( String image )
{
    Pipeline.getInstance().agent = new DockerAgent( image: image )
}

def kubernetes( String buildProfile )
{
    Pipeline.getInstance().agent = new KubernetesAgent( podSpec: buildProfile )
}
