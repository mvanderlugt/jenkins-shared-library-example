import us.vanderlugt.example.jenkins.library.BuildGradleStage

def build(String name = "Build", String tasks = "clean build", boolean useWrapper = true) {
    new BuildGradleStage(this).execute()
}
