// Define the package that this class belongs to
package view;

// Import the required classes
import classes.DataValidation;
import javax.swing.JOptionPane;
import classes.PropertyManager;
import java.awt.Color;
import java.awt.Desktop;
import java.net.URI;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

import jnafilechooser.api.JnaFileChooser;

public class AddPropertyScreen extends javax.swing.JFrame {
     private PropertyManager propertyManager;

    public AddPropertyScreen() {
        initComponents(); // Initialize the components of the frame
        propertyManager  = new PropertyManager();
          populateComboBox();
    }
    private void populateComboBox() {
          ArrayList<String> categories = propertyManager.getCategories();

    // Populate the combo box model
    String[] categoriesArray = categories.toArray(new String[0]);
    cmbCategory.setModel(new DefaultComboBoxModel<>(categoriesArray));
}
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panMain = new javax.swing.JPanel();
        lblSuburb = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblcategory = new javax.swing.JLabel();
        lblBathrooms = new javax.swing.JLabel();
        lblBedrooms = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtSuburb = new javax.swing.JTextField();
        txtUnitNo = new javax.swing.JTextField();
        spnBedrooms = new javax.swing.JSpinner();
        spnBathrooms = new javax.swing.JSpinner();
        lblRent = new javax.swing.JLabel();
        txtRent = new javax.swing.JTextField();
        buttonGradient1 = new swing.CustomButtonGradient();
        btnBack = new swing.CustomButtonGradient();
        lblHeading = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        lblRent1 = new javax.swing.JLabel();
        btnAddProperty = new swing.CustomButtonGradient();
        Mailbtn = new javax.swing.JButton();
        jLabel_inven2 = new javax.swing.JLabel();
        ytubebtn = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        chbOccupied = new javax.swing.JCheckBox();
        lblComplex = new javax.swing.JLabel();
        txtComplex = new javax.swing.JTextField();
        cmbCategory = new javax.swing.JComboBox<>();
        lblUnitNo = new javax.swing.JLabel();
        lblErrorUnitNO = new javax.swing.JLabel();
        lblErrorImage = new javax.swing.JLabel();
        lblErrorComplex = new javax.swing.JLabel();
        lblErrorSuburb = new javax.swing.JLabel();
        lblErrorAddress = new javax.swing.JLabel();
        lblErrorRent = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panMain.setBackground(new java.awt.Color(21, 25, 28));
        panMain.setMaximumSize(new java.awt.Dimension(1026, 573));
        panMain.setMinimumSize(new java.awt.Dimension(1026, 573));

        lblSuburb.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        lblSuburb.setForeground(new java.awt.Color(169, 224, 49));
        lblSuburb.setText("Suburb:");

        lblAddress.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        lblAddress.setForeground(new java.awt.Color(169, 224, 49));
        lblAddress.setText("Address:");

        lblcategory.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        lblcategory.setForeground(new java.awt.Color(169, 224, 49));
        lblcategory.setText("Category:");

        lblBathrooms.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        lblBathrooms.setForeground(new java.awt.Color(169, 224, 49));
        lblBathrooms.setText("Bathrooms:");

        lblBedrooms.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        lblBedrooms.setForeground(new java.awt.Color(169, 224, 49));
        lblBedrooms.setText("Bedrooms:");

        txtAddress.setBackground(new java.awt.Color(31, 36, 42));
        txtAddress.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        txtAddress.setForeground(new java.awt.Color(169, 224, 49));
        txtAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 224, 49)));

        txtSuburb.setBackground(new java.awt.Color(31, 36, 42));
        txtSuburb.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        txtSuburb.setForeground(new java.awt.Color(169, 224, 49));
        txtSuburb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 224, 49)));

        txtUnitNo.setBackground(new java.awt.Color(31, 36, 42));
        txtUnitNo.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        txtUnitNo.setForeground(new java.awt.Color(169, 224, 49));
        txtUnitNo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 224, 49)));

        spnBedrooms.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        spnBedrooms.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));
        spnBedrooms.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 224, 49)));
        spnBedrooms.setBackground(new java.awt.Color(31, 36, 42));
        spnBedrooms.setForeground(Color.BLUE);

        spnBathrooms.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        spnBathrooms.setModel(new javax.swing.SpinnerNumberModel(1.0d, 1.0d, 20.0d, 0.5d));
        spnBathrooms.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 224, 49)));

        lblRent.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        lblRent.setForeground(new java.awt.Color(169, 224, 49));
        lblRent.setText("Rent:");

        txtRent.setBackground(new java.awt.Color(31, 36, 42));
        txtRent.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        txtRent.setForeground(new java.awt.Color(169, 224, 49));
        txtRent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 224, 49)));

        buttonGradient1.setBackground(new java.awt.Color(0, 0, 0));
        buttonGradient1.setForeground(new java.awt.Color(0, 0, 0));
        buttonGradient1.setText("Select Image");
        buttonGradient1.setColor1(new java.awt.Color(169, 224, 49));
        buttonGradient1.setColor2(new java.awt.Color(169, 224, 49));
        buttonGradient1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGradient1ActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setForeground(new java.awt.Color(0, 0, 0));
        btnBack.setText("Back");
        btnBack.setColor1(new java.awt.Color(15, 214, 79));
        btnBack.setColor2(new java.awt.Color(248, 239, 66));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblHeading.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        lblHeading.setForeground(new java.awt.Color(169, 224, 49));
        lblHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeading.setText("ADD PROPERTY");

        lblImage.setFont(new java.awt.Font("Trebuchet MS", 0, 8)); // NOI18N
        lblImage.setForeground(new java.awt.Color(255, 255, 255));

        lblRent1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        lblRent1.setForeground(new java.awt.Color(169, 224, 49));
        lblRent1.setText("Occupied:");

        btnAddProperty.setBackground(new java.awt.Color(0, 0, 0));
        btnAddProperty.setForeground(new java.awt.Color(0, 0, 0));
        btnAddProperty.setText("Add Property");
        btnAddProperty.setColor1(new java.awt.Color(169, 224, 49));
        btnAddProperty.setColor2(new java.awt.Color(169, 224, 49));
        btnAddProperty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPropertyActionPerformed(evt);
            }
        });

        Mailbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Secured_Letter_32px.png"))); // NOI18N
        Mailbtn.setToolTipText("Email");
        Mailbtn.setBorder(null);
        Mailbtn.setBorderPainted(false);
        Mailbtn.setContentAreaFilled(false);
        Mailbtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Secured_Letter_32px_2.png"))); // NOI18N

        jLabel_inven2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel_inven2.setForeground(new java.awt.Color(169, 224, 49));
        jLabel_inven2.setText("support         Help");

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

        chbOccupied.setBackground(new java.awt.Color(21, 25, 28));
        chbOccupied.setForeground(new java.awt.Color(169, 224, 49));
        chbOccupied.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(21, 25, 28)));
        chbOccupied.setBorderPainted(true);
        chbOccupied.setBorderPaintedFlat(true);
        chbOccupied.setOpaque(true);

        lblComplex.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        lblComplex.setForeground(new java.awt.Color(169, 224, 49));
        lblComplex.setText("Complex:");

        txtComplex.setBackground(new java.awt.Color(31, 36, 42));
        txtComplex.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        txtComplex.setForeground(new java.awt.Color(169, 224, 49));
        txtComplex.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 224, 49)));

        cmbCategory.setBackground(new java.awt.Color(31, 36, 42));
        cmbCategory.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        cmbCategory.setForeground(new java.awt.Color(169, 224, 49));
        cmbCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCategory.setBorder(null);

        lblUnitNo.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        lblUnitNo.setForeground(new java.awt.Color(169, 224, 49));
        lblUnitNo.setText("UnitNo:");

        lblErrorUnitNO.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblErrorUnitNO.setForeground(new java.awt.Color(244, 67, 54));
        lblErrorUnitNO.setText("*");

        lblErrorImage.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblErrorImage.setForeground(new java.awt.Color(244, 67, 54));
        lblErrorImage.setText("*");

        lblErrorComplex.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblErrorComplex.setForeground(new java.awt.Color(244, 67, 54));
        lblErrorComplex.setText("*");

        lblErrorSuburb.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblErrorSuburb.setForeground(new java.awt.Color(244, 67, 54));
        lblErrorSuburb.setText("*");

        lblErrorAddress.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblErrorAddress.setForeground(new java.awt.Color(244, 67, 54));
        lblErrorAddress.setText("*");

        lblErrorRent.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblErrorRent.setForeground(new java.awt.Color(244, 67, 54));
        lblErrorRent.setText("*");

        javax.swing.GroupLayout panMainLayout = new javax.swing.GroupLayout(panMain);
        panMain.setLayout(panMainLayout);
        panMainLayout.setHorizontalGroup(
            panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(251, 251, 251)
                .addComponent(lblHeading, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addGap(99, 99, 99)
                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panMainLayout.createSequentialGroup()
                        .addComponent(Mailbtn)
                        .addGap(40, 40, 40)
                        .addComponent(ytubebtn))
                    .addComponent(jLabel_inven2))
                .addGap(18, 18, 18)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(panMainLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panMainLayout.createSequentialGroup()
                        .addComponent(chbOccupied, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(243, 243, 243))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panMainLayout.createSequentialGroup()
                        .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRent1)
                            .addComponent(buttonGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panMainLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblBathrooms)
                                    .addComponent(lblRent)
                                    .addComponent(lblBedrooms)
                                    .addComponent(lblcategory)
                                    .addComponent(lblSuburb)
                                    .addComponent(lblAddress)
                                    .addComponent(lblComplex)
                                    .addComponent(lblUnitNo))))
                        .addGap(35, 35, 35)
                        .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUnitNo, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(spnBathrooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRent)
                                .addComponent(spnBedrooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSuburb)
                                .addComponent(txtAddress)
                                .addComponent(txtComplex)
                                .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panMainLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAddProperty, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panMainLayout.createSequentialGroup()
                        .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblErrorImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblErrorRent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblErrorSuburb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblErrorAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblErrorComplex, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblErrorUnitNO, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        panMainLayout.setVerticalGroup(
            panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMainLayout.createSequentialGroup()
                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panMainLayout.createSequentialGroup()
                        .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panMainLayout.createSequentialGroup()
                        .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Mailbtn)
                            .addComponent(ytubebtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_inven2)))
                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUnitNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblErrorUnitNO))
                    .addComponent(lblUnitNo))
                .addGap(18, 18, 18)
                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblComplex)
                    .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtComplex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblErrorComplex)))
                .addGap(18, 18, 18)
                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAddress)
                    .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblErrorAddress)))
                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panMainLayout.createSequentialGroup()
                        .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSuburb)
                            .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSuburb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblErrorSuburb)))
                        .addGap(20, 20, 20)
                        .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblcategory)
                            .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panMainLayout.createSequentialGroup()
                                .addComponent(lblBedrooms)
                                .addGap(18, 18, 18)
                                .addComponent(lblBathrooms))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panMainLayout.createSequentialGroup()
                                .addComponent(spnBedrooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(spnBathrooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panMainLayout.createSequentialGroup()
                                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtRent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblErrorRent))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblErrorImage)))
                            .addGroup(panMainLayout.createSequentialGroup()
                                .addComponent(lblRent)
                                .addGap(18, 18, 18)
                                .addComponent(buttonGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRent1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(chbOccupied, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))
                    .addGroup(panMainLayout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(btnAddProperty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        spnBathrooms.setModel(new javax.swing.SpinnerNumberModel(1.5, 0.0, 10.0, 0.1));
        cmbCategory.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGradient1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGradient1ActionPerformed
        JnaFileChooser jnaCh = new JnaFileChooser();
        boolean action = jnaCh.showOpenDialog(this);
        if (action) {
            String selectedFilePath = jnaCh.getSelectedFile().getPath();
            lblImage.setText(selectedFilePath); // Set the selected image file path to the label
        }
    }//GEN-LAST:event_buttonGradient1ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // Navigate back to the PropertyScreen and close the current window
        new PropertyScreen().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddPropertyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPropertyActionPerformed
        // Extract property details from input fields
        String complex = txtComplex.getText();
        String unitno = txtUnitNo.getText();
        String address = txtAddress.getText();
        String suburb = txtSuburb.getText();
        String category = cmbCategory.getSelectedItem().toString();
        int bedrooms = Integer.parseInt(spnBedrooms.getValue().toString());
        double bathrooms = Double.parseDouble(spnBathrooms.getValue().toString());
        String rent = txtRent.getText();
        String image = lblImage.getText();
         Boolean occupied = chbOccupied.isSelected();

        // Perform data validation using DataValidation class
        DataValidation valid = new DataValidation();
        lblErrorUnitNO.setText(valid. checkUnitNo(unitno));
        lblErrorComplex.setText(valid.checkComplex(complex));
        lblErrorAddress.setText(valid.checkAddress(address));
       lblErrorSuburb.setText(valid.checkSuburb(suburb));
       lblErrorRent.setText(valid.checkRent(rent));
       lblErrorImage.setText(valid.checkImage(image));
     

        if (valid.isValid()) {
            if (valid.propertyExists(address, suburb, 0)) {
                // Check if the property already exists
                JOptionPane.showMessageDialog(null, "Property already exists.");
                return;
            } else {
                // Prompt for confirmation to add the property
                int confirmation = JOptionPane.showConfirmDialog(AddPropertyScreen.this, "Are you sure you want to add this Property?", "Edit Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    PropertyManager pm = new PropertyManager();
                 pm.addProperty(complex,unitno,address, suburb, category, bedrooms, bathrooms, Integer.parseInt(rent), image); // Add the property

                   

                    JOptionPane.showMessageDialog(null, "Property has been added");
                    new PropertyScreen().setVisible(true); // Navigate back to PropertyScreen
                    this.dispose(); // Close the current window
                }
            }
        }
    }//GEN-LAST:event_btnAddPropertyActionPerformed

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
       // minimise the application
        this.setState(ICONIFIED);
    }//GEN-LAST:event_jButton11MouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
       // close the application
        System.exit(0);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void ytubebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ytubebtnActionPerformed
        try {
            String url = "https://vimeo.com/994576038#t=9m6s.";
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
            java.util.logging.Logger.getLogger(AddPropertyScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPropertyScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPropertyScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPropertyScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddPropertyScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Mailbtn;
    private swing.CustomButtonGradient btnAddProperty;
    private swing.CustomButtonGradient btnBack;
    private swing.CustomButtonGradient buttonGradient1;
    private javax.swing.JCheckBox chbOccupied;
    private javax.swing.JComboBox<String> cmbCategory;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JLabel jLabel_inven2;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBathrooms;
    private javax.swing.JLabel lblBedrooms;
    private javax.swing.JLabel lblComplex;
    private javax.swing.JLabel lblErrorAddress;
    private javax.swing.JLabel lblErrorComplex;
    private javax.swing.JLabel lblErrorImage;
    private javax.swing.JLabel lblErrorRent;
    private javax.swing.JLabel lblErrorSuburb;
    private javax.swing.JLabel lblErrorUnitNO;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblRent;
    private javax.swing.JLabel lblRent1;
    private javax.swing.JLabel lblSuburb;
    private javax.swing.JLabel lblUnitNo;
    private javax.swing.JLabel lblcategory;
    private javax.swing.JPanel panMain;
    private javax.swing.JSpinner spnBathrooms;
    private javax.swing.JSpinner spnBedrooms;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtComplex;
    private javax.swing.JTextField txtRent;
    private javax.swing.JTextField txtSuburb;
    private javax.swing.JTextField txtUnitNo;
    private javax.swing.JButton ytubebtn;
    // End of variables declaration//GEN-END:variables
}
