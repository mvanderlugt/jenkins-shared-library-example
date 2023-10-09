package us.vanderlugt.example.jenkins.library.checks

enum Status {
    None(""), Queued("QUEUED"), InProgress("IN_PROGRESS"), Completed("COMPLETED")

    final String value

    Status(String value) {
        this.value = value
    }
}
