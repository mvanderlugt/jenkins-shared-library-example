package us.vanderlugt.example.jenkins.library.gradle

class GradleCommand
{
    private List<String> tasks
    private boolean useWrapper

    void execute( steps )
    {
        steps.sh "${gradleCommand} ${tasks.join( " " )}"
    }

    private String getGradleCommand()
    {
        return useWrapper ? "./gradlew" : "gradle"
    }
}
