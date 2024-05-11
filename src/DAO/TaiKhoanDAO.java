package DAO;

import DTO.NhanVien;
import DAO.DataProvider;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
