package project.algothproject;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class MainPageController extends Application {

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button refreshButton;

    @FXML
    private Text dateText;

    @FXML
    private TextArea descriptionField;

    @FXML
    private ListView<String> listView;

    @FXML
    private Button orderButton;

    @FXML
    private CheckBox reverseCheck;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchField;

    ArrayList<Task> tasks = Instruments.readObject();

    public void initialize() {
//        tasks.add(new Task("Meeting with Client", "Discuss project details", LocalDate.of(2023, 12, 15), "14:30"));
//        tasks.add(new Task("Complete Coding Assignment", "Finish Java project", LocalDate.of(2023, 12, 18), "18:00"));
//        tasks.add(new Task("Gym Session", "Workout and stay healthy", LocalDate.of(2023, 12, 20), "07:00"));
//        tasks.add(new Task("Buy Groceries", "Essentials for the week", LocalDate.of(2023, 12, 16), "16:45"));
//        tasks.add(new Task("Read Book", "Start new novel", LocalDate.of(2023, 12, 14), "20:00"));
//        tasks.add(new Task("Project Deadline", "Submit final report", LocalDate.of(2023, 12, 22), "23:59"));
//        tasks.add(new Task("Family Dinner", "Quality time with loved ones", LocalDate.of(2023, 12, 17), "19:30"));
//        tasks.add(new Task("Morning Run", "Stay active", LocalDate.of(2023, 12, 19), "06:00"));
//        tasks.add(new Task("Work on Presentation", "Prepare slides for meeting", LocalDate.of(2023, 12, 21), "10:00"));
//        tasks.add(new Task("Visit Doctor", "Health checkup", LocalDate.of(2023, 12, 23), "11:15"));
//        Instruments.writeObject(tasks);
        updateListView(tasks);


        refreshButton.setOnAction(event -> {
            tasks = Instruments.readObject();
            updateListView(tasks);
            searchField.setText("");
            dateText.setText("");
            descriptionField.setText("");
        });

        addButton.setOnAction(event -> {
            try {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add-page.fxml")));
                Stage stage = new Stage();
                stage.setTitle("Add New...");
                stage.setScene(new Scene(root));
                stage.show();
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        listView.setOnMouseClicked(event -> {
            // Get the selected item's index
            int selectedIndex = listView.getSelectionModel().getSelectedIndex();

            // Perform actions based on the selected item
            if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
                Task selectedTask = tasks.get(selectedIndex);

                // Insert the description into the TextArea
                descriptionField.setText(selectedTask.getDetails());
                dateText.setText(selectedTask.getDate() + " Time: " + selectedTask.getTime());
            }
            deleteButton.setOnAction(actionEvent ->{
                tasks.remove(tasks.get(selectedIndex));
                updateListView(tasks);
                Instruments.writeObject(tasks);
                descriptionField.setText("");
                dateText.setText("");
            });
        });

        orderButton.setOnAction(event ->{
            if(reverseCheck.isSelected()){
                updateListView(Instruments.selectionSortDesc(tasks));
            }
            else {
                updateListView(Instruments.bubbleSortAsc(tasks));
            }
        });

        searchButton.setOnAction(event ->{
            if(Instruments.isValidTimeFormat(searchField.getText())){
                Instruments.bubbleSortAsc(tasks);

                ArrayList<Task> searchResult = Instruments.linearSearchByTime(searchField.getText(), tasks);

                updateListView(searchResult);
            }
            else Instruments.showAlert("Enter time in correct format!!!", Alert.AlertType.WARNING);
        });
    }

    private void updateListView(ArrayList<Task> tasks) {
        listView.getItems().clear(); // Clear existing items

        for (Task task : tasks) {
            listView.getItems().add(task.getDescription());
        }
    }


    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-page.fxml")));
        stage.setTitle("To-Do-List");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
