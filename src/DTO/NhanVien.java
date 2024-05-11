/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class NhanVien {

    int maNV;
    boolean trangThai;
    String tenNV, SDT, userName, password, chucVu, diaChi;

    public int getMaNV() {
        return maNV;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public String getTenNV() {
        return tenNV;
    }

    public String getSDT() {
        return SDT;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getChucVu() {
        return chucVu;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public NhanVien(ResultSet rs) {
        try {
            this.maNV = rs.getInt("MaNV");
            this.tenNV = rs.getString("TenNV");
            this.SDT = rs.getString("SDT");
            this.userName = rs.getString("UserName");
            this.password = rs.getString("Password");
            this.chucVu = rs.getString("ChucVu");           
            this.diaChi = rs.getString("DiaChi");
            this.trangThai = rs.getBoolean("TrangThai");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
