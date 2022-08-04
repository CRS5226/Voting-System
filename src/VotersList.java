import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public class VotersList extends javax.swing.JFrame {

    public VotersList() {
        initComponents();
        voters();
        setTitle("Students List");
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
    
    public void voters(){
        
        String sql ="SELECT student_name,status FROM account";
        
        try{        
            Connection con = getConnection();         
            ResultSet Rs;      
            Statement st;       
            st= con.createStatement();
            Rs = st.executeQuery(sql);                     
            voterstable.setModel(DbUtils.resultSetToTableModel(Rs));                   
        }
        catch (Exception e){           
        }                        
    }
    
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        voterstable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        voterstable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        voterstable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                voterstableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(voterstable);

        jButton1.setText("RESET ALL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("RESET");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("BACK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 868, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }

    private void voterstableMouseClicked(java.awt.event.MouseEvent evt) {
        int T = voterstable.getSelectedRow();
        TableModel Model =voterstable.getModel();      
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
                setVisible(false);
                adminmenu info3 = new adminmenu();
                info3.setVisible(true);
                info3.setLocationRelativeTo(null); 
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        String stat="no";    
        String sql ="UPDATE account SET status='"+stat+"'  ";
     
        try{     
            Connection con = getConnection();    
            ResultSet rs;
            Statement st;      
            st = con.createStatement();
            st.executeUpdate(sql);
  
            voters();
  
            if (st==st){     
                JOptionPane.showMessageDialog(null, "all is clear");
 
                voters();  
            }   
            else {   
                JOptionPane.showMessageDialog(null, "all is wrong");        
            }        
        }
        catch(Exception e){        
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
   
        int T = voterstable.getSelectedRow();  
        TableModel Model =voterstable.getModel();
           
        try{                
            String stat="no";                 
            String sql ="UPDATE account SET status='"+stat+"' WHERE student_name = '"+Model.getValueAt(T,0)+"' ";                     
            Connection con = getConnection();      
            Statement st = con.createStatement();       
            st.executeUpdate(sql);
     
            voters();     
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
            java.util.logging.Logger.getLogger(VotersList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VotersList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VotersList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VotersList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VotersList().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable voterstable;
}
