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

import java.io.*;
import java.util.ArrayList;

public class Main extends Application {
    public static ArrayList<SaveState> dataArray;
static{
    try {
         dataArray = new ArrayList<SaveState>();
        FileInputStream input = new FileInputStream("C:\\Users\\Randell\\IdeaProjects\\BD for Administration\\src\\src\\SaveBD\\saveBD.ser");
        ObjectInputStream objPut = new ObjectInputStream(input);

        dataArray.add((SaveState) objPut.readObject());


    objPut.close();

    }
    catch(Exception e){

    }
    System.out.println(dataArray.toString());
}
      public static ObservableList<Official> dataOfficial= FXCollections.observableArrayList();

    public static FileChooser fileChooser;
    public static File filePathChosser;
    @Override
    public void start(Stage primaryStage) throws Exception{
        for(var vol:dataArray){
            dataOfficial.add(new Official(vol.getNameInfo(),vol.getEmailInfo(),vol.getPathInfo()));
        }

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
