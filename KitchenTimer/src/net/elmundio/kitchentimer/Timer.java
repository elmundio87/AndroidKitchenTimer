package net.elmundio.kitchentimer;

import java.util.Observable;
import java.util.Observer;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class Timer extends Observable implements Observer {
	
	private int id;
	private Time time;
	private TextView text;
	private Handler mHandler; 
	
	
	public Timer (int minutes, int seconds)
	{
		try {
			time = new Time(minutes, seconds);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Timer (int minutes, int seconds, Handler mHandler)
	{
		try {
			time = new Time(minutes, seconds);
			this.text = text;
			this.mHandler = mHandler;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getId(){
		return id;
	}
	
	private Time tick(){
		Time t = time.tick();
		if(t.minutes == 0 && t.seconds == 0)
		{
			setChanged();
			notifyObservers("finished");
		}
		return t;	
	}
	
	public String toString()
	{
		return new String(time.toString());
	}
	
	public void start()
	{
		TimeSource.getInstance().addObserver(this);
	}
	
	public void stop()
	{
		TimeSource.getInstance().deleteObserver(this);
	}


	@Override
	public void update(Observable obj, Object arg) {
		  String resp = (String) arg;
          this.tick();
                  
        
        	  Message msg = new Message();
              msg.obj = this.toString();
              mHandler.sendMessage(msg);
   

          
		  System.out.println(this.toString() );
	}
	

}
