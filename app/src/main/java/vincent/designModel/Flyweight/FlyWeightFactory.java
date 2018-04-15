package vincent.designModel.Flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MingRen on 2016/8/30.
 */
public class FlyWeightFactory {

    private Map<Character, FlyWeight> flies = new HashMap<>();

    public FlyWeight produce(Character internalState) {//生产具体享元

        FlyWeight flyWeight = flies.get(internalState);//取享元对象

        if (flyWeight == null) {
            flyWeight = new ConcreteFlyWeight(internalState);
            flies.put(internalState, flyWeight);
        }
        return flyWeight;
    }
}
