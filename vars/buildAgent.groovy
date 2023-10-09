import us.vanderlugt.example.jenkins.library.PipelineManager
import us.vanderlugt.example.jenkins.library.agents.DockerAgent
import us.vanderlugt.example.jenkins.library.agents.KubernetesAgent
import us.vanderlugt.example.jenkins.library.agents.NodeLabelAgent

def anyAvailable() {
    PipelineManager.agent(new NodeLabelAgent())
}

def byLabel(String label) {
    PipelineManager.agent(new NodeLabelAgent(label: label))
}

def docker(String image) {
    PipelineManager.agent(new DockerAgent(image: image))
}

def kubernetes(String buildProfile) {
    PipelineManager.agent(new KubernetesAgent(podSpec: buildProfile))
}
