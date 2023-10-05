import us.vanderlugt.example.jenkins.library.BuildGradleStage
import us.vanderlugt.example.jenkins.library.IntegrationTestGradleStage

def build( String name = "Build",
    List<String> tasks = ["clean", "build"],
    boolean useWrapper = true )
{
    new BuildGradleStage( name, tasks, useWrapper )
        .execute( this )
}

def integrationTest(String name = "Integration Test",
    List<String> tasks = ["integrationTest"],
    boolean useWrapper = true)
{
    new IntegrationTestGradleStage(name, tasks, useWrapper).execute( this )
}
