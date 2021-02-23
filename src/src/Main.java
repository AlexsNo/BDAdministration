package src;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {
      public static ObservableList<Official> dataOfficial= FXCollections.observableArrayList(new Official("Novikov","mail","C:\\Users\\Randell\\IdeaProjects\\BD for Administration\\src\\src\\1.txt")
      ,new Official("Novikov","mail","C:\\Users\\Randell\\IdeaProjects\\BD for Administration\\src\\src\\2.txt"));
    public static FileChooser fileChooser;
    public static File filePathChosser;
    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("MainFXML.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }
    public static void FileInput(Stage stage) {
        fileChooser= new FileChooser();
        fileChooser.setTitle("Choose file");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.showOpenDialog(stage);


    }


    public static void main(String[] args) {
        launch(args);
    }
}
