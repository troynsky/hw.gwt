package home.work.gwt.client.json;

import com.google.gwt.core.client.JavaScriptObject;

public class JsUser extends JavaScriptObject {

    protected JsUser() {
    }

    public native final String name() /*-{
        return this.name;
    }-*/;

}
