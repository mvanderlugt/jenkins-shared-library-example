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
        dockerNode.image(image, pipeline)
    }
}
