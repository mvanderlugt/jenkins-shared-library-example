package us.vanderlugt.example.jenkins.library

interface PipelineAgent extends Serializable
{
    void execute( script, Closure pipeline )
}
