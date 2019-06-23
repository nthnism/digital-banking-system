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
    private Account account;
    
    public CreateTransaction(Account a) {
        this.LOGIC = Logic.getInstance();
        this.account = a;
        this.setTitle("Withdraw money");
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeadline = new javax.swing.JLabel();
        txfTransactionID = new javax.swing.JTextField();
        lblTransactionID = new javax.swing.JLabel();
        lblAmount = new javax.swing.JLabel();
        txfAmount = new javax.swing.JTextField();
        btnWithdraw = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblHeadline.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblHeadline.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeadline.setText("Withdraw money");

        txfTransactionID.setEnabled(false);
        txfTransactionID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfTransactionIDActionPerformed(evt);
            }
        });

        lblTransactionID.setText("Transaction-ID");

        lblAmount.setText("Amount to withdraw");

        btnWithdraw.setText("Withdraw");
        btnWithdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWithdrawActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHeadline, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblAmount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(lblTransactionID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnWithdraw, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txfTransactionID)
                            .addComponent(txfAmount))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeadline)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTransactionID)
                    .addComponent(txfTransactionID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAmount)
                    .addComponent(txfAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnWithdraw)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfTransactionIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfTransactionIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfTransactionIDActionPerformed

    private void btnWithdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWithdrawActionPerformed
        String sum = txfAmount.getText();
        try {
            LOGIC.validateNumber(sum, "amount");
            LOGIC.createTransaction(this.account, Double.parseDouble(sum), "Withdrawal", "Withdrawal at our bank");
            String confirmation = "The withdrawal was successful\nNew balance: " + account.getBalance();
            JOptionPane.showMessageDialog(null, confirmation , "Success", JOptionPane.PLAIN_MESSAGE);
            this.LOGIC.setEditable(true);
            this.dispose();
            
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE); 
        }
    }//GEN-LAST:event_btnWithdrawActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnWithdraw;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JLabel lblTransactionID;
    private javax.swing.JTextField txfAmount;
    private javax.swing.JTextField txfTransactionID;
    // End of variables declaration//GEN-END:variables
}
