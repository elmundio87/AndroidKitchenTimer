package net.elmundio.kitchentimer;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class SequentialTimerCollection implements Observer{

	ArrayList<Timer> timers = new ArrayList<Timer>();
	int timerIndex = 0;
	
	public void addTimer(Timer timer){
		timers.add(timer);
		
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
	
	
	private void stopAllTimers()
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
	
	private void alarm()
	{
		System.out.println("TIMER HAS FINISHED RING RING RING");
	}
	
}
