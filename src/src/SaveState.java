package src;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SaveState {
    private String nameInfo;
    private String emailInfo;
    private String pathInfo;

    public SaveState(String nameInfo,String emailInfo,String pathInfo){
        this.nameInfo = nameInfo;
        this.emailInfo = emailInfo;
        this.pathInfo = pathInfo;
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
    public void setNameInfo(String nameInfo){
        this.nameInfo = nameInfo;
    }
    public void setEmailInfo(String emailInfo){
        this.emailInfo = emailInfo;
    }
    public void setPathInfo(String pathInfo){
        this.pathInfo = pathInfo;
    }
    public void SaveDate(){
        try{
            FileOutputStream input = new Inp
        }
        catch (Exception e){

        }
    }


}
