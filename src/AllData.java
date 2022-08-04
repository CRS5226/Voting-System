import java.sql.*;
import javax.swing.*;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public class AllData extends javax.swing.JFrame {

    public AllData() {
        initComponents();
        candidate();
        setTitle("Candidate List");
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
        
    public void candidate(){       
        String sql ="SELECT * FROM candidate";
        
        try{        
            Connection con = getConnection();         
            ResultSet Rs;      
            Statement st;                 
            st= con.createStatement();          
            Rs = st.executeQuery(sql);
            
            candidateTL.setModel(DbUtils.resultSetToTableModel(Rs));            
        }
        catch(Exception e){                  
        }          
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        candidateTL = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        candidateTL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        candidateTL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                candidateTLMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(candidateTL);

        jButton1.setText("Clear All");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("back");
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
                .addGap(155, 155, 155)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        int zero =0;      
        String sql ="UPDATE candidate set points="+zero;

        try{    
            Connection con = getConnection(); 
            ResultSet rs;
            Statement st;   
            st = con.createStatement(); 
            st.executeUpdate(sql);
            candidate();
  
            if (st==st){   
                JOptionPane.showMessageDialog(null, "all is clear");
                candidate(); 
            } 
            else {
                JOptionPane.showMessageDialog(null, "all is wrong");      
            }
        }
        catch(Exception e){
        }
       
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
            setVisible(false);
            adminmenu info1 = new adminmenu();
            info1.setVisible(true);
            info1.setLocationRelativeTo(null); 
    }

    private void candidateTLMouseClicked(java.awt.event.MouseEvent evt) {
        int T = candidateTL.getSelectedRow();
        TableModel Model =candidateTL.getModel();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        int T = candidateTL.getSelectedRow();
        TableModel Model =candidateTL.getModel();
        String pass = null;
       
        try{        
            int zero =0;
            String sql ="UPDATE candidate set points='"+zero+"'  WHERE candidate_id='"+Model.getValueAt(T,0)+"'   ";
            Connection con = getConnection();
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            candidate();    
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
            java.util.logging.Logger.getLogger(AllData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AllData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AllData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AllData().setVisible(true);
            }
        });
    }

    private javax.swing.JTable candidateTL;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
}
