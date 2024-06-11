/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.View;
import Model.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author claeo
 */
public class Controller implements ActionListener
{
    public View view; 
    public Model model;
    
  
    public Controller(View view, Model model)
    {
        this.view = view;
        this.model = model;
        this.view.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand(); 
        Object source = e.getSource();
        
        System.out.println("Action Command: " + command);
        
        switch (command){
            case "Log in":
            {
                // Login button 
                System.out.println("Log in button pressed");
                String username = this.view.loginPanel.unInput.getText(); 
                String password = this.view.loginPanel.pwInput.getText(); 
                {
                    try {
                        this.model.checkName(username, password); 
                        this.model.checkPaper(username);
                    } 
                    catch (SQLException ex) {
                        System.out.println(ex);
                    }
                }
            }
            break;
            
            case "EXIT":
            {
                System.out.println("The exit button works");
                this.model.checkFlag();
            }
            break;
            
            //Same thing as above, but to enter Remove Menu instead.
            case "Remove a chosen papers":
            {
                System.out.println("The Remove your chosen papers button works");
                this.model.changeToRemove();
            }
            break;
            
            case "comboBoxChanged":
            {
                System.out.println("The JBOX button works");
                if (source == this.view.coursePanel1.PaperBox)
                {
                    this.view.coursePanel1.PaperBox.getSelectedItem();
                    break;
                }
                
                if (source == this.view.coursePanel2.PaperBox)
                {
                    this.view.coursePanel2.PaperBox.getSelectedItem();
                    break;
                }
                
                if (source == this.view.coursePanel2.PaperBox)
                {
                    this.view.coursePanel1.PaperBox.getSelectedItem();
                    break;
                }
                
                if (source == this.view.removePanel.PaperBox)
                {
                    this.view.removePanel.PaperBox.getSelectedItem();
                    break;
                }
                String course = (String)this.view.mainMenuPanel.CourseBox.getSelectedItem();
                this.model.changeToCourse(course);
            }
            break;
            
            case "REMOVE COURSE/COURSES":
            {
                System.out.println("Remove Course button works");
                String paper = (String) this.view.removePanel.PaperBox.getSelectedItem();
                String username = this.model.username;
                try {
                    this.model.RemovePaper(paper, username);
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            
            case "ADD PAPER":
            {
                System.out.println("ADD PAPER button works");
                if (e.getSource() == this.view.coursePanel1.AddButton)
                {
                    String username = this.model.username;
                    String paper = (String) this.view.coursePanel1.PaperBox.getSelectedItem();
                    try {
                        this.model.AddPaper(paper, username);
                    } catch (SQLException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                if (e.getSource() == this.view.coursePanel2.AddButton)
                {
                    String username = this.model.username;
                    String paper = (String) this.view.coursePanel2.PaperBox.getSelectedItem();
                    try {
                        this.model.AddPaper(paper, username);
                    } catch (SQLException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                if (e.getSource() == this.view.coursePanel3.AddButton)
                {
                    String username = this.model.username;
                    String paper = (String) this.view.coursePanel3.PaperBox.getSelectedItem();
                    try {
                        this.model.AddPaper(paper, username);
                    } catch (SQLException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            break;
        }
    }
}
