package tangyong.wab.sample.jsf;

import java.net.URL;

import javax.faces.view.facelets.ResourceResolver;

import tangyong.wab.sample.web.cdi.Util;

public class MyResourceResolver extends ResourceResolver {
    private ResourceResolver parent;
    
    public MyResourceResolver(ResourceResolver parent) {
        this.parent = parent;
    }

    @Override
    public URL resolveUrl(String path) {
        System.out.println("Resolving " + path);
        URL url = null;
        try {
            url = Util.getResourceFromModule(path);
            
            if (url == null) {
                url = parent.resolveUrl(path);
            }

        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return url;
    }
    
    
}
