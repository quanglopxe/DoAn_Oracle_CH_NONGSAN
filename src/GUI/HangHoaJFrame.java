/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.HangHoaDAO;
import DAO.NhaCungCapDAO;
import DAO.NhomHangDAO;
import DTO.HangHoa;
import DTO.NhaCungCap;
import DTO.NhomHang;
import java.io.File;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import Main.FontOptionPane;
/**
 *
 * @author Admin
 */
public class HangHoaJFrame extends javax.swing.JFrame {

    private HangHoaJPanel hangHoaPanel;
    /**
     * Creates new form HangHoaJFrame
     */

    int flag = 0;

    public HangHoaJFrame(HangHoa hangHoa, HangHoaJPanel hangHoaPanel, int flag) {
        initComponents();
        setView(hangHoa);
        this.flag = flag;
        this.hangHoaPanel = hangHoaPanel;
        FontOptionPane.setUIFont();
        
    }

    public void setView(HangHoa hangHoa) {
        if (hangHoa != null) {
            jtfMaHH.setText(hangHoa.getMaHang() + "");
            setComboBoxNHH(hangHoa);
            setComboBoxNCC(hangHoa);
            jtfTenHH.setText(hangHoa.getTenHang());
            jtfHinhAnh.setText(hangHoa.getHinhAnh());
            jtfDVT.setText(hangHoa.getdVT());
            jtfGiaBan.setText(hangHoa.getGiaBan() + "");
            jtfHeSo.setText(hangHoa.getHeSo() + "");
            jtfGiaNhap.setText(hangHoa.getGiaNhap() + "");
            jtfHinhAnh.setText(hangHoa.getHinhAnh());
            jtfSoLuongTon.setText(hangHoa.getSoLuongTon() + "");
            jchkTrangThai.setSelected(hangHoa.getTrangThai());
        } else {
            setComboBoxNHH(null);
            setComboBoxNCC(null);
        }
    }

    public void setComboBoxNCC(HangHoa hangHoa) {
        DefaultComboBoxModel<NhaCungCap> model = new DefaultComboBoxModel<>();
        List<NhaCungCap> listNCC = NhaCungCapDAO.getInstance().getListNhaCungCap();

        for (NhaCungCap ncc : listNCC) {
            model.addElement(ncc);
        }

        if (hangHoa != null) {
            NhaCungCap nhacungcap = NhaCungCapDAO.getInstance().getNhaCungCap(hangHoa.getMaNCC());
            model.setSelectedItem(nhacungcap);
        }
        jcbNhaCC.setModel(model);
    }

    public void setComboBoxNHH(HangHoa hangHoa) {
        DefaultComboBoxModel<NhomHang> model = new DefaultComboBoxModel<>();
        List<NhomHang> listNH = NhomHangDAO.getInstance().getListNhomHang();

        for (NhomHang nhomhang : listNH) {
            model.addElement(nhomhang);
        }

        if (hangHoa != null) {
            NhomHang nhomhang = NhomHangDAO.getInstance().getNhomHang(hangHoa.getMaNhomHang());
            model.setSelectedItem(nhomhang);
        }
        jcbNhomHH.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnThongTinHangHoa = new javax.swing.JPanel();
        jlbMaHH = new javax.swing.JLabel();
        jtfMaHH = new javax.swing.JTextField();
        jlbNhomHH = new javax.swing.JLabel();
        jlbNhaCC = new javax.swing.JLabel();
        jlbTenHH = new javax.swing.JLabel();
        jtfTenHH = new javax.swing.JTextField();
        jcbNhomHH = new javax.swing.JComboBox<>();
        jcbNhaCC = new javax.swing.JComboBox<>();
        jlbDVT = new javax.swing.JLabel();
        jtfDVT = new javax.swing.JTextField();
        jlbGiaBan = new javax.swing.JLabel();
        jtfGiaBan = new javax.swing.JTextField();
        jtfHeSo = new javax.swing.JTextField();
        jlbHeSo = new javax.swing.JLabel();
        jtfGiaNhap = new javax.swing.JTextField();
        jlbGiaNhap = new javax.swing.JLabel();
        jlbHinhAnh = new javax.swing.JLabel();
        jtfHinhAnh = new javax.swing.JTextField();
        jlbSoLuongTon = new javax.swing.JLabel();
        jtfSoLuongTon = new javax.swing.JTextField();
        btnChonAnh = new javax.swing.JButton();
        jchkTrangThai = new javax.swing.JCheckBox();
        jlbTrangThai = new javax.swing.JLabel();
        btnLuu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jpnThongTinHangHoa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin hàng hóa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jpnThongTinHangHoa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jlbMaHH.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jlbMaHH.setText("Mã hàng hóa");

        jtfMaHH.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jtfMaHH.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        jtfMaHH.setEnabled(false);

        jlbNhomHH.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jlbNhomHH.setText("Nhóm hàng hóa");

        jlbNhaCC.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jlbNhaCC.setText("Nhà cung cấp");

        jlbTenHH.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jlbTenHH.setText("Tên hàng hóa");

        jtfTenHH.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jcbNhomHH.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jcbNhaCC.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jlbDVT.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jlbDVT.setText("Đơn vị tính");

        jtfDVT.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jlbGiaBan.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jlbGiaBan.setText("Giá bán");

        jtfGiaBan.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jtfGiaBan.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        jtfGiaBan.setEnabled(false);

        jtfHeSo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jlbHeSo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jlbHeSo.setText("Hệ số");

        jtfGiaNhap.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jlbGiaNhap.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jlbGiaNhap.setText("Giá nhập");

        jlbHinhAnh.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jlbHinhAnh.setText("Hình Ảnh");

        jtfHinhAnh.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jlbSoLuongTon.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jlbSoLuongTon.setText("Số lượng tồn");

        jtfSoLuongTon.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jtfSoLuongTon.setDisabledTextColor(new java.awt.Color(153, 153, 153));

        btnChonAnh.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnChonAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon-openfolder.png"))); // NOI18N
        btnChonAnh.setText("Chọn ảnh");
        btnChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonAnhActionPerformed(evt);
            }
        });

        jchkTrangThai.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jchkTrangThai.setText("Kích hoạt");

        jlbTrangThai.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jlbTrangThai.setText("Trạng thái");

        javax.swing.GroupLayout jpnThongTinHangHoaLayout = new javax.swing.GroupLayout(jpnThongTinHangHoa);
        jpnThongTinHangHoa.setLayout(jpnThongTinHangHoaLayout);
        jpnThongTinHangHoaLayout.setHorizontalGroup(
            jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongTinHangHoaLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnThongTinHangHoaLayout.createSequentialGroup()
                        .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbNhaCC)
                            .addComponent(jlbTenHH)
                            .addComponent(jlbHinhAnh))
                        .addGap(31, 31, 31)
                        .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtfHinhAnh, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfTenHH, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbNhaCC, 0, 271, Short.MAX_VALUE)
                            .addComponent(btnChonAnh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpnThongTinHangHoaLayout.createSequentialGroup()
                        .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbNhomHH)
                            .addComponent(jlbMaHH))
                        .addGap(18, 18, 18)
                        .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfMaHH)
                            .addComponent(jcbNhomHH, 0, 270, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jpnThongTinHangHoaLayout.createSequentialGroup()
                            .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlbSoLuongTon)
                                .addComponent(jlbGiaNhap))
                            .addGap(18, 18, 18)
                            .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jchkTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbHeSo)
                            .addGroup(jpnThongTinHangHoaLayout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(jtfHeSo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnThongTinHangHoaLayout.createSequentialGroup()
                                    .addComponent(jlbDVT)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtfDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnThongTinHangHoaLayout.createSequentialGroup()
                                    .addComponent(jlbGiaBan)
                                    .addGap(53, 53, 53)
                                    .addComponent(jtfGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jlbTrangThai))
                .addGap(50, 50, 50))
        );
        jpnThongTinHangHoaLayout.setVerticalGroup(
            jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongTinHangHoaLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnThongTinHangHoaLayout.createSequentialGroup()
                        .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbDVT)
                            .addComponent(jtfDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbGiaBan)
                            .addComponent(jtfGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbHeSo)
                            .addComponent(jtfHeSo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbGiaNhap)
                            .addComponent(jtfGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbSoLuongTon)))
                    .addGroup(jpnThongTinHangHoaLayout.createSequentialGroup()
                        .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbMaHH)
                            .addComponent(jtfMaHH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbNhomHH)
                            .addComponent(jcbNhomHH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbNhaCC)
                            .addComponent(jcbNhaCC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbTenHH)
                            .addComponent(jtfTenHH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbHinhAnh)
                            .addComponent(jtfHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlbTrangThai)
                        .addComponent(jchkTrangThai))
                    .addComponent(btnChonAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        btnLuu.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon-save.png"))); // NOI18N
        btnLuu.setText("Lưu dữ liệu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnThongTinHangHoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnThongTinHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        HangHoa hanghoa = new HangHoa();
        NhomHang selectedNhomHang = (NhomHang) jcbNhomHH.getSelectedItem();
        hanghoa.setMaNhomHang(selectedNhomHang.getMaNhomHang());
        NhaCungCap selectedNhaCungCap = (NhaCungCap) jcbNhaCC.getSelectedItem();
        hanghoa.setMaNCC(selectedNhaCungCap.getMaNCC());
        hanghoa.setTenHang(jtfTenHH.getText().trim());
        hanghoa.setHinhAnh(jtfHinhAnh.getText());
        hanghoa.setdVT(jtfDVT.getText());
        hanghoa.setHeSo((Double.parseDouble(jtfHeSo.getText())));
        hanghoa.setGiaNhap(Double.parseDouble(jtfGiaNhap.getText()));
        hanghoa.setSoLuongTon(Double.parseDouble(jtfSoLuongTon.getText()));
        hanghoa.setTrangThai((jchkTrangThai.isSelected()) ? true : false);
        if (flag == 1) {
            HangHoaDAO.getInstance().insertHangHoa(hanghoa);
            JOptionPane.showMessageDialog(this, "Thêm thành công!", "Thêm hàng hóa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            hanghoa.setMaHang(Integer.parseInt(jtfMaHH.getText()));
            HangHoaDAO.getInstance().updateHangHoa(hanghoa);
            JOptionPane.showMessageDialog(this, "Sửa thành công!", "Sửa hàng hóa", JOptionPane.INFORMATION_MESSAGE);
        }
        hangHoaPanel.LoadHHVaoTable(null, null, null, 1);
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnChonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonAnhActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String fileName = file.getName();
            jtfHinhAnh.setText(fileName);
        }
    }//GEN-LAST:event_btnChonAnhActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonAnh;
    private javax.swing.JButton btnLuu;
    private javax.swing.JComboBox<NhaCungCap> jcbNhaCC;
    private javax.swing.JComboBox<NhomHang> jcbNhomHH;
    private javax.swing.JCheckBox jchkTrangThai;
    private javax.swing.JLabel jlbDVT;
    private javax.swing.JLabel jlbGiaBan;
    private javax.swing.JLabel jlbGiaNhap;
    private javax.swing.JLabel jlbHeSo;
    private javax.swing.JLabel jlbHinhAnh;
    private javax.swing.JLabel jlbMaHH;
    private javax.swing.JLabel jlbNhaCC;
    private javax.swing.JLabel jlbNhomHH;
    private javax.swing.JLabel jlbSoLuongTon;
    private javax.swing.JLabel jlbTenHH;
    private javax.swing.JLabel jlbTrangThai;
    private javax.swing.JPanel jpnThongTinHangHoa;
    private javax.swing.JTextField jtfDVT;
    private javax.swing.JTextField jtfGiaBan;
    private javax.swing.JTextField jtfGiaNhap;
    private javax.swing.JTextField jtfHeSo;
    private javax.swing.JTextField jtfHinhAnh;
    private javax.swing.JTextField jtfMaHH;
    private javax.swing.JTextField jtfSoLuongTon;
    private javax.swing.JTextField jtfTenHH;
    // End of variables declaration//GEN-END:variables
}
