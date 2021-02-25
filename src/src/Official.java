package src;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Hyperlink;

import java.io.Serializable;

public  class Official  {
    private final SimpleStringProperty Name;
    private final SimpleStringProperty Email;
    private final SimpleObjectProperty<Hyperlink> File;
    private String path;
    public Official(String Name,String Email,String path){
        this.Name=new SimpleStringProperty(Name);
        this.Email=new SimpleStringProperty(Email);
        this.File=new SimpleObjectProperty(new Hyperlink("Download"));
        this.path=path;
    }
    public String getName(){
        return this.Name.get();
    }
    public String getPath(){
        return this.path;
    }
    public String getEmail(){
        return this.Email.get();
    }
    public Hyperlink getFile(){
        return this.File.get();
    }
    public void setName(String Name){
        this.Name.set(Name);
    }
    public void setPath(String path){
        this.path=path;
    }
    public void setEmail(String Email){
        this.Email.set(Email);
    }
    public void setFile(String File){
        this.Email.set(File);
    }
}
