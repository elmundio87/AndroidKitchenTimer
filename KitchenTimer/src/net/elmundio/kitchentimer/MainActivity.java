package net.elmundio.kitchentimer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
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
        ts = new TimeSource();
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
    


    
}
