package com.hansion.hble.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hansion.h_ble.BleController;
import com.hansion.h_ble.callback.OnReceiverCallback;
import com.hansion.h_ble.callback.OnWriteCallback;
import com.hansion.hble.R;

public class SendAndReciveActivity extends AppCompatActivity implements View.OnClickListener {

    private BleController mBleController;
    private Button mSendButton;
    private EditText mSendEdit;
    private TextView mReciveText;
    private StringBuffer mReciveString = new StringBuffer();
    public static final String REQUESTKEY_SENDANDRECIVEACTIVITY = "SendAndReciveActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_and_recive);

        initView();

        // TODO 在新的界面要获取实例，无需init
        mBleController = BleController.getInstance();

        // TODO 接收数据的监听
        mBleController.registReciveListener(REQUESTKEY_SENDANDRECIVEACTIVITY, new OnReceiverCallback() {
            @Override
            public void onRecive(byte[] value) {
                mReciveString.append(mBleController.bytesToHexString(value) + "\r\n");
                mReciveText.setText(mReciveString.toString());
            }
        });
    }

    private void initView() {
        mSendButton = (Button) findViewById(R.id.mSendButton);
        mSendEdit = (EditText) findViewById(R.id.mSendEdit);
        mReciveText = (TextView) findViewById(R.id.mReciveText);

        mSendButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mSendButton:
                String sendText = mSendEdit.getText().toString().trim();
                if (TextUtils.isEmpty(sendText)) {
                    Toast.makeText(this, "请输入要发送的内容！", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    byte[] bytes = sendText.getBytes();

                    // TODO 发送数据 可以输入 A 测试，如果串口调试工具显示为0x41 代表接收正确
                    mBleController.writeBuffer(bytes, new OnWriteCallback() {
                        @Override
                        public void onSuccess() {
                            Toast.makeText(SendAndReciveActivity.this, "发送成功！", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailed(int state) {
                            Toast.makeText(SendAndReciveActivity.this, "发送失败！", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                break;

            default:

                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //移除接收数据的监听
        mBleController.unregistReciveListener(REQUESTKEY_SENDANDRECIVEACTIVITY);
        // TODO 断开连接
        mBleController.closeBleConn();
    }
}
