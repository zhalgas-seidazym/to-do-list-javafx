module project.algothpjocect {
    requires javafx.controls;
    requires javafx.fxml;


    opens project.algothproject to javafx.fxml;
    exports project.algothproject;
}