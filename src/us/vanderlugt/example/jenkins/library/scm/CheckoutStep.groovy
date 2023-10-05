package us.vanderlugt.example.jenkins.library.scm

import us.vanderlugt.example.jenkins.library.PipelineStep

class CheckoutStep implements PipelineStep
{
    @Override
    void execute( script )
    {
        script.checkout script.scm
    }
}
