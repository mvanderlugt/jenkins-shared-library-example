package us.vanderlugt.example.jenkins.library

final class Pipeline implements Serializable
{
    private static Pipeline instance
    private final def script

    private PipelineAgent agent
    private List<PipelineStep> steps = new LinkedList<>()

    private Pipeline( script )
    {
        this.script = script
    }

    private void executeInternal()
    {
        agent.execute( script ) {
            for( PipelineStep step : steps )
            {
                if( step instanceof PipelineStage )
                {
                    script.stage( step.name() ) {
                        step.execute( script )
                    }
                }
                else
                {
                    step.execute( script )

                }
            }
        }
    }

    private static Pipeline getInstance()
    {
        if( instance == null )
        {
            throw new IllegalStateException( "Pipeline must be initialized first" )
        }
        return instance
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

    static void execute()
    {
        getInstance().executeInternal()
    }
}
