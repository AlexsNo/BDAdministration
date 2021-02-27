package src;

import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;


public class SaveState implements Serializable {
    private String nameInfo;
    private String emailInfo;
    private String pathInfo;
    private static ArrayList<SaveState> temp=new ArrayList<SaveState>();

    public SaveState(String nameInfo,String emailInfo,String pathInfo){
        this.nameInfo=nameInfo;
        this.emailInfo=emailInfo;
        this.pathInfo=pathInfo;
    }
    public String getNameInfo(){
        return nameInfo;
    }
    public String getEmailInfo(){
        return emailInfo;
    }
    public String getPathInfo(){
        return pathInfo;
    }

    public static void setData(String nameInfo,String emailInfo,String pathInfo){
        temp.add(new SaveState(nameInfo,emailInfo,pathInfo));
    }

    public static void writeDate(){
            var vol=Main.dataOfficial.get(Main.dataOfficial.size()-1);
                setData(vol.getName(),vol.getEmail(),vol.getPath());

        try{
            FileOutputStream outPut = new FileOutputStream("C:\\Users\\Randell\\IdeaProjects\\BD for Administration\\src\\src\\SaveBD\\saveBD.ser");
            ObjectOutputStream objPut = new ObjectOutputStream(outPut);
            objPut.writeObject(temp);
            objPut.close();
            outPut.close();
        }
        catch(Exception e){

        }

    }
    public static  ArrayList<SaveState> readDate() throws  Exception{
        ArrayList<SaveState> temp;


            FileInputStream inPut = new FileInputStream("C:\\Users\\Randell\\IdeaProjects\\BD for Administration\\src\\src\\SaveBD\\saveBD.ser");
            ObjectInputStream objIn = new ObjectInputStream(inPut);
            temp = (ArrayList<SaveState>) objIn.readObject();
            objIn.close();
            inPut.close();
        return  temp;
        }
    @Override
    public String toString() {
        return "SaveState{" +
                "nameInfo=" + getNameInfo() +
                ",emailInfo=" +getEmailInfo() +
                ",pathInfo=" + getPathInfo() +
                '}';
    }
    }



