package View;

import java.awt.event.ActionListener;
import java.util.Observable;
import Model.Data;
import javax.swing.SwingUtilities;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ViewTest {
    private static View view;
    
    public ViewTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        SwingUtilities.invokeAndWait(() -> view = new View());
    }
    
    @AfterClass
    public static void tearDownClass() {
        view.dispose(); // Clean up the view instance
    }
    
    @Before
    public void setUp() {
        // Reset view to login panel before each test
        SwingUtilities.invokeLater(() -> {
            view.getContentPane().removeAll();
            view.add(view.loginPanel);
            view.revalidate();
            view.repaint();
        });
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testLoginPanelInitialSetup() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            assertTrue(view.loginPanel.isVisible());
            assertEquals(800, view.getWidth());
            assertEquals(400, view.getHeight());
        });
    }

    @Test
    public void testMainMenu() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            Data data = new Data();
            data.loginFlag = true;
            view.update(null, data);
            assertTrue(view.mainMenuPanel.isVisible());
            assertEquals(800, view.getWidth());
            assertEquals(400, view.getHeight());
        });
    }

    @Test
    public void testCourseMenu1() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            Data data = new Data();
            data.Course1Flag = true;
            view.update(null, data);
            assertTrue(view.coursePanel1.isVisible());
            assertEquals("", view.coursePanel1.DupError.getText());
        });
    }

    @Test
    public void testCourseMenu2() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            Data data = new Data();
            data.Course2Flag = true;
            view.update(null, data);
            assertTrue(view.coursePanel2.isVisible());
            assertEquals("", view.coursePanel2.DupError.getText());
        });
    }

    @Test
    public void testCourseMenu3() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            Data data = new Data();
            data.Course3Flag = true;
            view.update(null, data);
            assertTrue(view.coursePanel3.isVisible());
            assertEquals("", view.coursePanel3.DupError.getText());
        });
    }

    @Test
    public void testRemoveMenu() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            Data data = new Data();
            data.removeFlag = true;
            view.update(null, data);
            assertTrue(view.removePanel.isVisible());
        });
    }

    @Test
    public void testUpdate() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            Data data = new Data();
            data.loginFlag = true;
            view.update(null, data);
            assertTrue(view.mainMenuPanel.isVisible());
        });
    }
}