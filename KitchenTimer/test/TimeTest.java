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
			e.printStackTrace();
		}
		t.tick();
		assertEquals(t.toString(), "4:59");
	}
	

	@Test
	public void test60secondsIsOneMinute() {
		Time t = null;
		try {
			t = new Time(0,60);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(t.toString(), "1:00");
	}
	
	@Test
	public void testMinimumTimeIsZero() {
		Time t = null;
		try {
			t = new Time(0,1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		t.tick();
		t.tick();
		assertEquals(t.toString(), "0:00");
	}
}
