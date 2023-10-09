package us.vanderlugt.example.jenkins.library.pipeline

import us.vanderlugt.example.jenkins.library.checks.PipelineCheck

interface PipelineStep extends Serializable {
    PipelineCheck getCheck()

    void initialize(script)

    void before(script)

    void execute(script)

    void after(script)

    void onFailure(script, Exception exception)
}
