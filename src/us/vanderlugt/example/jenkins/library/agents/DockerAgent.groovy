package us.vanderlugt.example.jenkins.library.agents

class DockerAgent implements PipelineAgent {
    private String image

    @Override
    void execute(script, Closure pipeline) {
        script.docker.image(image).withRun {
            pipeline()
        }
    }
}
