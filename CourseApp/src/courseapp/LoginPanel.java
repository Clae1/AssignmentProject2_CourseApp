/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseapp;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author claeo
 */
public class LoginPanel extends JPanel 
{
    public JLabel uName = new JLabel("Username: ");
    public JLabel pWord = new JLabel("Password: ");
    public JTextField unInput = new JTextField(10);
    public JTextField pwInput = new JTextField(10);
    public JLabel wrongName = new JLabel("Wrong username or password!");
    public JButton loginButton = new JButton("Log in");
    public JLabel message = new JLabel("Welcome!", JLabel.CENTER);
    
    public LoginPanel()
    {
        this.add(uName);
        this.add(unInput);
        this.add(pWord);
        this.add(pwInput);
        this.add(loginButton);
        this.add(this.message, BorderLayout.SOUTH);
    }
}
