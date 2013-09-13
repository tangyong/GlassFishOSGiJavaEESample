package tangyong.wab.sample.web.cdi;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import tangyong.wab.sample.core.Module;

public class ServiceTrackerProducer {
    
    @Produces
    public ServiceTracker getServiceTracker(BundleContext bc) {
        ServiceTracker st = new ServiceTracker(bc, Module.class.getName(), null);        
        st.open();
        return st;
    }

    public void close(@Disposes ServiceTracker st) {
        st.close();
    }
}