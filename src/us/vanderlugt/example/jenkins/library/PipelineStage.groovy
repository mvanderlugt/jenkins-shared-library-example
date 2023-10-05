package us.vanderlugt.example.jenkins.library

interface PipelineStage extends PipelineStep
{
    String name()
}