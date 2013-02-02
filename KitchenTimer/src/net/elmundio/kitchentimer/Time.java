package net.elmundio.kitchentimer;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Time {

	int minutes;
	int seconds;
	
	public Time ()
	{
		this.minutes = 0;
		this.seconds = 0;
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
	
	private String getFormattedTime(){
		String minutes = Integer.toString(this.minutes);
		String seconds = String.format("%02d",this.seconds);
		return minutes + ":" + seconds;
		
	}
	
	public String toString()
	{
		return getFormattedTime();
	}
	
}
