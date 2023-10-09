package us.vanderlugt.example.jenkins.library

import us.vanderlugt.example.jenkins.library.agents.PipelineAgent
import us.vanderlugt.example.jenkins.library.pipeline.*

import java.time.Duration

final class PipelineManager implements Serializable {
    private static BuildPipeline instance

    private static BuildPipeline getInstance() {
        if (instance == null) {
            instance = new BuildPipeline()
        }
        return instance
    }

    static BuildPipeline initialize(script) {
        return getInstance().initialize(script)
    }

    static BuildPipeline agent(PipelineAgent agent) {
        getInstance().agent(agent)
    }

    static BuildPipeline addStage(String name, PipelineSteps steps) {
        def stage = new PipelineStage(name, steps)
        return getInstance().addStep(stage)
    }

    static BuildPipeline addStep(PipelineStep step) {
        return getInstance().addStep(step)
    }

    static BuildPipeline setTimeout(Duration timeout) {
        return getInstance().setTimeout(timeout)
    }

    static void execute() {
        getInstance().execute()
    }
}
