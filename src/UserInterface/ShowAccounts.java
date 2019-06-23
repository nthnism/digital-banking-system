package UserInterface;

import LogicAndClasses.Account;
import LogicAndClasses.Customer;
import LogicAndClasses.Logic;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan Laabs
 */

public class ShowAccounts extends javax.swing.JFrame {

    private final Logic LOGIC;
    private Customer customer;
    private Account account;
    private ArrayList<Account> accountList;
    
    public ShowAccounts(Customer c) {
        this.LOGIC = Logic.getInstance();
        this.customer = c;
        this.accountList = this.customer.getACCOUNTS();
        this.setTitle("Accounts Overview");
        initComponents();
        lblHeadline.setText("Showing accounts for " + this.customer.getFullName());
        setAccounts();
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                onExit();
            }
        });
    }
    
    public void onExit() {
        this.dispose();
    }
    
    public void setAccounts() {
        for (Account a : accountList) {
            cbxAccounts.addItem(a.toString());
        }
    }
    
    public void setFields() {
        txfID.setText(Integer.toString(this.account.getACCOUNT_ID()));
        txfCreatedAt.setText(this.account.getCREATED_AT().toString());
        txfAccountType.setText(this.account.getAccountType());
        txfBalance.setText(Double.toString(this.account.getBalance()));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeadline = new javax.swing.JLabel();
        cbxAccounts = new javax.swing.JComboBox<>();
        btnEdit = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnTransaction = new javax.swing.JButton();
        btnWithdraw = new javax.swing.JButton();
        btnDeposit = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        txfID = new javax.swing.JTextField();
        lblAccountType = new javax.swing.JLabel();
        txfAccountType = new javax.swing.JTextField();
        lblBalance = new javax.swing.JLabel();
        txfBalance = new javax.swing.JTextField();
        lblCreatedAt = new javax.swing.JLabel();
        txfCreatedAt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblHeadline.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblHeadline.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeadline.setText("Showing accounts for");

        cbxAccounts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAccountsActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnPrint.setText("Print report");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnTransaction.setText("Make a transaction");
        btnTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransactionActionPerformed(evt);
            }
        });

        btnWithdraw.setText("Withdraw");
        btnWithdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWithdrawActionPerformed(evt);
            }
        });

        btnDeposit.setText("Deposit");
        btnDeposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositActionPerformed(evt);
            }
        });

        lblID.setText("Account-ID ");

        txfID.setEnabled(false);

        lblAccountType.setText("Type of account");

        txfAccountType.setEnabled(false);

        lblBalance.setText("Balance");

        txfBalance.setEnabled(false);

        lblCreatedAt.setText("Opened on");

        txfCreatedAt.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxAccounts, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHeadline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAccountType, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(lblBalance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCreatedAt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txfID)
                            .addComponent(txfAccountType)
                            .addComponent(txfCreatedAt, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txfBalance))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTransaction, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(btnDeposit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnWithdraw, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeadline)
                .addGap(18, 18, 18)
                .addComponent(cbxAccounts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEdit)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnPrint)
                                    .addComponent(lblCreatedAt)
                                    .addComponent(txfCreatedAt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnTransaction))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblID)
                                .addComponent(txfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnWithdraw))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAccountType)
                            .addComponent(txfAccountType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBalance)
                            .addComponent(txfBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(btnDeposit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxAccountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAccountsActionPerformed
        this.account = this.accountList.get(cbxAccounts.getSelectedIndex());
        setFields();
    }//GEN-LAST:event_cbxAccountsActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (LOGIC.isEditable()) {
            new EditAccount(this.account).setVisible(true);
            LOGIC.setEditable(false);
            return;
        }
        JOptionPane.showMessageDialog(null, "Please close other editing dialogs first", "Error", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositActionPerformed
        if (LOGIC.isEditable()) {
            new CreateDeposit(this.account).setVisible(true);
            LOGIC.setEditable(false);
            return;
        }
        JOptionPane.showMessageDialog(null, "Please close other editing dialogs first", "Error", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnDepositActionPerformed

    private void btnWithdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWithdrawActionPerformed
        if (LOGIC.isEditable()) {
            new CreateWithdrawal(this.account).setVisible(true);
            LOGIC.setEditable(false);
            return;
        }
        JOptionPane.showMessageDialog(null, "Please close other editing dialogs first", "Error", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnWithdrawActionPerformed

    private void btnTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransactionActionPerformed
        if (LOGIC.isEditable()) {
            new CreateTransaction(this.account).setVisible(true);
            LOGIC.setEditable(false);
            return;
        }
        JOptionPane.showMessageDialog(null, "Please close other editing dialogs first", "Error", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnTransactionActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        if (LOGIC.isEditable()) {
            new ShowTransactions(this.account).setVisible(true);
            LOGIC.setEditable(false);
            return;
        }
        JOptionPane.showMessageDialog(null, "Please close other editing dialogs first", "Error", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnPrintActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeposit;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnTransaction;
    private javax.swing.JButton btnWithdraw;
    private javax.swing.JComboBox<String> cbxAccounts;
    private javax.swing.JLabel lblAccountType;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblCreatedAt;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JLabel lblID;
    private javax.swing.JTextField txfAccountType;
    private javax.swing.JTextField txfBalance;
    private javax.swing.JTextField txfCreatedAt;
    private javax.swing.JTextField txfID;
    // End of variables declaration//GEN-END:variables
}
