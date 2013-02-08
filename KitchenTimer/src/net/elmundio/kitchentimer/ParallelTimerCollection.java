package net.elmundio.kitchentimer;

import java.util.ArrayList;

public class ParallelTimerCollection {

	ArrayList<SequentialTimerCollection> timerCollections = new ArrayList<SequentialTimerCollection>();
	
	boolean finalised = false;
	
	public ParallelTimerCollection(){
		
	}
	
	public void AddTimerCollection(SequentialTimerCollection t){
		timerCollections.add(t);
	}
	
	public void RemoveTimerCollectoin(SequentialTimerCollection t){
		timerCollections.remove(t);
	}
	
	public void Finalise()
	{
		int min = 0;
		SequentialTimerCollection t_max = null;
		for(SequentialTimerCollection t: timerCollections)
		{
			if(t.getTotalTimeInSeconds() > min)
			{
				t_max = t;
				min = t.getTotalTimeInSeconds();
			}
		}
		
		for(SequentialTimerCollection t: timerCollections)
		{
			if(t.getTotalTimeInSeconds() < t_max.getTotalTimeInSeconds())
			{
				t.addTimer(new Timer(t_max.getTotalTimeInSeconds() - t.getTotalTimeInSeconds()));
			}
		}
		
		finalised = true;
	}
	
	public void startAllTimers(){
		
	}
	
	public void stopAllTimers(){
		
	}
}
