/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanmodelinherit;

import controllers.controllerMhs;
import java.sql.SQLException;
import javax.swing.UnsupportedLookAndFeelException;
import models.modelMhs;
import views.viewMhs;

/**
 *
 * @author ANGGAA
 */
public class LatihanModelInherit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        
        //====pakai nimbuz java SWING biar gak jadul AWT==//
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        //=============================//
        
        new controllerMhs(new modelMhs(), new viewMhs());
    }
    
}
