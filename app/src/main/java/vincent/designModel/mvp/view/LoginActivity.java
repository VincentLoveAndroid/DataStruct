package vincent.designModel.mvp.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import vincent.datastruct.R;
import vincent.designModel.mvp.presenter.IPresenter;
import vincent.designModel.mvp.presenter.PresenterImp;


/**
 * Created by MingRen on 2016/8/29.
 * email:674928145@qq.com
 * address:shenzhen
 */
public class LoginActivity extends Activity implements IView, View.OnClickListener {
    private TextView tvLogin;
    private TextView tvClearText;
    private EditText etName;
    private EditText etPsw;
    private IPresenter presenter;
    private Bitmap mBitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }


    private void init() {

        tvLogin = (TextView) findViewById(R.id.tv_login);
        tvClearText = (TextView) findViewById(R.id.tv_clear_text);
        etName = (EditText) findViewById(R.id.et_name);
        etPsw = (EditText) findViewById(R.id.et_psw);
        tvLogin.setOnClickListener(this);
        tvClearText.setOnClickListener(this);

        presenter = new PresenterImp(this);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        System.out.println("onAttachedToWindow");
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        System.out.println("onDetachedFromWindow");
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        System.out.println("attachBaseContext");
    }

    @Override
    public void login() {
        Toast.makeText(this, "正在登录...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearText() {
        etName.setText("");
        etPsw.setText("");
    }

    @Override
    public void onLoginResult(String name) {
        Toast.makeText(this, name + " 登录成功啦", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_login:
                presenter.Login(etName.getText().toString().trim(), etPsw.getText().toString().trim());
//                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.tv_clear_text:
                presenter.clearText();
                break;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
