import static org.junit.Assert.*;

import net.elmundio.kitchentimer.Timer;

import org.junit.Test;


public class TimerTest {

	@Test
	public void testTimerConstructor() {
		Timer t = new Timer(5,0);
		assertEquals(t.toString(), "5:00");
	}

}
