package src;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;

public class Main extends Application  {
public static ObservableList<Official> dataOfficial= FXCollections.observableArrayList();
public static FileChooser fileChooser;
public static File filePathChosser;
static{
    try{
        for(var vol:SaveState.readDate()){
            dataOfficial.add(new Official(vol.getNameInfo(),vol.getEmailInfo(), vol.getPathInfo()));
            SaveState.setData(vol.getNameInfo(),vol.getEmailInfo(),vol.getPathInfo());
        }
    }
    catch (Exception e){

    }
    Controller.hyperAction(true);
}
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainFXML.fxml"));
        primaryStage.setTitle("BD Administration");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }
    public static void FileInput(Stage stage) {
        fileChooser= new FileChooser();
        fileChooser.setTitle("Choose file");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        Main.filePathChosser = Main.fileChooser.showOpenDialog(stage);
    }
    public static void main(String[] args) {
        launch(args);
    }
    public static ArrayList<Official> getData(ArrayList<SaveState> array){
        ArrayList<Official> temp=null;
        for(var vol:array){
            temp.add(new Official(vol.getNameInfo(),vol.getEmailInfo(),vol.getPathInfo()));
        }
        return  temp;
    }
}
