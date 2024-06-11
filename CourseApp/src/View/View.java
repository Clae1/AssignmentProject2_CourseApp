/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Data;
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
    
    //For Course pages
    public CoursePanel1 coursePanel1 = new CoursePanel1();
    public CoursePanel2 coursePanel2 = new CoursePanel2();
    public CoursePanel3 coursePanel3 = new CoursePanel3();
    
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
    
    public void CourseMenu1()
    {
        this.getContentPane().removeAll();
        this.add(coursePanel1);
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }
    
    public void CourseMenu2()
    {
        this.getContentPane().removeAll();
        this.add(coursePanel2);
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }
    
    public void CourseMenu3()
    {
        this.getContentPane().removeAll();
        this.add(coursePanel3);
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
        //For the course pages 
        coursePanel1.ExitButton.addActionListener(listener);
        coursePanel1.AddButton.addActionListener(listener);
        coursePanel1.PaperBox.addActionListener(listener);
        
        coursePanel2.ExitButton.addActionListener(listener);
        coursePanel3.ExitButton.addActionListener(listener);
        
        //For the remove page 
        removePanel.ExitButton.addActionListener(listener);
        
        //For login page 
        loginPanel.loginButton.addActionListener(listener);
        
        //For Main menu page
        mainMenuPanel.RemovePaperButton.addActionListener(listener);
        mainMenuPanel.CourseBox.addActionListener(listener);
    }

    @Override
    public void update(Observable o, Object arg) 
    {
        Data data = (Data) arg;
         // These if statements are for the three course pages that the user
        // can enter by clicking on one of the items in the combox list. 
        if (data.Course1Flag) {
            this.CourseMenu1();
        } 
        else if (data.Course2Flag) {   
            this.CourseMenu2();
        } 
        else if (data.Course3Flag) {
            this.CourseMenu3();
        } 
        
        if (!data.loginFlag) {
            loginPanel.unInput.setText("");
            loginPanel.pwInput.setText("");
            loginPanel.message.setText("Invalid username or password.");
        }

        if (data.loginFlag) {
            this.mainMenu();
        }
                
        // Will change the frame to the remove paper 
        if (data.removeFlag){
            this.RemoveMenu();
        } 
    }
}
