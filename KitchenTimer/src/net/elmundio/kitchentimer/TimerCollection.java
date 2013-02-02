package net.elmundio.kitchentimer;

import java.util.ArrayList;

public class TimerCollection {

	ArrayList<Timer> timers = new ArrayList<Timer>();
	
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
	
}
