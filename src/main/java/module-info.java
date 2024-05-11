module com.example.j2fp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.j2fp to javafx.fxml;
    exports com.example.j2fp;
}