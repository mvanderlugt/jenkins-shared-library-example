package us.vanderlugt.example.jenkins.library

class Pipeline implements Serializable
{
    private static Pipeline instance
    private final def script

    private PipelineAgent agent
    private List<PipelineStep> steps

    private Pipeline( script )
    {
        this.script = script
    }

    static Pipeline initialize( script )
    {
        if( instance == null )
        {
            instance = new Pipeline( script )
        }
        else
        {
            script.echo "WARNING: Pipeline re-initialized"
            instance = new Pipeline( script )
        }
        return instance
    }

    static Pipeline getInstance()
    {
        if( instance == null )
        {
            throw new IllegalStateException( "Pipeline must be initialized first" )
        }
        return instance
    }

    static Pipeline agent( PipelineAgent agent )
    {
        def instance = getInstance()
        instance.agent = agent
        return instance
    }

    static Pipeline addStep( PipelineStep step )
    {
        def instance = getInstance()
        instance.steps.add( step )
        return instance
    }

    void execute()
    {
        agent.execute( script ) {
            for( PipelineStep step : steps )
            {
                step.execute( script )
            }
        }
    }
}
