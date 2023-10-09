package us.vanderlugt.example.jenkins.library.pipeline

interface PipelineStep extends Serializable {
    PipelineCheck getCheck()

    void initialize(script)

    void before(script)

    void execute(script)

    void after(script)

    void onFailure(script, Exception exception)
}
