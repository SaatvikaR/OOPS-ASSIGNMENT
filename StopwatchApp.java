import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopwatchApp extends JFrame implements ActionListener {

    // GUI components
    private JLabel timeLabel;
    private JButton startButton, stopButton, resetButton;

    // Timer variables
    private int elapsedTime = 0; // in milliseconds
    private boolean running = false;

    // Swing timer (updates every 1 second)
    private Timer timer;

    public StopwatchApp() {
        // Frame setup
        setTitle("Stopwatch App");
        setSize(300, 200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center on screen

        // Label to show time
        timeLabel = new JLabel(formatTime(0));
        timeLabel.setFont(new Font("Verdana", Font.BOLD, 30));

        // Buttons
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");

        // Add action listeners
        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        resetButton.addActionListener(this);

        // Add to frame
        add(timeLabel);
        add(startButton);
        add(stopButton);
        add(resetButton);

        // Timer setup (every 1 second = 1000 ms)
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                elapsedTime += 1000;
                timeLabel.setText(formatTime(elapsedTime));
            }
        });

        setVisible(true);
    }

    // Format time as HH:MM:SS
    private String formatTime(int millis) {
        int seconds = (millis / 1000) % 60;
        int minutes = (millis / 60000) % 60;
        int hours = millis / 3600000;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    // Button actions
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            if (!running) {
                timer.start();
                running = true;
            }
        } else if (e.getSource() == stopButton) {
            timer.stop();
            running = false;
        } else if (e.getSource() == resetButton) {
            timer.stop();
            running = false;
            elapsedTime = 0;
            timeLabel.setText(formatTime(0));
        }
    }

    // Main method
    public static void main(String[] args) {
        new StopwatchApp();
    }
}
