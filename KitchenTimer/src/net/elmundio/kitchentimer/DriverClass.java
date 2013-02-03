package net.elmundio.kitchentimer;

public class DriverClass {
    
	static TimeSource ts;
	
	public static void main(String[] args){
		
		
		System.out.println("TEST OUTPUT");
		ts = TimeSource.getInstance();
		
	    
	    TimerCollection tc = new TimerCollection();
	    Timer t1 = new Timer(10, 0);
	    Timer t2 = new Timer(1,0);
	    tc.addTimer(t1);
	    tc.addTimer(t2);
	    
	    tc.startTimers();
	    
		//testCreateTimeAndTickThreeTimes(1,1);
		//testCreateTimeAndTickThreeTimes(0,1);
		//testCreateTimeAndTickThreeTimes(0,100);
		//testCreateTimeAndTickThreeTimes(0,59);
		//testCreateTimerAndAttachToTimeSource(0,8);
		//testCreateTimerAndAttachToTimeSource(5,01);
		//testCreateTimerAndAttachToTimeSource(10,59);
		//testCreateTimerAndAttachToTimeSource(100,59);
		//testCreateTimerAndAttachToTimeSource(101,59);
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
		Timer t = new Timer(minutes, seconds);
		
		ts.addObserver(t);

	}
}
