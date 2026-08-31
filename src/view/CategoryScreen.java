// Define the package that this class belongs to
package view;

// Import the required classes
import classes.Category;
import filter.SearchOption;
import classes.CategoryManager;
import classes.DataValidation;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import swing.scrollbar.ScrollBarCustom;
import filter.SearchOptionEvent;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryScreen extends javax.swing.JFrame {

    // A static variable to store the Expense selected from the table.
    public static Category expenseSelected;

  
   // Constructor for the CategoryScreen class.
    public CategoryScreen() {
        initComponents();

        // Initialize the ExpenseManager and add data to the table.
        CategoryManager cm = new CategoryManager();
        cm.addDataToTable((DefaultTableModel) tblCategories.getModel());

        // Set up the appearance of the GUI components.
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        tblCategories.setShowGrid(true);
        tblCategories.setSelectionBackground(Color.decode("#2AC2EC"));

        // Add search options to the textFieldSearchOption and set the default selected option.
        textFieldSearchOption.addOption(new SearchOption("CategoryID", new ImageIcon(getClass().getResource("/icon/user (2).png"))));
        textFieldSearchOption.addOption(new SearchOption("Category", new ImageIcon(getClass().getResource("/icon/5.png"))));
        textFieldSearchOption.setSelectedIndex(0);

      
     

        // Add an event listener to the textFieldSearchOption to update the hint text when an option is selected.
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

        panMain = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCategories = new javax.swing.JTable();
        lblHeading = new javax.swing.JLabel();
        btnBack = new swing.CustomButtonGradient();
        textFieldSearchOption = new filter.TextFieldSearchOption();
        btnAddCategory = new swing.CustomButtonGradient();
        btnDeleteCategory = new swing.CustomButtonGradient();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        twitterbtn = new javax.swing.JButton();
        jLabel_inven1 = new javax.swing.JLabel();
        fbookbtn = new javax.swing.JButton();
        instagrambtn = new javax.swing.JButton();
        Mailbtn = new javax.swing.JButton();
        ytubebtn = new javax.swing.JButton();
        jLabel_inven2 = new javax.swing.JLabel();
        txtAddCategory = new javax.swing.JTextField();
        lblNewCategory = new javax.swing.JLabel();
        lblErrorCategory = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panMain.setBackground(new java.awt.Color(21, 25, 28));

        tblCategories.setBackground(new java.awt.Color(24, 25, 26));
        tblCategories.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        tblCategories.setForeground(new java.awt.Color(169, 224, 49));
        tblCategories.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "CategoryID", "Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCategories.setGridColor(new java.awt.Color(0, 255, 102));
        tblCategories.setRowHeight(25);
        tblCategories.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblCategories);

        lblHeading.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        lblHeading.setForeground(new java.awt.Color(169, 224, 49));
        lblHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeading.setText("Apartment Category:");

        btnBack.setForeground(new java.awt.Color(0, 0, 0));
        btnBack.setText("Back");
        btnBack.setColor1(new java.awt.Color(15, 214, 79));
        btnBack.setColor2(new java.awt.Color(248, 239, 66));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        textFieldSearchOption.setBackground(new java.awt.Color(36, 37, 38));
        textFieldSearchOption.setForeground(new java.awt.Color(169, 224, 49));
        textFieldSearchOption.setColorOverlay1(new java.awt.Color(15, 214, 79));
        textFieldSearchOption.setColorOverlay2(new java.awt.Color(248, 239, 66));
        textFieldSearchOption.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldSearchOptionKeyReleased(evt);
            }
        });

        btnAddCategory.setForeground(new java.awt.Color(0, 0, 0));
        btnAddCategory.setText("Add Category");
        btnAddCategory.setColor1(new java.awt.Color(169, 224, 49));
        btnAddCategory.setColor2(new java.awt.Color(169, 224, 49));
        btnAddCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCategoryActionPerformed(evt);
            }
        });

        btnDeleteCategory.setForeground(new java.awt.Color(0, 0, 0));
        btnDeleteCategory.setText("Delete Category");
        btnDeleteCategory.setColor1(new java.awt.Color(169, 224, 49));
        btnDeleteCategory.setColor2(new java.awt.Color(169, 224, 49));
        btnDeleteCategory.setMaximumSize(new java.awt.Dimension(100, 36));
        btnDeleteCategory.setMinimumSize(new java.awt.Dimension(100, 36));
        btnDeleteCategory.setPreferredSize(new java.awt.Dimension(100, 36));
        btnDeleteCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCategoryActionPerformed(evt);
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

        txtAddCategory.setBackground(new java.awt.Color(31, 36, 42));
        txtAddCategory.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        txtAddCategory.setForeground(new java.awt.Color(255, 255, 255));
        txtAddCategory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 224, 49)));

        lblNewCategory.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        lblNewCategory.setForeground(new java.awt.Color(169, 224, 49));
        lblNewCategory.setText("Add a new Category:");

        lblErrorCategory.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblErrorCategory.setForeground(new java.awt.Color(244, 67, 54));
        lblErrorCategory.setText("*");

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
                        .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panMainLayout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panMainLayout.createSequentialGroup()
                                        .addComponent(twitterbtn)
                                        .addGap(6, 6, 6)
                                        .addComponent(fbookbtn)
                                        .addGap(6, 6, 6)
                                        .addComponent(instagrambtn))
                                    .addComponent(jLabel_inven1))
                                .addGap(59, 59, 59)
                                .addComponent(lblHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panMainLayout.createSequentialGroup()
                                        .addComponent(Mailbtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ytubebtn))
                                    .addComponent(jLabel_inven2)))
                            .addGroup(panMainLayout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(btnAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(172, 172, 172)
                                .addComponent(btnDeleteCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 88, Short.MAX_VALUE))
                    .addGroup(panMainLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panMainLayout.createSequentialGroup()
                                .addComponent(txtAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblErrorCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblNewCategory))
                        .addGap(18, 18, 18)
                        .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(textFieldSearchOption, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE))))
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
                                .addComponent(jLabel_inven2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panMainLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(textFieldSearchOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDeleteCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(panMainLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(lblNewCategory)
                        .addGap(18, 18, 18)
                        .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblErrorCategory))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
            new PropertyScreen().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void textFieldSearchOptionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldSearchOptionKeyReleased
        // Check if the search option is selected.
        if (textFieldSearchOption.isSelected()) {
            // Get the index of the selected search option.
            int option = textFieldSearchOption.getSelectedIndex();
            // Get the search text from the textFieldSearchOption and trim any leading/trailing spaces.
            String text = "%" + textFieldSearchOption.getText().trim() + "%";

            // Create an instance of the OwnerManager class to perform owner-related operations.
            CategoryManager em = new CategoryManager();

            // Use a switch statement to perform different searches based on the selected search option.
            switch (option) {
                // Case 0 represents searching by OwnerID.
                case 0:
                    // Add searched owner data to the table by calling the addSearchedDataToTable method of OwnerManager.
                    // The search condition "WHERE OwnerID LIKE ?" is used to search for rows with matching OwnerID.
                    // The "?" will be replaced with the 'text' variable, which contains the search text.
                    em.addSearchedDataToTable((DefaultTableModel) tblCategories.getModel(), "WHERE CategoryID LIKE ?", text);
                    break;
                // Case 1 represents searching by Firstname.
                case 1:
                    em.addSearchedDataToTable((DefaultTableModel) tblCategories.getModel(), "WHERE Category LIKE ?", text);
                    break;
               
                // Default case is used if none of the above cases match (though this is unlikely given the ComboBox options).
                default:
                    break;
            }
        }
    }//GEN-LAST:event_textFieldSearchOptionKeyReleased

    private void btnAddCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCategoryActionPerformed
        
         // Get user input
       
        String type = txtAddCategory.getText();      // get the value entered in the AddCategory field
       
        // Data Validation
        DataValidation valid = new DataValidation();           // create a new DataValidation object to validate the user input
        lblErrorCategory.setText(valid.checkCategory(type));   // check if the Category input is valid and set the error message if not
        if (valid.isValid()) { 
            // Create a new Category object and add it to the database
                Category category = new Category(type);
                CategoryManager Cm = new CategoryManager();
                Cm.addCategory(category);
                JOptionPane.showMessageDialog(null, "Category has been added");   // Display a message to the user that the owner has been successfully added

                new PropertyScreen().setVisible(true);
                this.dispose();}

      
              
            
        
    }//GEN-LAST:event_btnAddCategoryActionPerformed

    private void btnDeleteCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCategoryActionPerformed
        int rowSelected = tblCategories.getSelectedRow(); // Get the row number of the selected owner from the table
        if (rowSelected == -1) { // Check if no row is selected
            JOptionPane.showMessageDialog(null, "Please select a Expense to delete"); // Show error message
        } else {
            int confirmation = JOptionPane.showConfirmDialog(CategoryScreen.this, "Are you sure you want to delete this Expense?", "Edit Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                int categoryID = Integer.parseInt(tblCategories.getValueAt(rowSelected, 0).toString()); // Get the ID of the selected  from the first column of the table
                CategoryManager cm = new CategoryManager(); // Create an instance of the OwnerManager class
                cm.deleteCategory(categoryID); // Delete the selected owner from the database
                cm.addSearchedDataToTable((DefaultTableModel) tblCategories.getModel(), ""); // Refresh the JTable by calling the addDataToTable() method of OwnerManager class
                JOptionPane.showMessageDialog(null, "Expense has been deleted"); // Show success message
            }
        }
    }//GEN-LAST:event_btnDeleteCategoryActionPerformed

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
            String url = "https://vimeo.com/994576038#t=8m49s.";
            // Use Desktop class to open the URL
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_ytubebtnActionPerformed

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
            java.util.logging.Logger.getLogger(CategoryScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CategoryScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CategoryScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CategoryScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private swing.CustomButtonGradient btnAddCategory;
    private swing.CustomButtonGradient btnBack;
    private swing.CustomButtonGradient btnDeleteCategory;
    private javax.swing.JButton fbookbtn;
    private javax.swing.JButton instagrambtn;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JLabel jLabel_inven1;
    private javax.swing.JLabel jLabel_inven2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblErrorCategory;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblNewCategory;
    private javax.swing.JPanel panMain;
    private javax.swing.JTable tblCategories;
    private filter.TextFieldSearchOption textFieldSearchOption;
    private javax.swing.JButton twitterbtn;
    private javax.swing.JTextField txtAddCategory;
    private javax.swing.JButton ytubebtn;
    // End of variables declaration//GEN-END:variables
}
