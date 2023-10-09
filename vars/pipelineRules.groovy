def isDeploymentPipeline() {
    return (env.TAG_NAME || ["master", "main"].contains(env.BRANCH_NAME))
}
