/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author claeo
 */
public class CoursePanel2 extends JPanel
{
    public JLabel Check = new JLabel("Course 2 works !!!");
    public JButton ExitButton = new JButton("EXIT");
    public JComboBox CourseBox;
    public JComboBox PaperBox;
    
    public CoursePanel2()
    {
        this.setBackground(Color.GRAY);
        this.setLayout(null);
        
        Check.setBounds(200, 200, 100, 50);
        
        ExitButton.setBounds(0, 0, 100, 50);
        ExitButton.setBackground(Color.RED);
        
        String[] paper = {};
        PaperBox = new JComboBox(paper);
        PaperBox.setBounds(300, 100, 225, 100);
        
        this.add(Check);
        this.add(PaperBox);
        this.add(ExitButton);
    }
}
