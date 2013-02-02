package net.elmundio.kitchentimer;

public class Timer {
	
	private int id;
	private Time time;
	
	public Timer (int seconds)
	{
		time = new Time();
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
	

}
