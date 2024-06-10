/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Admin;

import DAO.Admin.PermissionDAO;
import DAO.Admin.UserDAO;
import DAO.TaiKhoanDAO;
import DAO.Admin.RolesDAO;
import DTO.Admin.Permission;
import DTO.Admin.Roles;
import DTO.Admin.User;
import DTO.NhanVien;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Admin
 */
public class PermissionJPanel extends javax.swing.JPanel {

    ArrayList<Permission> listPermission;
    ArrayList<Permission> listUserPermission;
    ArrayList<Roles> listRoles;
    ArrayList<Roles> listAllRoles;
    private List<String> checkedPermissions = new ArrayList<>();
    
    /**
     * Creates new form PermissionJPanel
     */
    public PermissionJPanel() {
        initComponents();
               
    }

    private void loadPrivs()
    {
        String[] header = {"", "QUYỀN"};
        listPermission = PermissionDAO.getInstance().getInfo();
        DefaultTableModel modelTableDb = new DefaultTableModel(header, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 0 ? Boolean.class : String.class;
            }
            
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                if(jcbEmpName.getSelectedItem() != null)
                {
                    return colIndex == 0;
                }
                return false;
            }
            
        };
        if(!listPermission.isEmpty())
        {
            for (Permission p : listPermission) {
                Object[] row = {false, p.getPrivilege()};
                modelTableDb.addRow(row);
            }            
        }        
        TableRowSorter<TableModel> rowSorter = null;        

        jtPermission.setModel(modelTableDb);
        jtPermission.setRowSorter(rowSorter);

        jtPermission.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        jtPermission.setFont(new Font("Arial", Font.PLAIN, 14));
        jtPermission.getTableHeader().setPreferredSize(new Dimension(100, 50));
        jtPermission.setRowHeight(50);
        jtPermission.validate();
        jtPermission.repaint();

        jsPermission.setPreferredSize(new Dimension(700, 400));

        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(jsPermission);
        jpnView.validate();
        jpnView.repaint();
    }
    private void loadUserPrivs()
    {
        String[] header = {"NHÂN VIÊN", "QUYỀN"};
        if (jcbEmpName.getSelectedItem() != null) {
            String username = (String) jcbEmpName.getSelectedItem();
            listUserPermission = PermissionDAO.getInstance().getInfoByUser(username);
            DefaultTableModel modelTableDb = new DefaultTableModel(header, 0) {                
                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {                    
                    return false;                                        
                }

            };
            if (!listUserPermission.isEmpty()) {
                for (Permission p : listUserPermission) {
                    Object[] row = {p.getGrantee(), p.getPrivilege()};
                    modelTableDb.addRow(row);
                }
            }

            TableRowSorter<TableModel> rowSorter = null;

            jtUserPrivs.setModel(modelTableDb);
            jtUserPrivs.setRowSorter(rowSorter);

            jtUserPrivs.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
            jtUserPrivs.setFont(new Font("Arial", Font.PLAIN, 14));
            jtUserPrivs.getTableHeader().setPreferredSize(new Dimension(100, 50));
            jtUserPrivs.setRowHeight(50);
            jtUserPrivs.validate();
            jtUserPrivs.repaint();

            jsUserPrivs.setPreferredSize(new Dimension(700, 400));

            jpnUserPriv.removeAll();
            jpnUserPriv.setLayout(new CardLayout());
            jpnUserPriv.add(jsUserPrivs);
            jpnUserPriv.validate();
            jpnUserPriv.repaint();
        }
    }
    private void loadRoles()
    {
       String[] header = {"NHÓM QUYỀN"};
        listAllRoles = RolesDAO.getInstance().getInfo();
        DefaultTableModel modelTableDb = new DefaultTableModel(header, 0) {            
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {                
                return false;
            }
            
        };
        if(!listAllRoles.isEmpty())
        {
            for (Roles role : listAllRoles) {
                Object[] row = {role.getRole()};
                modelTableDb.addRow(row);
            }            
        }        
        TableRowSorter<TableModel> rowSorter = null;        

        jtListRole.setModel(modelTableDb);
        jtListRole.setRowSorter(rowSorter);

        jtListRole.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        jtListRole.setFont(new Font("Arial", Font.PLAIN, 14));
        jtListRole.getTableHeader().setPreferredSize(new Dimension(100, 50));
        jtListRole.setRowHeight(50);
        jtListRole.validate();
        jtListRole.repaint();

        jsListRole.setPreferredSize(new Dimension(700, 400));

        jpnListRole.removeAll();
        jpnListRole.setLayout(new CardLayout());
        jpnListRole.add(jsListRole);
        jpnListRole.validate();
        jpnListRole.repaint();
    }
    private void loadPrivsForRoles()
    {
        String[] header = {"", "QUYỀN"};
        listPermission = PermissionDAO.getInstance().getInfo();
        DefaultTableModel modelTableDb = new DefaultTableModel(header, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 0 ? Boolean.class : String.class;
            }
            
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                int selectedRow = jtListRole.getSelectedRow();
                int selectedColumn = jtListRole.getSelectedColumn();
                
                Object value = jtListRole.getValueAt(selectedRow, selectedColumn);
                if(value != null)
                {
                    return colIndex == 0;
                }
                return false;
            }
            
        };
        if(!listPermission.isEmpty())
        {
            for (Permission p : listPermission) {
                Object[] row = {false, p.getPrivilege()};
                modelTableDb.addRow(row);
            }            
        }        
        TableRowSorter<TableModel> rowSorter = null;        

        jtListPriv.setModel(modelTableDb);
        jtListPriv.setRowSorter(rowSorter);

        jtListPriv.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        jtListPriv.setFont(new Font("Arial", Font.PLAIN, 14));
        jtListPriv.getTableHeader().setPreferredSize(new Dimension(100, 50));
        jtListPriv.setRowHeight(50);
        jtListPriv.validate();
        jtListPriv.repaint();

        jsListPriv.setPreferredSize(new Dimension(700, 400));

        jpnListPriv.removeAll();
        jpnListPriv.setLayout(new CardLayout());
        jpnListPriv.add(jsListPriv);
        jpnListPriv.validate();
        jpnListPriv.repaint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtbPermission = new javax.swing.JTabbedPane();
        jpnPriv = new javax.swing.JPanel();
        jcbEmpName = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnPhanQuyen = new javax.swing.JButton();
        btnHuyQuyen = new javax.swing.JButton();
        btnXemQuyen = new javax.swing.JButton();
        jpnView = new javax.swing.JPanel();
        jsPermission = new javax.swing.JScrollPane();
        jtPermission = new javax.swing.JTable();
        jpnUserPriv = new javax.swing.JPanel();
        jsUserPrivs = new javax.swing.JScrollPane();
        jtUserPrivs = new javax.swing.JTable();
        jpnRole = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfRoleName = new javax.swing.JTextField();
        btnTaoRole = new javax.swing.JButton();
        btnXoaRole = new javax.swing.JButton();
        jpnListRole = new javax.swing.JPanel();
        jsListRole = new javax.swing.JScrollPane();
        jtListRole = new javax.swing.JTable();
        jpnListPriv = new javax.swing.JPanel();
        jsListPriv = new javax.swing.JScrollPane();
        jtListPriv = new javax.swing.JTable();
        btnCapQuyenChoNhomQuyen = new javax.swing.JButton();

        jtbPermission.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jtbPermission.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jtbPermissionStateChanged(evt);
            }
        });

        jcbEmpName.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Chọn tên người dùng");

        btnPhanQuyen.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnPhanQuyen.setText("Phân quyền");
        btnPhanQuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhanQuyenActionPerformed(evt);
            }
        });

        btnHuyQuyen.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnHuyQuyen.setText("Hủy quyền");
        btnHuyQuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyQuyenActionPerformed(evt);
            }
        });

        btnXemQuyen.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnXemQuyen.setText("Xem quyền");
        btnXemQuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemQuyenActionPerformed(evt);
            }
        });

        jtPermission.setModel(new javax.swing.table.DefaultTableModel(
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
        jtPermission.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPermissionMouseClicked(evt);
            }
        });
        jsPermission.setViewportView(jtPermission);

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jsPermission, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jsPermission, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jtUserPrivs.setModel(new javax.swing.table.DefaultTableModel(
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
        jtUserPrivs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtUserPrivsMouseClicked(evt);
            }
        });
        jsUserPrivs.setViewportView(jtUserPrivs);

        javax.swing.GroupLayout jpnUserPrivLayout = new javax.swing.GroupLayout(jpnUserPriv);
        jpnUserPriv.setLayout(jpnUserPrivLayout);
        jpnUserPrivLayout.setHorizontalGroup(
            jpnUserPrivLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jsUserPrivs, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jpnUserPrivLayout.setVerticalGroup(
            jpnUserPrivLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jsUserPrivs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnPrivLayout = new javax.swing.GroupLayout(jpnPriv);
        jpnPriv.setLayout(jpnPrivLayout);
        jpnPrivLayout.setHorizontalGroup(
            jpnPrivLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPrivLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnPrivLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnPrivLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jcbEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addComponent(jpnView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jpnPrivLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnPrivLayout.createSequentialGroup()
                        .addComponent(btnXemQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnPhanQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btnHuyQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jpnUserPriv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        jpnPrivLayout.setVerticalGroup(
            jpnPrivLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPrivLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jpnPrivLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPhanQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXemQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnPrivLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnUserPriv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtbPermission.addTab("Quyền", jpnPriv);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tên nhóm quyền");

        btnTaoRole.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnTaoRole.setText("Tạo");
        btnTaoRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoRoleActionPerformed(evt);
            }
        });

        btnXoaRole.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnXoaRole.setText("Xóa");
        btnXoaRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaRoleActionPerformed(evt);
            }
        });

        jtListRole.setModel(new javax.swing.table.DefaultTableModel(
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
        jtListRole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListRoleMouseClicked(evt);
            }
        });
        jsListRole.setViewportView(jtListRole);

        javax.swing.GroupLayout jpnListRoleLayout = new javax.swing.GroupLayout(jpnListRole);
        jpnListRole.setLayout(jpnListRoleLayout);
        jpnListRoleLayout.setHorizontalGroup(
            jpnListRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jsListRole, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
        );
        jpnListRoleLayout.setVerticalGroup(
            jpnListRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jsListRole, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jtListPriv.setModel(new javax.swing.table.DefaultTableModel(
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
        jtListPriv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListPrivMouseClicked(evt);
            }
        });
        jsListPriv.setViewportView(jtListPriv);

        javax.swing.GroupLayout jpnListPrivLayout = new javax.swing.GroupLayout(jpnListPriv);
        jpnListPriv.setLayout(jpnListPrivLayout);
        jpnListPrivLayout.setHorizontalGroup(
            jpnListPrivLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jsListPriv, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jpnListPrivLayout.setVerticalGroup(
            jpnListPrivLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jsListPriv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );

        btnCapQuyenChoNhomQuyen.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnCapQuyenChoNhomQuyen.setText("Cấp quyền cho nhóm quyền");
        btnCapQuyenChoNhomQuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapQuyenChoNhomQuyenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnRoleLayout = new javax.swing.GroupLayout(jpnRole);
        jpnRole.setLayout(jpnRoleLayout);
        jpnRoleLayout.setHorizontalGroup(
            jpnRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRoleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnRoleLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfRoleName, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTaoRole, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaRole, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(355, 355, 355)
                        .addComponent(btnCapQuyenChoNhomQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnRoleLayout.createSequentialGroup()
                        .addComponent(jpnListRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jpnListPriv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        jpnRoleLayout.setVerticalGroup(
            jpnRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRoleLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jpnRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfRoleName, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaoRole, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaRole, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapQuyenChoNhomQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpnListRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnListPriv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtbPermission.addTab("Nhóm quyền", jpnRole);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtbPermission, javax.swing.GroupLayout.PREFERRED_SIZE, 1662, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtbPermission, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXemQuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemQuyenActionPerformed
        // TODO add your handling code here:
        if(jcbEmpName.getSelectedItem() != null)
        {
            jpnUserPriv.setVisible(true);
            loadUserPrivs();
        }
        else
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần xem quyền" , "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnXemQuyenActionPerformed

    private void btnHuyQuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyQuyenActionPerformed
        // TODO add your handling code here:
        String username = (String) jcbEmpName.getSelectedItem();
        if(checkedPermissions != null)
        {
            for (String permission : checkedPermissions) {
                PermissionDAO.getInstance().revokeUserPrivilege(username, permission);
                JOptionPane.showMessageDialog(this, "Đã hủy quyền " + permission + " của " + username, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }            
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn quyền cần thực hiện" , "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnHuyQuyenActionPerformed

    private void btnPhanQuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhanQuyenActionPerformed
        // TODO add your handling code here:
        String username = (String) jcbEmpName.getSelectedItem();
        if(checkedPermissions != null)
        {
            for (String permission : checkedPermissions) {
                PermissionDAO.getInstance().grantUserPrivilege(username, permission);
                JOptionPane.showMessageDialog(this, "Đã phân quyền " + permission + " cho " + username, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }            
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn quyền cần thực hiện" , "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnPhanQuyenActionPerformed

    private void jtPermissionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPermissionMouseClicked
        // TODO add your handling code here:
        int row = jtPermission.rowAtPoint(evt.getPoint());
        int column = jtPermission.columnAtPoint(evt.getPoint());

        if (column == 0) {
            boolean isChecked = (boolean) jtPermission.getValueAt(row, column);
            String permission = (String) jtPermission.getValueAt(row, 1);

            if (isChecked) {
                checkedPermissions.add(permission);
            }
        }
    }//GEN-LAST:event_jtPermissionMouseClicked

    private void jtUserPrivsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtUserPrivsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtUserPrivsMouseClicked

    private void btnTaoRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoRoleActionPerformed
        // TODO add your handling code here:
        String rolename = jtfRoleName.getText();
        RolesDAO.getInstance().createRole(rolename);
        JOptionPane.showMessageDialog(this, "Đã tạo nhóm quyền " + rolename, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnTaoRoleActionPerformed

    private void jtListRoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListRoleMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtListRoleMouseClicked

    private void jtListPrivMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListPrivMouseClicked
        // TODO add your handling code here:
        int row = jtListPriv.rowAtPoint(evt.getPoint());
        int column = jtListPriv.columnAtPoint(evt.getPoint());

        if (column == 0) {
            boolean isChecked = (boolean) jtListPriv.getValueAt(row, column);
            String permission = (String) jtListPriv.getValueAt(row, 1);

            if (isChecked) {
                checkedPermissions.add(permission);
            }
        }
        
    }//GEN-LAST:event_jtListPrivMouseClicked

    private void jtbPermissionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jtbPermissionStateChanged
        // TODO add your handling code here:        
        loadComboBoxUers(); 
        int index = jtbPermission.getSelectedIndex();
        if (index == 0) {                                 
            loadPrivs();
            jpnUserPriv.setVisible(false);
        }
        if(index == 1)
        {
            loadPrivsForRoles();
            loadRoles();
        }
    }//GEN-LAST:event_jtbPermissionStateChanged

    private void btnCapQuyenChoNhomQuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapQuyenChoNhomQuyenActionPerformed
        // TODO add your handling code here:
        int selectedRow = jtListRole.getSelectedRow();
        int selectedColumn = jtListRole.getSelectedColumn();
        
        String roles = (String) jtListRole.getValueAt(selectedRow, selectedColumn);
        if(checkedPermissions != null)
        {
            for (String permission : checkedPermissions) {
                PermissionDAO.getInstance().grantUserPrivilege(roles, permission);
                JOptionPane.showMessageDialog(this, "Đã phân quyền " + permission + " cho " + roles, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }            
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn quyền cần thực hiện" , "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnCapQuyenChoNhomQuyenActionPerformed

    private void btnXoaRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaRoleActionPerformed
        // TODO add your handling code here:
        int selectedRow = jtListRole.getSelectedRow();
        int selectedColumn = jtListRole.getSelectedColumn();
        
        String roles = (String) jtListRole.getValueAt(selectedRow, selectedColumn);
        if(roles != null)
        {            
            RolesDAO.getInstance().dropRole(roles);
            JOptionPane.showMessageDialog(this, "Đã hủy nhóm quyền " + roles, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnXoaRoleActionPerformed
    private void loadComboBoxUers()
    {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement(null);
        List<User> listNV = UserDAO.getInstance().getListUser();

        for (User nv : listNV) {
            model.addElement(nv.getUSERNAME());
        }
        jcbEmpName.setModel(model);
    }    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapQuyenChoNhomQuyen;
    private javax.swing.JButton btnHuyQuyen;
    private javax.swing.JButton btnPhanQuyen;
    private javax.swing.JButton btnTaoRole;
    private javax.swing.JButton btnXemQuyen;
    private javax.swing.JButton btnXoaRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> jcbEmpName;
    private javax.swing.JPanel jpnListPriv;
    private javax.swing.JPanel jpnListRole;
    private javax.swing.JPanel jpnPriv;
    private javax.swing.JPanel jpnRole;
    private javax.swing.JPanel jpnUserPriv;
    private javax.swing.JPanel jpnView;
    private javax.swing.JScrollPane jsListPriv;
    private javax.swing.JScrollPane jsListRole;
    private javax.swing.JScrollPane jsPermission;
    private javax.swing.JScrollPane jsUserPrivs;
    private javax.swing.JTable jtListPriv;
    private javax.swing.JTable jtListRole;
    private javax.swing.JTable jtPermission;
    private javax.swing.JTable jtUserPrivs;
    private javax.swing.JTabbedPane jtbPermission;
    private javax.swing.JTextField jtfRoleName;
    // End of variables declaration//GEN-END:variables
}
