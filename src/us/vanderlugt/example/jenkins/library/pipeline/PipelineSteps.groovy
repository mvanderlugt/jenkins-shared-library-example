package us.vanderlugt.example.jenkins.library.pipeline

import us.vanderlugt.example.jenkins.library.checks.NoOpCheck
import us.vanderlugt.example.jenkins.library.pipeline.PipelineCheck.Conclusion
import us.vanderlugt.example.jenkins.library.pipeline.PipelineCheck.Status

class PipelineSteps implements PipelineStep {
    private final List<PipelineStep> steps = new LinkedList<PipelineStep>()

    PipelineSteps() {
    }

    PipelineSteps(PipelineStep... steps) {
        super()
        for (def step : steps) {
            this.steps.add(step)
        }
    }

    static PipelineSteps of(PipelineStep... steps) {
        return new PipelineSteps(steps)
    }

    void add(PipelineStep step) {
        this.steps.add(step)
    }

    @Override
    PipelineCheck getCheck() {
        return NoOpCheck.INSTANCE
    }

    @Override
    void initialize(script) {
        for (PipelineStep step : steps) {
            queueCheck(script, step.getCheck())

            step.initialize(script)
        }
    }

    @Override
    void before(script) {

    }

    @Override
    void execute(script) {
        for (PipelineStep step : steps) {
            executeStep(script, step)
        }
    }

    @Override
    void after(script) {

    }

    @Override
    void onFailure(script, Exception exception) {
        throw exception
    }

    private static void executeStep(script, PipelineStep step) {
        PipelineCheck check = step.getCheck()
        try {
            step.before(script)

            check.status = Status.InProgress
            check.publish(script)

            step.execute(script)

            check.conclusion = Conclusion.Success
        }
        catch (Exception exception) { // todo add exception to pipeline check?
            check.conclusion = Conclusion.Failure

            step.onFailure(script, exception)
        }
        finally {
            check.status = Status.Completed
            check.publish(script)

            step.after(script)
        }
    }

    private static void queueCheck(script, PipelineCheck check) {
        check.status = Status.Queued
        check.conclusion = Conclusion.None
        check.publish(script)
    }
}
