
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class GUIManager extends javax.swing.JFrame 
{

    /**
     * Creates new form GUIManager
     */
    public GUIManager() 
    {
        initComponents();
        lst.setModel(mod);
    }
    
    ArrayList<Customer> c = new ArrayList();
    public DefaultListModel mod = new DefaultListModel();
    public ArrayList<Branch> bCount = new ArrayList();
    public ArrayList<Integer> bNum = new ArrayList();
    
    public void read(String n) throws FileNotFoundException, IOException
    {
        String line = "";
        try
        {
            BufferedReader b = new BufferedReader(new FileReader(n));
            
            while((line = b.readLine()) != null)
            {
                String[] values = line.split(",");

                    long proID = Long.parseLong(values[1]);
                    int proDate = Integer.parseInt(values[7]);
                    double proAm = Double.parseDouble(values[8]);

                
                Product temp = new Product(proID, values[2], values[6], proDate, proAm);
                Customer cust = new Customer(Long.parseLong(values[0]), values[3], Integer.parseInt(values[5]), temp);
                c.add(cust);
                Branch bran = new Branch(values[4], cust.branchNum);
                if(bNum.contains(bran.number))
                {
                    int y = bNum.indexOf(bran.number);
                    bCount.get(y).add(cust);
                    
                }
                else
                {
                    bCount.add(bran);
                    bNum.add(bran.number);
                    bran.add(cust);
                    mod.addElement("Branch " + bran.number);
                }
            }
            
                        
        }
        catch(FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(rootPane, "No Such File Exists");
            e.printStackTrace();
        }
    }
    
    
    public void write(Long custID, Long pID, String pName, String n, String l, int num , String date, int dO, double am, String path) throws IOException
    {
        try
        {
            FileWriter fw = new FileWriter(path,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(Long.toString(custID) + "," + Long.toString(pID) + "," + pName  + "," + n + "," + l + "," + Integer.toString(num) + "," + date + "," + Integer.toString(dO) + "," + Double.toString(am));
            
            pw.flush();
            pw.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, "An Error Has Occurred"); 
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnAddBranch = new javax.swing.JButton();
        btnRemoveBranch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lst = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        btnAccessBranch = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        btnCSV = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setText("Database");

        btnAddBranch.setText("Add Branch");
        btnAddBranch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBranchActionPerformed(evt);
            }
        });

        btnRemoveBranch.setText("Remove Selected Branch");
        btnRemoveBranch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveBranchActionPerformed(evt);
            }
        });

        lst.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Branch 1", "Branch 2" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lst.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(lst);

        jLabel2.setText("Select a branch to access:");

        btnAccessBranch.setText("Access Selected Branch");
        btnAccessBranch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccessBranchActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnLoad.setText("Load Data");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        btnCSV.setText("Write CSV");
        btnCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCSVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnLoad)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnCSV))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(jLabel2))
                                    .addComponent(btnAccessBranch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnRemoveBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAddBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnClose)
                        .addGap(80, 80, 80))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(btnAccessBranch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemoveBranch)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddBranch))
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClose)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLoad)
                        .addComponent(btnCSV)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAccessBranchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccessBranchActionPerformed
        // TODO add your handling code here:
        String s = lst.getSelectedValuesList().toString();
        int i = lst.getSelectedIndex();
        if(i == -1)
        {
            JOptionPane.showMessageDialog(rootPane, "No Branch Selected");
        }
        else
        {
            
            BranchEditor be = new BranchEditor(bCount.get(i), c);
            be.setVisible(true);
        }
    }//GEN-LAST:event_btnAccessBranchActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        System.exit(0);
        
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        // TODO add your handling code here:
        String fileName = JOptionPane.showInputDialog("Enter File Name:");
        try {
            read(fileName);
        } catch (IOException ex) {
            Logger.getLogger(GUIManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnRemoveBranchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveBranchActionPerformed
        // TODO add your handling code here:
        String s = lst.getSelectedValuesList().toString();
        int i = lst.getSelectedIndex();
        if(i == -1)
        {
            JOptionPane.showMessageDialog(rootPane, "No Branch Selected");
        }
        else
        {
            
            int x = bNum.get(i);
            System.out.println(x);
            bNum.remove(i);
            bCount.remove(i);
            for(int  k = 0; k < c.size(); k++)
            {
                if(c.get(k).branchNum == x)
                {
                    c.remove(k);
                }
            }
            mod.remove(i);
        }
    }//GEN-LAST:event_btnRemoveBranchActionPerformed

    private void btnAddBranchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBranchActionPerformed
        // TODO add your handling code here:
        String loc = JOptionPane.showInputDialog("Enter Branch Location:");
        String iDen = JOptionPane.showInputDialog("Enter Branch Number:");
        int num = Integer.parseInt(iDen);
        if(bNum.contains(num))
        {
            JOptionPane.showMessageDialog(rootPane, "A Branch With That ID Number Already Exists");
        }
        else
        {
            Branch temp = new Branch(loc, num);
            mod.addElement("Branch " + temp.number);
            bNum.add(temp.number);
            bCount.add(temp);
        }
    }//GEN-LAST:event_btnAddBranchActionPerformed

    private void btnCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCSVActionPerformed
        // TODO add your handling code here:
        if(c.size() > 0)
        {
            String in = JOptionPane.showInputDialog("Enter New File Path:");
            System.out.println(bCount.size());
            System.out.println(bNum.size());
            int p = 0;
            for(int k = 0; k < c.size(); k++)
            {

                Customer temp = c.get(k);


                p = bNum.indexOf((temp.branchNum));
                Branch t;
                if(p != -1)
                {
                    t = bCount.get(p);
                

                    try {
                        write(temp.number, temp.card.number, temp.card.name, temp.nationality, t.location , temp.branchNum, temp.card.openDate, temp.card.overDue, temp.card.amount, in );
                    } catch (IOException ex) {
                        Logger.getLogger(GUIManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
                
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Database Is empty");
        }
        
    }//GEN-LAST:event_btnCSVActionPerformed

    public static void main(String args[]) 
    {
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
            java.util.logging.Logger.getLogger(GUIManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() 
            {
                new GUIManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccessBranch;
    private javax.swing.JButton btnAddBranch;
    private javax.swing.JButton btnCSV;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnRemoveBranch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lst;
    // End of variables declaration//GEN-END:variables
}
