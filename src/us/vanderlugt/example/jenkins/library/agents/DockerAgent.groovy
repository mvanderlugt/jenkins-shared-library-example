package us.vanderlugt.example.jenkins.library.agents

class DockerAgent
{
    private final String image

    DockerAgent( String image )
    {
        this.image = image
    }

    def define( Script script )
    {
        script.agent {
            docker {
                image this.image
            }
        }
    }
}
