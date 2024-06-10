import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateAndTime {

    public static void main(String[] args) {
        // Create a JPanel to hold the input fields
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        // Create a sub-panel for the date fields
        JPanel datePanel = new JPanel(new FlowLayout());
        datePanel.add(new JLabel("YYYY:"));
        JTextField yearField = new JTextField(4);
        datePanel.add(yearField);

        datePanel.add(new JLabel("MM:"));
        JTextField monthField = new JTextField(2);
        datePanel.add(monthField);

        datePanel.add(new JLabel("DD:"));
        JTextField dayField = new JTextField(2);
        datePanel.add(dayField);

        // Add labels and date panel to the main panel
        panel.add(new JLabel("Enter the date of your trip:"));
        panel.add(datePanel);

        // Create a sub-panel for the time fields
        JPanel timePanel = new JPanel(new FlowLayout());
        timePanel.add(new JLabel("HH:"));
        JTextField hourField = new JTextField(2);
        timePanel.add(hourField);

        timePanel.add(new JLabel("MM:"));
        JTextField minuteField = new JTextField(2);
        timePanel.add(minuteField);

        // Add labels and time panel to the main panel
        panel.add(new JLabel("Enter the time of your trip:"));
        panel.add(timePanel);

        // Add an empty label and a submit button
        panel.add(new JLabel(""));
        JButton submitButton = new JButton("Submit");
        panel.add(submitButton);

        // Create a JOptionPane to display the panel
        int result = JOptionPane.showConfirmDialog(null, panel, "Trip Planner", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String year = yearField.getText();
            String month = monthField.getText();
            String day = dayField.getText();
            String hour = hourField.getText();
            String minute = minuteField.getText();

            // Combine year, month, and day into a single date string
            String date = year + "-" + month + "-" + day;

            // Combine hour and minute into a single time string
            String time = hour + ":" + minute;

            // Validate date and time
            if (isValidDate(date) && isValidTime(time)) {
                JOptionPane.showMessageDialog(null, "Your trip is scheduled for " + date + " at " + time + ".",
                        "Trip Scheduled", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid date or time format. Please try again.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Method to validate date format
    private static boolean isValidDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    // Method to validate time format
    private static boolean isValidTime(String time) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        timeFormat.setLenient(false);
        try {
            timeFormat.parse(time);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
