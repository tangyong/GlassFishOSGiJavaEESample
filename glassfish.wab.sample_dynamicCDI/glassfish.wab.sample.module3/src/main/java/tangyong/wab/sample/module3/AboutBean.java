package tangyong.wab.sample.module3;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.glassfish.osgicdi.DynamicBean;

@Named("aboutBean_module3")
@RequestScoped
@DynamicBean(hostContextPath="/wabsample")
public class AboutBean {
    private String message;

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String greeting(){
    	return  "/" + Module3.MODULE_NAME + "/greeting.xhtml";
    }
    
    
}
