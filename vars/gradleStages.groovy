import us.vanderlugt.example.jenkins.library.gradle.BuildGradleStep
import us.vanderlugt.example.jenkins.library.gradle.IntegrationTestGradleStep
import static us.vanderlugt.example.jenkins.library.PipelineManager.addStage
import static us.vanderlugt.example.jenkins.library.pipeline.PipelineSteps.of

def build(List<String> tasks = ["clean", "build"],
          boolean useWrapper = true) {
    addStage("Build", of(new BuildGradleStep(tasks, useWrapper)))
}

def integrationTest(List<String> tasks = ["integrationTest"],
                    boolean useWrapper = true) {
    addStage("Integration Test", of(new IntegrationTestGradleStep(tasks, useWrapper)))
}
