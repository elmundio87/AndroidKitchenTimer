import static org.junit.Assert.*;

import net.elmundio.kitchentimer.Time;
import net.elmundio.kitchentimer.Timer;

import org.junit.Test;


public class TimeTest {

	@Test
	public void testTimeTick() {
		Time t = null;
		try {
			t = new Time(5,0);
		} catch (Exception e) {
			
		}
		t.tick();
		assertEquals(t.toString(), "4:59");
	}
	

	@Test
	public void testTooManySeconds() {
		Time t = null;
		try {
			t = new Time(0,60);
			fail("Should have thrown an exception here");
		} catch (Exception e) {
			
		}
		
	}
	
	@Test
	public void testMinimumTimeIsZero() {
		Time t = null;
		try {
			t = new Time(0,1);
		} catch (Exception e) {
			
		}
		t.tick();
		t.tick();
		assertEquals(t.toString(), "0:00");
	}
	
	@Test
	public void testBigTime() {
		Time t = null;
		try {
			t = new Time(999999,0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		t.tick();
		assertEquals(t.toString(), "999998:59");
	}
}
