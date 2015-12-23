package com.example.testmessage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {
	
	private int count = 0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
	public void testOnClick(View view) {
		count++;
		Intent intent = new Intent();
		intent.setAction("com.landicorp.zacloud.HAD_MSG");
		intent.putExtras(installMsg(count));
		this.sendBroadcast(intent);
		Log.i("Zhou", "-testOnClick-");
	}
	
	private Bundle installMsg(int index) {
		Bundle bundle = new Bundle();
		bundle.putString(Message.MSG_ID, Integer.toString(index));
		bundle.putString(Message.MSG_TITLE, "系统升级 "+index);
		bundle.putString(Message.MSG_CONTENT, getResources().getString(R.string.msg_test_content));
		bundle.putString(Message.MSG_TIME, "下午 3:14");
		return bundle;
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
