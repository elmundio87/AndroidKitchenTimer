import static org.junit.Assert.*;

import net.elmundio.kitchentimer.ParallelTimerCollection;
import net.elmundio.kitchentimer.SequentialTimerCollection;
import net.elmundio.kitchentimer.Timer;

import org.junit.Test;


public class ParallelTimerCollectionTest {

	@Test
	public void testFinaliseWithTwoTimers() {
		ParallelTimerCollection ptc = new ParallelTimerCollection();
		SequentialTimerCollection stc1 = new SequentialTimerCollection();
		SequentialTimerCollection stc2 = new SequentialTimerCollection();
		Timer t1 = new Timer(5,0);
		Timer t2 = new Timer(2,0);
		stc1.addTimer(t1);
		stc2.addTimer(t2);
		ptc.AddTimerCollection(stc1);
		ptc.AddTimerCollection(stc2);
		assertEquals(stc2.getTotalTimeInSeconds(), 120);
		ptc.Finalise();
		assertEquals(stc2.getTotalTimeInSeconds(), stc1.getTotalTimeInSeconds());
	}
	
	@Test
	public void testFinaliseWithOneTimer() {
		ParallelTimerCollection ptc = new ParallelTimerCollection();
		SequentialTimerCollection stc1 = new SequentialTimerCollection();
		Timer t1 = new Timer(5,0);
		stc1.addTimer(t1);
		ptc.AddTimerCollection(stc1);
		assertEquals(stc1.getTotalTimeInSeconds(), 300);
		ptc.Finalise();
		assertEquals(stc1.getTotalTimeInSeconds(), 300);
	}
	
	
	@Test
	public void testFinaliseWithTwoTimersThatContainMultipleTimers() {
		ParallelTimerCollection ptc = new ParallelTimerCollection();
		SequentialTimerCollection stc1 = new SequentialTimerCollection();
		SequentialTimerCollection stc2 = new SequentialTimerCollection();
		Timer t1 = new Timer(10,0);
		Timer t2 = new Timer(5,0);
		Timer t3 = new Timer(5,0);
		Timer t4 = new Timer(6,0);
		
		stc1.addTimer(t1);
		stc1.addTimer(t2);
		stc2.addTimer(t3);
		stc2.addTimer(t4);
		
		ptc.AddTimerCollection(stc1);
		ptc.AddTimerCollection(stc2);
		
		assertEquals(stc1.getTotalTimeInSeconds(), 900);
		assertEquals(stc2.getTotalTimeInSeconds(), 660);
		ptc.Finalise();
		assertEquals(stc1.getTotalTimeInSeconds(), 900);
		assertEquals(stc2.getTotalTimeInSeconds(), 900);
		
	}
	
	@Test
	public void testFinaliseWithTwoIdenticalTimers() {
		ParallelTimerCollection ptc = new ParallelTimerCollection();
		SequentialTimerCollection stc1 = new SequentialTimerCollection();
		SequentialTimerCollection stc2 = new SequentialTimerCollection();
		Timer t1 = new Timer(5,0);
		Timer t2 = new Timer(5,0);
	
		stc1.addTimer(t1);
		stc2.addTimer(t2);
	
		ptc.AddTimerCollection(stc1);
		ptc.AddTimerCollection(stc2);
		
		assertEquals(stc1.getTotalTimeInSeconds(), 300);
		assertEquals(stc2.getTotalTimeInSeconds(), 300);
		ptc.Finalise();
		assertEquals(stc1.getTotalTimeInSeconds(), 300);
		assertEquals(stc2.getTotalTimeInSeconds(), 300);
		
	}
	
	

}
