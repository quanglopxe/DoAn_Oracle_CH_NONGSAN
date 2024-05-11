/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import GUI.DangNhapJDialog;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        DangNhapJDialog dialog = new DangNhapJDialog(null, true);
        dialog.setTitle("Đăng Nhập Hệ Thống");
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
