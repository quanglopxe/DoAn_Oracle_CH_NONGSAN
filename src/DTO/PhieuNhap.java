/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Quang
 */
public class PhieuNhap {
    int maPN, maNV, maNCC;
    Date ngayNhap;
    float tongTien;
    String trangThai;
    
    public PhieuNhap(ResultSet rs) {
        try {
            this.maPN = rs.getInt("MaPN");
            this.maNV = rs.getInt("MaNV");
            this.maNCC = rs.getInt("MaNCC");
            this.ngayNhap = rs.getDate("NgayNhap");
            this.tongTien = rs.getFloat("TongTien");
            this.trangThai = rs.getString("TrangThai");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public PhieuNhap() {
    }

    public PhieuNhap(int maPN, int maNV, int maNCC, Date ngayNhap, float tongTien, String trangThai) {
        this.maPN = maPN;
        this.maNV = maNV;
        this.maNCC = maNCC;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public int getMaPN() {
        return maPN;
    }

    public int getMaNV() {
        return maNV;
    }

    public int getMaNCC() {
        return maNCC;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public float getTongTien() {
        return tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setMaPN(int maPN) {
        this.maPN = maPN;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
}
