package UserInterface;

import LogicAndClasses.Account;
import LogicAndClasses.Logic;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan Laabs
 */

public class CreateTransaction extends javax.swing.JFrame {

    private final Logic LOGIC;
    private Account originAcc;
    private Account targetAcc;
    
    public CreateTransaction(Account a) {
        this.LOGIC = Logic.getInstance();
        this.originAcc = a;
        this.setTitle("Make a transaction");
        initComponents();
        txfTransactionID.setText(LOGIC.getNextTransactionId());
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
    
    public void setFields() {
        btnTransfer.setEnabled(true);
        txftOwnerName.setText(this.targetAcc.getOwners().get(0).getFullName());
    }
    
    public void resetAllFields() {
        txfID.setText("");
        btnTransfer.setEnabled(false);
        txftOwnerName.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeadline = new javax.swing.JLabel();
        txfTransactionID = new javax.swing.JTextField();
        lblTransactionID = new javax.swing.JLabel();
        lblAmount = new javax.swing.JLabel();
        txfAmount = new javax.swing.JTextField();
        btnTransfer = new javax.swing.JButton();
        lblTargetAcc = new javax.swing.JLabel();
        lblOwnerName = new javax.swing.JLabel();
        txftOwnerName = new javax.swing.JTextField();
        txfID = new javax.swing.JTextField();
        btnCheck = new javax.swing.JButton();
        lblReason = new javax.swing.JLabel();
        txfReason = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblHeadline.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblHeadline.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeadline.setText("Make a transaction");

        txfTransactionID.setEnabled(false);
        txfTransactionID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfTransactionIDActionPerformed(evt);
            }
        });

        lblTransactionID.setText("Transaction-ID");

        lblAmount.setText("Amount to withdraw");

        btnTransfer.setText("Transfer");
        btnTransfer.setEnabled(false);
        btnTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferActionPerformed(evt);
            }
        });

        lblTargetAcc.setText("ID of receiving account");

        lblOwnerName.setText("Name of owner");

        txftOwnerName.setEnabled(false);

        btnCheck.setText("Check");
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });

        lblReason.setText("Reason");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblHeadline, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblAmount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(lblTransactionID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblReason, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txfAmount, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfTransactionID, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfReason, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTargetAcc, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(lblOwnerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfID)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txftOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHeadline)
                    .addComponent(btnCheck))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTransactionID)
                    .addComponent(txfTransactionID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTargetAcc)
                    .addComponent(txfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAmount)
                    .addComponent(txfAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOwnerName)
                    .addComponent(txftOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTransfer)
                    .addComponent(lblReason)
                    .addComponent(txfReason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfTransactionIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfTransactionIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfTransactionIDActionPerformed

    private void btnTransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferActionPerformed
        String sum = txfAmount.getText();
        try {
            LOGIC.validateNumber(sum, "amount");
            LOGIC.createTransaction(this.targetAcc, this.originAcc, Double.parseDouble(sum), "Transaction", txfReason.getText());
            String confirmation = "The transaction was successful\nNew balance: " + originAcc.getBalance();
            JOptionPane.showMessageDialog(null, confirmation , "Success", JOptionPane.PLAIN_MESSAGE);
            this.LOGIC.setEditable(true);
            this.dispose();
            
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE); 
        }
    }//GEN-LAST:event_btnTransferActionPerformed

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        String input = txfID.getText();
        try {
            LOGIC.validateNumber(input, "receiving ID");
            if (this.originAcc.getACCOUNT_ID() == Integer.parseInt(input)) {
                throw new Exception("You cannot transfer to this very account");
            }
            this.targetAcc = LOGIC.getAccountById(Integer.parseInt(input));
            setFields();
            
        }
        catch (Exception e) {
            this.targetAcc = null;
            resetAllFields();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnCheckActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnTransfer;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JLabel lblOwnerName;
    private javax.swing.JLabel lblReason;
    private javax.swing.JLabel lblTargetAcc;
    private javax.swing.JLabel lblTransactionID;
    private javax.swing.JTextField txfAmount;
    private javax.swing.JTextField txfID;
    private javax.swing.JTextField txfReason;
    private javax.swing.JTextField txfTransactionID;
    private javax.swing.JTextField txftOwnerName;
    // End of variables declaration//GEN-END:variables
}
