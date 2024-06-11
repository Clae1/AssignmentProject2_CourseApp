/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseapp;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author claeo
 */
public class MainMenuPanel extends JPanel 
{
    //For MainPage
    public JButton ExitButton = new JButton("EXIT");
    public JComboBox CourseBox = new JComboBox();
    public JButton RemovePaperButton = new JButton("Remove your chosen papers");
    public JTextArea MainMenuInfo = new JTextArea();
    
    public MainMenuPanel()
    {
        this.setBackground(Color.GRAY);
        this.setLayout(null);
        
        ExitButton.setBounds(0, 0, 100, 50);
        ExitButton.setBackground(Color.RED);
        
        String[] courses = 
        {"Bachelor of Computer Science", "Bachelor of Business", "Bachelor of Engineering Technology"};        
        CourseBox = new JComboBox(courses);
        CourseBox.setBounds(100, 100, 225, 100);
        
        RemovePaperButton.setBounds(340, 100, 200, 100);
        
        MainMenuInfo.setBounds(580, 10, 200, 330);
        MainMenuInfo.setText("Will add a variable later");
        MainMenuInfo.setEditable(false);
        
        this.add(MainMenuInfo);
        this.add(ExitButton);
        this.add(CourseBox);
        this.add(RemovePaperButton);
    }
}
