// Package declaration for the view components of the application
package view;

// Importing necessary classes from various packages
import classes.Tenant;                       // Importing Tenant class from the classes package
import classes.TenantManager;                // Importing TenantManager class from the classes package
import filter.SearchOption;                  // Importing SearchOption class from the filter package
import filter.SearchOptionEvent;             // Importing SearchOptionEvent class from the filter package
import java.awt.Color;                       // Importing Color class from the java.awt package for setting colors
import java.awt.Desktop;                     // Importing Desktop class for desktop integration
import java.awt.event.ActionEvent;           // Importing ActionEvent class for handling action events
import java.awt.event.ActionListener;        // Importing ActionListener interface for receiving action events
import java.awt.print.PageFormat;            // Importing PageFormat class for page formatting
import java.awt.print.Paper;                 // Importing Paper class for paper size settings
import java.awt.print.PrinterException;      // Importing PrinterException class for handling printer exceptions
import java.awt.print.PrinterJob;            // Importing PrinterJob class for managing print jobs
import java.io.IOException;                  // Importing IOException class for handling input/output exceptions
import java.net.URI;                         // Importing URI class for handling URIs
import java.net.URISyntaxException;          // Importing URISyntaxException class for handling URI syntax exceptions
import java.time.LocalDate;                  // Importing LocalDate class for handling dates
import java.util.logging.Level;              // Importing Level class for logging levels
import java.util.logging.Logger;             // Importing Logger class for logging
import javax.swing.ImageIcon;                // Importing ImageIcon class for displaying images
import javax.swing.JOptionPane;              // Importing JOptionPane class for displaying dialog boxes
import javax.swing.JTable;                   // Importing JTable class for table components
import javax.swing.table.DefaultTableModel;  // Importing DefaultTableModel class for table models
import swing.scrollbar.ScrollBarCustom;      // Importing ScrollBarCustom class from the swing.scrollbar package for custom scrollbars

/**
 * TenantScreen class to manage the tenant interface in the application.
 * @author Liron
 */
public class TenantScreen extends javax.swing.JFrame {
    public static Tenant tenantSelected;

    /**
     * Creates new form TenantScreen
     */
    public TenantScreen() {
        initComponents();  // Initialize components
        
        // Initialize the TenantManager and add data to the table
        TenantManager tm = new TenantManager();
        tm.addDataToTable((DefaultTableModel) tblTenants.getModel());
        
        // Set custom scroll bar
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        
        // Set table properties
        tblTenants.setShowGrid(true);
        tblTenants.setSelectionBackground(Color.decode("#2AC2EC"));
        
        // Adding search options and setting the default option to "TenantID"
        textFieldSearchOption.addOption(new SearchOption("TenantID", new ImageIcon(getClass().getResource("/icon/user (2).png"))));
        textFieldSearchOption.addOption(new SearchOption("Firstname", new ImageIcon(getClass().getResource("/icon/4.png"))));
        textFieldSearchOption.addOption(new SearchOption("Surname", new ImageIcon(getClass().getResource("/icon/5.png"))));
        textFieldSearchOption.addOption(new SearchOption("DOB", new ImageIcon(getClass().getResource("/icon/1.png"))));
        textFieldSearchOption.addOption(new SearchOption("Email", new ImageIcon(getClass().getResource("/icon/email.png"))));
        textFieldSearchOption.setSelectedIndex(0);  // Set default search option
        
        // Adding sorting options to the combo box
        ComboBoxSort.addItem("None");
        ComboBoxSort.addItem("Youngest to Oldest");
        ComboBoxSort.addItem("Oldest to Youngest");
        ComboBoxSort.addItem("Firstname (A to Z)");
        ComboBoxSort.addItem("Firstname (Z to A)");
        ComboBoxSort.addItem("Surname (A to Z)");
        ComboBoxSort.addItem("Surname (Z to A)");

        // Adding action listener to sort the table based on the selected option
        ComboBoxSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = ComboBoxSort.getSelectedItem().toString();
                TenantManager tm = new TenantManager();
                tm.sortTable(tblTenants, selectedOption);
            }
        });

        // Adding event listener for the search option combo box to update hint text
        textFieldSearchOption.addEventOptionSelected(new SearchOptionEvent() {
            @Override
            public void optionSelected(SearchOption option, int index) {
                textFieldSearchOption.setHint(" Search by " + option.getName() + "...");
            }
        });
    
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnBack = new swing.CustomButtonGradient();
        twitterbtn = new javax.swing.JButton();
        fbookbtn = new javax.swing.JButton();
        instagrambtn = new javax.swing.JButton();
        jLabel_inven1 = new javax.swing.JLabel();
        lblHeading = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        ytubebtn = new javax.swing.JButton();
        Mailbtn = new javax.swing.JButton();
        jLabel_inven2 = new javax.swing.JLabel();
        textFieldSearchOption = new filter.TextFieldSearchOption();
        ComboBoxSort = new swing.Combobox();
        btnprinttab = new swing.CustomButtonGradient();
        btnAddTenant = new swing.CustomButtonGradient();
        btnDeleteTenant = new swing.CustomButtonGradient();
        btnEditTennant = new swing.CustomButtonGradient();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTenants = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1026, 573));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1026, 573));

        jPanel1.setBackground(new java.awt.Color(21, 25, 28));
        jPanel1.setMaximumSize(new java.awt.Dimension(1026, 573));
        jPanel1.setMinimumSize(new java.awt.Dimension(1026, 573));
        jPanel1.setPreferredSize(new java.awt.Dimension(1026, 573));

        btnBack.setForeground(new java.awt.Color(0, 0, 0));
        btnBack.setText("Back");
        btnBack.setColor1(new java.awt.Color(15, 214, 79));
        btnBack.setColor2(new java.awt.Color(248, 239, 66));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
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

        jLabel_inven1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel_inven1.setForeground(new java.awt.Color(169, 224, 49));
        jLabel_inven1.setText("Connect with us on     ");

        lblHeading.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        lblHeading.setForeground(new java.awt.Color(169, 224, 49));
        lblHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeading.setText("Tenant's TABLE");

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
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
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

        jLabel_inven2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel_inven2.setForeground(new java.awt.Color(169, 224, 49));
        jLabel_inven2.setText("support         Help");

        textFieldSearchOption.setBackground(new java.awt.Color(36, 37, 38));
        textFieldSearchOption.setForeground(new java.awt.Color(169, 224, 49));
        textFieldSearchOption.setColorOverlay1(new java.awt.Color(15, 214, 79));
        textFieldSearchOption.setColorOverlay2(new java.awt.Color(248, 239, 66));
        textFieldSearchOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldSearchOptionActionPerformed(evt);
            }
        });
        textFieldSearchOption.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldSearchOptionKeyReleased(evt);
            }
        });

        ComboBoxSort.setBackground(new java.awt.Color(36, 37, 38));
        ComboBoxSort.setForeground(new java.awt.Color(169, 224, 49));
        ComboBoxSort.setLabeText("Sort");

        btnprinttab.setForeground(new java.awt.Color(0, 0, 0));
        btnprinttab.setText("print table");
        btnprinttab.setColor1(new java.awt.Color(169, 224, 49));
        btnprinttab.setColor2(new java.awt.Color(169, 224, 49));
        btnprinttab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprinttabActionPerformed(evt);
            }
        });

        btnAddTenant.setForeground(new java.awt.Color(0, 0, 0));
        btnAddTenant.setText("Add Tenant");
        btnAddTenant.setColor1(new java.awt.Color(169, 224, 49));
        btnAddTenant.setColor2(new java.awt.Color(169, 224, 49));
        btnAddTenant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTenantActionPerformed(evt);
            }
        });

        btnDeleteTenant.setForeground(new java.awt.Color(0, 0, 0));
        btnDeleteTenant.setText("Delete Tenant");
        btnDeleteTenant.setColor1(new java.awt.Color(169, 224, 49));
        btnDeleteTenant.setColor2(new java.awt.Color(169, 224, 49));
        btnDeleteTenant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTenantActionPerformed(evt);
            }
        });

        btnEditTennant.setForeground(new java.awt.Color(0, 0, 0));
        btnEditTennant.setText("Edit Tenant");
        btnEditTennant.setColor1(new java.awt.Color(169, 224, 49));
        btnEditTennant.setColor2(new java.awt.Color(169, 224, 49));
        btnEditTennant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditTennantActionPerformed(evt);
            }
        });

        tblTenants.setBackground(new java.awt.Color(24, 25, 26));
        tblTenants.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        tblTenants.setForeground(new java.awt.Color(169, 224, 49));
        tblTenants.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "TenantID", "FirstName", "MiddleName", "Surname", "PropertyID", "LeaseStartDate", "DOB", "Email", "PhoneNumber"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTenants.setRowHeight(25);
        tblTenants.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblTenants);
        if (tblTenants.getColumnModel().getColumnCount() > 0) {
            tblTenants.getColumnModel().getColumn(0).setMinWidth(60);
            tblTenants.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblTenants.getColumnModel().getColumn(0).setMaxWidth(60);
            tblTenants.getColumnModel().getColumn(1).setMinWidth(70);
            tblTenants.getColumnModel().getColumn(1).setPreferredWidth(70);
            tblTenants.getColumnModel().getColumn(1).setMaxWidth(70);
            tblTenants.getColumnModel().getColumn(3).setMinWidth(70);
            tblTenants.getColumnModel().getColumn(3).setPreferredWidth(70);
            tblTenants.getColumnModel().getColumn(3).setMaxWidth(70);
            tblTenants.getColumnModel().getColumn(4).setMinWidth(60);
            tblTenants.getColumnModel().getColumn(4).setPreferredWidth(60);
            tblTenants.getColumnModel().getColumn(4).setMaxWidth(60);
            tblTenants.getColumnModel().getColumn(5).setMinWidth(80);
            tblTenants.getColumnModel().getColumn(5).setPreferredWidth(80);
            tblTenants.getColumnModel().getColumn(5).setMaxWidth(80);
            tblTenants.getColumnModel().getColumn(6).setMinWidth(80);
            tblTenants.getColumnModel().getColumn(6).setPreferredWidth(80);
            tblTenants.getColumnModel().getColumn(6).setMaxWidth(80);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textFieldSearchOption, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ComboBoxSort, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(twitterbtn)
                                    .addGap(6, 6, 6)
                                    .addComponent(fbookbtn)
                                    .addGap(6, 6, 6)
                                    .addComponent(instagrambtn))
                                .addComponent(jLabel_inven1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(151, 151, 151)))
                        .addGap(128, 128, 128)
                        .addComponent(lblHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Mailbtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ytubebtn))
                            .addComponent(jLabel_inven2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(98, 98, 98))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAddTenant, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditTennant, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteTenant, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnprinttab, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(1, 1, 1)
                                            .addComponent(fbookbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(twitterbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(instagrambtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_inven1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lblHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ytubebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Mailbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_inven2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldSearchOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnprinttab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteTenant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditTennant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddTenant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
                   
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // Open the HomeScreen and close the current TenantScreen.
       // new HomeScreen().setVisible(true);
            new HomeScreen().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_jButton11MouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

    }//GEN-LAST:event_jButton11ActionPerformed

    private void ytubebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ytubebtnActionPerformed
        try {
            String url = "https://vimeo.com/994576038#t=4m4s.";
            // Use Desktop class to open the URL
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_ytubebtnActionPerformed

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

    private void textFieldSearchOptionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldSearchOptionKeyReleased
        // Check if the search option is selected (if the user has chosen a specific search filter).
        if (textFieldSearchOption.isSelected()) {
            // Get the index of the selected search option from the textFieldSearchOption.
            int option = textFieldSearchOption.getSelectedIndex();

            // Get the text entered by the user and add "%" wildcards at the beginning and end for a partial match.
            String text = "%" + textFieldSearchOption.getText().trim() + "%";

            // Create an instance of the ClientManager to manage client-related operations.
            TenantManager tm = new TenantManager();

            // Search for clients based on the selected search option and update the table accordingly.
            switch (option) {
                case 0:
                    // Search clients by ClientID and update the table using the addSearchedDataToTable method of ClientManager.
                    tm.addSearchedDataToTable((DefaultTableModel) tblTenants.getModel(), "WHERE TenantID LIKE ?", text);
                    break;
                case 1:
                    // Search clients by Firstname and update the table using the addSearchedDataToTable method of ClientManager.
                     tm.addSearchedDataToTable((DefaultTableModel) tblTenants.getModel(), "WHERE Firstname LIKE ?", text);
                    break;
                case 2:
                    // Search clients by Surname and update the table using the addSearchedDataToTable method of ClientManager.
                    tm.addSearchedDataToTable((DefaultTableModel) tblTenants.getModel(), "WHERE Surname LIKE ?", text);
                    break;
                case 3:
                    // Search clients by DOB (Date of Birth) and update the table using the addSearchedDataToTable method of ClientManager.
                    tm.addSearchedDataToTable((DefaultTableModel) tblTenants.getModel(), "WHERE Email LIKE ?", text);
                    break;
                case 4:
                    // Search clients by Email and update the table using the addSearchedDataToTable method of ClientManager.
                    tm.addSearchedDataToTable((DefaultTableModel) tblTenants.getModel(), "WHERE unitRented LIKE ?", text);
                    break;
                default:
                    // If no valid option is selected, do nothing.
                    break;
            }
        }

    }//GEN-LAST:event_textFieldSearchOptionKeyReleased

    private void btnDeleteTenantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTenantActionPerformed
        int rowSelected = tblTenants.getSelectedRow(); // Get the row number of the selected Tenanr from the table
        if (rowSelected == -1) { // Check if no row is selected
            JOptionPane.showMessageDialog(null, "Please select a Tenant to delete"); // Show error message
        } else {
            int confirmation = JOptionPane.showConfirmDialog(TenantScreen.this, "Are you sure you want to delete this Tenant?", "Edit Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                int tenantID = Integer.parseInt(tblTenants.getValueAt(rowSelected, 0).toString()); // Get the ID of the selected Tenant from the first column of the table
                TenantManager tm = new TenantManager(); // Create an instance of the ClientManager class
                tm.deleteTenant(tenantID); // Delete the selected client from the database
                tm.addSearchedDataToTable((DefaultTableModel) tblTenants.getModel(), ""); // Refresh the JTable by calling the addDataToTable() method of Tenant Manager class
                JOptionPane.showMessageDialog(null, "Tenant has been deleted"); // Show success message
            }
        }
    }//GEN-LAST:event_btnDeleteTenantActionPerformed

    private void btnEditTennantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditTennantActionPerformed
        // Get the index of the selected row in the Tenants table
        int rowSelected = tblTenants.getSelectedRow();
        // Check if a row has been selected
        if (rowSelected == -1) {
            // Show an error message if no row is selected
            JOptionPane.showMessageDialog(null, "Please select a Tennant to edit");
        } else {
            int tenantId = Integer.parseInt(tblTenants.getValueAt(rowSelected, 0).toString()); 
            String firstName = tblTenants.getValueAt(rowSelected, 1).toString();;
            String middleName =tblTenants.getValueAt(rowSelected, 2).toString();
            String surname = tblTenants.getValueAt(rowSelected, 3).toString();
            int propertyId = Integer.parseInt(tblTenants.getValueAt(rowSelected, 4).toString()); 
            String  LeaseStartDate = tblTenants.getValueAt(rowSelected, 5).toString();
            String  dob = tblTenants.getValueAt(rowSelected, 6).toString();
            String email = tblTenants.getValueAt(rowSelected, 7).toString();
            String phonenumber =tblTenants.getValueAt(rowSelected, 8).toString();
          

            // Create a new Tenant object with the selected details
            tenantSelected = new Tenant(tenantId, firstName,middleName, surname,propertyId,LocalDate.parse(LeaseStartDate), LocalDate.parse(dob), email, phonenumber);
            // Open the EditScreen and close the current ClientScreen
            new EditTenantScreen().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnEditTennantActionPerformed

    private void btnAddTenantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTenantActionPerformed
        // Open the AddTenantScreen and close the current ClientScreen
        new AddTenantScreen().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAddTenantActionPerformed

    private void textFieldSearchOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldSearchOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldSearchOptionActionPerformed

    private void btnprinttabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprinttabActionPerformed
         PrinterJob printerJob = PrinterJob.getPrinterJob();
    printerJob.setPrintable(tblTenants.getPrintable(JTable.PrintMode.FIT_WIDTH, null, null));

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
    
    printerJob.setPrintable(tblTenants.getPrintable(JTable.PrintMode.FIT_WIDTH, null, null), pageFormat);

    boolean doPrint = printerJob.printDialog();
    if (doPrint) {
        try {
            printerJob.print();
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }
    }//GEN-LAST:event_btnprinttabActionPerformed

    /**
     * @param args the command line arguments
     */
   
        
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Combobox ComboBoxSort;
    private javax.swing.JButton Mailbtn;
    private swing.CustomButtonGradient btnAddTenant;
    private swing.CustomButtonGradient btnBack;
    private swing.CustomButtonGradient btnDeleteTenant;
    private swing.CustomButtonGradient btnEditTennant;
    private swing.CustomButtonGradient btnprinttab;
    private javax.swing.JButton fbookbtn;
    private javax.swing.JButton instagrambtn;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JLabel jLabel_inven1;
    private javax.swing.JLabel jLabel_inven2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JTable tblTenants;
    private filter.TextFieldSearchOption textFieldSearchOption;
    private javax.swing.JButton twitterbtn;
    private javax.swing.JButton ytubebtn;
    // End of variables declaration//GEN-END:variables
}
