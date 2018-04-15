package vincent.designModel.Observer;

/**
 * Created by MingRen on 2016/8/30.
 */
public abstract class AbstractSubject {

    public abstract void addObserver(Observerable observer);

    public abstract void removeObserver(Observerable observer);

    public abstract void notifyObserver();

    public abstract void update();
}
