/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author claeo
 */
public class Data 
{
    public boolean loginFlag = false;
    public boolean quitFlag = false;
    public boolean Course1Flag = false;
    public boolean Course2Flag = false;
    public boolean Course3Flag = false;
    public boolean removeFlag = false;
    
    // Is used when there is a duplicate paper when adding papers
    public boolean duplicateFlag = false;
            
    // Will keep count of the papers that the user plans to add to their 
    // account. 
    public int PaperCount = 0;
    public boolean MaxPaper = false;
}
