package us.vanderlugt.example.jenkins.library.pipeline

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
    void initialize(script) {
        steps.initialize(script)
    }

    @Override
    void execute(Object script) {

        if (agent != null) {
            agent.execute(script) {
                steps.execute(script)
            }
        } else {
            steps.execute(script)
        }
    }
}
