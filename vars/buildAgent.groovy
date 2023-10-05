import us.vanderlugt.example.jenkins.library.agents.DockerAgent
import us.vanderlugt.example.jenkins.library.agents.KubernetesAgent

def anyAvailable(Closure pipeline)
{
    node pipeline
}

def byLabel(String label, Closure pipeline)
{
    node(label, pipeline)
}

def docker( String image, Closure pipeline )
{
    docker.image(image, pipeline)
}

def kubernetes( String buildProfile, Closure pipeline )
{
//    script.agent {
//        kubernetes {
//            cloud this.cloud
//            namespace this.namespace
//            defaultContainer this.defaultContainer
//            script.yaml libraryResource("us/vanderlugt/example/jenkins/library/agents/${podSpec}-agent.yaml")
//        }
//    }
}
