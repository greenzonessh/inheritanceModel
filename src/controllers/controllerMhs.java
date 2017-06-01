/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.modelMhs;
import views.viewMhs;

/**
 *
 * @author ANGGAA
 */
public class controllerMhs {

    private modelMhs theModel;
    private viewMhs theView;

    public controllerMhs(modelMhs theModel, viewMhs theView) throws SQLException {
        this.theModel = theModel;
        this.theView = theView;
        theView.setVisible(true);

        theView.setComboAngkatan(theModel.angkatan());
        theView.setTabel(theModel.getTable());
        theView.addSaveListener(new saveListener());
        theView.addDeleteListener(new deleteListener());
    }

    private class deleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (theView.getSelectedRow() != -1) {
                    if (theModel.delete(theView.getValueAtNIM(theView.getSelectedRow(), 0))) {
                        theView.showMessage("data telah dihapus!");
                        theView.setTabel(theModel.getTable());
                    }else{
                        theView.showMessage("Gagal menghapus !");
                    }
                } else{
                    theView.showMessage("Pilih data !");
                }
            } catch (SQLException ex) {
                Logger.getLogger(controllerMhs.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class saveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (theView.getTxtNIM().length() == 12 && theView.getTxtNama().length() > 0) {
                    if (theModel.save("'" + theView.getTxtNIM() + "','" + theView.getTxtNama() + "'," + theView.getComboAngkatan() + 1 + "")) {
                        theView.showMessage("data berhasil ditambahkan");
                        theView.setTabel(theModel.getTable());
                    } else {
                        theView.showMessage("data gagal ditambahkan");
                    }
                } else {
                    theView.showMessage("Panjang nim wajib 12 dan nama tidak boleh kosong!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(controllerMhs.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
