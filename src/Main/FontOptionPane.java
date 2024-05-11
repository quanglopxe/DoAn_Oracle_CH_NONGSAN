package Main;

import java.awt.Font;
import javax.swing.UIManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class FontOptionPane {

    public static void setUIFont() {
        Font font = new Font("Arial", Font.PLAIN, 16);
        UIManager.put("OptionPane.messageFont", font);
        UIManager.put("OptionPane.buttonFont", font);
    }
}
