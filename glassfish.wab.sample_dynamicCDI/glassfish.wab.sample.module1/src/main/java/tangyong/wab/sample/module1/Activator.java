package tangyong.wab.sample.module1;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import tangyong.wab.sample.core.Module;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		 context.registerService(Module.class.getName(), new Module1(context), null);
	     System.out.println("Module1 started");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		 System.out.println("Module1 stopped");
	}

}
