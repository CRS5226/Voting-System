import javax.swing.*;
import java.sql.*;

public class voting extends javax.swing.JFrame {
    
    Connection con;
    ResultSet rs,rs1,rs2,rs3,rs4,rs5,rs6,rsAccount;
    PreparedStatement pst,pst1,pst2,pst3,pst4,pst5,pst6,pstAccount;
    
    public voting() {
        initComponents();        
        forms();
        setTitle("Voting Portal");
    }
    
    public voting(String passid) {       
        initComponents();
        idreceive.setText(passid);
        forms();
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
    

    public void forms(){
    
       try{
            
           Connection con = getConnection();

           int pre=1;
           String president= "select candidate_name from candidate where position_id='"+pre+"'";
           pst1 = con.prepareStatement(president); 
           rs1 = pst1.executeQuery();

           int vicepre=2;
           String vicepresident= "select candidate_name from candidate where position_id='"+vicepre+"'";
           pst2 = con.prepareStatement(vicepresident); 
           rs2 = pst2.executeQuery();

           int secnum=3;
           String secretary = "select candidate_name from candidate where position_id='"+secnum+"'";
           pst3 = con.prepareStatement(secretary); 
           rs3 = pst3.executeQuery();

           int treanum=5;
           String treasurer = "select candidate_name from candidate where position_id='"+treanum+"'";
           pst4 = con.prepareStatement(treasurer); 
           rs4 = pst4.executeQuery();

           int audi=4;
           String auditor = "select candidate_name from candidate where position_id='"+audi+"'";
           pst5 = con.prepareStatement(auditor); 
           rs5 = pst5.executeQuery();

           int pionum=6;
           String pio = "select candidate_name from candidate where position_id='"+pionum+"'";
           pst6 = con.prepareStatement(pio); 
           rs6 = pst6.executeQuery();
           
           while(rs1.next()&&rs2.next() && rs3.next() &&rs4.next() &&rs5.next() &&rs6.next() ){
               presidentCB.addItem(rs1.getString(1));
               vicepresidentCB.addItem(rs2.getString(1));
               secretaryCB.addItem(rs3.getString(1));
               treasurerCB.addItem(rs4.getString(1));
               auditorCB.addItem(rs5.getString(1));
               pioCB.addItem(rs6.getString(1));
            }     
       } 
        
       catch(Exception e){          
       }
}

    private void initComponents() {

        PresidentGroup = new javax.swing.ButtonGroup();
        VicePresidentGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        idreceive = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        treasurerCB = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        presidentCB = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        vicepresidentCB = new javax.swing.JComboBox<>();
        secretaryCB = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        auditorCB = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        pioCB = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 24)); 
        jLabel1.setText("Secretary");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        jButton2.setText("Vote now");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, 110, 60));
        getContentPane().add(idreceive, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 27, 190, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel6.setText("STUDENT ID NUMBER");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 20, -1, 29));

        treasurerCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        treasurerCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                treasurerCBActionPerformed(evt);
            }
        });
        getContentPane().add(treasurerCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 185, 35));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, 130, 80));

        presidentCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        presidentCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presidentCBActionPerformed(evt);
            }
        });
        getContentPane().add(presidentCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 185, 35));

        jLabel9.setFont(new java.awt.Font("Courier New", 1, 24)); 
        jLabel9.setText("Your Choices");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel10.setText("jLabel8");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, 130, 80));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel11.setText("jLabel8");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, 130, 80));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel12.setText("jLabel8");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 360, 130, 80));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel13.setText("jLabel8");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 490, 130, 80));

        jLabel14.setFont(new java.awt.Font("Courier New", 1, 24)); 
        jLabel14.setText("Treasurer");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        jLabel15.setFont(new java.awt.Font("Courier New", 1, 24)); 
        jLabel15.setText("Vice PRESIDENT");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, -1, -1));

        vicepresidentCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        vicepresidentCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vicepresidentCBActionPerformed(evt);
            }
        });
        getContentPane().add(vicepresidentCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 185, 35));

        secretaryCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        secretaryCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secretaryCBActionPerformed(evt);
            }
        });
        getContentPane().add(secretaryCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 185, 35));

        jLabel16.setFont(new java.awt.Font("Courier New", 1, 24)); 
        jLabel16.setText("Auditor");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, -1, -1));

        auditorCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        auditorCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                auditorCBActionPerformed(evt);
            }
        });
        getContentPane().add(auditorCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 185, 35));

        jLabel17.setFont(new java.awt.Font("Courier New", 1, 24)); 
        jLabel17.setText("PRESIDENT");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        pioCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        pioCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pioCBActionPerformed(evt);
            }
        });
        getContentPane().add(pioCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, 185, 35));

        jLabel18.setFont(new java.awt.Font("Courier New", 1, 24)); 
        jLabel18.setText("P.I.O");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 500, 130, 60));

        pack();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
  
        String prs = presidentCB.getSelectedItem().toString();
        String updatePres = "UPDATE candidate SET points = points + 1 WHERE candidate_name ='"+prs+"' ";
        if (presidentCB.getSelectedItem().toString().equals(prs)){
    
            try{
                Connection con = getConnection();
                Statement state;          
                state =con.prepareStatement(updatePres);
                state.execute(updatePres);       
            }
                     
            catch(Exception e) {                             
                JOptionPane.showMessageDialog(null,"Voted wrong!"+e);                           
            }          
        }
        
            String vrs = vicepresidentCB.getSelectedItem().toString();      
            String updateVice = "UPDATE candidate SET points = points + 1 WHERE candidate_name ='"+vrs+"' ";
                
            if (vicepresidentCB.getSelectedItem()==vrs){                      
                    try{           
                        Connection con = getConnection();                       
                        Statement state;    
                        state =con.prepareStatement(updateVice);    
                        state.execute(updateVice);                     
                    }                    
                    catch(Exception e) {                  
                        JOptionPane.showMessageDialog(null,"Voted wrong!"+e);
                   }                      
            }
             
            String ids=idreceive.getText();
            String updateid="Yes";
            String voters ="UPDATE account SET status = '"+updateid+"' WHERE id_number ='"+ids+"' ";
        
            try{               
                Connection con = getConnection();        
                Statement stateid;         
                stateid =con.prepareStatement(voters);      
                stateid.execute(voters);        
            }        
            catch(Exception e){                     
            }    
     
            String sec = secretaryCB.getSelectedItem().toString(); 
            String updateSec = "UPDATE candidate SET points = points + 1 WHERE candidate_name ='"+sec+"' "; 
            if (secretaryCB.getSelectedItem()==sec){   
                try{        
                    Connection con = getConnection();
                    Statement state;    
                    state =con.prepareStatement(updateSec);       
                    state.execute(updateSec);          
                }          
                catch(Exception e) {                   
                    JOptionPane.showMessageDialog(null,"Voted wrong!"+e);                   
                }                    
            }
   
            String tres = treasurerCB.getSelectedItem().toString(); 
            String updateTres = "UPDATE candidate SET points = points + 1 WHERE candidate_name ='"+tres+"' "; 
            if (treasurerCB.getSelectedItem()==tres){
    
                try{        
                    Connection con = getConnection(); 
                    Statement state;     
                    state =con.prepareStatement(updateTres);    
                    state.execute(updateTres);          
                }                     
                catch(Exception e) {                  
                    JOptionPane.showMessageDialog(null,"Voted wrong!"+e);                  
                }          
            }
                   
            String aud = auditorCB.getSelectedItem().toString();                     
            String updateAud = "UPDATE candidate SET points = points + 1 WHERE candidate_name ='"+aud+"' ";             
            if (auditorCB.getSelectedItem()==aud){    
                try{        
                    Connection con = getConnection(); 
                    Statement state;                  
                    state =con.prepareStatement(updateAud);        
                    state.execute(updateAud);          
                }                     
                catch(Exception e) {                   
                    JOptionPane.showMessageDialog(null,"Voted wrong!"+e);                   
                }           
            }
                      
            String pio = pioCB.getSelectedItem().toString();                
            String updatePio = "UPDATE candidate SET points = points + 1 WHERE candidate_name ='"+pio+"' ";                       
            if (pioCB.getSelectedItem()==pio){    
                try{       
                    Connection con = getConnection(); 
                    Statement state;  
                    state =con.prepareStatement(updatePio);      
                    state.execute(updatePio);         
                }                   
                catch(Exception e) {        
                    JOptionPane.showMessageDialog(null,"Voted wrong!"+e);          
                }                    
            }
                       
            String id = idreceive.getText().toString();                 
            Connection con = getConnection();                  
            try{                      
                String status="yes";       
                String search ="select student_name from account where id_number='"+id+"'";       
                String updtestudentid ="UPDATE account set status='"+status+"'   where id_number='"+id+"'  "; 
                String updateTime = "UPDATE account set dt= now() where id_number='"+id+"'  ";                             
                Statement searchst = con.createStatement();      
                ResultSet setthis = searchst.executeQuery(search);                  
                Statement stupdate = con.createStatement();       
                stupdate.executeUpdate(updtestudentid);

                Statement dtupdate = con.createStatement();
                dtupdate.executeUpdate(updateTime);                                            
            }
            catch(Exception e){               
                JOptionPane.showMessageDialog(null,"Wrong vote!");    
                setVisible(false);                     
            }            
            JOptionPane.showMessageDialog(null,"Thank you For Voting");      
            setVisible(false);     
            mainmenu info = new mainmenu();
            info.setVisible(true);
    }

   
    private void presidentCBActionPerformed(java.awt.event.ActionEvent evt) {
        String x = presidentCB.getSelectedItem().toString();
        jLabel8.setText(x);
    }

    private void treasurerCBActionPerformed(java.awt.event.ActionEvent evt) {
        String x = treasurerCB.getSelectedItem().toString();
        jLabel12.setText(x);
    }

    private void vicepresidentCBActionPerformed(java.awt.event.ActionEvent evt) {
        String x = vicepresidentCB.getSelectedItem().toString();
        jLabel10.setText(x);
    }

    private void secretaryCBActionPerformed(java.awt.event.ActionEvent evt) {
        String x = secretaryCB.getSelectedItem().toString();
        jLabel11.setText(x);
    }

    private void auditorCBActionPerformed(java.awt.event.ActionEvent evt) {
        String x = auditorCB.getSelectedItem().toString();
        jLabel13.setText(x);
    }

    private void pioCBActionPerformed(java.awt.event.ActionEvent evt) {
        String x = pioCB.getSelectedItem().toString();
        jLabel2.setText(x);
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
            java.util.logging.Logger.getLogger(voting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(voting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(voting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(voting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new voting().setVisible(true);
            }
        });
    }

    private javax.swing.ButtonGroup PresidentGroup;
    private javax.swing.ButtonGroup VicePresidentGroup;
    private javax.swing.JComboBox<String> auditorCB;
    private javax.swing.JTextField idreceive;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> pioCB;
    private javax.swing.JComboBox<String> presidentCB;
    private javax.swing.JComboBox<String> secretaryCB;
    private javax.swing.JComboBox<String> treasurerCB;
    private javax.swing.JComboBox<String> vicepresidentCB;
}
