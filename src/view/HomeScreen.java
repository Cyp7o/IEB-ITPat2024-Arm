/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

// Package declaration for the view components of the application
package view;

// Import necessary classes for GUI and data handling
import classes.ExpenseManager; // Import for managing expenses
import classes.PropertyManager; // Import for managing properties
import classes.MainManager; // Import for managing main data operations
import classes.PaymentManager; // Import for managing payments
import classes.TenantManager; // Import for managing tenants
import filter.SearchOption; // Import for search options (not used in this class)
import filter.SearchOptionEvent; // Import for search option events (not used in this class)
import java.awt.Color; // Import for handling color
import java.awt.Desktop; // Import for desktop operations (not used in this class)
import java.awt.event.ActionEvent; // Import for action events
import java.awt.event.ActionListener; // Import for action listeners
import java.io.IOException; // Import for handling IOExceptions (not used in this class)
import java.net.URI; // Import for handling URIs (not used in this class)
import java.net.URISyntaxException; // Import for handling URI syntax exceptions (not used in this class)
import java.util.logging.Level; // Import for setting log levels
import java.util.logging.Logger; // Import for logging messages and exceptions
import javax.swing.ImageIcon; // Import for handling image icons
import javax.swing.JOptionPane; // Import for showing dialog boxes
import javax.swing.table.DefaultTableModel; // Import for handling table models
import swing.scrollbar.ScrollBarCustom; // Import for custom scrollbar implementation

/**
 * HomeScreen is a JFrame that displays the main screen of the application, including
 * statistics, sorting options, and user information.
 */
public class HomeScreen extends javax.swing.JFrame {

    /**
     * Creates a new HomeScreen frame and initializes the components.
     */
    public HomeScreen() {
        initComponents(); // Initialize GUI components
        
        // Create an instance of MainManager and populate the main table with data
        MainManager Mm = new MainManager();
        Mm.addDataToTable((DefaultTableModel) tblMain.getModel());

        // Customize the scroll bar and table appearance
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom()); // Set custom vertical scroll bar
        tblMain.setShowGrid(true); // Display grid lines in the table
        tblMain.setSelectionBackground(Color.decode("#2AC2EC")); // Set selection background color
        
        // Display the username of the logged-in user on the menu panel
        lblUsername.setText(LoginScreen.userSelected.getUsername());

        // Set the profile picture of the logged-in user on the menu panel
        imageAvatar.setIcon(new ImageIcon(LoginScreen.userSelected.getProfilePic()));

        // Create instances of manager classes
        ExpenseManager expenseManager = new ExpenseManager(); 
        PropertyManager propertyManager = new PropertyManager();
        TenantManager tenantManager = new TenantManager();
        PaymentManager paymentManager = new PaymentManager();

        // Get and format the current month's total expenses
        double currentMonthTotal = expenseManager.getCurrentMonthTotal();
        currentMonthTotal = Math.round(currentMonthTotal * 100.0) / 100.0;
        
        // Get the current month's total income
        double monthIncome = paymentManager.getMonthIncome();

        // Set labels with statistics values
        lbExpenseValue.setText("R " + Double.toString(currentMonthTotal)); // Set expense value
        lbTenatNo.setText(Integer.toString(tenantManager.getTotalEntries())); // Set tenant count
        lbPropertiesValue.setText(Integer.toString(propertyManager.getTotalEntries())); // Set property count
        lbIncomeValue.setText("R " + Double.toString(monthIncome)); // Set income value

        // Add sorting options to the ComboBoxSort and set up its action listener
        ComboBoxSort.addItem("None"); // Option to show no sorting
        ComboBoxSort.addItem("Paid"); // Option to sort by paid status
        ComboBoxSort.addItem("Unpaid"); // Option to sort by unpaid status
        ComboBoxSort.addItem("Firstname (A to Z)"); // Option to sort by first name (A to Z)
        ComboBoxSort.addItem("Firstname (Z to A)"); // Option to sort by first name (Z to A)
        ComboBoxSort.addItem("Surname (A to Z)"); // Option to sort by surname (A to Z)
        ComboBoxSort.addItem("Surname (Z to A)"); // Option to sort by surname (Z to A)

        // Set up action listener for sorting options
        ComboBoxSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = ComboBoxSort.getSelectedItem().toString(); // Get selected sort option
                MainManager mm = new MainManager(); // Create a new MainManager instance
                mm.sortTable(tblMain, selectedOption); // Sort the table based on selected option
            }
        });
    
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelShadow1 = new swingExtra.PanelShadow();
        lbName = new javax.swing.JLabel();
        lbExpenseValue = new javax.swing.JLabel();
        btnExpense = new javax.swing.JButton();
        panelShadow3 = new swingExtra.PanelShadow();
        lbName1 = new javax.swing.JLabel();
        lbIncomeValue = new javax.swing.JLabel();
        btnPayments = new javax.swing.JButton();
        panelShadow7 = new swingExtra.PanelShadow();
        lbName3 = new javax.swing.JLabel();
        lbTenatNo = new javax.swing.JLabel();
        btnTenants = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        twitterbtn = new javax.swing.JButton();
        fbookbtn = new javax.swing.JButton();
        instagrambtn = new javax.swing.JButton();
        Mailbtn = new javax.swing.JButton();
        ytubebtn = new javax.swing.JButton();
        jLabel_inven1 = new javax.swing.JLabel();
        lblHeading = new javax.swing.JLabel();
        imageAvatar = new swing.CircleImageAvatar();
        lblUsername = new javax.swing.JLabel();
        panelShadow4 = new swingExtra.PanelShadow();
        lbName2 = new javax.swing.JLabel();
        lbPropertiesValue = new javax.swing.JLabel();
        btnPayments1 = new javax.swing.JButton();
        ComboBoxSort = new swing.Combobox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMain = new javax.swing.JTable();
        jButton12 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(21, 25, 28));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1026, 573));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(21, 25, 28));
        jPanel1.setMaximumSize(new java.awt.Dimension(1026, 573));
        jPanel1.setMinimumSize(new java.awt.Dimension(1026, 573));
        jPanel1.setPreferredSize(new java.awt.Dimension(1026, 573));

        panelShadow1.setBackground(new java.awt.Color(49, 59, 66));
        panelShadow1.setShadowType(null);

        lbName.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        lbName.setForeground(new java.awt.Color(169, 224, 49));
        lbName.setText("Expenses");

        lbExpenseValue.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbExpenseValue.setForeground(new java.awt.Color(169, 224, 49));
        lbExpenseValue.setText("Values");

        btnExpense.setBackground(new java.awt.Color(49, 59, 66));
        btnExpense.setForeground(new java.awt.Color(169, 224, 49));
        btnExpense.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-bank-card-dollar-48.png"))); // NOI18N
        btnExpense.setBorder(null);
        btnExpense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpenseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnExpense, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbName)
                    .addComponent(lbExpenseValue))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExpense)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addComponent(lbName)
                        .addGap(0, 0, 0)
                        .addComponent(lbExpenseValue)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelShadow3.setBackground(new java.awt.Color(49, 59, 66));
        panelShadow3.setShadowType(null);

        lbName1.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        lbName1.setForeground(new java.awt.Color(169, 224, 49));
        lbName1.setText("income");

        lbIncomeValue.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbIncomeValue.setForeground(new java.awt.Color(169, 224, 49));
        lbIncomeValue.setText("Values");

        btnPayments.setBackground(new java.awt.Color(49, 59, 66));
        btnPayments.setForeground(new java.awt.Color(169, 224, 49));
        btnPayments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-profit-48.png"))); // NOI18N
        btnPayments.setBorder(null);
        btnPayments.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPayments.setDefaultCapable(false);
        btnPayments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelShadow3Layout = new javax.swing.GroupLayout(panelShadow3);
        panelShadow3.setLayout(panelShadow3Layout);
        panelShadow3Layout.setHorizontalGroup(
            panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnPayments, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbName1)
                    .addComponent(lbIncomeValue))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelShadow3Layout.setVerticalGroup(
            panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow3Layout.createSequentialGroup()
                .addGroup(panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow3Layout.createSequentialGroup()
                        .addComponent(lbName1)
                        .addGap(0, 0, 0)
                        .addComponent(lbIncomeValue))
                    .addComponent(btnPayments, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelShadow7.setBackground(new java.awt.Color(49, 59, 66));
        panelShadow7.setShadowType(null);

        lbName3.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        lbName3.setForeground(new java.awt.Color(169, 224, 49));
        lbName3.setText("total tenats");

        lbTenatNo.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbTenatNo.setForeground(new java.awt.Color(169, 224, 49));
        lbTenatNo.setText("Values");

        btnTenants.setBackground(new java.awt.Color(49, 59, 66));
        btnTenants.setForeground(new java.awt.Color(169, 224, 49));
        btnTenants.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-purchase-order-48.png"))); // NOI18N
        btnTenants.setBorder(null);
        btnTenants.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnTenants.setDefaultCapable(false);
        btnTenants.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTenantsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelShadow7Layout = new javax.swing.GroupLayout(panelShadow7);
        panelShadow7.setLayout(panelShadow7Layout);
        panelShadow7Layout.setHorizontalGroup(
            panelShadow7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTenants, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(panelShadow7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTenatNo)
                    .addComponent(lbName3))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        panelShadow7Layout.setVerticalGroup(
            panelShadow7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelShadow7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTenants)
                    .addGroup(panelShadow7Layout.createSequentialGroup()
                        .addComponent(lbName3)
                        .addGap(0, 0, 0)
                        .addComponent(lbTenatNo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Back_To_32px_2.png"))); // NOI18N
        jButton10.setToolTipText("Logout");
        jButton10.setBorder(null);
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.setRequestFocusEnabled(false);
        jButton10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-back-30.png"))); // NOI18N
        jButton10.setVerifyInputWhenFocusTarget(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
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

        jLabel_inven1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel_inven1.setForeground(new java.awt.Color(169, 224, 49));
        jLabel_inven1.setText("Connect with us on       support          Help");

        lblHeading.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        lblHeading.setForeground(new java.awt.Color(169, 224, 49));
        lblHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeading.setText("Dashboard");

        imageAvatar.setForeground(new java.awt.Color(240, 240, 240));
        imageAvatar.setBorderSize(3);
        imageAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/default.jpeg"))); // NOI18N
        imageAvatar.setInheritsPopupMenu(true);

        lblUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(200, 200, 200));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsername.setText("Admin");

        panelShadow4.setBackground(new java.awt.Color(49, 59, 66));
        panelShadow4.setShadowType(null);

        lbName2.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        lbName2.setForeground(new java.awt.Color(169, 224, 49));
        lbName2.setText("Properties");

        lbPropertiesValue.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPropertiesValue.setForeground(new java.awt.Color(169, 224, 49));
        lbPropertiesValue.setText("Values");

        btnPayments1.setBackground(new java.awt.Color(49, 59, 66));
        btnPayments1.setForeground(new java.awt.Color(169, 224, 49));
        btnPayments1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-building-48.png"))); // NOI18N
        btnPayments1.setBorder(null);
        btnPayments1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPayments1.setDefaultCapable(false);
        btnPayments1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayments1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelShadow4Layout = new javax.swing.GroupLayout(panelShadow4);
        panelShadow4.setLayout(panelShadow4Layout);
        panelShadow4Layout.setHorizontalGroup(
            panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnPayments1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbName2)
                    .addComponent(lbPropertiesValue))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelShadow4Layout.setVerticalGroup(
            panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow4Layout.createSequentialGroup()
                .addGroup(panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow4Layout.createSequentialGroup()
                        .addComponent(lbName2)
                        .addGap(0, 0, 0)
                        .addComponent(lbPropertiesValue))
                    .addComponent(btnPayments1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ComboBoxSort.setBackground(new java.awt.Color(36, 37, 38));
        ComboBoxSort.setForeground(new java.awt.Color(169, 224, 49));
        ComboBoxSort.setLabeText("Sort");
        ComboBoxSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxSortActionPerformed(evt);
            }
        });

        tblMain.setBackground(new java.awt.Color(24, 25, 26));
        tblMain.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        tblMain.setForeground(new java.awt.Color(169, 224, 49));
        tblMain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "FirstName", "SurName", "Complex", "Unit no", "Adress", "Rent", "Outstanding", "LastPayment"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMain.setRowHeight(30);
        tblMain.setSelectionBackground(new java.awt.Color(24, 24, 24));
        tblMain.setShowGrid(false);
        tblMain.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblMain);
        if (tblMain.getColumnModel().getColumnCount() > 0) {
            tblMain.getColumnModel().getColumn(0).setResizable(false);
            tblMain.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblMain.getColumnModel().getColumn(1).setResizable(false);
            tblMain.getColumnModel().getColumn(2).setResizable(false);
            tblMain.getColumnModel().getColumn(3).setResizable(false);
            tblMain.getColumnModel().getColumn(4).setResizable(false);
            tblMain.getColumnModel().getColumn(5).setResizable(false);
            tblMain.getColumnModel().getColumn(6).setResizable(false);
            tblMain.getColumnModel().getColumn(7).setResizable(false);
            tblMain.getColumnModel().getColumn(8).setResizable(false);
        }

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Cancel_32px.png"))); // NOI18N
        jButton12.setToolTipText("Close");
        jButton12.setBorder(null);
        jButton12.setBorderPainted(false);
        jButton12.setContentAreaFilled(false);
        jButton12.setRequestFocusEnabled(false);
        jButton12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Cancel_30px_3.png"))); // NOI18N
        jButton12.setVerifyInputWhenFocusTarget(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(twitterbtn)
                                .addGap(7, 7, 7)
                                .addComponent(fbookbtn)
                                .addGap(7, 7, 7)
                                .addComponent(instagrambtn)
                                .addGap(29, 29, 29)
                                .addComponent(Mailbtn)
                                .addGap(47, 47, 47)
                                .addComponent(ytubebtn))
                            .addComponent(jLabel_inven1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(179, 179, 179)
                        .addComponent(lblHeading)
                        .addGap(97, 97, 97)
                        .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ComboBoxSort, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelShadow7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelShadow3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelShadow4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHeading)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ytubebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(twitterbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fbookbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(instagrambtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Mailbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addComponent(jLabel_inven1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblUsername)
                                .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelShadow7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelShadow3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelShadow4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(ComboBoxSort, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_jButton11MouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
          // Show a confirmation dialog to log out
                    int confirmation = JOptionPane.showConfirmDialog(HomeScreen.this, "Are you sure you want to log out?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        // Take the user back to the login screen and close this screen (HomeScreen)
                        new LoginScreen().setVisible(true);
                        dispose();}
    }//GEN-LAST:event_jButton10ActionPerformed

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
           
            String url = "https://vimeo.com/994576038#t=1m1s.";
            // Use Desktop class to open the URL
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_ytubebtnActionPerformed

    private void btnExpenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpenseActionPerformed
        new ExpenseScreen().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnExpenseActionPerformed

    private void btnTenantsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTenantsActionPerformed
        new TenantScreen().setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnTenantsActionPerformed

    private void btnPaymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentsActionPerformed
    new PaymentScreen().setVisible(true);
    dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_btnPaymentsActionPerformed

    private void btnPayments1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayments1ActionPerformed
        // TODO add your handling code here:
        new PropertyScreen().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnPayments1ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
   System.exit(0);       
    }//GEN-LAST:event_jButton12ActionPerformed

    private void ComboBoxSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxSortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxSortActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Combobox ComboBoxSort;
    private javax.swing.JButton Mailbtn;
    private javax.swing.JButton btnExpense;
    private javax.swing.JButton btnPayments;
    private javax.swing.JButton btnPayments1;
    private javax.swing.JButton btnTenants;
    private javax.swing.JButton fbookbtn;
    private swing.CircleImageAvatar imageAvatar;
    private javax.swing.JButton instagrambtn;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JLabel jLabel_inven1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbExpenseValue;
    private javax.swing.JLabel lbIncomeValue;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbName1;
    private javax.swing.JLabel lbName2;
    private javax.swing.JLabel lbName3;
    private javax.swing.JLabel lbPropertiesValue;
    private javax.swing.JLabel lbTenatNo;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblUsername;
    private swingExtra.PanelShadow panelShadow1;
    private swingExtra.PanelShadow panelShadow3;
    private swingExtra.PanelShadow panelShadow4;
    private swingExtra.PanelShadow panelShadow7;
    private javax.swing.JTable tblMain;
    private javax.swing.JButton twitterbtn;
    private javax.swing.JButton ytubebtn;
    // End of variables declaration//GEN-END:variables
}
