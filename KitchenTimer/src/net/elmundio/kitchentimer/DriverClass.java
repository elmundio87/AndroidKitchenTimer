package net.elmundio.kitchentimer;

public class DriverClass {
    
	public static void main(String[] args){
		System.out.println("TEST OUTPUT");
		System.out.println("Timer starting at 1:01");
		
		Time t1 = new Time(1,1);
		System.out.println(t1.toString());
		t1.tick();
		System.out.println(t1.toString());
		t1.tick();
		System.out.println(t1.toString());
		t1.tick();
		System.out.println(t1.toString());
		
		System.out.println("Timer starting at 0:01");
		Time t2 = new Time(0,1);
		System.out.println(t2.toString());
		t2.tick();
		System.out.println(t2.toString());
		t2.tick();
		System.out.println(t2.toString());
		t2.tick();
		System.out.println(t2.toString());
		
	}
	
}
