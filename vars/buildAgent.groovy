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
    docker.image( image ).withRun {
        pipeline()
    }
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
