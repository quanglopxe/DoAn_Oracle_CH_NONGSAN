/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Admin;
import DAO.Admin.TablespaceDAO;
import DTO.Admin.Tablespace;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author Admin
 */
public class TablespaceJPanel extends javax.swing.JPanel {
    ArrayList<Tablespace> listTBS;
    /**
     * Creates new form TablespaceJPanel
     */
    public TablespaceJPanel() {
        initComponents();
        loadTablespace();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtbTablespace = new javax.swing.JTabbedPane();
        jpnInfoTBS = new javax.swing.JPanel();
        jpnView = new javax.swing.JPanel();
        jspTBS = new javax.swing.JScrollPane();
        jtTBS = new javax.swing.JTable();
        jtfName = new javax.swing.JTextField();
        jlbName = new javax.swing.JLabel();
        jlbError = new javax.swing.JLabel();
        jbtSearch = new javax.swing.JButton();

        jtbTablespace.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jtbTablespace.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jtbTablespaceStateChanged(evt);
            }
        });

        jtTBS.setModel(new javax.swing.table.DefaultTableModel(
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
        jspTBS.setViewportView(jtTBS);

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnViewLayout.createSequentialGroup()
                .addComponent(jspTBS, javax.swing.GroupLayout.DEFAULT_SIZE, 1088, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspTBS, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
        );

        jbtSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbtSearch.setText("Tìm");
        jbtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnInfoTBSLayout = new javax.swing.GroupLayout(jpnInfoTBS);
        jpnInfoTBS.setLayout(jpnInfoTBSLayout);
        jpnInfoTBSLayout.setHorizontalGroup(
            jpnInfoTBSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnInfoTBSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnInfoTBSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnInfoTBSLayout.createSequentialGroup()
                        .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jpnInfoTBSLayout.createSequentialGroup()
                        .addComponent(jlbName, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbError, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jpnInfoTBSLayout.setVerticalGroup(
            jpnInfoTBSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnInfoTBSLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jpnInfoTBSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpnInfoTBSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlbName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlbError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtbTablespace.addTab("Thông tin tablespace", jpnInfoTBS);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1147, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(jtbTablespace)
                    .addGap(15, 15, 15)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 649, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(jtbTablespace)
                    .addGap(15, 15, 15)))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void loadTablespace() {
        String[] header = {"Username", "Default Tablespace"};        
        listTBS = TablespaceDAO.getInstance().getInfo();
        DefaultTableModel modelTableDb = new DefaultTableModel(header, 0) {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        for (Tablespace tbs : listTBS) {
            Object[] row = {tbs.getUsername(), tbs.getDefault_tablespace()};
            modelTableDb.addRow(row);
        }
        jlbError.setText("");

        TableRowSorter<TableModel> rowSorter = null;
        jlbName.setText("Nhập tên nhân viên cần xem tablespace:");
        
        
        jtTBS.setModel(modelTableDb);
        jtTBS.setRowSorter(rowSorter);

        jtTBS.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        jtTBS.setFont(new Font("Arial", Font.PLAIN, 14));
        jtTBS.getTableHeader().setPreferredSize(new Dimension(100, 50));
        jtTBS.setRowHeight(50);
        jtTBS.validate();
        jtTBS.repaint();

        jspTBS.setPreferredSize(new Dimension(1350, 400));

        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(jspTBS);
        jpnView.validate();
        jpnView.repaint();
    }
    private void jtbTablespaceStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jtbTablespaceStateChanged
        // TODO add your handling code here:
        int index = jtbTablespace.getSelectedIndex();
        if (index == 0) {
            loadTablespace();
        }
    }//GEN-LAST:event_jtbTablespaceStateChanged

    private void jbtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSearchActionPerformed
        // TODO add your handling code here:
        String[] header = {"Username", "Default Tablespace"};        
        listTBS = TablespaceDAO.getInstance().getInfoByOwner(jtfName.getText());
        DefaultTableModel modelTableDb = new DefaultTableModel(header, 0) {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        if(!listTBS.isEmpty())
        {
            for (Tablespace tbs : listTBS) {
                Object[] row = {tbs.getUsername(), tbs.getDefault_tablespace()};
                modelTableDb.addRow(row);
            }
            jlbError.setText("");
        }                    
        TableRowSorter<TableModel> rowSorter = null;
        jlbName.setText("Nhập tên nhân viên cần xem tablespace:");
        
        
        jtTBS.setModel(modelTableDb);
        jtTBS.setRowSorter(rowSorter);

        jtTBS.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        jtTBS.setFont(new Font("Arial", Font.PLAIN, 14));
        jtTBS.getTableHeader().setPreferredSize(new Dimension(100, 50));
        jtTBS.setRowHeight(50);
        jtTBS.validate();
        jtTBS.repaint();

        jspTBS.setPreferredSize(new Dimension(1350, 400));

        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(jspTBS);
        jpnView.validate();
        jpnView.repaint();
        if(jtfName.getText().isEmpty())
        {
            jlbError.setText("Tên nhân viên không tồn tại!");
            loadTablespace();            
        }
    }//GEN-LAST:event_jbtSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtSearch;
    private javax.swing.JLabel jlbError;
    private javax.swing.JLabel jlbName;
    private javax.swing.JPanel jpnInfoTBS;
    private javax.swing.JPanel jpnView;
    private javax.swing.JScrollPane jspTBS;
    private javax.swing.JTable jtTBS;
    private javax.swing.JTabbedPane jtbTablespace;
    private javax.swing.JTextField jtfName;
    // End of variables declaration//GEN-END:variables
}
