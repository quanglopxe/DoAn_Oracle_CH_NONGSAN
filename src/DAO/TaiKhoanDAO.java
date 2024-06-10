package DAO;

import DTO.NhanVien;
import DAO.DataProvider;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class TaiKhoanDAO {

    private static TaiKhoanDAO instance;

    public static TaiKhoanDAO getInstance() {
        if (instance == null) {
            instance = new TaiKhoanDAO();
        }
        return instance;
    }

    private TaiKhoanDAO() {

    }

    public NhanVien Login(String username, String password) {
        NhanVien nv = null;
        ResultSet rs = DataProvider.getInstance().executeQuery("Select * from CHNONGSAN.NhanVien where username=? and password=?", username, password);
        try {
            if (rs.next()) {
                nv = new NhanVien(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nv;
    }
    public ArrayList<NhanVien> getListNhanVien() {
        ArrayList<NhanVien> listNhanVien = new ArrayList<NhanVien>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("call CHNONGSAN.get_employee_names");
            while (rs.next()) {
                String username = rs.getString("TenNV");
                NhanVien nv = new NhanVien(username);
                listNhanVien.add(nv);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return listNhanVien;
    }
}
