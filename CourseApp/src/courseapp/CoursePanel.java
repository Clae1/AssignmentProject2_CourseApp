/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseapp;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author claeo
 */
public class CoursePanel extends JPanel 
{
    public JLabel check = new JLabel("This page works");
    public JButton ExitButton = new JButton("EXIT");
    
    public CoursePanel()
    {
        ExitButton.setBounds(0, 0, 100, 50);
        ExitButton.setBackground(Color.RED);
        
        this.add(check);
        this.add(ExitButton);
        this.setBackground(Color.GRAY);
        this.setLayout(null);
    }
    
}
