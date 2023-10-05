package us.vanderlugt.example.jenkins.library.agents

class DockerAgent
{
    private final String image

    DockerAgent( String image )
    {
        this.image = image
    }

    void execute( steps, Closure pipeline )
    {
        steps.docker.image( image ).withRun {
            pipeline()
        }
    }
}
