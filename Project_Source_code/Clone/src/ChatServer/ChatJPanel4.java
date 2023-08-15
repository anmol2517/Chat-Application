package ChatServer;

import java.net.*;
import javax.swing.*;

public class ChatJPanel4 extends javax.swing.JPanel {

    String me;
    String username;
    DatagramSocket ds;

    public ChatJPanel4() {
        initComponents();
    }

    public ChatJPanel4(String me, String username, DatagramSocket ds) {
        this.me = me;
        this.username = username;
        this.ds = ds;
        initComponents();
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setContentPane(new ChatJPanel4());
        f.setBounds(10, 10, 430, 330);
        f.setVisible(true);
    }

    @SuppressWarnings("unchecked")


    //  ---  <editor-fold defaultstate="collapsed" desc="Generated Code">
    //  ---  GEN-BEGIN:initComponents


    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(163, 165, 173));
        setLayout(null);

        jButton1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(320, 250, 90, 31);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 400, 230);
        add(jTextField1);
        jTextField1.setBounds(10, 250, 300, 30);
    }

    //  ---  </editor-fold>//GEN-END:initComponents

    public void showMessage(String str) {
        jTextArea1.append("\n" + username + ":" + str);
        jTextArea1.setCaretPosition(jTextArea1.getText().length());
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String ss = "PERSONAL:" + me + ":" + username + ":" + jTextField1.getText();
            byte b[] = ss.getBytes();
            InetAddress ia = InetAddress.getByName(MainConstants.SERVER_IP);
            DatagramPacket dp = new DatagramPacket(b, b.length, ia, MainConstants.COMMUNICATION_PORT);
            ds.send(dp);
            jTextArea1.append("\n" + me + ":" + jTextField1.getText());
            jTextArea1.setCaretPosition(jTextArea1.getText().length());
            jTextField1.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unable to List to Port");
        }
    }


    //  ---  GEN-LAST:event_jButton1ActionPerformed
    //  ---  Variables declaration - do not modify//GEN-BEGIN:variables


    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;


    //  ---  End of variables declaration//GEN-END:variables
}

