package Model;

import Model.Data;
import Model.UserDatabase;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDatabaseTest {

    private UserDatabase userDatabase;
    private Connection conn;
    private String url = "jdbc:derby:StudentDB;create=true"; 
    private String dbusername = "pdc";
    private String dbpassword = "pdc";

    @Before
    public void setUp() throws SQLException {
        userDatabase = new UserDatabase();
        userDatabase.dbsetup();
        conn = DriverManager.getConnection(url, dbusername, dbpassword);
        clearDatabase();
    }

    @After
    public void tearDown() throws SQLException {
        clearDatabase();
        conn.close();
    }

    private void clearDatabase() throws SQLException {
        Statement statement = conn.createStatement();
        statement.executeUpdate("DELETE FROM StudentTable");
        statement.close();
    }

    @Test
    public void testUserLoginSuccess() throws SQLException {
        String username = "testUser";
        String password = "testPassword";

        // Insert a test user
        Statement statement = conn.createStatement();
        statement.executeUpdate("INSERT INTO StudentTable (studentid, password, paper) VALUES('" + username + "', '" + password + "', '')");
        statement.close();

        Data data = userDatabase.checkName(username, password);
        assertTrue(data.loginFlag);
    }

    @Test
    public void testUserLoginFailure() throws SQLException {
        String username = "testUser";
        String password = "testPassword";
        String wrongPassword = "wrongPassword";

        // Insert a test user
        Statement statement = conn.createStatement();
        statement.executeUpdate("INSERT INTO StudentTable (studentid, password, paper) VALUES('" + username + "', '" + password + "', '')");
        statement.close();

        Data data = userDatabase.checkName(username, wrongPassword);
        assertFalse(data.loginFlag);
    }
}