package vincent.designModel.Bridge;

import org.w3c.dom.NamedNodeMap;

/**
 * Created by MingRen on 2016/8/30.
 */
public class MyBridge extends Bridge {
    @Override
    protected void setSource(Sourceable source) {
        this.source = source;
    }

    @Override
    protected void sing() {
        if (source != null) source.sing();
    }

}
