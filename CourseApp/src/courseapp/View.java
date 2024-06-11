/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseapp;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
/**
 *
 * @author claeo
 */
public class View extends JFrame implements Observer {
//For user page
    public LoginPanel loginPanel = new LoginPanel();
    
    //For MainPage
    public MainMenuPanel mainMenuPanel = new MainMenuPanel();
    
    //For Course page
    public CoursePanel coursePanel = new CoursePanel();
    
    //For Remove page
    public RemovePanel removePanel = new RemovePanel();
   
    //Constructor 
    public View()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);
        this.setLocationRelativeTo(null); 
        this.add(loginPanel);
        this.setVisible(true);
    }
    
    public void mainMenu()
    {
        //Changing the size and location of the GUI
        this.setLocation(500,300);
        this.setSize(800, 400); 
        this.getContentPane().removeAll();
        this.add(mainMenuPanel);
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }
    
    public void CourseMenu()
    {
        this.getContentPane().removeAll();
        this.add(coursePanel);
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }
    
    public void RemoveMenu()
    {
        this.getContentPane().removeAll();
        this.add(removePanel);
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }
    
  
    public void addActionListener(ActionListener listener)
    {
        coursePanel.ExitButton.addActionListener(listener);
        removePanel.ExitButton.addActionListener(listener);
        loginPanel.loginButton.addActionListener(listener);
        mainMenuPanel.RemovePaperButton.addActionListener(listener);
        mainMenuPanel.PaperButton.addActionListener(listener);
    }

    @Override
    public void update(Observable o, Object arg) {
        Data data = (Data) arg;
        if (!data.loginFlag) {
            loginPanel.unInput.setText("");
            loginPanel.pwInput.setText("");
            loginPanel.message.setText("Invalid username or password.");
        }

        if (data.loginFlag) {
            this.mainMenu();
        }
        
        // Only allows one menu on.
        if (data.CourseFlag) 
        {
            this.CourseMenu();
        } 
        else if (data.removeFlag) 
        {
            this.RemoveMenu();
        } 
        else if (!data.CourseFlag && !data.removeFlag) 
        {
            this.mainMenu();
        }
    }
}
