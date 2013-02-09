package net.elmundio.kitchentimer;

import android.os.Handler;

public class ScheduledTimer extends Timer {


	public ScheduledTimer(int seconds, Handler mHandler) {
		super(seconds, mHandler);
	}

	public String toString()
	{
		return new String(this.getLabel() + ": " + "Scheduled to start in " + this.getTime().toString());
	}
}
