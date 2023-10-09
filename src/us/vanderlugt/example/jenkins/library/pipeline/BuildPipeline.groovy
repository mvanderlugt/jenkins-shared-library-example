package us.vanderlugt.example.jenkins.library.pipeline

import us.vanderlugt.example.jenkins.library.agents.PipelineAgent

import java.time.Duration
import java.time.temporal.ChronoUnit

class BuildPipeline implements Serializable {
    enum Style {
        PullRequest, ReleaseCandidate
    }

    private def script
    private PipelineAgent agent
    private PipelineSteps steps = new PipelineSteps()
    private Duration timeout = Duration.of(1, ChronoUnit.HOURS)

    BuildPipeline initialize(script) {
        this.script = script
        return this
    }

    BuildPipeline agent(PipelineAgent agent) {
        this.agent = agent
        return this
    }

    BuildPipeline addStep(PipelineStep step) {
        this.steps.add(step)
        return this
    }

    BuildPipeline setTimeout(Duration timeout) {
        this.timeout = timeout
        return this
    }

    void execute() {
        agent.execute(script) {
            script.timeout(this.timeout.toMinutes()) {
                script.stage("Initialize") {
                    steps.initialize(script)
                }
                steps.execute(script)
            }
        }
    }
}
