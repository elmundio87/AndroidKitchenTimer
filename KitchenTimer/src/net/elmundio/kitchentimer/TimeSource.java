package net.elmundio.kitchentimer;

import java.util.Observable;


public final class TimeSource extends Observable implements Runnable{
	
	
	private TimeSource()
	{
		Thread thread = new Thread(this);
	    thread.start();
	}

	public static TimeSource getInstance(){
		return fINSTANCE;
	}
	
	private static final TimeSource fINSTANCE = new TimeSource();
	
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
