package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author claeo
 */
public class RemovePanel extends JPanel 
{
    // For RemoveMenu
    public JTextArea PaperDisplay = new JTextArea();
    public JScrollPane scrollPane;
    private JLabel pRemove = new JLabel("Which paper would you like to remove? ");
    private JLabel RTitle = new JLabel("Remove Course Page");
    public JTextField RemoveInput = new JTextField(10);
    public JButton RemoveButton = new JButton("REMOVE COURSE/COURSES");
    public JButton ExitButton = new JButton("EXIT");
    
    public RemovePanel()
    {
        this.setLayout(new BorderLayout(10, 10));
        this.setBackground(Color.WHITE);
        
        // Exit button settings
        ExitButton.setPreferredSize(new Dimension(100, 50));
        ExitButton.setBackground(Color.RED);
        
        // Remove button settings
        RemoveButton.setPreferredSize(new Dimension(250, 50));
        
        RemoveInput.setPreferredSize(new Dimension(100, 50));
        
        RTitle.setHorizontalAlignment(SwingConstants.CENTER);
        RTitle.setFont(new Font("Arial", Font.BOLD, 20));
        
        // PaperDisplay settings
        PaperDisplay.setText("These will display papers");
        PaperDisplay.setLineWrap(true);
        PaperDisplay.setEditable(false);
        PaperDisplay.setMargin(new Insets(10, 10, 10, 10));
        scrollPane = new JScrollPane(PaperDisplay);
        scrollPane.setPreferredSize(new Dimension(300, 400));
        
        // Panel to hold the Exit button and title
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(ExitButton, BorderLayout.WEST);
        topPanel.add(RTitle, BorderLayout.CENTER);
         
        // Panel to hold the input and remove button
        JPanel inputPanel = new JPanel();
        inputPanel.add(pRemove);
        inputPanel.add(RemoveInput);
        inputPanel.add(RemoveButton);
        
        // Adding components to the main panel
        this.add(topPanel, BorderLayout.NORTH);
        this.add(inputPanel, BorderLayout.CENTER);
        this.add(scrollPane, BorderLayout.EAST);
    }
}
