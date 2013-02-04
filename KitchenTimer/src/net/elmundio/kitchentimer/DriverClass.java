package net.elmundio.kitchentimer;

public class DriverClass {
    
	static TimeSource ts;
	
	public static void main(String[] args){
		
		
		System.out.println("TEST OUTPUT");
		ts = TimeSource.getInstance();
		ts = TimeSource.getInstance();
		ts = TimeSource.getInstance();
		
		
	    TimerCollection tc = new TimerCollection();
	    Timer t1 = new Timer(0, 5);
	    Timer t2 = new Timer(0,10);
	    Timer t3 = new Timer(0,10);
	    tc.addTimer(t1);
	    tc.addTimer(t2);
	    tc.addTimer(t3);
	    
	    TimerCollection tc2 = new TimerCollection();
	    Timer t4 = new Timer(0,10);
	    Timer t5 = new Timer(0,10);
	    tc2.addTimer(t4);
	    tc2.addTimer(t5);
	    
	    tc.startTimer();
	    tc2.startTimer();
	    
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
