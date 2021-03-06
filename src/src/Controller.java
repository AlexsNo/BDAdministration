package src;

import java.io.*;
import java.util.Calendar;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller   {
    @FXML
    private TableColumn TableCol1;

    @FXML
    private TableColumn TableCol2;

    @FXML
    private TableColumn TableCol3;

    @FXML
    private TableView<Official> TableV;

    @FXML
    private TextField TextF1;

    @FXML
    private Button Button1;

    @FXML
    private Button Button2;

    @FXML
    private Button Button3;

    @FXML
    private TextField TextF2;

    @FXML
    private Label Lab1;

    @FXML
    void initialize() {
        TableCol1.setCellValueFactory(new PropertyValueFactory<Official,String>("name"));
        TableCol2.setCellValueFactory(new PropertyValueFactory<Official,String>("email"));
        TableCol3.setCellValueFactory(new PropertyValueFactory<Official,String>("file"));
        TableV.setItems(Main.dataOfficial);
        TableV.getColumns().addAll(TableCol1,TableCol2,TableCol3);
         Button1.setOnAction(event ->{
            Main.dataOfficial.add(new Official(TextF1.getText(),TextF2.getText(),Main.filePathChosser.toString()));
            hyperAction(false);
             SaveState.writeDate();
    });



         Button2.setOnAction(event -> {
             Stage stage = new Stage();
             Main.FileInput(stage);
    });
        Button3.setOnAction(event -> {

        });

    }
    public static void hyperAction(boolean bol) {
        if(bol){
            for(var vol:Main.dataOfficial){
                vol.getFile().setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {
                            File fileIn = new File(vol.getPath());
                            File fileOut = new File("C:\\Users\\Randell\\IdeaProjects\\BD for Administration\\src\\src\\Download\\"+fileIn.getName());
                            FileInputStream input = new FileInputStream(fileIn);
                            FileOutputStream output = new FileOutputStream(fileOut);
                            BufferedInputStream buffer = new BufferedInputStream(input);
                            byte[] data=new byte[buffer.available()];
                            while(buffer.available()>0) {
                                buffer.read(data, 0, data.length);
                            }
                            output.write(data,0,data.length);
                            output.close();
                            buffer.close();
                        }
                        catch (Exception e){

                        }

                    }
                });
            }
        }
        else{

            Main.dataOfficial.get(Main.dataOfficial.size()-1).getFile().setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {
                            File fileIn = new File(Main.dataOfficial.get(Main.dataOfficial.size()-1).getPath());
                            File fileOut = new File("C:\\Users\\Randell\\IdeaProjects\\BD for Administration\\src\\src\\Download\\"+fileIn.getName());
                            FileInputStream input = new FileInputStream(fileIn);
                            FileOutputStream output = new FileOutputStream(fileOut);
                            BufferedInputStream buffer = new BufferedInputStream(input);
                            byte[] data=new byte[buffer.available()];
                            while(buffer.available()>0) {
                                buffer.read(data, 0, data.length);
                            }
                            output.write(data,0,data.length);
                            output.close();
                            buffer.close();
                        }
                        catch (Exception e){

                        }

                    }
                });

        }
    }


}
