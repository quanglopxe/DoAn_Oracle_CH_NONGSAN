package DTO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author Admin
 */
public class NhomHang {

    int maNhomHang;
    boolean trangThai;
    String tenNhomHang;

    public NhomHang(int maNhomHang, String tenNhomHang) {
        this.maNhomHang = maNhomHang;
        this.tenNhomHang = tenNhomHang;
    }

    public void setMaNhomHang(int maNhomHang) {
        this.maNhomHang = maNhomHang;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public void setTenNhomHang(String tenNhomHang) {
        this.tenNhomHang = tenNhomHang;
    }

    public int getMaNhomHang() {
        return maNhomHang;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public String getTenNhomHang() {
        return tenNhomHang;
    }

    public NhomHang(ResultSet rs) {
        try {
            this.maNhomHang = rs.getInt("MaNhomHang");
            this.tenNhomHang = rs.getString("TenNhomHang");
            this.trangThai = rs.getBoolean("TrangThai");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return tenNhomHang;
    }

    
}
