package vincent.datastruct;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import vincent.datastruct.R;
import vincent.other.HandlerSth;

public class HandlerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);


        findViewById(R.id.tv_test).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                HandlerSth handlerSth = new HandlerSth();
                handlerSth.sendMessage();

                handlerSth.sendToTarget();

                handlerSth.sendMessageFromThread();

                handlerSth.handlerThreadTest();
            }
        });
    }
}
