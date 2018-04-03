import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {

	Timer dingTimer;
	Timer dongTimer;

	public TimerDemo(int ding,int dong) {

		dingTimer = new Timer();
		//dingTimer.schedule(new Sound("Ding!"), ding * 1000, ding * 1000);
		dingTimer.scheduleAtFixedRate(new Sound("Ding!"), ding * 1000, ding * 1000);

		dongTimer = new Timer();
		//dongTimer.schedule(new Sound("Dong!"), dong * 1000, dong * 1000);
		dongTimer.scheduleAtFixedRate(new Sound("Dong!"), dong * 1000, dong * 1000);
	}

	public static void main(String args[]) {
		new TimerDemo(2,4);
	}
}
class Sound extends TimerTask {

	Toolkit toolkit;
	String sound;

	public Sound(String sound) {
		this.sound = sound;
		toolkit = Toolkit.getDefaultToolkit();
	}

	public void run() {
		System.out.println(sound);
		//toolkit.beep();
	}
}