package us.vanderlugt.example.jenkins.library

class ProjectVersion
{
    private String candidateVersionPrefix = "dev-"
    private String pullRequestVersionPrefix = "dev-"

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
