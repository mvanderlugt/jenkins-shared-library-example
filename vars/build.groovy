import us.vanderlugt.example.jenkins.library.Pipeline

def pipeline( Closure pipelineDefinition )
{
    Pipeline.initialize( this )
    pipelineDefinition()
    Pipeline.execute()
}
