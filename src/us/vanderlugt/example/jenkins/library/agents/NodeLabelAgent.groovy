package us.vanderlugt.example.jenkins.library.agents

import us.vanderlugt.example.jenkins.library.PipelineAgent

class NodeLabelAgent implements PipelineAgent
{
    private String label = ""

    @Override
    void execute( script, Closure pipeline )
    {
        script.node(label) {
            pipeline()
        }
    }
}
