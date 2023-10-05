package us.vanderlugt.example.jenkins.library

abstract class PipelineStage implements PipelineStep
{
    private final String name

    PipelineStage( String name )
    {
        this.name = name
    }

    abstract void executeStage(script)

    @Override
    void execute( script )
    {
        script.stage( name ) {
            executeStage( script )
        }
    }
}