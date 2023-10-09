package us.vanderlugt.example.jenkins.library.checks

class SimpleCheck implements PipelineCheck {
    private String title
    private String name
    Status status
    Conclusion conclusion

    SimpleCheck( String title, String name )
    {
        this.title = title
        this.name = name
        this.status = Status.None
        this.conclusion = Conclusion.None
    }

    void publish( script )
    {
        if( status != Status.None )
        {
            script.publishChecks title: title, name: name, status: status.value, conclusion: conclusion.value
        }
        else
        {
            throw new IllegalStateException( "Cannot publish pipeline check without a valid status" )
        }
    }
}
