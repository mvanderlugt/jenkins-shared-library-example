package us.vanderlugt.example.jenkins.library.pipeline

interface PipelineAgent extends Serializable {
    void execute(script, Closure pipeline)
}
