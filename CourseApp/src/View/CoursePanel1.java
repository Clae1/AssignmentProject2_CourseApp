/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;


import Model.CourseInfo;
import java.awt.Color;
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

/**
 *
 * @author claeo
 */
public class CoursePanel1 extends JPanel implements CourseInfo
{
    public JLabel Check = new JLabel("Page 1 works");
    public JButton AddButton = new JButton("ADD PAPER");
    public JButton ExitButton = new JButton("EXIT");
    public JComboBox CourseBox;
    public JComboBox PaperBox;
    public JTextArea textInfo = new JTextArea();
    public JScrollPane scrollPane;

    public CoursePanel1()
    {
        this.setBackground(Color.GRAY);
        this.setLayout(null);
       
        Check.setBounds(200, 200, 100, 50);
        
        AddButton.setBounds(250, 100, 225, 100);
        
        ExitButton.setBounds(0, 0, 100, 50);
        ExitButton.setBackground(Color.RED);
        
        String[] paper = coursePaperReader();
        PaperBox = new JComboBox(paper);
        PaperBox.setBounds(200, 100, 225, 100);
        
        String computerInfo = courseInfoReader();
        textInfo.setText(computerInfo);
        textInfo.setMargin(new Insets(10,10,10,10));
        textInfo.setLineWrap(true);
        textInfo.setEditable(false);
        
        scrollPane = new JScrollPane(textInfo);
        scrollPane.setBounds(500, 10, 280, 330);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        this.add(AddButton);
        this.add(scrollPane);
        this.add(Check);
        this.add(PaperBox);
        this.add(ExitButton);
    }

    @Override
    public String[] coursePaperReader() 
    {
        String[] paperArray = new String[30];
        int num = 0;
        try 
        (BufferedReader inputStream = new BufferedReader(new FileReader("./resources/computer_sci_paper.txt"))) 
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
        (BufferedReader inputStream = new BufferedReader(new FileReader("./resources/compsci_info.txt"))) 
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
