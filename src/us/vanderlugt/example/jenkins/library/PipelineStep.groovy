package us.vanderlugt.example.jenkins.library

interface PipelineStep extends Serializable
{
    void execute(script)
}