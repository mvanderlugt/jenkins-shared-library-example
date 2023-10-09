package us.vanderlugt.example.jenkins.library.agents

interface PipelineAgent extends Serializable {
    void execute(script, Closure pipeline)
}
