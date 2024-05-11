/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Quang
 */
import DTO.PhieuNhap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PhieuNhapDAO {
    private static PhieuNhapDAO instance;

    public static PhieuNhapDAO getInstance() {
        if (instance == null) {
            instance = new PhieuNhapDAO();
        }
        return instance;
    }

    private PhieuNhapDAO() {

    }

    public ArrayList<PhieuNhap> getListPhieuNhap() {
        ArrayList<PhieuNhap> listPN = new ArrayList<PhieuNhap>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("Select * from CHNONGSAN.PhieuNhap");
            while (rs.next()) {
                PhieuNhap phieunhap = new PhieuNhap(rs);
                listPN.add(phieunhap);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return listPN;
    }
    
    public PhieuNhap getPhieuNhap(int maPN) {
        ResultSet rs = DataProvider.getInstance().executeQuery("Select * from CHNONGSAN.PhieuNhap where MaPN=" + maPN);
        PhieuNhap phieunhap = null;
        try {
            while (rs.next()) {
                phieunhap = new PhieuNhap(rs);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return phieunhap;
    }
}
