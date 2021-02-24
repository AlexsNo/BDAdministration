package src;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SaveState implements Serializable {
    private String nameInfo;
    private String emailInfo;
    private String pathInfo;
    private static ArrayList<SaveState> temps = new ArrayList<SaveState>();
    public SaveState(String nameInfo,String emailInfo,String pathInfo){
        this.nameInfo=nameInfo;
        this.nameInfo=emailInfo;
        this.nameInfo=pathInfo;
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
        temps.add(new SaveState(nameInfo,emailInfo,pathInfo));
    }

    public static void writeDate(){
        for(var vol:Main.dataOfficial){
            setData(vol.getName(), vol.getEmail(),vol.getPath());
        }
        try{
            FileOutputStream outPut = new FileOutputStream("C:\\Users\\Randell\\IdeaProjects\\BD for Administration\\src\\src\\SaveBD\\saveBD.ser");
            ObjectOutputStream objPut = new ObjectOutputStream(outPut);
            objPut.writeObject(temps);
            objPut.close();
            outPut.close();
        }
        catch(Exception e){

        }

    }
    public static  ArrayList<SaveState> readDate(){
        try{
            Object temp=null;
            FileInputStream inPut = new FileInputStream("C:\\Users\\Randell\\IdeaProjects\\BD for Administration\\src\\src\\SaveBD\\saveBD.ser");
            ObjectInputStream objIn = new ObjectInputStream(inPut);
            temp=objIn.readObject();
            objIn.close();
            inPut.close();
            return (ArrayList<SaveState>) temp;

        }
        catch(Exception c){
            c.printStackTrace();
        }
        return  null;
    }

    @Override
    public String toString() {
        return "SaveState{" +
                "nameInfo=" + getNameInfo() +
                ", emailInfo=" + getNameInfo() +
                ", pathInfo=" + getPathInfo() +
                '}';
    }
    }



