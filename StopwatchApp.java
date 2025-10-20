import java.util.Scanner;

class Stopwatch {
    private long startTime;
    private long elapsedTime;
    private boolean running;

    // Start the stopwatch
    public void start() {
        if (!running) {
            startTime = System.currentTimeMillis();
            running = true;
            System.out.println("Stopwatch started.");
        } else {
            System.out.println("Stopwatch is already running!");
        }
    }

    // Stop the stopwatch
    public void stop() {
        if (running) {
            elapsedTime += System.currentTimeMillis() - startTime;
            running = false;
            System.out.println("Stopwatch stopped.");
        } else {
            System.out.println("Stopwatch is not running!");
        }
    }

    // Reset the stopwatch
    public void reset() {
        startTime = 0;
        elapsedTime = 0;
        running = false;
        System.out.println("Stopwatch reset.");
    }

    // Get elapsed time in seconds
    public double getElapsedTime() {
        long totalTime = elapsedTime;
        if (running) {
            totalTime += System.currentTimeMillis() - startTime;
        }
        return totalTime / 1000.0;
    }
}

public class StopwatchApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stopwatch sw = new Stopwatch();
        int choice;

        do {
            System.out.println("\n--- STOPWATCH MENU ---");
            System.out.println("1. Start");
            System.out.println("2. Stop");
            System.out.println("3. Reset");
            System.out.println("4. Show Elapsed Time");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sw.start();
                    break;
                case 2:
                    sw.stop();
                    break;
                case 3:
                    sw.reset();
                    break;
                case 4:
                    System.out.printf("Elapsed Time: %.2f seconds%n", sw.getElapsedTime());
                    break;
                case 5:
                    System.out.println("Exiting Stopwatch...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}



