package project.algothproject;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Instruments {

    public static ArrayList<Task> bubbleSortAsc(ArrayList<Task> tasks) {
        int n = tasks.size();
        Task temp;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Task task1 = tasks.get(j);
                Task task2 = tasks.get(j + 1);

                // Compare by date first
                if (task1.getDate().isAfter(task2.getDate())) {
                    // Swap tasks
                    temp = tasks.get(j);
                    tasks.set(j, tasks.get(j + 1));
                    tasks.set(j + 1, temp);
                } else if (task1.getDate().isEqual(task2.getDate())) {
                    // If dates are equal, compare by time
                    if (task1.getTime().compareTo(task2.getTime()) > 0) {
                        // Swap tasks
                        temp = tasks.get(j);
                        tasks.set(j, tasks.get(j + 1));
                        tasks.set(j + 1, temp);
                    }
                }
            }
        }

        return tasks;
    }

    public static ArrayList<Task> selectionSortDesc(ArrayList<Task> tasks) {
        int n = tasks.size();

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < n; j++) {
                Task task1 = tasks.get(j);
                Task task2 = tasks.get(maxIndex);

                // Compare by date first
                if (task1.getDate().isAfter(task2.getDate())) {
                    maxIndex = j;
                } else if (task1.getDate().isEqual(task2.getDate())) {
                    // If dates are equal, compare by time
                    if (task1.getTime().compareTo(task2.getTime()) > 0) {
                        maxIndex = j;
                    }
                }
            }

            // Swap tasks
            Task temp = tasks.get(maxIndex);
            tasks.set(maxIndex, tasks.get(i));
            tasks.set(i, temp);
        }

        return tasks;
    }

    public static ArrayList<Task> linearSearchByTime(String targetTime, ArrayList<Task> tasks) {
        ArrayList<Task> result = new ArrayList<>();

        for (Task task : tasks) {
            // Compare by time
            if (task.getTime().equals(targetTime)) {
                // Task found
                result.add(task);
            }
        }

        // Tasks not found
        return result;
    }

    public static void writeObject(ArrayList<Task> tasks){
        try{
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("src/main/java/project/algothproject/Tasks.txt"));
            outputStream.writeObject(tasks);
        }catch (IOException e){}
    }

    public static ArrayList<Task> readObject(){
        ObjectInputStream inputStream;
        try{
            inputStream = new ObjectInputStream(new FileInputStream("src/main/java/project/algothproject/Tasks.txt"));
            return (ArrayList<Task>) inputStream.readObject();
        }catch (IOException | ClassNotFoundException e){}
        return new ArrayList<>();
    }

    public static void showAlert(String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle("Alert");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static boolean isValidTimeFormat(String time) {
        // Define the regular expression for the time format
        String timeRegex = "^(?:[01]\\d|2[0-3]):[0-5]\\d$";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(timeRegex);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(time);

        // Check if the time string matches the pattern
        return matcher.matches();
    }

}
