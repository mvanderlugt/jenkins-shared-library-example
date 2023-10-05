package us.vanderlugt.example.jenkins.library.agents

class DockerAgent
{
    private final String image

    DockerAgent( String image )
    {
        this.image = image
    }

    def execute( def script, Closure pipeline )
    {
        script.println(script.getClass())
        script.docker.image(image, pipeline)
    }
}
