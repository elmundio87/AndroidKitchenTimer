package net.elmundio.kitchentimer;

import java.util.Observable;

public class TimeSource extends Observable implements Runnable{
	
	
	public TimeSource()
	{
		
	}

	@Override
	public void run() {
		try {
			while(true){
			System.out.println("tick");
			Thread.sleep(1000);
			setChanged();
			notifyObservers("tock");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
