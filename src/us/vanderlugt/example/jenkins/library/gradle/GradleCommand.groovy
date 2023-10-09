package us.vanderlugt.example.jenkins.library.gradle

class GradleCommand implements Serializable {
    private List<String> tasks
    private boolean useWrapper
    private List<String> flags = [
            "--no-daemon",
            "--refresh-dependencies",
            "--stacktrace"
    ]

    void execute(script) {
        script.sh "${gradleCommand} ${flags.join(" ")} ${tasks.join(" ")}"
    }

    private String getGradleCommand() {
        return useWrapper ? "./gradlew" : "gradle"
    }
}
