package us.vanderlugt.example.jenkins.library.gradle

import us.vanderlugt.example.jenkins.library.checks.SimpleCheck
import us.vanderlugt.example.jenkins.library.pipeline.PipelineCheck
import us.vanderlugt.example.jenkins.library.pipeline.PipelineStep

class BuildGradleStep implements PipelineStep {
    private final PipelineCheck check
    private final GradleCommand gradleCommand

    BuildGradleStep(List<String> tasks = ["clean", "build"], boolean useWrapper = true) {
        this.check = new SimpleCheck(tasks.join(" "), "gradle/build")
        this.gradleCommand = new GradleCommand(tasks: tasks, useWrapper: useWrapper)
    }

    @Override
    PipelineCheck getCheck() {
        return check
    }

    @Override
    void execute(script) {
        gradleCommand.execute(script)

        script.stash includes: 'build/libs/*.jar', name: 'gradleLibs'
    }

    @Override
    void after(script) {
        script.junit "build/test-results/test/*.xml"
        script.publishHTML([
                allowMissing         : true,
                alwaysLinkToLastBuild: false,
                keepAll              : true,
                reportDir            : 'build/reports/tests/test',
                reportFiles          : 'index.html',
                reportName           : "Unit Test Report"
        ])
        script.jacoco(
                execPattern: "build/jacoco/*.exec",
                classPattern: "build/classes/kotlin/main",
                sourcePattern: "src/main/kotlin",
                sourceInclusionPattern: "**/*.kt",
                exclusionPattern: "src/test"
        )
    }
}
