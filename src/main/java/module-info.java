module com.example.provoronoi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.provoronoi to javafx.fxml;
    exports com.example.provoronoi;
}