package net.elmundio.kitchentimer;

import java.util.Observable;
import java.util.Observer;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class Timer extends Observable implements Observer {
	
	private int id;
	private Time time;
	private Handler mHandler; 
	private String label;

	public Timer (int seconds)
	{
		int remainder = seconds % 60;
		int minutes = (seconds - remainder) / 60;
		try {
			time = new Time(minutes, remainder);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Timer (int seconds, Handler mHandler)
	{
		int remainder = seconds % 60;
		int minutes = (seconds - remainder) / 60;
		this.mHandler = mHandler;
		try {
			time = new Time(minutes, remainder);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
			this.mHandler = mHandler;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getId(){
		return id;
	}
	
	public Time tick(){
		Time t = this.getTime().tick();
		if(t.minutes == 0 && t.seconds == 0)
		{
			setChanged();
			notifyObservers("finished");
		}
		return t;	
	}
	
	public String toString()
	{
		return new String(this.getLabel() + ": " + this.getTime().toString());
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
	
	public int getTimeInSeconds(){
		return (this.getTime().minutes * 60) + this.getTime().seconds;
	}
	
	public Time getTime()
	{
		return time;
	}
	
	public void setLabel(String label)
	{
		this.label = label;
	}
	
	public String getLabel()
	{
		return label;
	}
	

}
