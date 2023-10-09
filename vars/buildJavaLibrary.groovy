
def call(Map pipelineParams) {
    build.pipeline {
        buildAgent.anyAvailable()

        build.durabilityHint("PERFORMANCE_OPTIMIZED")

        versionControl.checkout()

        gradleStages.build()

        if( pipelineRules.isDeploymentPipeline() )
        {
            deployment.webhook()

//        gradleStages.integrationTest()
        }
    }
}
