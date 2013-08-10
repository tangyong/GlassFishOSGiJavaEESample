package tangyong.wab.sample.web.cdi;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import tangyong.wab.sample.core.Module;

@Named
@ApplicationScoped
public class ApplicationBean {

    @Inject
    private BundleContext bc;
    
    @Inject
    private ModuleListener moduleListener;
    
    private List<Module> modules = new ArrayList<Module>();

    @Inject
    public void initialize(ServiceTracker st) {
        bc.addServiceListener(moduleListener);        
        loadServices(st);
    }

   public void afterAddModule(Module module) {
        System.out.println("Module added.");
        modules.add(module);
    }

    public void beforeRemoveModule(Module module) {
        System.out.println("Module removed");
        modules.remove(module);
    }

    public List<Module> getModules() {
        return modules;
    }

    private void loadServices(ServiceTracker st) {
        ServiceReference[] srs = st.getServiceReferences();
        if (srs != null) {
            for (ServiceReference sr : srs) {
                Module m = (Module) bc.getService(sr);
                modules.add(m);
            }
        }
    }    
        
}
