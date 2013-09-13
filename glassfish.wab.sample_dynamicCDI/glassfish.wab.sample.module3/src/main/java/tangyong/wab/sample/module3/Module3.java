package tangyong.wab.sample.module3;

import java.net.URL;

import org.osgi.framework.BundleContext;

import tangyong.wab.sample.core.Module;

public class Module3 implements Module{
	
	public static final String MODULE_NAME = "MODULE_3";
    private BundleContext bc;
    
    public Module3(BundleContext bc) {
    	this.bc = bc;
    }

	@Override
	public String getAboutPage() {
		return "/about.xhtml";
	}

	@Override
	public String getModuleName() {
		 return MODULE_NAME;
	}

	@Override
	public URL getResource(String path) {
		return bc.getBundle().getEntry(path);
	}

}
