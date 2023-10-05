import us.vanderlugt.example.jenkins.library.Pipeline
import us.vanderlugt.example.jenkins.library.gradle.BuildGradleStage
import us.vanderlugt.example.jenkins.library.gradle.IntegrationTestGradleStage

def build( String name = "Build",
    List<String> tasks = ["clean", "build"],
    boolean useWrapper = true )
{
    Pipeline.addStep( new BuildGradleStage( name, tasks, useWrapper ) )
}

def integrationTest( String name = "Integration Test",
    List<String> tasks = ["integrationTest"],
    boolean useWrapper = true )
{
    Pipeline.addStep( new IntegrationTestGradleStage( name, tasks, useWrapper ) )
}
