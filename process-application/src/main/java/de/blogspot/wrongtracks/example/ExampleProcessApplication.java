package de.blogspot.wrongtracks.example;

import org.camunda.bpm.application.PostDeploy;
import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.extension.osgi.application.OSGiProcessApplication;
import org.osgi.framework.BundleContext;
import org.osgi.service.blueprint.container.BlueprintContainer;

@ProcessApplication(name="MyProcessApplication")
public class ExampleProcessApplication extends OSGiProcessApplication {
  
  public ExampleProcessApplication(BundleContext ctx, BlueprintContainer blueprintContainer) {
    super(ctx.getBundle(), blueprintContainer);
  }

  @PostDeploy
  public void executeProcess(ProcessEngine processEngine){
    processEngine.getRuntimeService().startProcessInstanceByKey("Process_1");
  }
}
