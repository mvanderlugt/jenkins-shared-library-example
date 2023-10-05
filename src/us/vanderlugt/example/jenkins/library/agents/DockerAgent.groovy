package us.vanderlugt.example.jenkins.library.agents

class DockerAgent
{
    private String image

    void execute( steps, Closure pipeline )
    {
        steps.docker.image( image ).withRun {
            pipeline()
        }
    }
}
