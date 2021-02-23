package src;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class SaveState implements Serializable {
    private ArrayList<String> nameInfo;
    private ArrayList<String> emailInfo;
    private ArrayList<String> pathInfo;

    public SaveState(){

    }

    public ArrayList<String> getNameInfo(){
        return nameInfo;
    }

    public ArrayList<String> getEmailInfo(){
        return emailInfo;
    }
    public ArrayList<String> getPathInfo(){
        return pathInfo;
    }
    public void setData(String nameInfo,String emailInfo,String pathInfo){
        this.nameInfo.add(nameInfo);
        this.emailInfo.add(emailInfo);
        this.pathInfo.add(pathInfo);
    }
    public ArrayList<Official> officialReturn(){
        ArrayList<Official> temp = new ArrayList<Official>();
       for(int i=0;i<nameInfo.size();i++){
           temp.add(new Official(nameInfo.get(i),emailInfo.get(i),pathInfo.get(i)));
       }
       return temp;
    }
    public void writeDate(){
        for(var vol:Main.dataOfficial){
            nameInfo.add(vol.getName());
            emailInfo.add(vol.getEmail());
            pathInfo.add(vol.getPath());
        }
        try{
            FileOutputStream outPut = new FileOutputStream("C:\\Users\\Randell\\IdeaProjects\\BD for Administration\\src\\src\\SaveBD\\saveBD.ser");
            ObjectOutputStream objPut = new ObjectOutputStream(outPut);
            objPut.writeObject(officialReturn());
            objPut.close();
        }
        catch(Exception e){

        }

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



