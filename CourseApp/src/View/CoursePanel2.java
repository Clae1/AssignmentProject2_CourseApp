/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import javax.swing.SwingConstants;

/**
 *
 * @author claeo
 */
public class CoursePanel2 extends JPanel implements CourseInfo
{
    public JLabel cTitle = new JLabel("Business Course Menu");
    public JLabel DupError = new JLabel();
    public JButton AddButton = new JButton("ADD PAPER");
    public JButton ExitButton = new JButton("EXIT");
    public JComboBox CourseBox;
    public JComboBox PaperBox;
    public JTextArea textInfo = new JTextArea();
    public JScrollPane scrollPane;

    public CoursePanel2()
    {
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout(10, 10));
 
        
        AddButton.setPreferredSize(new Dimension(300, 150));
        
        ExitButton.setPreferredSize(new Dimension(100, 50));
        ExitButton.setBackground(Color.RED);
        
        String[] paper = coursePaperReader();
        PaperBox = new JComboBox(paper);
        PaperBox.setPreferredSize(new Dimension(200, 50));
        
        String computerInfo = courseInfoReader();
        textInfo.setText(computerInfo);
        textInfo.setMargin(new Insets(10,10,10,10));
        textInfo.setLineWrap(true);
        textInfo.setEditable(false);
        
        cTitle.setFont(new Font("Arial", Font.BOLD, 20));
        cTitle.setHorizontalAlignment(SwingConstants.CENTER);
        
        DupError.setHorizontalAlignment(SwingConstants.CENTER);
        DupError.setForeground(Color.red);
        DupError.setFont(new Font("Arial", Font.BOLD, 20));

        scrollPane = new JScrollPane(textInfo);
        scrollPane.setPreferredSize(new Dimension(300, 400));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(AddButton);
        inputPanel.add(PaperBox);
        
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(ExitButton, BorderLayout.WEST);
        topPanel.add(cTitle, BorderLayout.CENTER);
        
        this.add(topPanel, BorderLayout.NORTH);
        this.add(inputPanel, BorderLayout.CENTER);
        this.add(scrollPane, BorderLayout.EAST);
        this.add(DupError, BorderLayout.SOUTH);
    }

    @Override
    public String[] coursePaperReader() 
    {
        String[] paperArray = new String[30];
        int num = 0;
        try 
        (BufferedReader inputStream = new BufferedReader(new FileReader("./resources/business_paper.txt"))) 
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
    public String courseInfoReader() 
    {
        String info  = "";
        try 
        (BufferedReader inputStream = new BufferedReader(new FileReader("./resources/business_info_1.txt"))) 
        {
            String line = null;
            while (null!=(line=inputStream.readLine()))
            {
                info += line + "\n";
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
        return info;   
    }
}
