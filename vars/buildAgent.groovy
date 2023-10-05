import us.vanderlugt.example.jenkins.library.agents.DockerAgent

def anyAvailable( Closure pipeline )
{
    node {
        pipeline()
    }
}

def byLabel( String label, Closure pipeline )
{
    node( label ) {
        pipeline()
    }
}

def docker( String image, Closure pipeline )
{
    new DockerAgent(image).execute(steps, pipeline)
}

def kubernetes( String buildProfile, Closure pipeline )
{
    def podSpec = readYaml( libraryResource( "us/vanderlugt/example/jenkins/library/agents/${buildProfile}-agent.yaml" ) )
    podTemplate( cloud = "kubernetes",
        namespace = "jenkins-agents",
        defaultContainer = "jdk",
        yaml = podSpec ) {
        pipeline()
    }
}
