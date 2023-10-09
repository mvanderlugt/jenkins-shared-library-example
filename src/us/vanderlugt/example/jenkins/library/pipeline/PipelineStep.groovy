package us.vanderlugt.example.jenkins.library.pipeline

import us.vanderlugt.example.jenkins.library.checks.NoOpCheck

interface PipelineStep extends Serializable {
    default PipelineCheck getCheck() {
        return NoOpCheck.INSTANCE
    }

    default void initialize(script) {

    }

    default void before(script) {

    }

    void execute(script)

    default void after(script) {

    }

    default void onFailure(script, Exception exception) {
        throw exception // todo should we eat this and exit gracefully `script.error(exception.message)`
    }
}
