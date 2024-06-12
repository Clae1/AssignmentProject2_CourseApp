/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author claeo
 */
import Model.Data;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UserDatabase 
{
    Connection conn = null;
    String url = "jdbc:derby:StudentDB;create=true"; 
    String dbusername = "pdc";
    String dbpassword = "pdc";
    
    public void dbsetup() throws SQLException
    {
        try
        {
            conn = DriverManager.getConnection(url, dbusername, dbpassword);
            Statement statement = conn.createStatement();
            String tableName = "StudentTable";
            
            if (!checkTableExisitng(tableName))
            {
                statement.executeUpdate("CREATE TABLE " + tableName + "(studentid VARCHAR(12), password VARCHAR(12), paper VARCHAR(100))");
            }
            statement.close();
        }
        
        catch (SQLException e)
        {
            System.out.println(e);
        }
    }
    
    public Data checkName(String username, String password) throws SQLException
    {
        Data data = new Data(); // Initialize an instance of Data
        if (username.length() > 10 || password.length() > 10)
        {
            data.loginFlag = false;
            System.out.println("Bad Login");
            return data;
        }
        try
        {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT studentid, password, paper FROM StudentTable "
                    + "WHERE studentid = '" + username + "'");
            if (rs.next())
            {
                String pass = rs.getString("password");
                System.out.println("***" + pass);
                System.out.println("found user");

                if (password.compareTo(pass) == 0)
                {
                    data.loginFlag = true;
                }
                else
                {
                    data.loginFlag = false;
                }
            }
            else
            {
                System.out.println("no such user");
                statement.executeUpdate("INSERT INTO StudentTable (studentid, password, paper) "
                        + "VALUES('" + username + "', '" + password + "', '')");
                data.loginFlag = true;
            }
            rs.close(); // close the ResultSet
            statement.close(); // close the Statement
        }
        catch (SQLException ex)
        {
            System.out.println(ex);
        }
        return data;
    }
    
    public Data AddPaper(String paper, String username) throws SQLException
    {
        Data data = new Data(); // Initialize an instance of Data
        data.duplicateFlag = false;
        data.loginFlag = true;
        String[] tablePaper;
        try
        {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT studentid, paper FROM StudentTable "
                    + "WHERE studentid = '" + username + "'");
            
            if (rs.next())
            {
                //ChatGPT code
                String currentPapers = rs.getString("paper");
                if (currentPapers == null) 
                {
                    currentPapers = ""; // Initialize to empty if null
                }
                tablePaper = currentPapers.isEmpty() ? new String[0] : currentPapers.split(",");
                //end of code
                for (String tablePaper1 : tablePaper) 
                {
                    if (paper.equalsIgnoreCase(tablePaper1)) 
                    {
                        System.out.println("Duplicate found");
                        data.duplicateFlag = true;
                        data.loginFlag = false;
                        rs.close(); 
                        statement.close(); 
                        return data;
                    } 
                }
                if (data.PaperCount > 6)
                {
                    System.out.println("Max papers reached");
                    data.MaxPaper = true;
                    data.loginFlag = false;
                    rs.close(); 
                    statement.close(); 
                    return data;
                }    
               System.out.println("No duplicates and has not reached limit");
               //ChatGPT code
               // Add the new paper to the existing papers
               String updatedPapers = currentPapers.isEmpty() ? paper : currentPapers + "," + paper;
               System.out.println("Updated Papers: " + updatedPapers); // Debug output

               // Use Statement to execute the update query
               String updateQuery = "UPDATE StudentTable SET paper = '" + updatedPapers + "' WHERE studentid = '" + username + "'";
               statement.executeUpdate(updateQuery);
               //end of code
            }
            rs.close();
            statement.close(); 
        }
        catch (SQLException ex)
        {
            System.out.println("SQL Exception: " + ex.getMessage());
        }
        return data;     
    }
    
    public String checkPaper(String username) throws SQLException
    {
        String userPaper = "";
        try
        {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT studentid, password, paper FROM StudentTable "
                    + "WHERE studentid = '" + username + "'");
            if (rs.next())
            {
                userPaper = rs.getString("paper");
            }
        
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        return userPaper;
    }
    
    //The method that will delete or remove the paper from the database
    public void RemovePaper(String paper, String username) throws SQLException
    {
        Data data = new Data(); // Initialize an instance of Data
        String updatedPapers = "";
        try
        {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT studentid, paper FROM StudentTable "
                    + "WHERE studentid = '" + username + "'");
            
            if (rs.next())
            {
                String[] currentPapers = rs.getString("paper").split(",");
                for (int i = 0; i < currentPapers.length-1; ++i)
                {
                    if (paper.equalsIgnoreCase(currentPapers[i])) 
                    {
                        System.out.println("Paper has been removed");
                        currentPapers[i] = "";
                    } 
                }
                for (int i = 0; i < currentPapers.length; ++i)
                {
                   updatedPapers += currentPapers[i];
                }
                
                // Use Statement to execute the update query
                String updateQuery = "UPDATE StudentTable SET paper = '" + updatedPapers + "' WHERE studentid = '" + username + "'";
                statement.executeUpdate(updateQuery);
                //end of code
            }
            rs.close();
            statement.close(); 
        }
        catch (SQLException ex)
        {
            System.out.println("SQL Exception: " + ex.getMessage());
        }
       
    }
    
    
    private boolean checkTableExisitng(String newTableName) throws SQLException
    {
        boolean flag = false;
        try
        {
            System.out.println("check existing tables....");
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null); //types
            //Statement dropStatement=null;
            while (rsDBMeta.next())
            {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                if (tableName.compareToIgnoreCase(newTableName) == 0)
                {
                    System.out.println(tableName + " is there");
                    flag = true;
                }
            }
            if (rsDBMeta != null)
            {
                rsDBMeta.close();
            }
        }
        catch (SQLException ex)
        {
            System.out.println(ex);
        }
        return flag;
    }
}
