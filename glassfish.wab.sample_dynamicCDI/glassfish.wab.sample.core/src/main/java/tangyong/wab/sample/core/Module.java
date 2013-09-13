package tangyong.wab.sample.core;

import java.net.URL;

public interface Module {
	    public String getModuleName();
	    public URL getResource(String path);
	    public String getAboutPage();
}
