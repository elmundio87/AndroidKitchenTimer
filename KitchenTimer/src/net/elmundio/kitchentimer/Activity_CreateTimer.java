package net.elmundio.kitchentimer;

import android.os.Bundle;
import android.app.Activity;

import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Activity_CreateTimer extends Activity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createtimer);
           	 	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void button1_click(View view){
    	EditText timerName = new EditText(this);
    	EditText timerMinutes = new EditText(this);
    	timerName.setHint("Timer Name");
    	timerMinutes.setHint("Minutes");
    	
    	
    	LinearLayout ll = (LinearLayout)findViewById(R.id.mainView);
    	LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
    	LinearLayout ll2 = new LinearLayout(this);
    	
    	ll2.addView(timerName);
    	ll2.addView(timerMinutes);
    	ll.addView(ll2);
    }
    
}
