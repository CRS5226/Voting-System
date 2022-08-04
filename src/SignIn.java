import java.sql.*;
import javax.swing.JOptionPane;

public class SignIn extends javax.swing.JFrame {
    Connection con;
    ResultSet rs;
    PreparedStatement pst;
    
    public SignIn() {
        initComponents();
        setTitle("Sign In");
    }
    
    public Connection getConnection(){      
        
        try{                                                                        
            Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3307/voting_system","root","");
            return con; 
        }      
        catch(Exception e){     
            System.out.println(e);     
        }
       
        return null;
}
                         
    private void initComponents() {

        usertext = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        passtext = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        usertext1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        passtext1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        usertext.setFont(new java.awt.Font("Courier New", 1, 18)); 
        
        usertext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usertextKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 18)); 
        jLabel1.setText("ID Number");

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 18)); 
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Confirm Password");

        jButton2.setFont(new java.awt.Font("Courier New", 1, 24)); 
        jButton2.setText("SUBMIT");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
        });
        
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        passtext.setFont(new java.awt.Font("Courier New", 1, 18)); 
        
        passtext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passtextKeyPressed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Courier New", 1, 18)); 
        jButton1.setText("Back");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Courier New", 1, 18)); 
        jLabel3.setText("Name");

        usertext1.setFont(new java.awt.Font("Courier New", 1, 18)); 
        usertext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usertext1ActionPerformed(evt);
            }
        });
        usertext1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usertext1KeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Courier New", 1, 18)); 
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Password");

        passtext1.setFont(new java.awt.Font("Courier New", 1, 18)); 
        passtext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passtext1ActionPerformed(evt);
            }
        });
        passtext1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passtext1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usertext, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(passtext, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(usertext1)
                            .addComponent(passtext1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usertext1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(usertext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(passtext1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(passtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(51, 51, 51))
        );

        pack();
    }                    

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        String yes="yes"; 
        String no="no";
        String passid=usertext.getText(); 

        String passname = usertext1.getText();
        String pass = new String(passtext.getPassword());
        String pass2 = new String(passtext1.getPassword());

        String login = "INSERT INTO account (id_number, student_name, password, status, dt) VALUES ('" +usertext1.getText()+"', '" +usertext.getText()+"', '" +passtext1.getText()+"', '" +no+"', current_timestamp())";
        
        if(pass.equals(pass2)){
            try{                     
                Connection con = getConnection();           
                pst = con.prepareStatement(login);            
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Account made Successfully"); 
                setVisible(false);
                mainmenu info3 = new mainmenu();
                info3.setVisible(true);
            }        
            catch(Exception e){        
                JOptionPane.showMessageDialog(null, e);    
            }
        }else{
            JOptionPane.showMessageDialog(null, "Password not match"); 
        }
    }
        
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {                                      
        setVisible(false);
        mainmenu main = new mainmenu();
        main.setVisible(true);       
        main.setLocationRelativeTo(null);
    }                                     

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {                                      
    }                                       

    private void passtextKeyPressed(java.awt.event.KeyEvent evt) {                                    
    }                                   

    private void usertextKeyPressed(java.awt.event.KeyEvent evt) {                                    
    }                                    

    private void usertext1ActionPerformed(java.awt.event.ActionEvent evt) {                                          
    }                                         

    private void usertext1KeyPressed(java.awt.event.KeyEvent evt) {                                     
    }                                    

    private void passtext1ActionPerformed(java.awt.event.ActionEvent evt) {                                          
    }                                         

    private void passtext1KeyPressed(java.awt.event.KeyEvent evt) {                                     
    }                                    

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignIn().setVisible(true);
            }
        });
    }
                  
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField passtext;
    private javax.swing.JPasswordField passtext1;
    private javax.swing.JTextField usertext;
    private javax.swing.JTextField usertext1;                
}
