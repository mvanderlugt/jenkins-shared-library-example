import us.vanderlugt.example.jenkins.library.Pipeline
import us.vanderlugt.example.jenkins.library.scm.CheckoutStep

def checkout()
{
    Pipeline.addStep( new CheckoutStep() )
}