package net.elmundio.kitchentimer;

public class Time {

	int minutes;
	int seconds;
	
	public Time ()
	{
		minutes = 0;
		seconds = 0;
	}
	
	public Time(int minutes, int seconds) throws Exception
	{
		this.minutes = minutes;
		this.seconds = seconds;
		
		if(this.seconds > 59)
		{
			throw new Exception("Too many seconds");
		}
	}
	
	public Time tick(){
		seconds = seconds - 1;
		if(seconds == -1)
		{
			seconds = 59;
			minutes = minutes - 1;
		}
		
		if(minutes == -1)
		{
			minutes = 0;
			seconds = 0;
		}
		
		return this;
	}
	
	public String toString()
	{
		return new String(Integer.toString(minutes) + ":" + Integer.toString(seconds));
	}
	
}
