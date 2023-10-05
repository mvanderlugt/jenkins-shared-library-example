package us.vanderlugt.example.jenkins.library.agents

class KubernetesAgent
{
    private String cloud = "kubernetes"
    private String namespace = "jenkins-agents"
    private String defaultContainer = "jdk"
    private String podSpec = "jdk-17"

    void execute( steps, Closure pipeline )
    {
        def yaml = steps.libraryResource( "us/vanderlugt/example/jenkins/library/agents/${podSpec}-agent.yaml" )
        steps.podTemplate( cloud: cloud,
            namespace: namespace,
            yaml: yaml ) {
            steps.container( defaultContainer ) {
                pipeline()
            }
        }
    }
}
