package net.elmundio.kitchentimer;

public class DriverClass {
    
	static TimeSource ts;
	
	public static void main(String[] args){
		
		
		System.out.println("TEST OUTPUT");
		ts = TimeSource.getInstance();
		ts = TimeSource.getInstance();
		ts = TimeSource.getInstance();
		
		
	    SequentialTimerCollection tc = new SequentialTimerCollection();
	    Timer t1 = new Timer(0, 5);
	    Timer t2 = new Timer(0,10);
	    Timer t3 = new Timer(0,10);
	    tc.addTimer(t1);
	    tc.addTimer(t2);
	    tc.addTimer(t3);
	    
	    SequentialTimerCollection tc2 = new SequentialTimerCollection();
	    Timer t4 = new Timer(0,10);
	    Timer t5 = new Timer(0,10);
	    tc2.addTimer(t4);
	    tc2.addTimer(t5);
	    
	    tc.startTimer();
	    tc2.startTimer();

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
