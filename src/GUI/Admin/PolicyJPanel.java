/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Admin;
import DAO.Admin.AuditDAO;
import DAO.Admin.PolicyDAO;
import DAO.DataProvider;
import DTO.Admin.Audit;
import DTO.Admin.Policy;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author Admin
 */
public class PolicyJPanel extends javax.swing.JPanel {
    ArrayList<Policy> listPolicy;
    ArrayList<Audit> listAudit;
    DataProvider dataProvider = DataProvider.getInstance();
    Connection connection = dataProvider.getConnection();
    /**
     * Creates new form PolicyJPanel
     */
    public PolicyJPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtbPolicy = new javax.swing.JTabbedPane();
        jpnInfoPolicy = new javax.swing.JPanel();
        jpnView = new javax.swing.JPanel();
        jspPolicy = new javax.swing.JScrollPane();
        jtPolicy = new javax.swing.JTable();
        jlbSoLuongPolicy = new javax.swing.JLabel();
        jbtnThem = new javax.swing.JButton();
        jpnInfoAudit = new javax.swing.JPanel();
        jpnView1 = new javax.swing.JPanel();
        jspAudit = new javax.swing.JScrollPane();
        jtAudit = new javax.swing.JTable();
        jbtnThemAudit = new javax.swing.JButton();
        jtfAuditType = new javax.swing.JTextField();
        jtfUsername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jtbPolicy.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jtbPolicy.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jtbPolicyStateChanged(evt);
            }
        });

        jtPolicy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtPolicy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPolicyMouseClicked(evt);
            }
        });
        jspPolicy.setViewportView(jtPolicy);

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnViewLayout.createSequentialGroup()
                .addComponent(jspPolicy, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspPolicy, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
        );

        jlbSoLuongPolicy.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jlbSoLuongPolicy.setText("Số lượng policy: ");

        jbtnThem.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jbtnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon-plus.png"))); // NOI18N
        jbtnThem.setText("Tạo policy");
        jbtnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnInfoPolicyLayout = new javax.swing.GroupLayout(jpnInfoPolicy);
        jpnInfoPolicy.setLayout(jpnInfoPolicyLayout);
        jpnInfoPolicyLayout.setHorizontalGroup(
            jpnInfoPolicyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnInfoPolicyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnInfoPolicyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnInfoPolicyLayout.createSequentialGroup()
                        .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jpnInfoPolicyLayout.createSequentialGroup()
                        .addComponent(jlbSoLuongPolicy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnThem)
                        .addGap(54, 54, 54))))
        );
        jpnInfoPolicyLayout.setVerticalGroup(
            jpnInfoPolicyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnInfoPolicyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnInfoPolicyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbSoLuongPolicy)
                    .addComponent(jbtnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtbPolicy.addTab("Thông tin Policy", jpnInfoPolicy);

        jtAudit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtAudit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtAuditMouseClicked(evt);
            }
        });
        jspAudit.setViewportView(jtAudit);

        javax.swing.GroupLayout jpnView1Layout = new javax.swing.GroupLayout(jpnView1);
        jpnView1.setLayout(jpnView1Layout);
        jpnView1Layout.setHorizontalGroup(
            jpnView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnView1Layout.createSequentialGroup()
                .addComponent(jspAudit, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jpnView1Layout.setVerticalGroup(
            jpnView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspAudit, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );

        jbtnThemAudit.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jbtnThemAudit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon-plus.png"))); // NOI18N
        jbtnThemAudit.setText("Tạo Audit trên user");
        jbtnThemAudit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnThemAuditActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Audit");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Tên USER");

        javax.swing.GroupLayout jpnInfoAuditLayout = new javax.swing.GroupLayout(jpnInfoAudit);
        jpnInfoAudit.setLayout(jpnInfoAuditLayout);
        jpnInfoAuditLayout.setHorizontalGroup(
            jpnInfoAuditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnInfoAuditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnInfoAuditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnInfoAuditLayout.createSequentialGroup()
                        .addComponent(jpnView1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jpnInfoAuditLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfAuditType, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jtfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnThemAudit, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
        );
        jpnInfoAuditLayout.setVerticalGroup(
            jpnInfoAuditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnInfoAuditLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jpnInfoAuditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnThemAudit, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfAuditType, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnView1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtbPolicy.addTab("Quá trình audit", jpnInfoAudit);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jtbPolicy)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jtbPolicy)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void loadPolicy() {
        String[] header = {"POLICY NAME", "OBJECT SCHEMA", "OBJECT NAME", "POLICY OWNER", "SELECT","INSERT","UPDATE","DELETE", "PLC COL OPTIONS"};
        listPolicy = PolicyDAO.getInstance().getInfo();
        DefaultTableModel modelTableDb = new DefaultTableModel(header, 0) {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };

        for (Policy dt : listPolicy) {
            Object[] row = {dt.getPolicy_name(), dt.getObject_schema(), dt.getObject_name(), dt.getPolicy_owner(), dt.getSEL(), dt.getINS(), dt.getUPD(), dt.getDEL(), dt.getPolicy_column_options()};
            modelTableDb.addRow(row);
        }
        
        TableRowSorter<TableModel> rowSorter = null;
        jlbSoLuongPolicy.setText("Số lượng policy: ");
        String txtSoLuongPolicy = jlbSoLuongPolicy.getText() + listPolicy.size();
        jlbSoLuongPolicy.setText(txtSoLuongPolicy);
        
        jtPolicy.setModel(modelTableDb);
        jtPolicy.setRowSorter(rowSorter);

        jtPolicy.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        jtPolicy.setFont(new Font("Arial", Font.PLAIN, 14));
        jtPolicy.getTableHeader().setPreferredSize(new Dimension(100, 50));
        jtPolicy.setRowHeight(50);
        jtPolicy.validate();
        jtPolicy.repaint();

        jspPolicy.setPreferredSize(new Dimension(1350, 400));

        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(jspPolicy);
        jpnView.validate();
        jpnView.repaint();
    }
    public void loadAudit() {
        String[] header = {"TIME STAMP", "SQL TEXT", "OBJECT SCHEMA", "OBJECT NAME", "POLICY NAME"};
        listAudit = AuditDAO.getInstance().getInfo();
        DefaultTableModel modelTableDb = new DefaultTableModel(header, 0) {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };

        for (Audit dt : listAudit) {
            Object[] row = {dt.getTimestamp(), dt.getSql_text(), dt.getObject_schema(), dt.getObject_name(), dt.getPolicy_name()};
            modelTableDb.addRow(row);
        }
        
        TableRowSorter<TableModel> rowSorter = null;        
        
        jtAudit.setModel(modelTableDb);
        jtAudit.setRowSorter(rowSorter);

        jtAudit.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        jtAudit.setFont(new Font("Arial", Font.PLAIN, 14));
        jtAudit.getTableHeader().setPreferredSize(new Dimension(100, 50));
        jtAudit.setRowHeight(50);
        jtAudit.validate();
        jtAudit.repaint();

        jspAudit.setPreferredSize(new Dimension(1350, 400));

        jpnView1.removeAll();
        jpnView1.setLayout(new CardLayout());
        jpnView1.add(jspAudit);
        jpnView1.validate();
        jpnView1.repaint();
    }
    private void jtPolicyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPolicyMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2 && jtPolicy.getSelectedRow() != -1) {
            int index = jtPolicy.getSelectedRow();

//            Policy policy = listPolicy.get(index);
//
//            int file_id = policy.getFile_id();
//
//            PolicyJFrame frame = new PolicyJFrame(file_id);
//            frame.setResizable(false);
//
//            JDialog dialog = new JDialog();
//
//            dialog.setModal(true);
//            dialog.getContentPane().add(frame.getContentPane());
//            dialog.pack();
//            dialog.setLocationRelativeTo(null);
//            dialog.setTitle("Thông tin chi tiết Policy");
//            dialog.setVisible(true);
        }
    }//GEN-LAST:event_jtPolicyMouseClicked

    private void jtbPolicyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jtbPolicyStateChanged
        // TODO add your handling code here:
        int index = jtbPolicy.getSelectedIndex();
        if (index == 0) {
            loadPolicy();
        }
        if (index == 1) {
            loadAudit();
        }
    }//GEN-LAST:event_jtbPolicyStateChanged

    private void jbtnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnThemActionPerformed
        // TODO add your handling code here:
        PolicyJFrame frame = new PolicyJFrame(null, this);
        frame.setResizable(false);

        JDialog dialog = new JDialog();
        dialog.setModal(true);
        dialog.getContentPane().add(frame.getContentPane());
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setTitle("Thêm policy");
        dialog.setVisible(true);
    }//GEN-LAST:event_jbtnThemActionPerformed

    private void jtAuditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtAuditMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jtAuditMouseClicked
    private void checkAndAlert() {
        List<Audit> auditRecords = AuditDAO.getAuditRecords();
        if(auditRecords.size()>5)
            JOptionPane.showMessageDialog(this, "Bạn đã đăng nhập hơn 5 lần!", "Cảnh báo", JOptionPane.INFORMATION_MESSAGE);
    }
    private void jbtnThemAuditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnThemAuditActionPerformed
        // TODO add your handling code here:
        String username = jtfUsername.getText();
        String auditType = jtfAuditType.getText();
        try {
            AuditDAO.setupUserAudit(connection, auditType, username);
            JOptionPane.showMessageDialog(this, "Thêm thành công!", "Thêm audit", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(PolicyJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnThemAuditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbtnThem;
    private javax.swing.JButton jbtnThemAudit;
    private javax.swing.JLabel jlbSoLuongPolicy;
    private javax.swing.JPanel jpnInfoAudit;
    private javax.swing.JPanel jpnInfoPolicy;
    private javax.swing.JPanel jpnView;
    private javax.swing.JPanel jpnView1;
    private javax.swing.JScrollPane jspAudit;
    private javax.swing.JScrollPane jspPolicy;
    private javax.swing.JTable jtAudit;
    private javax.swing.JTable jtPolicy;
    private javax.swing.JTabbedPane jtbPolicy;
    private javax.swing.JTextField jtfAuditType;
    private javax.swing.JTextField jtfUsername;
    // End of variables declaration//GEN-END:variables
}
