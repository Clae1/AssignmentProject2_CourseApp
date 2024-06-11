/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author claeo
 */
import java.sql.SQLException;
import java.util.Observable;

public class Model extends Observable 
{
    public UserDatabase db;
    public Data data;
    public String username; 
    
 
    //Constructor 
    public Model() throws SQLException
    {
        this.db = new UserDatabase();
        this.db.dbsetup();
    }
    
    public void checkName(String username, String password) throws SQLException
    {
        this.username = username;
        this.data = this.db.checkName(username, password);
        this.setChanged(); 
        this.notifyObservers(this.data);
    }
    
    public void checkPaper(String username) throws SQLException
    {
        this.username = username;
        this.db.checkPaper(username);
        this.setChanged(); 
        this.notifyObservers(this.data);
    }
    
    public void AddPaper(String paper, String username) throws SQLException
    {
        this.data = this.db.AddPaper(paper, username);
        this.setChanged(); 
        this.notifyObservers(this.data);
    }
    
     public void RemovePaper(String paper, String username) throws SQLException
    {
        this.db.RemovePaper(paper, username);
        this.setChanged(); 
        this.notifyObservers(this.data);
    }
    
    public void changeToCourse(String course)
    {
        switch (course)
        {
            case("Bachelor of Computer Science"):
            {
                this.data.Course1Flag = true;
                this.data.loginFlag = false;
            }
            break;
            
            case("Bachelor of Business"):
            {
                this.data.Course2Flag = true;
                this.data.loginFlag = false;
            }
            break;
            
            case("Bachelor of Engineering Technology"):
            {
                this.data.Course3Flag = true;
                this.data.loginFlag = false;
            }
            break;
        }
        this.setChanged(); 
        this.notifyObservers(this.data);
    }
    
    public void checkFlag()
    {
        if (this.data.Course1Flag == true)
        {
            this.data.Course1Flag = false;
            this.data.loginFlag = true;
        }
        
        if (this.data.Course2Flag == true)
        {
            this.data.Course2Flag = false;
            this.data.loginFlag = true;
        }
        
        if (this.data.Course3Flag == true)
        {
            this.data.Course3Flag = false;
            this.data.loginFlag = true;
        }
        this.setChanged(); 
        this.notifyObservers(this.data);
    }
    
    public void changeToRemove()
    {
        this.data.removeFlag = true;
        this.setChanged(); 
        this.notifyObservers(this.data);
        this.data.removeFlag = false;
    }
}
