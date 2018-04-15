package vincent.designModel.Adapater.对象适配;

/**
 * Created by vincent on 2016/11/18.
 * email-address:674928145@qq.com
 * description:
 */

public class ObjectAdapter extends Chinese implements English {
    private Chinese chinese;

    public ObjectAdapter(Chinese chinese) {
        this.chinese = chinese;
    }

    @Override
    public void speakEnglish(String word) {//对象适配器将方法改派
        chinese.speakChinese("汉语转英语" + word);
    }
}
