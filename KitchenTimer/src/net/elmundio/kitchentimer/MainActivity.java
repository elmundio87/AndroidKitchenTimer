package net.elmundio.kitchentimer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	public TimeSource ts;
	private ParallelTimerCollection ptc = new ParallelTimerCollection();

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Button button = (Button) findViewById(R.id.button2);
       // button.setOnClickListener(onClickListener);
        ts = TimeSource.getInstance();
   	 	//Thread thread = new Thread(ts);
   	 	//thread.start();
   	 	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void startTimer(View view){
    	ptc.Finalise();
    	ptc.startAllTimers();
    }
    
    public void pauseTimer(View view){
    	ptc.stopAllTimers();
    }
    
    public void addTimer(View view){
    	String message = "Initialising";
    	String label;
    	LinearLayout l = (LinearLayout) findViewById(R.id.layout_timers);
       	EditText edt_minutes = (EditText) findViewById(R.id.edt_minutes);
       	EditText edt_label = (EditText) findViewById(R.id.edt_label);
        label = edt_label.getText().toString();
       	final TextView timerName = new TextView(this);
        
    	
    	Handler mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                String message = (String)msg.obj;
                TextView text = timerName;
                text.setText(message);
            }
        };
        
        timerName.setText(edt_label.getText() + ": " + edt_minutes.getText() + ":00");
        SequentialTimerCollection stc = new SequentialTimerCollection(mHandler);
        int min = Integer.parseInt(edt_minutes.getText().toString().trim());
        Timer t = new Timer(min, 0, mHandler);
        stc.setLabel(label);
        stc.addTimer(t);
        ptc.AddTimerCollection(stc);
    	LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
    	l.addView(timerName);
        
    	edt_label.setText("");
        edt_minutes.setText("");
       
    }
    

    OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
        	Intent myintent = new Intent(MainActivity.this, Activity_CreateTimer.class);
            startActivity(myintent);    
        }
    };

 


    
}
