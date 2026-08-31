// Define the package that this class belongs to
package view;

// Import the required classes
import classes.PaymentManager;
import classes.Payment;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import swing.scrollbar.ScrollBarCustom;
import java.awt.Desktop;
import static java.awt.Frame.ICONIFIED;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

public class PaymentScreen extends javax.swing.JFrame {

    // A static variable to store the Expense selected from the table.
    public static Payment PaymentSelected;
    private boolean reportGenerated;
    private int currentMonth = -1;

    // Constructor for the ExpenseScreen class.
    public PaymentScreen() {
        this.reportGenerated = false;
        initComponents();

        // Initialize the ExpenseManager and add data to the table.
        PaymentManager pm = new PaymentManager();
        pm.addDataToTable((DefaultTableModel) tblPayments.getModel());
    

        // Set up the appearance of the GUI components.
       // PanelBackground pb = new PanelBackground();
       // winButton.initEvent(this, pb);

        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        tblPayments.setShowGrid(true);
        tblPayments.setSelectionBackground(Color.decode("#2AC2EC"));

      
           // Start the date check thread
        startDateCheckThread();
    }

    private void startDateCheckThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Calendar now = Calendar.getInstance();
                    int dayOfMonth = now.get(Calendar.DAY_OF_MONTH);
                    int month = now.get(Calendar.MONTH);
                    
                    // Check if today is the 1st of the month
                    if (dayOfMonth == 1 && month != currentMonth) {
                        // Call the method to generate the report and delete old data
                        generateMonthlyPaymentsReportAndDelete();
                        
                        // Update the flag and the current month
                        reportGenerated = true;
                        currentMonth = month;
                        
                        // Sleep for a full day to avoid multiple calls in the same day
                        try {
                            Thread.sleep(24 * 60 * 60 * 1000); // 24 hours
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    
                    // Reset the flag on any other day
                    if (dayOfMonth != 1) {
                        reportGenerated = false;
                    }
                    
                    // Sleep for an hour before checking again
                    try {
                        Thread.sleep(60 * 60 * 1000); // 1 hour
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    

    private void generateMonthlyPaymentsReportAndDelete() {
        // Implement the method to generate the monthly payments report and delete old data
        PaymentManager pm = new PaymentManager();
        try {
            pm.generateMonthlyPaymentsReportAndDelete();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PaymentScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panMain = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPayments = new javax.swing.JTable();
        lblHeading = new javax.swing.JLabel();
        btnBack = new swing.CustomButtonGradient();
        btnAddPayment = new swing.CustomButtonGradient();
        btnDeletePayment = new swing.CustomButtonGradient();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        twitterbtn = new javax.swing.JButton();
        jLabel_inven1 = new javax.swing.JLabel();
        fbookbtn = new javax.swing.JButton();
        instagrambtn = new javax.swing.JButton();
        Mailbtn = new javax.swing.JButton();
        ytubebtn = new javax.swing.JButton();
        jLabel_inven2 = new javax.swing.JLabel();
        btnprinttab = new swing.CustomButtonGradient();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panMain.setBackground(new java.awt.Color(21, 25, 28));

        tblPayments.setBackground(new java.awt.Color(24, 25, 26));
        tblPayments.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        tblPayments.setForeground(new java.awt.Color(169, 224, 49));
        tblPayments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "#", "TennantID", "amount", "invoice", "Date paid"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPayments.setGridColor(new java.awt.Color(0, 255, 102));
        tblPayments.setRowHeight(25);
        tblPayments.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblPayments);
        if (tblPayments.getColumnModel().getColumnCount() > 0) {
            tblPayments.getColumnModel().getColumn(0).setMinWidth(40);
            tblPayments.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblPayments.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        lblHeading.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        lblHeading.setForeground(new java.awt.Color(169, 224, 49));
        lblHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeading.setText("Payments TABLE");

        btnBack.setForeground(new java.awt.Color(0, 0, 0));
        btnBack.setText("Back");
        btnBack.setColor1(new java.awt.Color(15, 214, 79));
        btnBack.setColor2(new java.awt.Color(248, 239, 66));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnAddPayment.setForeground(new java.awt.Color(0, 0, 0));
        btnAddPayment.setText("Add Payment");
        btnAddPayment.setColor1(new java.awt.Color(169, 224, 49));
        btnAddPayment.setColor2(new java.awt.Color(169, 224, 49));
        btnAddPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPayment(evt);
            }
        });

        btnDeletePayment.setForeground(new java.awt.Color(0, 0, 0));
        btnDeletePayment.setText("Delete Payment");
        btnDeletePayment.setColor1(new java.awt.Color(169, 224, 49));
        btnDeletePayment.setColor2(new java.awt.Color(169, 224, 49));
        btnDeletePayment.setMaximumSize(new java.awt.Dimension(100, 36));
        btnDeletePayment.setMinimumSize(new java.awt.Dimension(100, 36));
        btnDeletePayment.setPreferredSize(new java.awt.Dimension(100, 36));
        btnDeletePayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePaymentActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Cancel_32px.png"))); // NOI18N
        jButton10.setToolTipText("Close");
        jButton10.setBorder(null);
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.setRequestFocusEnabled(false);
        jButton10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Cancel_30px_3.png"))); // NOI18N
        jButton10.setVerifyInputWhenFocusTarget(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Minus_32px_1.png"))); // NOI18N
        jButton11.setToolTipText("Minimize");
        jButton11.setBorder(null);
        jButton11.setBorderPainted(false);
        jButton11.setContentAreaFilled(false);
        jButton11.setFocusPainted(false);
        jButton11.setRequestFocusEnabled(false);
        jButton11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Minus_30px_3.png"))); // NOI18N
        jButton11.setVerifyInputWhenFocusTarget(false);
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
        });

        twitterbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Twitter_32px.png"))); // NOI18N
        twitterbtn.setToolTipText("Twitter");
        twitterbtn.setBorder(null);
        twitterbtn.setBorderPainted(false);
        twitterbtn.setContentAreaFilled(false);
        twitterbtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Twitter_32px_2.png"))); // NOI18N
        twitterbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twitterbtnActionPerformed(evt);
            }
        });

        jLabel_inven1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel_inven1.setForeground(new java.awt.Color(169, 224, 49));
        jLabel_inven1.setText("Connect with us on     ");

        fbookbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Facebook_32px_2.png"))); // NOI18N
        fbookbtn.setToolTipText("Facebook");
        fbookbtn.setBorder(null);
        fbookbtn.setBorderPainted(false);
        fbookbtn.setContentAreaFilled(false);
        fbookbtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Facebook_32px_7.png"))); // NOI18N
        fbookbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fbookbtnActionPerformed(evt);
            }
        });

        instagrambtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Instagram_32px.png"))); // NOI18N
        instagrambtn.setToolTipText("Instagram");
        instagrambtn.setBorder(null);
        instagrambtn.setBorderPainted(false);
        instagrambtn.setContentAreaFilled(false);
        instagrambtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Instagram_32px_3.png"))); // NOI18N
        instagrambtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instagrambtnActionPerformed(evt);
            }
        });

        Mailbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Secured_Letter_32px.png"))); // NOI18N
        Mailbtn.setToolTipText("Email");
        Mailbtn.setBorder(null);
        Mailbtn.setBorderPainted(false);
        Mailbtn.setContentAreaFilled(false);
        Mailbtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Secured_Letter_32px_2.png"))); // NOI18N
        Mailbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MailbtnActionPerformed(evt);
            }
        });

        ytubebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_YouTube_32px.png"))); // NOI18N
        ytubebtn.setToolTipText("YouTube");
        ytubebtn.setBorder(null);
        ytubebtn.setBorderPainted(false);
        ytubebtn.setContentAreaFilled(false);
        ytubebtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_YouTube_32px_1.png"))); // NOI18N
        ytubebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ytubebtnActionPerformed(evt);
            }
        });

        jLabel_inven2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel_inven2.setForeground(new java.awt.Color(169, 224, 49));
        jLabel_inven2.setText("support         Help");

        btnprinttab.setForeground(new java.awt.Color(0, 0, 0));
        btnprinttab.setText("print table");
        btnprinttab.setColor1(new java.awt.Color(169, 224, 49));
        btnprinttab.setColor2(new java.awt.Color(169, 224, 49));
        btnprinttab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprinttabActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panMainLayout = new javax.swing.GroupLayout(panMain);
        panMain.setLayout(panMainLayout);
        panMainLayout.setHorizontalGroup(
            panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panMainLayout.createSequentialGroup()
                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panMainLayout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panMainLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(panMainLayout.createSequentialGroup()
                                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panMainLayout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panMainLayout.createSequentialGroup()
                                                .addComponent(twitterbtn)
                                                .addGap(6, 6, 6)
                                                .addComponent(fbookbtn)
                                                .addGap(6, 6, 6)
                                                .addComponent(instagrambtn))
                                            .addComponent(jLabel_inven1))
                                        .addGap(128, 128, 128)
                                        .addComponent(lblHeading)
                                        .addGap(115, 115, 115)
                                        .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(panMainLayout.createSequentialGroup()
                                                .addComponent(Mailbtn)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(ytubebtn))
                                            .addComponent(jLabel_inven2)))
                                    .addGroup(panMainLayout.createSequentialGroup()
                                        .addGap(170, 170, 170)
                                        .addComponent(btnAddPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDeletePayment, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnprinttab, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 88, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panMainLayout.setVerticalGroup(
            panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panMainLayout.createSequentialGroup()
                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panMainLayout.createSequentialGroup()
                                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panMainLayout.createSequentialGroup()
                                            .addGap(1, 1, 1)
                                            .addComponent(fbookbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(twitterbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(instagrambtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_inven1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panMainLayout.createSequentialGroup()
                                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ytubebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Mailbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_inven2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnprinttab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeletePayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // Open the HomeScreen and close the current ExpenseScreen.
       // new HomeScreen().setVisible(true);
            new HomeScreen().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDeletePaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePaymentActionPerformed
        int rowSelected = tblPayments.getSelectedRow(); // Get the row number of the selected owner from the table
        if (rowSelected == -1) { // Check if no row is selected
            JOptionPane.showMessageDialog(null, "Please select a Payment to delete"); // Show error message
        } else {
            int confirmation = JOptionPane.showConfirmDialog(PaymentScreen.this, "Are you sure you want to delete this Payment?", "Edit Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                int paymentID = Integer.parseInt(tblPayments.getValueAt(rowSelected, 0).toString()); // Get the ID of the selected  from the first column of the table
                PaymentManager pm = new PaymentManager(); // Create an instance of the OwnerManager class
                pm.deletePayment(paymentID); // Delete the selected owner from the database
                pm.addSearchedDataToTable((DefaultTableModel) tblPayments.getModel(), ""); // Refresh the JTable by calling the addDataToTable() method of OwnerManager class
                JOptionPane.showMessageDialog(null, "Payment has been deleted"); // Show success message
            }
        }
    }//GEN-LAST:event_btnDeletePaymentActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_jButton11MouseClicked

    private void twitterbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twitterbtnActionPerformed
        try {
            // Specify the URL
            String url = "https://x.com/";
            // Use Desktop class to open the URL
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_twitterbtnActionPerformed

    private void fbookbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fbookbtnActionPerformed
        try {
            // Specify the URL
            String url = "https://www.facebook.com/liron.mindel.3";
            // Use Desktop class to open the URL
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_fbookbtnActionPerformed

    private void instagrambtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instagrambtnActionPerformed
        try {
            // Specify the URL
            String url = "https://instagram.com/";
            // Use Desktop class to open the URL
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_instagrambtnActionPerformed

    private void MailbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MailbtnActionPerformed

        Desktop desktop;
        if (Desktop.isDesktopSupported()
            && (desktop = Desktop.getDesktop()).isSupported(Desktop.Action.MAIL)) {
            try {
                URI mailto = new URI("mailto:your-email@example.com?subject=Apartment%20rental%20manemgment%20support:");
                desktop.mail(mailto);
            } catch (URISyntaxException ex) {
                Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // TODO fallback to some Runtime.exec(..) voodoo?
            throw new RuntimeException("desktop doesn't support mailto; mail is dead anyway ;)");
        }
    }//GEN-LAST:event_MailbtnActionPerformed

    private void ytubebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ytubebtnActionPerformed
        try {
            String url = "https://vimeo.com/994576038#t=6m8s.";
            // Use Desktop class to open the URL
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_ytubebtnActionPerformed

    private void btnprinttabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprinttabActionPerformed

  PrinterJob printerJob = PrinterJob.getPrinterJob();
    printerJob.setPrintable(tblPayments.getPrintable(JTable.PrintMode.FIT_WIDTH, null, null));

    // Create a PageFormat with landscape orientation and A4 paper size
    PageFormat pageFormat = printerJob.defaultPage();
    Paper paper = pageFormat.getPaper();
    
    // A4 paper dimensions in inches
    double width = 8.27 * 72; // A4 width in points (1 inch = 72 points)
    double height = 11.69 * 72; // A4 height in points
    
    // Set the paper size
    paper.setSize(width, height);
    paper.setImageableArea(0, 0, width, height);
    
    // Apply paper to PageFormat and set orientation to landscape
    pageFormat.setPaper(paper);
    pageFormat.setOrientation(PageFormat.LANDSCAPE);
    
    printerJob.setPrintable(tblPayments.getPrintable(JTable.PrintMode.FIT_WIDTH, null, null), pageFormat);

    boolean doPrint = printerJob.printDialog();
    if (doPrint) {
        try {
            printerJob.print();
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }
    }//GEN-LAST:event_btnprinttabActionPerformed

    private void AddPayment(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPayment
        // TODO add your handling code here:
            // Open the AddExpenseScreen and close the current ExpenseScreen.
        new AddPaymentScreen().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AddPayment

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
            java.util.logging.Logger.getLogger(PaymentScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddExpenseScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Mailbtn;
    private swing.CustomButtonGradient btnAddPayment;
    private swing.CustomButtonGradient btnBack;
    private swing.CustomButtonGradient btnDeletePayment;
    private swing.CustomButtonGradient btnprinttab;
    private javax.swing.JButton fbookbtn;
    private javax.swing.JButton instagrambtn;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JLabel jLabel_inven1;
    private javax.swing.JLabel jLabel_inven2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JPanel panMain;
    private javax.swing.JTable tblPayments;
    private javax.swing.JButton twitterbtn;
    private javax.swing.JButton ytubebtn;
    // End of variables declaration//GEN-END:variables
}
