package org.hutsdev;

import org.hutsdev.elements.CustomPanel;
import org.hutsdev.elements.ShadowLabel;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ClockFrame extends JFrame {

    SimpleDateFormat timeFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel = new ShadowLabel();
    JLabel dateLabel = new ShadowLabel();
    boolean colonVisible = true;

    ClockFrame() {
        setContentPane(new CustomPanel());
        this.setSize(350, 220);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Clock");
        this.setLayout(new BorderLayout());

        timeFormat = new SimpleDateFormat("HH:mm:ss");
        dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        timeLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setOpaque(false);


        dateLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        dateLabel.setHorizontalAlignment(JLabel.CENTER);
        dateLabel.setOpaque(false);

        this.add(timeLabel, BorderLayout.NORTH);
        this.add(dateLabel, BorderLayout.CENTER);
        this.setVisible(true);

        setTime();
    }

    public void setTime() {
        Timer timer = new Timer(1000, e -> {
            Calendar now = Calendar.getInstance();
            int hour = now.get(Calendar.HOUR_OF_DAY);

            if (hour >= 6 && hour < 18) {
                timeLabel.setForeground(Color.GREEN);
            } else if (hour >= 18 && hour < 22) {
                timeLabel.setForeground(Color.ORANGE);
            } else {
                timeLabel.setForeground(Color.CYAN);
            }

            // Миготіння двокрапки
            colonVisible = !colonVisible;
            String timePattern = colonVisible ? "HH:mm:ss" : "HH mm ss";

            timeFormat.applyPattern(timePattern);
            timeLabel.setText(timeFormat.format(now.getTime()));

            dateLabel.setText(dateFormat.format(now.getTime()));
        });
        timer.setInitialDelay(0);
        timer.start();
    }
}
