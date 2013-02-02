package net.elmundio.kitchentimer;

public class DriverClass {
    
	static TimeSource ts;
	
	public static void main(String[] args){
		
		
		System.out.println("TEST OUTPUT");
		ts = new TimeSource();
		 Thread thread = new Thread(ts);
	     thread.start();
		//testCreateTimeAndTickThreeTimes(1,1);
		//testCreateTimeAndTickThreeTimes(0,1);
		//testCreateTimeAndTickThreeTimes(0,100);
		//testCreateTimeAndTickThreeTimes(0,59);
		testCreateTimerAndAttachToTimeSource(0,28);
		testCreateTimerAndAttachToTimeSource(0,59);
	}
	
	public static void testCreateTimeAndTickThreeTimes(int minutes, int seconds)
	{
		Time t;
		try {
			System.out.println("Time created with " + Integer.toString(minutes) + ":" + Integer.toString(seconds));
			t = new Time(minutes, seconds);
			t.tick();
			System.out.println(t.toString());
			t.tick();
			System.out.println(t.toString());
			t.tick();
			System.out.println(t.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
	
	public static void testCreateTimerAndAttachToTimeSource(int minutes, int seconds)
	{
		Timer t = new Timer(seconds);
		
		ts.addObserver(t);

	}
}
