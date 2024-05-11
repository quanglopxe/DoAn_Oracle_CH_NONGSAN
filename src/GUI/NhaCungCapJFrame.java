/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCap;
import java.io.File;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;

/**
 *
 * @author Quang
 */
public class NhaCungCapJFrame extends javax.swing.JFrame {

    /** Creates new form NhaCungCapJFrame */
    int flag = 0;
    public NhaCungCapJFrame(NhaCungCap ncc, int flag) {
        initComponents();
        setView(ncc);
        this.flag = flag;
    }
    
    public void setView(NhaCungCap ncc) {
        if (ncc != null) {
            jtfMaNCC.setText(ncc.getMaNCC() + "");            
            jtfTenNCC.setText(ncc.getTenNCC() + "");
            jtfSDT.setText(ncc.getSDT() + "");
            jtfDiaChi.setText(ncc.getDiaChi() + "");            
            jchkTrangThai.setSelected(ncc.getTrangThai());
        } 
    }

    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLuu = new javax.swing.JButton();
        jpnThongTinHangHoa = new javax.swing.JPanel();
        jlbMaHH = new javax.swing.JLabel();
        jtfMaNCC = new javax.swing.JTextField();
        jlbNhaCC = new javax.swing.JLabel();
        jlbTenHH = new javax.swing.JLabel();
        jtfTenNCC = new javax.swing.JTextField();
        jlbHinhAnh = new javax.swing.JLabel();
        jtfDiaChi = new javax.swing.JTextField();
        jchkTrangThai = new javax.swing.JCheckBox();
        jtfSDT = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnLuu.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon-save.png"))); // NOI18N
        btnLuu.setText("Lưu dữ liệu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        jpnThongTinHangHoa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin hàng hóa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jpnThongTinHangHoa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jlbMaHH.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jlbMaHH.setText("Mã nhà cung cấp");

        jtfMaNCC.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jtfMaNCC.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        jtfMaNCC.setEnabled(false);

        jlbNhaCC.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jlbNhaCC.setText("Tên nhà cung cấp");

        jlbTenHH.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jlbTenHH.setText("Số điện thoại");

        jtfTenNCC.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jlbHinhAnh.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jlbHinhAnh.setText("Địa chỉ");

        jtfDiaChi.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jchkTrangThai.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jchkTrangThai.setText("Kích hoạt");

        jtfSDT.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        javax.swing.GroupLayout jpnThongTinHangHoaLayout = new javax.swing.GroupLayout(jpnThongTinHangHoa);
        jpnThongTinHangHoa.setLayout(jpnThongTinHangHoaLayout);
        jpnThongTinHangHoaLayout.setHorizontalGroup(
            jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnThongTinHangHoaLayout.createSequentialGroup()
                .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnThongTinHangHoaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jchkTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnThongTinHangHoaLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnThongTinHangHoaLayout.createSequentialGroup()
                                .addComponent(jlbMaHH)
                                .addGap(54, 54, 54)
                                .addComponent(jtfMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnThongTinHangHoaLayout.createSequentialGroup()
                                .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlbNhaCC)
                                    .addComponent(jlbTenHH)
                                    .addComponent(jlbHinhAnh))
                                .addGap(50, 50, 50)
                                .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfDiaChi)
                                    .addComponent(jtfTenNCC)
                                    .addComponent(jtfSDT))))
                        .addGap(1, 1, 1)))
                .addGap(203, 203, 203))
        );
        jpnThongTinHangHoaLayout.setVerticalGroup(
            jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongTinHangHoaLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbMaHH))
                .addGap(18, 18, 18)
                .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbNhaCC)
                    .addComponent(jtfTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbTenHH)
                    .addComponent(jtfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnThongTinHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbHinhAnh))
                .addGap(18, 18, 18)
                .addComponent(jchkTrangThai)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jpnThongTinHangHoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnThongTinHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        NhaCungCap ncc = new NhaCungCap();        
        
        ncc.setMaNCC(Integer.parseInt(jtfMaNCC.getText()));
        ncc.setTenNCC(jtfTenNCC.getText().trim());
        ncc.setSDT(jtfSDT.getText().trim());        
        ncc.setDiaChi(jtfDiaChi.getText());
        ncc.setTrangThai((jchkTrangThai.isSelected()) ? true : false);
        if (flag == 1) {
            NhaCungCapDAO.getInstance().insertNhaCungCap(ncc);
        } else {
            ncc.setMaNCC(Integer.parseInt(jtfMaNCC.getText()));
            NhaCungCapDAO.getInstance().updateNhaCungCap(ncc);
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuu;
    private javax.swing.JCheckBox jchkTrangThai;
    private javax.swing.JLabel jlbHinhAnh;
    private javax.swing.JLabel jlbMaHH;
    private javax.swing.JLabel jlbNhaCC;
    private javax.swing.JLabel jlbTenHH;
    private javax.swing.JPanel jpnThongTinHangHoa;
    private javax.swing.JTextField jtfDiaChi;
    private javax.swing.JTextField jtfMaNCC;
    private javax.swing.JTextField jtfSDT;
    private javax.swing.JTextField jtfTenNCC;
    // End of variables declaration//GEN-END:variables

    

}
