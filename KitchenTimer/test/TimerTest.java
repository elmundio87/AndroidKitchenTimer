import static org.junit.Assert.*;

import net.elmundio.kitchentimer.Timer;

import org.junit.Test;


public class TimerTest {

	@Test
	public void testTimerConstructor() {
		Timer t = new Timer(5,0);
		assertEquals(t.toString(), "5:00");
	}

	@Test
	public void testTimerTick() {
		Timer t = new Timer(5,0);
		t.tick();
		assertEquals(t.toString(), "4:59");
	}
	
}
