package net.elmundio.kitchentimer;

import java.util.Observable;
import java.util.Observer;

public class Timer implements Observer {
	
	private int id;
	private Time time;
	
	public Timer (int seconds)
	{
		try {
			time = new Time(0, seconds);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getId(){
		return id;
	}
	
	private Time tick()
	{
		return time.tick();	
	}
	
	public String toString()
	{
		return new String(Integer.toString(id) + time.toString());
	}

	@Override
	public void update(Observable obj, Object arg) {
		  String resp = (String) arg;
          System.out.println("\nReceived Response: " + resp );
	}
	

}
