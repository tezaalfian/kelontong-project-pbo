/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelontongid;

import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class PenjualanEditForm extends javax.swing.JFrame {
    private DefaultComboBoxModel cbModel;
    private CrudBarang barangModel = new CrudBarang();
    private CrudTransaksi trxModel = new CrudTransaksi();
    private ResultSet dataBarang;
    private ResultSet dataTrx;
    private AdminForm admin = new AdminForm();
    
    public PenjualanEditForm(String id) {
        initComponents();
        dataTrx = trxModel.getById(id);
        setData();
    }

    private PenjualanEditForm() {
        
    }
    private void reset_text() {
        txt_totalHarga.setText("");
        txt_harga.setText("");
        txt_barangId.setText("");
        txt_jumlah.setText("");
        cb_barang.setSelectedIndex(0);
    }
    
    private void exitForm(){
        dispose();
        admin.tampil_transaksi("JUAL");
        admin.setVisible(true);
    }
    
    private void setData(){
        cbModel = new DefaultComboBoxModel();
        cb_barang.setModel(cbModel);
        dataBarang = barangModel.stokAda();
        try {
            cb_barang.addItem("Pilih Barang");
            int index = 0,i=1;
            dataTrx.next();
            while(dataBarang.next()){
                if(dataTrx.getString("barang_id").equals(dataBarang.getString("id"))){
                    index = i;
                }
                cb_barang.addItem(dataBarang.getString("id")+"-"+dataBarang.getString("nama_barang"));
                i++;
            }
            txt_jumlah.setText(dataTrx.getString("qty"));
            cb_barang.setSelectedIndex(index);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void setBarangDetail(String id){
        dataBarang = barangModel.getById(id);
        try {
            dataBarang.next();
            txt_barangId.setText(dataBarang.getString("id"));
            txt_harga.setText(dataBarang.getString("harga"));
            int jumlah = 1;
            if(!txt_jumlah.getText().trim().equals("")){
                if (!txt_jumlah.getText().trim().matches("[0-9]+")){
                    JOptionPane.showMessageDialog(null,"Jumlah tidak valid!");
                    txt_jumlah.setText("");
                    txt_jumlah.requestFocus();
                }else{
                    jumlah = Integer.parseInt(txt_jumlah.getText().trim());
                }
            }
            jumlah = Integer.parseInt(dataBarang.getString("harga")) * jumlah;
            txt_totalHarga.setText(Integer.toString(jumlah));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage()); 
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

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_reset = new javax.swing.JButton();
        btn_keluar = new javax.swing.JButton();
        txt_harga = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_jumlah = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_totalHarga = new javax.swing.JTextField();
        cb_barang = new javax.swing.JComboBox<>();
        txt_barangId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_simpan = new javax.swing.JButton();
        txt_totaltransaksi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(66, 123, 198));

        jPanel1.setBackground(new java.awt.Color(143, 192, 247));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("EDIT PENJUALAN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(358, 358, 358))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_reset.setBackground(new java.awt.Color(66, 123, 198));
        btn_reset.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_reset.setForeground(new java.awt.Color(255, 255, 255));
        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        btn_keluar.setBackground(new java.awt.Color(66, 123, 198));
        btn_keluar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_keluar.setForeground(new java.awt.Color(255, 255, 255));
        btn_keluar.setText("Keluar");
        btn_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluarActionPerformed(evt);
            }
        });

        txt_harga.setEditable(false);
        txt_harga.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txt_harga.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_harga.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(66, 123, 198)));
        txt_harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setText("Harga");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setText("Jumlah");

        txt_jumlah.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txt_jumlah.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_jumlah.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(66, 123, 198)));
        txt_jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jumlahActionPerformed(evt);
            }
        });
        txt_jumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_jumlahKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_jumlahKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setText("Total Harga");

        txt_totalHarga.setEditable(false);
        txt_totalHarga.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txt_totalHarga.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_totalHarga.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(66, 123, 198)));
        txt_totalHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalHargaActionPerformed(evt);
            }
        });
        txt_totalHarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_totalHargaKeyPressed(evt);
            }
        });

        cb_barang.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cb_barang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_barang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_barangItemStateChanged(evt);
            }
        });

        txt_barangId.setEditable(false);
        txt_barangId.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txt_barangId.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_barangId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(66, 123, 198)));
        txt_barangId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_barangIdActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setText("Kode Barang");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setText("Nama Barang");

        btn_simpan.setBackground(new java.awt.Color(66, 123, 198));
        btn_simpan.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_simpan.setForeground(new java.awt.Color(255, 255, 255));
        btn_simpan.setText("Simpan");
        btn_simpan.setActionCommand("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        txt_totaltransaksi.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(cb_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(69, 69, 69)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_barangId, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7)
                    .addComponent(txt_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_totalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(txt_totaltransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_keluar))))
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addGap(11, 11, 11)
                .addComponent(cb_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_barangId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel7)
                .addGap(11, 11, 11)
                .addComponent(txt_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel8)
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_totalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_totaltransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        reset_text();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluarActionPerformed
        // TODO add your handling code here:
        exitForm();
    }//GEN-LAST:event_btn_keluarActionPerformed

    private void txt_hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hargaActionPerformed

    private void txt_jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlahActionPerformed

    }//GEN-LAST:event_txt_jumlahActionPerformed

    private void txt_jumlahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jumlahKeyPressed

    }//GEN-LAST:event_txt_jumlahKeyPressed

    private void txt_jumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jumlahKeyReleased
        if(!txt_barangId.getText().trim().equals("")){
            setBarangDetail(txt_barangId.getText().trim());
        }
    }//GEN-LAST:event_txt_jumlahKeyReleased

    private void txt_totalHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalHargaActionPerformed

    }//GEN-LAST:event_txt_totalHargaActionPerformed

    private void txt_totalHargaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_totalHargaKeyPressed

    }//GEN-LAST:event_txt_totalHargaKeyPressed

    private void cb_barangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_barangItemStateChanged
        // TODO add your handling code here:
        if(cb_barang.getSelectedIndex() > 0){
            String[] barang = cb_barang.getSelectedItem().toString().split("\\-", -1);
            setBarangDetail(barang[0]);
        }else{
            txt_totalHarga.setText("");
            txt_harga.setText("");
            txt_barangId.setText("");
            txt_jumlah.setText("");
        }
    }//GEN-LAST:event_cb_barangItemStateChanged

    private void txt_barangIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_barangIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_barangIdActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        if (cb_barang.getSelectedIndex() < 1){
            JOptionPane.showMessageDialog(null,"Maaf, pilih terlebih dahulu barang nya!");
        } else if (!txt_jumlah.getText().trim().matches("[0-9]+")){
            JOptionPane.showMessageDialog(null,"Jumlah stok tidak valid!");
            txt_jumlah.setText("");
            txt_jumlah.requestFocus();
        }else {
            String [] barang = cb_barang.getSelectedItem().toString().split("\\-", -1);
            try {
//                dataTrx.next();
                int stok = Integer.parseInt(dataBarang.getString("stok")) + Integer.parseInt(dataTrx.getString("qty"));
                if(stok < Integer.parseInt(txt_jumlah.getText())){
                    JOptionPane.showMessageDialog(null,"Maaf, Stok tidak mencukupi!");
                    txt_jumlah.setText("");
                    txt_jumlah.requestFocus();
                }else{
                    String key[] ={"barang_id","qty","nominal"};
                    String value[] = {
                        barang[0],
                        txt_jumlah.getText(),
                        txt_totalHarga.getText()
                    };
                    trxModel.ubahData(key, value, dataTrx.getString("id"));
                    if(Integer.parseInt(dataTrx.getString("qty")) != Integer.parseInt(txt_totalHarga.getText())){
                        stok = Integer.parseInt(dataTrx.getString("qty")) - Integer.parseInt(txt_jumlah.getText());
                        barangModel.editStok("+", barang[0], Integer.toString(stok));
                    }
                    reset_text();
                    JOptionPane.showMessageDialog(null,"Data berhasil disimpan!");
                    exitForm();
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

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
            java.util.logging.Logger.getLogger(PenjualanEditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PenjualanEditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PenjualanEditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PenjualanEditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PenjualanEditForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JComboBox<String> cb_barang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txt_barangId;
    private javax.swing.JTextField txt_harga;
    private javax.swing.JTextField txt_jumlah;
    private javax.swing.JTextField txt_totalHarga;
    private javax.swing.JLabel txt_totaltransaksi;
    // End of variables declaration//GEN-END:variables
}
