package us.vanderlugt.example.jenkins.library.gradle

class GradleCommand
{
    private final List<String> tasks
    private final boolean useWrapper

    GradleCommand( List<String> tasks, boolean useWrapper = true )
    {
        this.tasks = tasks
        this.useWrapper = useWrapper
    }

    void execute( steps )
    {
        steps.sh "${gradleCommand} ${tasks.join( " " )}"
    }

    private String getGradleCommand()
    {
        return useWrapper ? "./gradlew" : "gradle"
    }
}
