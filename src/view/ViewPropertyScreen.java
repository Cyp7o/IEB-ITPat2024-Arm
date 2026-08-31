// Define the package that this class belongs to
package view;

// Import the required classes
import classes.Property;
import classes.Tenant;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ViewPropertyScreen extends javax.swing.JFrame {

    // Variables to store property and owner information
    private Property property;
    private Tenant tenant;
    private boolean fromOwnersPropertiesScreen;
    private boolean fromClientScreen;

    // Constructor: Initializes the ViewPropertyScreen with property and owner information
    public ViewPropertyScreen(Property property, Tenant tenant, boolean fromOwnersPropertiesScreen, boolean fromClientScreen) {
        this.property = property;
        this.tenant = tenant;
        this.fromOwnersPropertiesScreen = fromOwnersPropertiesScreen;
        this.fromClientScreen = fromClientScreen;

        initComponents();
        setBackground(new Color(0, 0, 0, 0));

    

        // Set property details in the UI
        lblRent.setText("R " + property.getRent() + " PM");
        lblAddress.setText(property.getAddress());
        lblSuburb.setText(property.getSuburb());
        lblPropertyType.setText(property.getCategory());
        lblBathroom.setText(String.valueOf(property.getBathrooms()));
        lblBedroom.setText(String.valueOf(property.getBedrooms()));
        ImageIcon propertyImage = new ImageIcon(property.getImage());
        imageProperty.setIcon(propertyImage);

        // Display property occupancy status
        if (property.isOccupied()) {
            lblOccupied.setText("Occupied");
        } else {
            lblOccupied.setText("Unoccupied");
        }

        // Set Tenants details in the UI
        if (property.isOccupied()) { 
        lblFirstname.setText(tenant.getFirstName());
        lblSurname.setText(tenant.getSurname());
      String TenantDOB = tenant.getDob().toString();
        lblDOB.setText(TenantDOB);
        lblEmail.setText(tenant.getEmail());
    }else{
            // if their is no tenant set it to not aplicable 
            lblFirstname.setText("N/a");
             lblSurname.setText("N/a");
              String TenantDOB = "N/a";
        lblDOB.setText(TenantDOB);
        lblEmail.setText("N/a");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        imageProperty = new swing.SquareImageAvatar();
        lblBedroom = new javax.swing.JLabel();
        imageBedroom = new swing.SquareImageAvatar();
        lblBathroom = new javax.swing.JLabel();
        imageBathroom = new swing.SquareImageAvatar();
        lblRent = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblSuburb = new javax.swing.JLabel();
        lblPropertyType = new javax.swing.JLabel();
        lblOccupied = new javax.swing.JLabel();
        lblTenantDetails = new javax.swing.JLabel();
        lblFirstname = new javax.swing.JLabel();
        lblSurname = new javax.swing.JLabel();
        lblDOB = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        btnBack = new swing.CustomButtonGradient();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(21, 25, 28));
        setMaximumSize(new java.awt.Dimension(1026, 573));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1026, 573));

        jPanel1.setBackground(new java.awt.Color(21, 25, 28));

        imageProperty.setForeground(new java.awt.Color(169, 224, 49));
        imageProperty.setBorderSize(2);
        imageProperty.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Ponte-Appartment-29.jpg"))); // NOI18N

        lblBedroom.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblBedroom.setForeground(new java.awt.Color(169, 224, 49));
        lblBedroom.setText("Bedrooms");

        imageBedroom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bed.png"))); // NOI18N

        lblBathroom.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblBathroom.setForeground(new java.awt.Color(169, 224, 49));
        lblBathroom.setText("Bathrooms");

        imageBathroom.setBackground(new java.awt.Color(169, 224, 49));
        imageBathroom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bathtub.png"))); // NOI18N

        lblRent.setBackground(new java.awt.Color(21, 25, 28));
        lblRent.setFont(new java.awt.Font("Trebuchet MS", 1, 32)); // NOI18N
        lblRent.setForeground(new java.awt.Color(169, 224, 49));
        lblRent.setText("Rent");

        lblAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAddress.setForeground(new java.awt.Color(169, 224, 49));
        lblAddress.setText("Address");

        lblSuburb.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSuburb.setForeground(new java.awt.Color(169, 224, 49));
        lblSuburb.setText("Suburb");

        lblPropertyType.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPropertyType.setForeground(new java.awt.Color(169, 224, 49));
        lblPropertyType.setText("PropertyType");

        lblOccupied.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblOccupied.setForeground(new java.awt.Color(169, 224, 49));
        lblOccupied.setText("Occupied OR Unoccupied");

        lblTenantDetails.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblTenantDetails.setForeground(new java.awt.Color(169, 224, 49));
        lblTenantDetails.setText("Tenant Details:");

        lblFirstname.setForeground(new java.awt.Color(169, 224, 49));
        lblFirstname.setText("Tenants Firstname");

        lblSurname.setForeground(new java.awt.Color(169, 224, 49));
        lblSurname.setText("Tenants Surname");

        lblDOB.setForeground(new java.awt.Color(169, 224, 49));
        lblDOB.setText("Tenants Date Of Birth");

        lblEmail.setForeground(new java.awt.Color(169, 224, 49));
        lblEmail.setText("Tenants Email");

        btnBack.setForeground(new java.awt.Color(0, 0, 0));
        btnBack.setText("Back");
        btnBack.setColor1(new java.awt.Color(15, 214, 79));
        btnBack.setColor2(new java.awt.Color(248, 239, 66));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(imageBathroom, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBathroom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(imageBedroom, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBedroom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblFirstname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(44, 44, 44))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addGap(2, 2, 2)
                                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(lblOccupied, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                                                .addComponent(lblAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(lblSuburb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(lblPropertyType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                        .addComponent(lblRent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblTenantDetails, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)))
                                        .addComponent(imageProperty, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(51, 51, 51))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblRent, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSuburb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPropertyType, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblOccupied, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(imageBathroom, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBathroom, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imageBedroom, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBedroom, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(lblTenantDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFirstname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSurname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDOB))
                    .addComponent(imageProperty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmail)
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

         new PropertyScreen().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.CustomButtonGradient btnBack;
    private swing.SquareImageAvatar imageBathroom;
    private swing.SquareImageAvatar imageBedroom;
    private swing.SquareImageAvatar imageProperty;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBathroom;
    private javax.swing.JLabel lblBedroom;
    private javax.swing.JLabel lblDOB;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFirstname;
    private javax.swing.JLabel lblOccupied;
    private javax.swing.JLabel lblPropertyType;
    private javax.swing.JLabel lblRent;
    private javax.swing.JLabel lblSuburb;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JLabel lblTenantDetails;
    // End of variables declaration//GEN-END:variables
}
