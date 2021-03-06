/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thaismartcardreaderfarme;

//libary from HostOS
import com.hostos.lib.thaismartcard.cardreader.pcscServices;
import com.hostos.lib.thaismartcard.model.MoiApplet1Info;
import com.hostos.lib.thaismartcard.main.tscmReader;

//libary from java && javax
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.smartcardio.Card;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.TerminalFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class tscmForm extends javax.swing.JFrame {
//  variable of java smartcard io
    private final TerminalFactory factory;
    private final List<CardTerminal> terminals;
    private CardTerminal terminal;
    private Card card;
    
//  variable of thaismartcard libary
    private pcscServices pcsc;
    private MoiApplet1Info moi;
    
    public tscmForm() throws CardException, IOException {
        initComponents();
        
        //service of libary
        pcsc = new pcscServices();
        //Model from libary HostOS
        moi = new MoiApplet1Info();
        
        // list of device
        factory = TerminalFactory.getDefault();
        terminals = factory.terminals().list();
        
        //Set Combo box to select device
        Vector Items = new Vector();
        for(int i=0; i<terminals.size();i++){
            System.out.println(i+" : "+terminals.get(i));
            Items.add(terminals.get(i));
            deviceCombo.setSelectedIndex(terminals.size());
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(Items);
        deviceCombo.setModel(model);
        deviceCombo.getSelectedIndex();
        
        // Use the first terminal
        terminal = terminals.get(0);
        // Connect with the card
        card = terminal.connect("*");
        //p.wakeupCard(card);
        pcsc.getAvialableDataInfo(card, true);
        
//      set text in label
        idTxt.setText(moi.getPid());
        nameTxt.setText(moi.getThaiName().toString());
        fnameTxt.setText(moi.getThaiName().getFirstName());
        lnameTxt.setText(moi.getThaiName().getLastName());
        birthTxt.setText(moi.getFormattedBod());
        sexTxt.setText(moi.getSexDesc());
        addressTxt.setText(moi.getAddress());
        issueTxt.setText(moi.getFormattedDateOfIssue());
        experTxt.setText(moi.getFormattedDateOfExpiry());
        miniID.setText(moi.getPid());
        
//      set image to label
        ByteArrayInputStream c = new ByteArrayInputStream(moi.getFacesImage());
        BufferedImage img = ImageIO.read(c);
        ImageIcon icon = new ImageIcon(img.getScaledInstance(148, 178, 0));
        picTxt.setIcon(icon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        picTxt = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        idTxt = new javax.swing.JLabel();
        nameTxt = new javax.swing.JLabel();
        fnameTxt = new javax.swing.JLabel();
        lnameTxt = new javax.swing.JLabel();
        birthTxt = new javax.swing.JLabel();
        addressTxt = new javax.swing.JLabel();
        miniID = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        issueTxt = new javax.swing.JLabel();
        experTxt = new javax.swing.JLabel();
        sexTxt = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        deviceCombo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setEnabled(false);
        jPanel1.setLayout(null);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 90, 0, 292);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 0, 84);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(35, 125, 0, 0);

        picTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        picTxt.setText("Pic");
        jPanel1.add(picTxt);
        picTxt.setBounds(510, 70, 160, 170);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("บัตรประจำตัวประชาชน Thai National ID Card");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(120, 10, 396, 29);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("เลขประจำตัวประชาชน");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(120, 50, 134, 15);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Identification Number");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(120, 70, 134, 15);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("ชื่อตัวและชื่อสกุล");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(190, 100, 94, 15);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("์Name");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(240, 130, 33, 15);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Last name");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(210, 150, 63, 15);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("เกิดวันที่");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(230, 190, 43, 15);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("เพศ");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(240, 220, 22, 15);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("ที่อยู่");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(90, 270, 25, 15);

        idTxt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        idTxt.setText("-");
        jPanel1.add(idTxt);
        idTxt.setBounds(260, 60, 235, 17);

        nameTxt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nameTxt.setText("-");
        jPanel1.add(nameTxt);
        nameTxt.setBounds(290, 100, 275, 17);

        fnameTxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fnameTxt.setText("-");
        jPanel1.add(fnameTxt);
        fnameTxt.setBounds(290, 130, 174, 15);

        lnameTxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lnameTxt.setText("-");
        jPanel1.add(lnameTxt);
        lnameTxt.setBounds(290, 150, 144, 15);

        birthTxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        birthTxt.setText("-");
        jPanel1.add(birthTxt);
        birthTxt.setBounds(290, 190, 128, 15);

        addressTxt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        addressTxt.setText("-");
        jPanel1.add(addressTxt);
        addressTxt.setBounds(120, 270, 480, 15);

        miniID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        miniID.setText("-");
        jPanel1.add(miniID);
        miniID.setBounds(540, 250, 100, 14);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("วันออกบัตร");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(180, 330, 54, 15);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("วันบัตรหมดอายุ");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(390, 330, 75, 15);

        issueTxt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        issueTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        issueTxt.setText("-");
        jPanel1.add(issueTxt);
        issueTxt.setBounds(140, 360, 130, 14);

        experTxt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        experTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        experTxt.setText("-");
        jPanel1.add(experTxt);
        experTxt.setBounds(370, 360, 130, 14);

        sexTxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sexTxt.setText("-");
        jPanel1.add(sexTxt);
        sexTxt.setBounds(290, 220, 70, 15);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pic/barcode.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 100, 60, 292);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pic/symbol.png"))); // NOI18N
        jPanel1.add(jLabel12);
        jLabel12.setBounds(10, 0, 90, 100);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pic/ship.png"))); // NOI18N
        jPanel1.add(jLabel16);
        jLabel16.setBounds(70, 110, 100, 100);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("เลือกเครื่องอ่านบัตร");

        deviceCombo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deviceCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        deviceCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deviceComboMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deviceComboMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deviceComboMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(deviceCombo, 0, 523, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(deviceCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deviceComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deviceComboMouseClicked
        System.out.println(deviceCombo.getSelectedIndex());
        terminal = terminals.get(deviceCombo.getSelectedIndex());
        try {
            card = terminal.connect("*");
            idTxt.setText(moi.getPid());
            nameTxt.setText(moi.getThaiName().toString());
            fnameTxt.setText(moi.getThaiName().getFirstName());
            lnameTxt.setText(moi.getThaiName().getLastName());
            birthTxt.setText(moi.getFormattedBod());
            sexTxt.setText(moi.getSexDesc());
            //System.out.println(moi.getSexDesc());
            addressTxt.setText(moi.getAddress());

            issueTxt.setText(moi.getFormattedDateOfIssue());
            experTxt.setText(moi.getFormattedDateOfExpiry());
            miniID.setText(moi.getPid());
            card.disconnect(true);
        } catch (CardException ex) {
            JOptionPane.showMessageDialog(rootPane, "กรุณาใสสมาร์ทการ์ดของคุณ");
        }
    }//GEN-LAST:event_deviceComboMouseClicked

    private void deviceComboMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deviceComboMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_deviceComboMouseEntered

    private void deviceComboMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deviceComboMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_deviceComboMousePressed

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
            java.util.logging.Logger.getLogger(tscmForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tscmForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tscmForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tscmForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new tscmForm().setVisible(true);
                } catch (CardException ex) {
                    Logger.getLogger(tscmForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(tscmForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressTxt;
    private javax.swing.JLabel birthTxt;
    private javax.swing.JComboBox<String> deviceCombo;
    private javax.swing.JLabel experTxt;
    private javax.swing.JLabel fnameTxt;
    private javax.swing.JLabel idTxt;
    private javax.swing.JLabel issueTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lnameTxt;
    private javax.swing.JLabel miniID;
    private javax.swing.JLabel nameTxt;
    private javax.swing.JLabel picTxt;
    private javax.swing.JLabel sexTxt;
    // End of variables declaration//GEN-END:variables
}
