package us.vanderlugt.example.jenkins.library.checks

enum Conclusion {
    None("NONE"), Success("SUCCESS"), Failure("FAILURE"), Canceled("CANCELED")

    final String value

    Conclusion(String value) {
        this.value = value
    }
}
