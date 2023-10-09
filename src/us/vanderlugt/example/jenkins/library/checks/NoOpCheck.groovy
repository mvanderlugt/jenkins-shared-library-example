package us.vanderlugt.example.jenkins.library.checks

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
