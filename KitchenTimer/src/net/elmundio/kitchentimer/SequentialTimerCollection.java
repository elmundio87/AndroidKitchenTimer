package net.elmundio.kitchentimer;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import android.os.Handler;

public class SequentialTimerCollection implements Observer{

	ArrayList<Timer> timers = new ArrayList<Timer>();
	public Handler mHandler; 
	private String label;
	int timerIndex = 0;
	

	public SequentialTimerCollection()
	{
		this.label = "";
		mHandler = new Handler();
	}
	
	
	public SequentialTimerCollection(String label)
	{
		this.label = label;
		mHandler = new Handler();
	}
	
	public SequentialTimerCollection(String label, Handler mHandler)
	{
		this.label = label;
		this.mHandler = mHandler;
	}
	
	public SequentialTimerCollection(Handler mHandler)
	{
		this.label = "";
		this.mHandler = mHandler;
	}
	
	
	public void addTimer(Timer timer){
		timer.setLabel(label);
		timers.add(timer);	
	}
	
	public void addTimerFirst(Timer timer){
		timer.setLabel(label);
		timers.add(0,timer);
	}
	
	public void removeTimer(int id){
		for(Timer t: timers)
		{
			if(t.getId() == id)
			{
				timers.remove(t);
			}
		}
	}
	
	public void startTimer(){
		startTimer(0);
	}
	
	
	public void stopAllTimers()
	{
		for(Timer t: timers)
		{
			t.stop();
		}
	}

	
	public void startTimer(int index){
		stopAllTimers();
		timers.get(index).start();
		timers.get(index).addObserver(this);
	}
	

	@Override
	public void update(Observable arg0, Object arg1) {
		arg0.deleteObserver(this);
		timerIndex += 1;
		if(timerIndex < timers.size()){
			startTimer(timerIndex);
		}
		else{
			stopAllTimers();
			alarm();
		}
	}
	
	public int getTotalTimeInSeconds(){
		int seconds = 0;
		for(Timer t: timers){
			seconds += t.getTimeInSeconds();
		}
		return seconds;
	}
	
	private void alarm()
	{
		System.out.println("TIMER HAS FINISHED RING RING RING");
	}


	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
	
}
