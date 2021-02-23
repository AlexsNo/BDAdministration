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
    public static SaveState saveState = new SaveState();
    public static SaveState saveReturn;
static{
    try {

        FileInputStream input = new FileInputStream("C:\\Users\\Randell\\IdeaProjects\\BD for Administration\\src\\src\\SaveBD\\saveBD.ser");
        ObjectInputStream objPut = new ObjectInputStream(input);

        saveReturn=(SaveState) objPut.readObject();


    objPut.close();

    }
    catch(Exception e){

    }

}
      public static ObservableList<Official> dataOfficial= FXCollections.observableArrayList();

    public static FileChooser fileChooser;
    public static File filePathChosser;
    @Override
    public void start(Stage primaryStage) throws Exception{
        if(saveReturn!=null)
       for(int i=0;i<saveReturn.getPathInfo().size();i++){
           dataOfficial.add(new Official(saveReturn.getNameInfo().get(i),
                            saveReturn.getEmailInfo().get(i),
                             saveReturn.getPathInfo().get(i)));
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
