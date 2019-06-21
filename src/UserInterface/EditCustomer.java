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

public class EditCustomer extends javax.swing.JFrame {

    private final Logic LOGIC;
    private Customer customer;
    
    public EditCustomer(Customer customer) {
        this.LOGIC = Logic.getInstance();
        this.customer = customer;
        this.setTitle("Edit this customer");
        initComponents();
        cbxTitle.addItem("Mr.");
        cbxTitle.addItem("Mrs.");
        setFields();
        
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
        txfCustomerID.setText(Integer.toString(customer.getCUSTOMER_ID()));
        txfCustomerSince.setText(customer.getCREATED_AT().toString());
        cbxTitle.setSelectedIndex(customer.getTitle().equals("Mr.") ? 0 : 1);
        txfFirstName.setText(customer.getFirstName());
        txfLastName.setText(customer.getLastName());
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeadline = new javax.swing.JLabel();
        txfCustomerID = new javax.swing.JTextField();
        lblCustomerID = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        txfFirstName = new javax.swing.JTextField();
        lblLastName = new javax.swing.JLabel();
        txfLastName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbxTitle = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        lblCustomerSince = new javax.swing.JLabel();
        txfCustomerSince = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblHeadline.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblHeadline.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeadline.setText("Edit this customer");

        txfCustomerID.setEnabled(false);
        txfCustomerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCustomerIDActionPerformed(evt);
            }
        });

        lblCustomerID.setText("Customer-ID");

        lblFirstName.setText("First name");

        lblLastName.setText("Last name");

        jLabel2.setText("Title");

        btnSave.setText("Save changes");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblCustomerSince.setText("Customer since");

        txfCustomerSince.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHeadline, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCustomerSince))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txfCustomerSince, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(txfCustomerID)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFirstName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txfFirstName)
                            .addComponent(txfLastName)
                            .addComponent(cbxTitle, 0, 100, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeadline)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerID)
                    .addComponent(txfCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerSince)
                    .addComponent(txfCustomerSince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFirstName)
                    .addComponent(txfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastName)
                    .addComponent(txfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String firstName = txfFirstName.getText();
        String lastName = txfLastName.getText();
        String title = cbxTitle.getItemAt(cbxTitle.getSelectedIndex());
        try {
            customer.setTitle(title);
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            JOptionPane.showMessageDialog(null, "The changes have been saved", "Success", JOptionPane.PLAIN_MESSAGE);
            this.LOGIC.setEditable(true);
            this.dispose();
        }
        catch(Exception e) {
            setFields();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE); 
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txfCustomerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCustomerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCustomerIDActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbxTitle;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblCustomerID;
    private javax.swing.JLabel lblCustomerSince;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JTextField txfCustomerID;
    private javax.swing.JTextField txfCustomerSince;
    private javax.swing.JTextField txfFirstName;
    private javax.swing.JTextField txfLastName;
    // End of variables declaration//GEN-END:variables
}
