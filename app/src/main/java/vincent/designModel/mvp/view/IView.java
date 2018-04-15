package vincent.designModel.mvp.view;

/**
 * Created by MingRen on 2016/9/1.
 */
public interface IView{

    void login();

    void clearText();

    void onLoginResult(String name);
}
