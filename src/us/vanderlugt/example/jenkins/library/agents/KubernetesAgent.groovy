package us.vanderlugt.example.jenkins.library.agents

import us.vanderlugt.example.jenkins.library.pipeline.PipelineAgent

class KubernetesAgent implements PipelineAgent {
    private String cloud = "kubernetes"
    private String namespace = "jenkins-agents"
    private String defaultContainer = "jdk"
    private String podSpec = "jdk-17"

    @Override
    void execute(script, Closure pipeline) {
        def yaml = script.libraryResource("us/vanderlugt/example/jenkins/library/agents/${podSpec}-agent.yaml")
        script.podTemplate(cloud: cloud,
                namespace: namespace,
                yaml: yaml) {
            script.container(defaultContainer) {
                pipeline()
            }
        }
    }
}
