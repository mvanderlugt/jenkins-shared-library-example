
def call(Map pipelineParams) {
    build.pipeline {
        buildAgent.anyAvailable()

        versionControl.checkout()

        gradleStages.build()

        if( pipelineRules.isDeploymentPipeline() )
        {
            deployment.webhook()

//        gradleStages.integrationTest()
        }
    }
}
