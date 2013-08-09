package tangyong.wab.sample.module2;

import java.net.URL;

import org.osgi.framework.BundleContext;

import tangyong.wab.sample.core.Module;

public class Module2 implements Module{
	
	public static final String MODULE_NAME = "MODULE_2";
    private BundleContext bc;
    
    public Module2(BundleContext bc) {
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
