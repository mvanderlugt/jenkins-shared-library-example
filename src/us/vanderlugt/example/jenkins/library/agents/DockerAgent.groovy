package us.vanderlugt.example.jenkins.library.agents

class DockerAgent
{
    private final String image

    DockerAgent( String image )
    {
        this.image = image
    }

    def execute( def buildAgent, Closure pipeline )
    {
        buildAgent.println(this.binding.variables)
        docker.image(image, pipeline)
    }
}
