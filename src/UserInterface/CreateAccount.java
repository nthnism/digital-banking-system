package UserInterface;

import LogicAndClasses.Customer;
import LogicAndClasses.Logic;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan Laabs
 */

public class CreateAccount extends javax.swing.JFrame {

    private final Logic LOGIC;
    private Customer customer;
    
    public CreateAccount(Customer c) {
        this.LOGIC = Logic.getInstance();
        this.setTitle("Create a new account");
        initComponents();
        txfCustomerID.setText(LOGIC.showNextAccountId());
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                onExit();
            }
        });
    }
    
    public void onExit() {
        this.LOGIC.setEditable(true);
        this.dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeadline = new javax.swing.JLabel();
        txfCustomerID = new javax.swing.JTextField();
        lblAccountID = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblHeadline.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblHeadline.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeadline.setText("Create a new account");

        txfCustomerID.setEnabled(false);
        txfCustomerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCustomerIDActionPerformed(evt);
            }
        });

        lblAccountID.setText("Next Account-ID");

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHeadline, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAccountID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txfCustomerID))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeadline)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAccountID)
                    .addComponent(txfCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 296, Short.MAX_VALUE)
                .addComponent(btnCreate)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        try {
            //LOGIC.createAccount( accountType, owner, initialDeposit)
            JOptionPane.showMessageDialog(null, "The account was created", "Success", JOptionPane.PLAIN_MESSAGE);
            this.LOGIC.setEditable(true);
            this.dispose();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE); 
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void txfCustomerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCustomerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCustomerIDActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JLabel lblAccountID;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JTextField txfCustomerID;
    // End of variables declaration//GEN-END:variables
}
