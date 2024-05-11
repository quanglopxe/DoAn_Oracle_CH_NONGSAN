/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NhomHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class NhomHangDAO {

    private static NhomHangDAO instance;

    public static NhomHangDAO getInstance() {
        if (instance == null) {
            instance = new NhomHangDAO();
        }
        return instance;
    }

    private NhomHangDAO() {

    }

    public ArrayList<NhomHang> getListNhomHang() {
        ArrayList<NhomHang> listNhomHang = new ArrayList<NhomHang>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("Select * from CHNONGSAN.NhomHang");
            while (rs.next()) {
                NhomHang nhomhang = new NhomHang(rs);
                listNhomHang.add(nhomhang);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return listNhomHang;
    }

    public NhomHang getNhomHang(int maNhom) {
        ResultSet rs = DataProvider.getInstance().executeQuery("Select * from CHNONGSAN.NhomHang where MaNhomHang=" + maNhom);
        NhomHang nhomhang = null;
        try {
            while (rs.next()) {
                nhomhang = new NhomHang(rs);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return nhomhang;
    }
}
