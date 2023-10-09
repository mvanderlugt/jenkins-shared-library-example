import us.vanderlugt.example.jenkins.library.PipelineManager

import java.time.Duration
import java.time.temporal.ChronoUnit

def pipeline(Closure pipelineDefinition) {
    PipelineManager.initialize(this)
    pipelineDefinition()
    PipelineManager.execute()
}

def timeout(int time = 60, ChronoUnit unit = ChronoUnit.MINUTES) {
    PipelineManager.setTimeout(Duration.of(60, unit))
}