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
    private String accountType;
    
    public CreateAccount(Customer c) {
        this.LOGIC = Logic.getInstance();
        this.customer = c;
        this.setTitle("Create a new account");
        initComponents();
        txfCustomerID.setText(LOGIC.getNextAccountId());
        txfOwner.setText(this.customer.getFullName());
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
        lblOwner = new javax.swing.JLabel();
        txfOwner = new javax.swing.JTextField();
        lblAccountType = new javax.swing.JLabel();
        radioStandard = new javax.swing.JRadioButton();
        radioSavings = new javax.swing.JRadioButton();
        radioStudent = new javax.swing.JRadioButton();
        txfInitialSum = new javax.swing.JTextField();
        lblInitialSum = new javax.swing.JLabel();

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

        lblAccountID.setText("Account-ID");

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        lblOwner.setText("Initial owner");

        txfOwner.setEnabled(false);

        lblAccountType.setText("Select type of account");

        radioStandard.setText("Standard");
        radioStandard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioStandardActionPerformed(evt);
            }
        });

        radioSavings.setText("Savings");
        radioSavings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSavingsActionPerformed(evt);
            }
        });

        radioStudent.setText("Student");
        radioStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioStudentActionPerformed(evt);
            }
        });

        lblInitialSum.setText("Initial Deposit");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHeadline, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblAccountType, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(lblAccountID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblOwner, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInitialSum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txfInitialSum)
                            .addComponent(radioStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(radioSavings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txfCustomerID)
                            .addComponent(txfOwner)
                            .addComponent(radioStandard, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOwner)
                    .addComponent(txfOwner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAccountType)
                    .addComponent(radioStandard))
                .addGap(18, 18, 18)
                .addComponent(radioSavings)
                .addGap(18, 18, 18)
                .addComponent(radioStudent)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfInitialSum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInitialSum))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btnCreate)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        String initialDeposit = txfInitialSum.getText();
        try {
            LOGIC.validateNumber(initialDeposit, "initial deposit");
            LOGIC.createAccount(this.accountType, this.customer, Double.parseDouble(initialDeposit));
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

    private void radioStandardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioStandardActionPerformed
        this.accountType = "Standard";
        radioSavings.setSelected(false);
        radioStudent.setSelected(false);
    }//GEN-LAST:event_radioStandardActionPerformed

    private void radioSavingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSavingsActionPerformed
        this.accountType = "Savings";
        radioStandard.setSelected(false);
        radioStudent.setSelected(false);
    }//GEN-LAST:event_radioSavingsActionPerformed

    private void radioStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioStudentActionPerformed
        this.accountType = "Student";
        radioStandard.setSelected(false);
        radioSavings.setSelected(false);
    }//GEN-LAST:event_radioStudentActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JLabel lblAccountID;
    private javax.swing.JLabel lblAccountType;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JLabel lblInitialSum;
    private javax.swing.JLabel lblOwner;
    private javax.swing.JRadioButton radioSavings;
    private javax.swing.JRadioButton radioStandard;
    private javax.swing.JRadioButton radioStudent;
    private javax.swing.JTextField txfCustomerID;
    private javax.swing.JTextField txfInitialSum;
    private javax.swing.JTextField txfOwner;
    // End of variables declaration//GEN-END:variables
}
