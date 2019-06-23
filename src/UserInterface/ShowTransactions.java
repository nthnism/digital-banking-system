package UserInterface;

import LogicAndClasses.Account;
import LogicAndClasses.Customer;
import LogicAndClasses.Logic;
import LogicAndClasses.Transaction;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan Laabs
 */

public class ShowTransactions extends javax.swing.JFrame {

    private final Logic LOGIC;
    private Account account;
    private ArrayList<Transaction> transactionsList;
    
    public ShowTransactions(Account a) {
        this.LOGIC = Logic.getInstance();
        this.account = a;
        this.transactionsList = a.getTransactions();
        this.setTitle("Accounts Overview");
        initComponents();
        txaReport.setTabSize(8);
        setTransactions();
        lblHeadline.setText("Showing transactions for account no." + a.getACCOUNT_ID());
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                onExit();
            }
        });
    }
    
    public void onExit() {
        LOGIC.setEditable(true);
        this.dispose();
    }
    
    public void setTransactions() {
        int i = 1;
        txaReport.setText("no\tunique-id\ttype\tsum\treason\t\tbalance after transaction");
        txaReport.append("\n\n");
        for (Transaction t : transactionsList) {
            txaReport.append(Integer.toString(i) + "\t" + t.toString() + account.getBalanceHistory().get(i-1) + "\n");
            i++;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeadline = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaReport = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblHeadline.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblHeadline.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeadline.setText("Showing transactions for");

        txaReport.setColumns(20);
        txaReport.setRows(5);
        jScrollPane1.setViewportView(txaReport);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(lblHeadline, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeadline)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JTextArea txaReport;
    // End of variables declaration//GEN-END:variables
}
