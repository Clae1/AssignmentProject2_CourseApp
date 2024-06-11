/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author claeo
 */
public class RemovePanel extends JPanel 
{
    //For RemoveMenu
    public JTextArea PaperDisplay = new JTextArea();
    private JLabel pRemove = new JLabel("Which paper would you like to remove? ");
    public JTextField RemoveInput = new JTextField(10);
    public JButton RemoveButton = new JButton("REMOVE COURSE/COURSES");
    public JButton ExitButton = new JButton("EXIT");
    
    
    public RemovePanel()
    {
        this.setLayout(null);
        this.setBackground(Color.GRAY);
        
        RemoveInput.setBounds(100, 100, 100, 50);
        
        ExitButton.setBounds(0, 0, 100, 50);
        ExitButton.setBackground(Color.RED);
        
        RemoveButton.setBounds(250, 100, 250, 50);
        
        
        PaperDisplay.setBounds(580, 10, 200, 330);
        PaperDisplay.setText("These will display papers");
        PaperDisplay.setEditable(false);
        
        this.add(pRemove);
        this.add(RemoveInput);
        this.add(RemoveButton);
        this.add(PaperDisplay);
        this.add(ExitButton);
        
    }
}
