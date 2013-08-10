package tangyong.wab.sample.web.cdi;

import javax.enterprise.inject.Produces;

import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleReference;

public class BundleContextProducer {
	
    @Produces
    public BundleContext getBundleContext() {
        BundleContext bc = BundleReference.class.cast(getClass().getClassLoader()).getBundle().getBundleContext();
        return bc;
    }
}