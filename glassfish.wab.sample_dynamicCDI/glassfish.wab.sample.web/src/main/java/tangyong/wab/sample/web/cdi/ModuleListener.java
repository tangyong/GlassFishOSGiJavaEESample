package tangyong.wab.sample.web.cdi;

import javax.inject.Inject;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;

import tangyong.wab.sample.core.Module;

public class ModuleListener implements ServiceListener {

    private BundleContext bc;
    
    @Inject
    private ApplicationBean appBean;
    
    @Inject
    public void initialize(BundleContext bc) {
        this.bc = bc;
    }

    public void serviceChanged(ServiceEvent event) {
        Object object = bc.getService(event.getServiceReference());

        if (object instanceof Module) {
            Module module = (Module) object;
            switch (event.getType()) {
                case ServiceEvent.REGISTERED:
                    appBean.afterAddModule(module);
                    break;
                case ServiceEvent.UNREGISTERING:
                    appBean.beforeRemoveModule(module);
                    break;
                default:
                    break;
            }
        }
    }
}
