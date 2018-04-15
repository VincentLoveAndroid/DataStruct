package vincent.designModel.ReflectFactory;

/**
 * Created by MingRen on 2016/9/5.
 */
public class ConcreateFactory implements ReflectFactory {
    @Override
    public <T extends Product> T produce(Class<T> clz) {
        T t = null;
        try {
            t = (T) Class.forName(clz.getName()).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }
}
