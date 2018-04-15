package vincent.designModel.Adapater.对象适配;

/**
 * Created by vincent on 2016/11/18.
 * email-address:674928145@qq.com
 * description:
 */

public class ObjectAdapterTest {
    public static void main(String arg[]) {
        Chinese chinese = new Chinese();
        ObjectAdapter objectAdapter = new ObjectAdapter(chinese);
        objectAdapter.speakEnglish("哈哈");
    }
}
