package ChatClient;

import javax.swing.*;
import java.net.*;

public class ChatJPanel1 extends javax.swing.JPanel {

    static JFrame f = null;

    public ChatJPanel1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(163, 165, 173));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 24), new java.awt.Color(0, 51, 255))); // NOI18N
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18));
        jLabel1.setText("User Name");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(60, 60, 120, 20);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18));
        jLabel2.setText("Password");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(60, 90, 120, 22);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(190, 60, 170, 20);
        jPanel1.add(jPasswordField1);
        jPasswordField1.setBounds(190, 90, 170, 20);

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jCheckBox1.setText("New User");
        jPanel1.add(jCheckBox1);
        jCheckBox1.setBounds(230, 160, 110, 40);

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("Connect");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(100, 160, 100, 30);

        add(jPanel1);
        jPanel1.setBounds(10, 30, 420, 250);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String[] args) {
        f = new JFrame("Client Login");
        f.setContentPane(new ChatJPanel1());
        f.setBounds(10, 10, 450, 325);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            DatagramSocket ds = new DatagramSocket();
            String a = new String();
            if (jCheckBox1.isSelected()) {
                a = "ON";
            } else {
                a = "OFF";
            }
            String str = jTextField1.getText() + "," + jPasswordField1.getText() + "," + a;
            byte arr[] = str.getBytes();
            InetAddress ia = InetAddress.getByName(MainConstants.SERVER_IP);
            DatagramPacket dp = new DatagramPacket(arr, arr.length, ia, MainConstants.CONNECTION_PORT);
            ds.send(dp);        // TODO add your handling code here:
            byte brr[] = new byte[100];
            DatagramPacket dp1 = new DatagramPacket(brr, brr.length);
            ds.receive(dp1);
            String str1 = new String(dp1.getData(), 0, dp1.getLength());
            str1 = str1.trim();
            if (str1.equals("CONNECTED")) {
                JOptionPane.showMessageDialog(this, "You Are Connected");
                JFrame f1 = new JFrame("Chatting Application!! User : " + jTextField1.getText());
                f1.setContentPane(new ChatJPanel3(jTextField1.getText(), ds));
                f1.setBounds(10, 10, 580, 480);
                f1.setVisible(true);
                f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(false);
            } else if (10 < 10) {
                JOptionPane.showMessageDialog(this, "User Already Exists Or Invalid Password");
                System.exit(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unable to List to Port");
        }

    }

    //  ---  GEN-LAST:event_jButton1ActionPerformed

    //  ---  Variables declaration - do not modify//GEN-BEGIN:variables


    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;


    //  ---  End of variables declaration//GEN-END:variables
}


