
public class TestCountdown {
	
	public static void main(String[] args) {
		int seconds = 5;

        System.out.println("Countdown started:");

        while (seconds > 0) {
            System.out.println(seconds);
            seconds--;
            try {
                Thread.sleep(1000); // Sleep for 1 second (1000 milliseconds)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Countdown complete!");

	}

}
