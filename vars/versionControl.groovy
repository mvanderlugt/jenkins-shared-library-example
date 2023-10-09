import us.vanderlugt.example.jenkins.library.PipelineManager
import us.vanderlugt.example.jenkins.library.scm.CheckoutStep

def checkout() {
    PipelineManager.addStep(new CheckoutStep())
}
