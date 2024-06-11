/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseapp;

import java.awt.Color;
import javax.swing.JButton;
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
    public JButton PaperButton = new JButton("Choose your papers");
    public JButton RemovePaperButton = new JButton("Remove your chosen papers");
    public JTextArea MainMenuInfo = new JTextArea();
    
    public MainMenuPanel()
    {
        ExitButton.setBounds(0, 0, 100, 50);
        ExitButton.setBackground(Color.RED);
        
        PaperButton.setBounds(100, 100, 150, 100); //(x, y, x,y)
        
        RemovePaperButton.setBounds(300, 100, 200, 100);
        
        MainMenuInfo.setBounds(580, 10, 200, 330);
        MainMenuInfo.setText("Will add a variable later");
        MainMenuInfo.setEditable(false);
        
        this.add(MainMenuInfo);
        this.add(ExitButton);
        this.add(PaperButton);
        this.add(RemovePaperButton);
        
        this.setBackground(Color.GRAY);
        this.setLayout(null);
    }
}
