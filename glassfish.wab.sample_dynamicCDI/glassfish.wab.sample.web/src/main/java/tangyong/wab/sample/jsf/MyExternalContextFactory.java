package tangyong.wab.sample.jsf;

import javax.faces.FacesException;
import javax.faces.context.ExternalContext;
import javax.faces.context.ExternalContextFactory;

public class MyExternalContextFactory extends ExternalContextFactory {
    private ExternalContextFactory parent;

    public MyExternalContextFactory (ExternalContextFactory parent) {
        super();
        this.parent = parent;
    }

    @Override
    public ExternalContext getExternalContext(Object context, Object request, Object response) throws FacesException {
        return new MyExternalContext(getWrapped().getExternalContext(context, request, response));
    }

    @Override
    public ExternalContextFactory getWrapped() {
        return parent;
    }
}

