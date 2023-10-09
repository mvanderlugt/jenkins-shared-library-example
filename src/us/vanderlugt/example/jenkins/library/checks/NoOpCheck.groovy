package us.vanderlugt.example.jenkins.library.checks

import us.vanderlugt.example.jenkins.library.pipeline.PipelineCheck

class NoOpCheck implements PipelineCheck {
    public static final PipelineCheck INSTANCE = new NoOpCheck()

    private NoOpCheck() {
    }

    @Override
    void setStatus(Status status) {
        // does nothing
    }

    @Override
    void setConclusion(Conclusion conclusion) {
        // does nothing
    }

    @Override
    void publish(Object script) {
        // does nothing
    }
}
