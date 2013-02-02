package net.elmundio.kitchentimer;

public class DriverClass {
    
	public static void main(String[] args){
		System.out.println("TEST OUTPUT");
		testCreateTimeAndTickThreeTimes(1,1);
		testCreateTimeAndTickThreeTimes(0,1);
		testCreateTimeAndTickThreeTimes(0,100);
		testCreateTimeAndTickThreeTimes(0,59);

	}
	
	public static void testCreateTimeAndTickThreeTimes(int minutes, int seconds)
	{
		Time t;
		try {
			System.out.println("Timer created with " + Integer.toString(minutes) + ":" + Integer.toString(seconds));
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
}
