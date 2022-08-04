import java.sql.*;
import javax.swing.JOptionPane;

public class logins extends javax.swing.JFrame {
    Connection con;
    ResultSet rs;
    PreparedStatement pst;
    
    public logins() {
        initComponents();
        setTitle("Log In");
    }
    
    public Connection getConnection(){      
        
        try{                                                                        
            Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3307/voting_system","root","");
            return con; 
        }      
        catch(Exception e){          
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        usertext.setFont(new java.awt.Font("Courier New", 1, 18)); 
        usertext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usertextActionPerformed(evt);
            }
        });
        usertext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usertextKeyPressed(evt);
            }
        });


        jLabel1.setFont(new java.awt.Font("Courier New", 1, 18)); 
        jLabel1.setText("ID Number");

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 18)); 
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Password");

        //jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Courier New", 1, 24)); 
        jButton2.setText("LOGIN");
        
        jButton2.setToolTipText("");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
        });
        jButton2.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jButton2InputMethodTextChanged(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        passtext.setFont(new java.awt.Font("Courier New", 1, 18)); 
        passtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passtextActionPerformed(evt);
            }
        });
        passtext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passtextKeyPressed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Courier New", 1, 18)); 
        jButton1.setText("Main Menu");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usertext)
                            .addComponent(passtext, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(usertext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addComponent(passtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(153, Short.MAX_VALUE))
        );

        pack();
    }                      

    private void usertextActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        String yes="yes";
        String no="no";
        String passid=usertext.getText();
        String login = "SELECT * FROM account WHERE id_number ='"+usertext.getText()+"' AND password = '"+passtext.getText() + " ' AND status = '"+no +"'";
        String already = "SELECT * FROM account WHERE id_number ='"+usertext.getText()+"' AND password = '"+passtext.getText() + " ' AND status = '"+yes +"'";
        String incorrect = "SELECT * FROM account WHERE id_number !='"+usertext.getText()+"' AND password != '"+passtext.getText() + " ' ";        
                   
        try{               
            Connection con = getConnection();                           
            pst = con.prepareStatement(login); 
            
            PreparedStatement pst1= con.prepareStatement(incorrect);                 
            ResultSet rs1;       
            rs1 = pst1.executeQuery();
    
            PreparedStatement pst2= con.prepareStatement(already);    
            ResultSet rs2;                   
            rs2 = pst2.executeQuery();                
            rs = pst.executeQuery();                
                
            if(rs.next()){                 
                rs.close();                
                pst.close();                
                JOptionPane.showMessageDialog(null,"Sucess!");             
                setVisible(false);
              
                new voting(passid).setVisible(true);          
            }                                
            else if (rs2.next()){             
                JOptionPane.showMessageDialog(null, "You already vote!");            
                usertext.setText(null);            
                passtext.setText(null);         
            }                            
            else if (rs1.next()){           
                JOptionPane.showMessageDialog(null, "Incorrect ID number AND Passowrd!");           
                usertext.setText(null);                        
                passtext.setText(null);           
            }       
        }                       
        catch(Exception e){                 
        }
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
                     
        String yes="yes"; 
        String no="no";
        String passid=usertext.getText();              
        String login = "SELECT * FROM account WHERE id_number ='"+usertext.getText()+"' AND password = '"+passtext.getText() + " ' AND status = '"+no +"'";
        String already = "SELECT * FROM account WHERE id_number ='"+usertext.getText()+"' AND password = '"+passtext.getText() + " ' AND status = '"+yes +"'";
        String incorrect = "SELECT * FROM account WHERE id_number !='"+usertext.getText()+"' AND password != '"+passtext.getText() + " ' ";
        
        try{                     
            Connection con = getConnection();           
            pst = con.prepareStatement(login);            
            rs = pst.executeQuery();
            
            PreparedStatement pst1= con.prepareStatement(incorrect);
            ResultSet rs1;        
            rs1 = pst1.executeQuery();
            
            PreparedStatement pst2= con.prepareStatement(already);
            ResultSet rs2;        
            rs2 = pst2.executeQuery();
                   
            if(rs.next()){           
                rs.close();
                pst.close();                
                JOptionPane.showMessageDialog(null,"Sucess!");                
                setVisible(false);              
                new voting(passid).setVisible(true);                        
            }                                    
            else if (rs2.next()){
                JOptionPane.showMessageDialog(null, "You already vote!");
                usertext.setText(null);
                passtext.setText(null);
            }            
            else if (rs1.next()){
                JOptionPane.showMessageDialog(null, "Incorrect ID number AND Passowrd!");                
                usertext.setText(null);
                passtext.setText(null);
            }                  
        }        
        catch(Exception e){                   
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

    private void jButton2InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {                                                

        String yes="yes";  
        String no="no";
        String passid=usertext.getText();              
        String login = "SELECT * FROM account WHERE id_number ='"+usertext.getText()+"' AND password = '"+passtext.getText() + " ' AND status = '"+no +"'";
        String already = "SELECT * FROM account WHERE id_number ='"+usertext.getText()+"' AND password = '"+passtext.getText() + " ' AND status = '"+yes +"'";
        String incorrect = "SELECT * FROM account WHERE id_number !='"+usertext.getText()+"' AND password != '"+passtext.getText() + " ' ";
        
        try{                       
            Connection con = getConnection();          
            pst = con.prepareStatement(login);                       
                       
            PreparedStatement pst1= con.prepareStatement(incorrect);
            ResultSet rs1;        
            rs1 = pst1.executeQuery();                                           
               
            PreparedStatement pst2= con.prepareStatement(already);
            ResultSet rs2;         
            rs2 = pst2.executeQuery();                    
            rs = pst.executeQuery();
           
            if(rs.next()){                             
                rs.close();
                pst.close();               
                JOptionPane.showMessageDialog(null,"Sucess!");                              
                setVisible(false);                
                new voting(passid).setVisible(true);            
            }                                  
            else if (rs2.next()){
                JOptionPane.showMessageDialog(null, "You already vote!");
                usertext.setText(null);
                passtext.setText(null);
            }
            else if (rs1.next()){
                JOptionPane.showMessageDialog(null, "Incorrect ID number AND Passowrd!");
                 usertext.setText(null);
                passtext.setText(null);
            }                                                     
        }              
        catch(Exception e){                 
        }     
    }                                               

    private void passtextKeyPressed(java.awt.event.KeyEvent evt) {                                    
    }                                   

    private void usertextKeyPressed(java.awt.event.KeyEvent evt) {                                    
    }                                   

    private void passtextActionPerformed(java.awt.event.ActionEvent evt) {                                         
         
        String yes="yes";  
        String no="no";
        String passid=usertext.getText();               
        String login = "SELECT * FROM account WHERE id_number ='"+usertext.getText()+"' AND password = '"+passtext.getText() + " ' AND status = '"+no +"'";
        String already = "SELECT * FROM account WHERE id_number ='"+usertext.getText()+"' AND password = '"+passtext.getText() + " ' AND status = '"+yes +"'";
        String incorrect = "SELECT * FROM account WHERE id_number !='"+usertext.getText()+"' AND password != '"+passtext.getText() + " ' ";
        
        try{                      
            Connection con = getConnection();           
            pst = con.prepareStatement(login);
                                              
            PreparedStatement pst1= con.prepareStatement(incorrect);
            ResultSet rs1;         
            rs1 = pst1.executeQuery();
                                   
            PreparedStatement pst2= con.prepareStatement(already);
            ResultSet rs2;         
            rs2 = pst2.executeQuery();                     
            rs = pst.executeQuery();
        
            if(rs.next()){              
                rs.close();
                pst.close();               
                JOptionPane.showMessageDialog(null,"Sucess!");                       
                setVisible(false);                
                new voting(passid).setVisible(true);              
            }           
            else if (rs2.next()){
                JOptionPane.showMessageDialog(null, "You already vote!");
                usertext.setText(null);
                passtext.setText(null);
            }                  
            else if (rs1.next()){
                JOptionPane.showMessageDialog(null, "Incorrect ID number AND Passowrd!");     
                usertext.setText(null);
                passtext.setText(null);
            }                                                   
        }          
        catch(Exception e){                
        }
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
            java.util.logging.Logger.getLogger(logins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(logins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(logins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(logins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new logins().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField passtext;
    private javax.swing.JTextField usertext;
}
