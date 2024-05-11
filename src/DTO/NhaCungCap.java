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
public class NhaCungCap {
    int maNCC;
    String tenNCC, SDT, diaChi;

    public NhaCungCap(int maNCC, String tenNCC) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
    }

    public NhaCungCap() {
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    boolean trangThai;

    
    public int getMaNCC() {
        return maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public String getSDT() {
        return SDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public boolean getTrangThai() {
        return trangThai;
    }
    
    public NhaCungCap(ResultSet rs) {
        try {
            this.maNCC = rs.getInt("MaNCC");
            this.tenNCC = rs.getString("TenNCC");
            this.SDT = rs.getString("SDT");
            this.diaChi = rs.getString("DiaChi");
            this.trangThai = rs.getBoolean("TrangThai");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return tenNCC;
    }
    
}
