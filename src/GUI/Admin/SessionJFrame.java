/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Admin;

import DTO.Admin.Process;
import DAO.Admin.SessionDAO;

/**
 *
 * @author Admin
 */
public class SessionJFrame extends javax.swing.JFrame {
    /**
     * Creates new form SessionJFrame
     */
    public SessionJFrame(int sid) {
        initComponents();
        setView(sid);
    }
    public void setView(int sid) {
        Process process = SessionDAO.getInstance().getProcess(sid);
        if(process != null) {
            jtfSpid.setText(""+ process.getSpid());            
            jtfProgram.setText(process.getProgram());
            jtfUsername.setText(process.getUsername());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnThongTinProcess = new javax.swing.JPanel();
        jlbSpid = new javax.swing.JLabel();
        jlbProgram = new javax.swing.JLabel();
        jtfSpid = new javax.swing.JTextField();
        jlbUsername = new javax.swing.JLabel();
        jtfUsername = new javax.swing.JTextField();
        jtfProgram = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnThongTinProcess.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin Process", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jpnThongTinProcess.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jlbSpid.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jlbSpid.setText("SPID");

        jlbProgram.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jlbProgram.setText("Program");

        jtfSpid.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jlbUsername.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jlbUsername.setText("Username");

        jtfUsername.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jtfProgram.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        javax.swing.GroupLayout jpnThongTinProcessLayout = new javax.swing.GroupLayout(jpnThongTinProcess);
        jpnThongTinProcess.setLayout(jpnThongTinProcessLayout);
        jpnThongTinProcessLayout.setHorizontalGroup(
            jpnThongTinProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnThongTinProcessLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jpnThongTinProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbSpid)
                    .addComponent(jlbProgram)
                    .addComponent(jlbUsername))
                .addGap(50, 50, 50)
                .addGroup(jpnThongTinProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                    .addComponent(jtfSpid)
                    .addComponent(jtfProgram))
                .addGap(100, 100, 100))
        );
        jpnThongTinProcessLayout.setVerticalGroup(
            jpnThongTinProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongTinProcessLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jpnThongTinProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbSpid)
                    .addComponent(jtfSpid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnThongTinProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbProgram)
                    .addComponent(jtfProgram, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnThongTinProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbUsername))
                .addGap(100, 100, 100))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 906, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(61, 61, 61)
                    .addComponent(jpnThongTinProcess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(62, 62, 62)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(84, 84, 84)
                    .addComponent(jpnThongTinProcess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(79, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlbProgram;
    private javax.swing.JLabel jlbSpid;
    private javax.swing.JLabel jlbUsername;
    private javax.swing.JPanel jpnThongTinProcess;
    private javax.swing.JTextField jtfProgram;
    private javax.swing.JTextField jtfSpid;
    private javax.swing.JTextField jtfUsername;
    // End of variables declaration//GEN-END:variables
}
