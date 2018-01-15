package stateandbehavior;

public class StopWatch {
	
	
	boolean start,stop;
	int totalticks,time,lap,lastLap;
	
	public StopWatch() {
		this.start = false;
		this.stop = false;
		this.totalticks = 0;
		this.time = -1;
		this.lap = -1;
		this.lastLap = -1;
	}
	
	public boolean isStarted() {
		return this.start;
	}
	
	public boolean isStopped() {
		return this.stop;
	}
	
	public int getTicks() {
		return this.totalticks;
	}
	
	public int getTime() {
		return this.time;
	}
	
	public int getLapTime() {
		return this.lap;
	}
	
	public int getLastLapTime() {
		return this.lastLap;
	}
	
	public void tick(int ticks) {
		this.totalticks += ticks;
		if (start && !stop) {
			this.time += ticks;
			this.lap += ticks;
		}
	}
	
	public void start() {
		this.start = true;
	}
	
	public void lap() {
		this.lastLap = this.lap;
		this.lap = 0;
	}
	
	public void stop() {
		this.stop = true;
	}
	
	
}
