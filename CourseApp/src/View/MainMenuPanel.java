/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Data;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 *
 * @author claeo
 */
public class MainMenuPanel extends JPanel 
{
    //For MainPage
    public JButton ExitButton = new JButton("EXIT");
    public JComboBox CourseBox = new JComboBox();
    public JScrollPane scrollPane;
    public JButton RemovePaperButton = new JButton("Remove a chosen papers");
    public JTextArea MainMenuInfo = new JTextArea();
    private JLabel MTitle = new JLabel("Main Menu");
    public JLabel Papers = new JLabel();
    
    public MainMenuPanel()
    {
        this.setLayout(new BorderLayout(10, 10));
        this.setBackground(Color.WHITE);
        
        ExitButton.setPreferredSize(new Dimension(100, 50));
        ExitButton.setBackground(Color.RED);
        
        String[] courses = 
        {"Bachelor of Computer Science", "Bachelor of Business", "Bachelor of Engineering Technology"};        
        CourseBox = new JComboBox(courses);
        CourseBox.setPreferredSize(new Dimension(350, 100));
        
        RemovePaperButton.setPreferredSize(new Dimension(350, 100));
        
        MainMenuInfo.setLineWrap(true);
        MainMenuInfo.setText("Welcome to the Course Selector. To select a paper of your choice, "
                + "please click on the dropdown and choose your desired course. Alternative, you may choose to remove any paper you have already selected.");
        MainMenuInfo.setEditable(false);
        MainMenuInfo.setMargin(new Insets(10, 10, 10, 10));
        scrollPane = new JScrollPane(MainMenuInfo);
        scrollPane.setPreferredSize(new Dimension(300, 400));
        
        MTitle.setFont(new Font("Arial", Font.BOLD, 15));
        MTitle.setHorizontalAlignment(SwingConstants.CENTER);
        
        Papers.setFont(new Font("Arial", Font.BOLD, 20));
        
        // Panel to hold the Exit button and title
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(ExitButton, BorderLayout.WEST);
        topPanel.add(MTitle, BorderLayout.CENTER);
        
        JPanel contentPanel = new JPanel(new FlowLayout());
        contentPanel.add(CourseBox);
        contentPanel.add(RemovePaperButton);

        
        this.add(topPanel, BorderLayout.NORTH);
        this.add(contentPanel, BorderLayout.CENTER) ;      
        this.add(scrollPane, BorderLayout.EAST);
        this.add(Papers, BorderLayout.SOUTH);
    }
}
