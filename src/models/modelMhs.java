/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANGGAA
 */
public class modelMhs extends BaseModel {

    private Koneksi kon;

    public modelMhs() throws SQLException {
        super();
        kon = new Koneksi("root", "", "dbmahasiswa");
    }

    @Override
    public boolean save(String query) throws SQLException {
        String queries = "INSERT INTO tb_mahasiswa VALUES (" + query + ")";
        return super.save(queries); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(String query) throws SQLException {
        String queries = "UPDATE tb_mahasiswa SET " + query;
        return super.update(queries); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String query) throws SQLException {
        System.out.println(query);
        String queries = "DELETE FROM tb_mahasiswa WHERE NIM='"+query+"'";
        return super.delete(queries); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String[] angkatan() throws SQLException {
        String query = "SELECT tahun FROM tb_angkatan";
        ResultSet rs = kon.getResult(query);
        rs.last();
        String tahun[] = new String[rs.getRow()];
        rs.beforeFirst();
        int a = 0;
        while (rs.next()) {
            tahun[a] = rs.getString("tahun");
            a++;
        }
        a=0;
        return tahun;
    }
    
    public DefaultTableModel getTable() throws SQLException{
        String header[] = {"NIM", "NAMA MHS", "TAHUN", "NAMA ANGKATAN"};
        DefaultTableModel tabelModel = new DefaultTableModel(null, header);
        ResultSet rs = kon.getResult("SELECT m.NIM, m.nama, t.tahun, t.nama_angkatan FROM tb_mahasiswa m join tb_angkatan t on (m.id_angkatan=t.id_angkatan)");
        for (int i = tabelModel.getRowCount() - 1; i >= 0; i--) {
            tabelModel.removeRow(i);
        }
        while (rs.next()) {
            String kolom[] = new String[4];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }

            tabelModel.addRow(kolom);
        }
        return tabelModel;
    }

}
