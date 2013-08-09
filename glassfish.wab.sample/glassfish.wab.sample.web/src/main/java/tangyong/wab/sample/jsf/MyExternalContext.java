package tangyong.wab.sample.jsf;

import java.net.MalformedURLException;
import java.net.URL;

import javax.faces.context.ExternalContext;
import javax.faces.context.ExternalContextWrapper;
import javax.inject.Inject;

import tangyong.wab.sample.web.cdi.ApplicationBean;
import tangyong.wab.sample.web.cdi.Util;

class MyExternalContext extends ExternalContextWrapper {
    @Inject
    private ApplicationBean appBean;
    private ExternalContext wrapped;

    public MyExternalContext(ExternalContext externalContext) {        
        wrapped = externalContext;
    }

    public URL getResource(String path) throws MalformedURLException {
        System.out.println("Looking for " + path);
        URL url = Util.getResourceFromModule(path);
        if (url == null) {
            url = getWrapped().getResource(path);
        }

        return url;
    }

    @Override
    public ExternalContext getWrapped() {
        return wrapped;
    }
    
    
}
