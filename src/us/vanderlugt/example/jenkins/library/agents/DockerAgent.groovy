package us.vanderlugt.example.jenkins.library.agents

class DockerAgent
{
    private final String image

    DockerAgent( String image )
    {
        this.image = image
    }

    def execute( Script script, Closure pipeline )
    {
        script.docker.image(image, pipeline)
    }
}
