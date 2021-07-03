/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelontongid;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class BarangForm extends javax.swing.JFrame {
    private String barangId = "";
    private CrudBarang barangModel = new CrudBarang();
    private AdminForm admin = new AdminForm();
    private ResultSet data;
    /**
     * Creates new form BarangForm
     */
    public BarangForm() {
        initComponents();
    }
    public BarangForm(String barangId) {
        initComponents();
        this.barangId = barangId;
        data = barangModel.getById(this.barangId);
        try {
            data.next();
            txt_id.setText(data.getString("id"));
            txt_namaBarang.setText(data.getString("nama_barang"));
            txt_stok.setText(data.getString("stok"));
            txt_harga.setText(data.getString("harga"));
            txt_id.setEditable(false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void reset_text() {
        txt_id.setText(""); 
        txt_namaBarang.setText("");
        txt_stok.setText("");
        txt_harga.setText("");
    }
    
    private void exitForm(){
        barangId = "";
        dispose();
        admin.tampil_barang();
        admin.setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txt_id = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_simpan = new javax.swing.JButton();
        btn_keluar = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        txt_namaBarang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_stok = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_harga = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_id.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txt_id.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(66, 123, 198)));
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });
        jPanel2.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 440, 30));

        jPanel3.setBackground(new java.awt.Color(66, 123, 198));

        jPanel1.setBackground(new java.awt.Color(143, 192, 247));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TAMBAH BARANG");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 70));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setText("ID Barang");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        btn_simpan.setBackground(new java.awt.Color(66, 123, 198));
        btn_simpan.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_simpan.setForeground(new java.awt.Color(255, 255, 255));
        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        jPanel2.add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 440, 30));

        btn_keluar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_keluar.setText("Keluar");
        btn_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 220, 30));

        btn_reset.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });
        jPanel2.add(btn_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, 220, 30));

        txt_namaBarang.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txt_namaBarang.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_namaBarang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(66, 123, 198)));
        txt_namaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namaBarangActionPerformed(evt);
            }
        });
        jPanel2.add(txt_namaBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 440, 30));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setText("Nama Barang");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setText("Stok");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        txt_stok.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txt_stok.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_stok.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(66, 123, 198)));
        txt_stok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_stokActionPerformed(evt);
            }
        });
        txt_stok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_stokKeyPressed(evt);
            }
        });
        jPanel2.add(txt_stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 440, 30));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setText("Harga");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        txt_harga.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txt_harga.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_harga.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(66, 123, 198)));
        txt_harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargaActionPerformed(evt);
            }
        });
        txt_harga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_hargaKeyPressed(evt);
            }
        });
        jPanel2.add(txt_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 440, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        if (txt_namaBarang.getText().trim().equals("") || txt_id.getText().trim().equals("") || txt_stok.getText().trim().equals("") || txt_harga.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Maaf, masih ada yang kosong!");
            txt_namaBarang.requestFocus();
        } else if (!txt_stok.getText().trim().matches("[0-9]+")){
            JOptionPane.showMessageDialog(null,"Jumlah stok tidak valid!");
            txt_stok.setText("");
            txt_stok.requestFocus();
        } else if (!txt_harga.getText().trim().matches("[0-9]+")){
            JOptionPane.showMessageDialog(null,"Harga barang tidak valid!");
            txt_harga.setText("");
            txt_harga.requestFocus();
        } else {
            try {
                String[] key = {
                    "id","nama_barang","stok","harga"
                };
                String[] value = {
                    txt_id.getText(),
                    txt_namaBarang.getText(),
                    txt_stok.getText(),
                    txt_harga.getText()
                };
                String msg = null;
                if(barangId.isEmpty()){
                    msg = barangModel.simpanData(key, value);
                }else{
                    msg = barangModel.ubahData(key, value, data.getString("id"));
                }
                JOptionPane.showMessageDialog(null, msg , "Informasi",JOptionPane.INFORMATION_MESSAGE);
                if(!barangId.isEmpty()){
                    exitForm();
                }
                if(msg.contains("berhasil")){
                    reset_text();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal tersimpan ("+e.getMessage()+")" , "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluarActionPerformed
        // TODO add your handling code here:
        exitForm();
    }//GEN-LAST:event_btn_keluarActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        reset_text();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void txt_namaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namaBarangActionPerformed

    private void txt_stokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_stokActionPerformed

    }//GEN-LAST:event_txt_stokActionPerformed

    private void txt_hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargaActionPerformed

    }//GEN-LAST:event_txt_hargaActionPerformed

    private void txt_stokKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_stokKeyPressed

    }//GEN-LAST:event_txt_stokKeyPressed

    private void txt_hargaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_hargaKeyPressed

    }//GEN-LAST:event_txt_hargaKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BarangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BarangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BarangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BarangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BarangForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txt_harga;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_namaBarang;
    private javax.swing.JTextField txt_stok;
    // End of variables declaration//GEN-END:variables
}