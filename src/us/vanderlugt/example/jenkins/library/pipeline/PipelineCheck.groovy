package us.vanderlugt.example.jenkins.library.pipeline

interface PipelineCheck extends Serializable {
    void setStatus(Status status)

    void setConclusion(Conclusion conclusion)

    void publish(script)

    enum Status {
        None(""), Queued("QUEUED"), InProgress("IN_PROGRESS"), Completed("COMPLETED")

        final String value

        Status(String value) {
            this.value = value
        }
    }

    enum Conclusion {
        None("NONE"), Success("SUCCESS"), Failure("FAILURE"), Canceled("CANCELED")

        final String value

        Conclusion(String value) {
            this.value = value
        }
    }
}