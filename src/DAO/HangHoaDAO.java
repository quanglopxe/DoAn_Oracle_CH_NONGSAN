/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.HangHoa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class HangHoaDAO {

    private static HangHoaDAO instance;

    public static HangHoaDAO getInstance() {
        if (instance == null) {
            instance = new HangHoaDAO();
        }
        return instance;
    }

    private HangHoaDAO() {

    }

    public ArrayList<HangHoa> getListHangHoa(int trangthai) {
        ArrayList<HangHoa> listHH = new ArrayList<HangHoa>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("Select * from CHNONGSAN.hanghoa where TrangThai=?", trangthai);
            while (rs.next()) {
                HangHoa hanghoa = new HangHoa(rs);
                listHH.add(hanghoa);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return listHH;
    }

    public HangHoa getHangHoa(int maHH) {
        ResultSet rs = DataProvider.getInstance().executeQuery("Select * from CHNONGSAN.hanghoa where MaHang=?", maHH);
        HangHoa hanghoa = null;
        try {
            while (rs.next()) {
                hanghoa = new HangHoa(rs);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return hanghoa;
    }

    public int updateHangHoa(HangHoa hanghoa) {
        int rs = DataProvider.getInstance().executeNonQuery("call CHNONGSAN.UpdateHangHoa", hanghoa.getMaHang(), hanghoa.getMaNhomHang(), hanghoa.getMaNCC(), hanghoa.getTenHang(),
                hanghoa.getdVT(), hanghoa.getGiaNhap(), hanghoa.getHeSo(), hanghoa.getHinhAnh(), hanghoa.getSoLuongTon(), (hanghoa.getTrangThai())?1:0);
        return rs;
    }

    public int insertHangHoa(HangHoa hanghoa) {
        int rs = DataProvider.getInstance().executeNonQuery("call CHNONGSAN.InsertHangHoa", hanghoa.getMaNhomHang(), hanghoa.getMaNCC(), hanghoa.getTenHang(),
                hanghoa.getdVT(), hanghoa.getGiaNhap(), hanghoa.getHeSo(), hanghoa.getHinhAnh(), hanghoa.getSoLuongTon(), (hanghoa.getTrangThai())?1:0);
        return rs;
    }

    public int deleteHangHoa(int maHangHoa) {
        int rs = DataProvider.getInstance().executeNonQuery("Update CHNONGSAN.hanghoa set TrangThai=0 where MaHang=?", maHangHoa);
        return rs;
    }
    
    public int deletePermanentHangHoa(int maHangHoa) {
        int rs = DataProvider.getInstance().executeNonQuery("Delete from CHNONGSAN.hanghoa where MaHang=?", maHangHoa);
        return rs;
    }
    
    public int recoveryHangHoa(int maHangHoa) {
        int rs = DataProvider.getInstance().executeNonQuery("Update CHNONGSAN.hanghoa set TrangThai=1 where MaHang=?", maHangHoa);
        return rs;
    }
}
