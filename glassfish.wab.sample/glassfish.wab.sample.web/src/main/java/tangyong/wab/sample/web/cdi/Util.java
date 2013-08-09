/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tangyong.wab.sample.web.cdi;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tangyong.wab.sample.core.Module;


public class Util {

    public static BeanManager getBeanManager() {
        InitialContext initialContext;
        try {
            initialContext = new InitialContext();
            BeanManager manager = (BeanManager) initialContext.lookup("java:comp/BeanManager");
            return manager;
        } catch (NamingException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static <T> T getBean(Class clazz) {
        BeanManager bm = getBeanManager();
        Bean<T> bean = (Bean<T>) bm.getBeans(clazz).iterator().next();
        CreationalContext<T> ctx = bm.createCreationalContext(bean);
        T cdiBean = (T) bm.getReference(bean, clazz, ctx);

        return cdiBean;
    }

    public static URL getResourceFromModule(String path) {
        URL url = null;
        ApplicationBean appBean = Util.getBean(ApplicationBean.class);

        for (Module m : appBean.getModules()) {
            Pattern p = Pattern.compile("/" + m.getModuleName() + "(/.+)");
            Matcher matcher = p.matcher(path);
            if (matcher.find()) {
                url = m.getResource(matcher.group(1));
            }
        }

        return url;

    }
}
