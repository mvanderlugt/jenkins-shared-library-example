package us.vanderlugt.example.jenkins.library.agents

class KubernetesAgent
{
    private final String cloud
    private final String namespace
    private final String defaultContainer
    private final String podSpec

    KubernetesAgent( String cloud = "kubernetes",
        String namespace = "jenkins-agents",
        String defaultContainer = "jdk",
        String podSpec = "jdk-17")
    {
        this.cloud = cloud
        this.namespace = namespace
        this.defaultContainer = defaultContainer
        this.podSpec = podSpec
    }

    def define(Script script) {
        script.agent {
            kubernetes {
                cloud this.cloud
                namespace this.namespace
                defaultContainer this.defaultContainer
                script.yaml libraryResource("us/vanderlugt/example/jenkins/library/agents/${podSpec}-agent.yaml")
            }
        }
    }
}
