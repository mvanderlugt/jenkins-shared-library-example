package us.vanderlugt.example.jenkins.library.scm

import us.vanderlugt.example.jenkins.library.checks.NoOpCheck
import us.vanderlugt.example.jenkins.library.pipeline.PipelineCheck
import us.vanderlugt.example.jenkins.library.pipeline.PipelineStep

class CheckoutStep implements PipelineStep {
    @Override
    PipelineCheck getCheck() {
        return NoOpCheck.INSTANCE
    }

    @Override
    void initialize(script) {

    }

    @Override
    void before(script) {

    }

    @Override
    void execute(script) {
        script.checkout script.scm
    }

    @Override
    void after(script) {

    }

    @Override
    void onFailure(script, Exception exception)
    {
        throw exception // todo should we eat this and exit gracefully `script.error(exception.message)`
    }
}
