package us.vanderlugt.example.jenkins.library.options

import us.vanderlugt.example.jenkins.library.checks.PipelineCheck
import us.vanderlugt.example.jenkins.library.pipeline.PipelineStep

class DurabilityHintStep implements PipelineStep {
    private final String durability

    DurabilityHintStep(String durability) {
        this.durability = durability
    }

    @Override
    PipelineCheck getCheck() {
        return null
    }

    @Override
    void initialize(script) {

    }

    @Override
    void before(script) {

    }

    @Override
    void execute(script) {
        script.properties([
                script.durabilityHint(durability)
        ])
    }

    @Override
    void after(script) {

    }

    @Override
    void onFailure(script, Exception exception) {

    }
}
