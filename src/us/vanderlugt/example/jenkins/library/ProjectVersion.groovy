package us.vanderlugt.example.jenkins.library

class ProjectVersion
{
    private final String candidateVersionPrefix
    private final String pullRequestVersionPrefix

    ProjectVersion( String candidateVersionPrefix = "dev-",
        String pullRequestVersionPrefix = "dev-" )
    {
        this.candidateVersionPrefix = candidateVersionPrefix
    }

    String getImageTag( env )
    {
        def imageTag
        if( env.TAG_NAME )
        {
            imageTag = "${env.TAG_NAME}"
        }
        else if( ["master", "main"].contains( env.BRANCH_NAME ) )
        {
            imageTag = "${candidateVersionPrefix}${env.GIT_COMMIT.take( 7 )}"
        }
        else
        {
            imageTag = "${pullRequestVersionPrefix}${env.GIT_COMMIT.take( 7 )}"
        }
        return imageTag
    }
}
