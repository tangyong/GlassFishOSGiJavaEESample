package tangyong.wab.sample.module2;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import tangyong.wab.sample.core.Module;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		 context.registerService(Module.class.getName(), new Module2(context), null);
	     System.out.println("Module2 started");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		 System.out.println("Module2 stopped");
	}

}
