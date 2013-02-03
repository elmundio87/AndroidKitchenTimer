package net.elmundio.kitchentimer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	public TimeSource ts;
	Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String message = (String)msg.obj;
            TextView text = (TextView) findViewById(R.id.textView1);
            text.setText(message);
        }
    };
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(onClickListener);
        ts = TimeSource.getInstance();
   	 	Thread thread = new Thread(ts);
   	 	thread.start();
   	 	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void startTimer(View view){
    	String message = "Initialising";
        TextView text = (TextView) findViewById(R.id.textView1);
        text.setText(message);
    	Timer t = new Timer(100, 0, mHandler);
    	ts.addObserver(t);
    }
    

    OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
        	Intent myintent = new Intent(MainActivity.this, Activity_CreateTimer.class);
            startActivity(myintent);    
        }
    };

 


    
}
