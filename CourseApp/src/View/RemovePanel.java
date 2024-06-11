package View;

import Model.CourseInfo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class RemovePanel extends JPanel implements CourseInfo 
{
    // For RemoveMenu
    public JTextArea PaperDisplay = new JTextArea();
    public JScrollPane scrollPane;
    private JLabel pRemove = new JLabel("Which paper would you like to remove? ");
    private JLabel RTitle = new JLabel("Remove Course Page");
    public JComboBox PaperBox = new JComboBox();
    public JButton RemoveButton = new JButton("REMOVE COURSE/COURSES");
    public JButton ExitButton = new JButton("EXIT");
    
    public RemovePanel()
    {
        this.setLayout(new BorderLayout(10, 10));
        this.setBackground(Color.WHITE);
        
        // Exit button settings
        ExitButton.setPreferredSize(new Dimension(100, 50));
        ExitButton.setBackground(Color.RED);
        
        String[] paper = coursePaperReader();
        PaperBox = new JComboBox(paper);
        PaperBox.setPreferredSize(new Dimension(200, 50));
        
        // Remove button settings
        RemoveButton.setPreferredSize(new Dimension(250, 50));
        
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
        inputPanel.add(RemoveButton);
        inputPanel.add(PaperBox);
        
        // Adding components to the main panel
        this.add(topPanel, BorderLayout.NORTH);
        this.add(inputPanel, BorderLayout.CENTER);
        this.add(scrollPane, BorderLayout.EAST);
    }

    @Override
    public String[] coursePaperReader() 
    {
        String[] paperArray = new String[30];
        int num = 0;
        try 
        (BufferedReader inputStream = new BufferedReader(new FileReader("./resources/all_papers.txt"))) 
        {
            String line = null;
            while (null!=(line=inputStream.readLine()))
            {
                paperArray[num] = line;
                num++;
                Thread.sleep(100);
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        catch(IOException e)
        {
            System.out.println("Error reading from file");
        } 
        catch (InterruptedException ex) 
        {
            Logger.getLogger(CoursePanel1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paperArray;   
    }

    @Override
    public String courseInfoReader() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
