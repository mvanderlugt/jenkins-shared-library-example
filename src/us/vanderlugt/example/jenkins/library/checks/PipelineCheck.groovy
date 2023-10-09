package us.vanderlugt.example.jenkins.library.checks

import us.vanderlugt.example.jenkins.library.checks.Conclusion
import us.vanderlugt.example.jenkins.library.checks.Status

interface PipelineCheck extends Serializable {
    void setStatus(Status status)

    void setConclusion(Conclusion conclusion)

    void publish(script)


}