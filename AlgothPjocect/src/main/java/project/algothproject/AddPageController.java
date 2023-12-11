package project.algothproject;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class AddPageController {

    @FXML
    private Button addButton;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField descriptionField;

    @FXML
    private TextArea detailArea;

    @FXML
    private TextField time;

    public void initialize(){
        addButton.setOnAction(event ->{
            if(datePicker.getValue() == null || descriptionField.getText() == null
            || detailArea.getText() == null || time.getText() == null
            || !Instruments.isValidTimeFormat(time.getText())){
                Instruments.showAlert("Fill all fields", Alert.AlertType.ERROR);
            }
            else {
                ArrayList<Task> tasks = Instruments.readObject();
                tasks.add(new Task(descriptionField.getText(), detailArea.getText(),
                        datePicker.getValue(), time.getText()));
                Instruments.writeObject(tasks);
                addButton.getScene().getWindow().hide();
            }
        });
    }

}

