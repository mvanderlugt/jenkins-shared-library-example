package us.vanderlugt.example.jenkins.library.pipeline

import us.vanderlugt.example.jenkins.library.agents.PipelineAgent
import us.vanderlugt.example.jenkins.library.checks.NoOpCheck
import us.vanderlugt.example.jenkins.library.checks.PipelineCheck

class PipelineStage implements PipelineStep {
    private final String name
    private PipelineAgent agent
    private final PipelineSteps steps

    PipelineStage(String name) {
        this(name, new PipelineSteps())
    }

    PipelineStage(String name, PipelineSteps steps) {
        this.name = name
        this.steps = steps
    }

    PipelineStage agent(PipelineAgent agent) {
        this.agent = agent
        return this
    }

    PipelineStage addStep(PipelineStep step) {
        this.steps.add(step)
        return this
    }

    @Override
    PipelineCheck getCheck() {
        return NoOpCheck.INSTANCE
    }

    @Override
    void before(script) {

    }

    @Override
    void initialize(script) {
        steps.initialize(script)
    }

    @Override
    void execute(script) {
        script.stage(name) {
            if (agent != null) {
                agent.execute(script) {
                    steps.execute(script)
                }
            } else {
                steps.execute(script)
            }
        }
    }

    @Override
    void after(script) {

    }

    @Override
    void onFailure(script, Exception exception) {
        throw exception
    }
}
