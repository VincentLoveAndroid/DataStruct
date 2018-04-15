package vincent.designModel.ProtoType;

/**
 * Created by MingRen on 2016/8/29.
 */
public class ProtoTypeTest {

    public static void main(String[] args) {
        ProtoTypeImp cp = new ProtoTypeImp();
        for (int i = 0; i < 10; i++) {
            ProtoTypeImp protoTypeImp = (ProtoTypeImp) cp.deepClone();
            protoTypeImp.show();
        }
    }
}
