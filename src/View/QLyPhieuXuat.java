/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.java to edit this template
 */
package View;

import DAO.*;
import Entity.*;
import ConnectDatabase.Connect;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.*;
import java.util.Date;
import static ExportExcel.ExportExcel.exportExcel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author MRSTHAO
 */
public class QLyPhieuXuat extends javax.swing.JFrame {

    /**
     * Creates new form NewApplication
     */
    public void JTable_ConnectDb(){
        try {
            String query = "SELECT *"
                    + " FROM phieuxuat "
                    + " INNER JOIN users ON phieuxuat.userId = users.id ";
            Connection cnt = Connect.getConnection();
            Statement stm = cnt.createStatement();
            ResultSet rs = stm.executeQuery(query);
            DefaultTableModel model=(DefaultTableModel) PhieuXuat_Table.getModel(); //tạo liên kết model với User_Table
            // hoặc sau khi gán cho model thì có thể User_Table.setModel(model);
            while (rs.next()){
                Object objList[] = {
                    rs.getInt("id"),
                    rs.getDate("dateOut")+" | "+rs.getTime("dateOut"),
                    rs.getString("fullname"),
                    rs.getInt("sumPayment")
                };
                model.addRow(objList);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void Reload_View(){
        IdPhieuXuat_TextField.setText("");
        Date date = new Date();
        SimpleDateFormat datesf = new SimpleDateFormat("yyyy/MM/dd");
        DateOut_TextField.setText(datesf.format(date));
        SimpleDateFormat timesf = new SimpleDateFormat("HH:mm:ss");
        Time_TextField.setText(timesf.format(date));
        
        //Remove all row of jtable and connect again;
        DefaultTableModel dm = (DefaultTableModel) PhieuXuat_Table.getModel();
        int rowCount = dm.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
        
        JTable_ConnectDb();
    }
    
    public QLyPhieuXuat() {
        initComponents();
        Reload_View();
    }
    String user_used;
    QLyPhieuXuat(String username_used){
        initComponents();
        this.user_used = username_used;
        UserName_TextField.setText(user_used);
        UserName_TextField.setEnabled(false);
        Reload_View();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        DateOut_TextField = new javax.swing.JTextField();
        UserName_TextField = new javax.swing.JTextField();
        IdPhieuXuat_TextField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        PhieuXuat_Table = new javax.swing.JTable();
        Insert_Button = new javax.swing.JButton();
        Select_Button = new javax.swing.JButton();
        Excel_Button = new javax.swing.JButton();
        Search_Button = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        SearchByMY_Button = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Time_TextField = new javax.swing.JTextField();
        Month_TextField = new javax.swing.JTextField();
        Year_TextField = new javax.swing.JTextField();
        Delete_Button = new javax.swing.JButton();
        Reload_Button = new javax.swing.JButton();
        MesId_Label = new javax.swing.JLabel();
        MesM_Label = new javax.swing.JLabel();
        MesY_Label = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("XUẤT HÀNG");

        jLabel4.setText("Mã phiếu xuất");

        jLabel10.setText("Ngày xuất");

        jLabel11.setText("Người xuất");

        DateOut_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateOut_TextFieldActionPerformed(evt);
            }
        });

        IdPhieuXuat_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdPhieuXuat_TextFieldActionPerformed(evt);
            }
        });
        IdPhieuXuat_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                IdPhieuXuat_TextFieldKeyPressed(evt);
            }
        });

        PhieuXuat_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phiếu xuất", "Ngày xuất", "Người xuất", "Tổng tiền hàng"
            }
        ));
        PhieuXuat_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PhieuXuat_TableMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PhieuXuat_TableMouseExited(evt);
            }
        });
        jScrollPane3.setViewportView(PhieuXuat_Table);

        Insert_Button.setText("Thêm");
        Insert_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Insert_ButtonActionPerformed(evt);
            }
        });

        Select_Button.setText("Xem");
        Select_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Select_ButtonActionPerformed(evt);
            }
        });

        Excel_Button.setText("Xuất báo cáo");
        Excel_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Excel_ButtonActionPerformed(evt);
            }
        });

        Search_Button.setText("Tìm");
        Search_Button.setToolTipText("");
        Search_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_ButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Tháng");

        jLabel3.setText("Năm");

        SearchByMY_Button.setText("Lọc");
        SearchByMY_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchByMY_ButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Thời gian");

        Month_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Month_TextFieldKeyPressed(evt);
            }
        });

        Year_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Year_TextFieldKeyPressed(evt);
            }
        });

        Delete_Button.setText("Xóa");
        Delete_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_ButtonActionPerformed(evt);
            }
        });

        Reload_Button.setText("Reload");
        Reload_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reload_ButtonActionPerformed(evt);
            }
        });

        MesId_Label.setText("     ");

        MesM_Label.setText("        ");

        MesY_Label.setText("       ");

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentsMenuItem.setMnemonic('c');
        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel5))
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(DateOut_TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                    .addComponent(Time_TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                    .addComponent(UserName_TextField)))
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Year_TextField)
                            .addComponent(IdPhieuXuat_TextField)
                            .addComponent(Month_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MesM_Label)
                            .addComponent(MesY_Label)
                            .addComponent(MesId_Label))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Search_Button))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(SearchByMY_Button)))
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(315, 315, 315)
                                .addComponent(jLabel1)))
                        .addContainerGap(39, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(Insert_Button)
                .addGap(64, 64, 64)
                .addComponent(Select_Button)
                .addGap(58, 58, 58)
                .addComponent(Delete_Button)
                .addGap(80, 80, 80)
                .addComponent(Reload_Button)
                .addGap(73, 73, 73)
                .addComponent(Excel_Button)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(DateOut_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(Time_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(UserName_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IdPhieuXuat_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(MesId_Label)
                            .addComponent(Search_Button))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Month_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MesM_Label))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Year_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MesY_Label)
                            .addComponent(SearchByMY_Button))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Insert_Button)
                    .addComponent(Select_Button)
                    .addComponent(Delete_Button)
                    .addComponent(Excel_Button)
                    .addComponent(Reload_Button))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        int yes_no = JOptionPane.showConfirmDialog(this, "Thoát chương trình ?","Thoát",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(yes_no == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void IdPhieuXuat_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdPhieuXuat_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdPhieuXuat_TextFieldActionPerformed

    private void Select_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Select_ButtonActionPerformed
        // TODO add your handling code here:
        if(!PhieuXuat_Table.getSelectionModel().isSelectionEmpty()){ 
            int i = PhieuXuat_Table.getSelectedRow();
            TableModel model = PhieuXuat_Table.getModel();
            int id =(int) model.getValueAt(i, 0);
            PhieuXuat px = PhieuXuatDAO.getById(id);
            if(px != null){
                Xuat_SanPham XuatSP_View = new Xuat_SanPham(id);
                XuatSP_View.setVisible(rootPaneCheckingEnabled);
                XuatSP_View.setDefaultCloseOperation(HIDE_ON_CLOSE);
            }else JOptionPane.showMessageDialog(null,"Ko tìm thấy phiếu xuất mã id:"+id);
            
        }else JOptionPane.showMessageDialog(null,"Vui lòng chọn phiếu");
        
    }//GEN-LAST:event_Select_ButtonActionPerformed

    private void DateOut_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateOut_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateOut_TextFieldActionPerformed

    private void Insert_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Insert_ButtonActionPerformed
        // TODO add your handling code here:
        if(!DateOut_TextField.getText().equals("")
            ||Time_TextField.getText().equals(""))
        {
            int id = -1;
            String queryId = "SELECT MAX(id) FROM phieuxuat";
            try {
                Connection cnt = Connect.getConnection();
                Statement stm = cnt.createStatement();
                ResultSet rs = stm.executeQuery(queryId);
                while(rs.next()){
                    id = rs.getInt("MAX(id)");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            id++;

            String dateOut = DateOut_TextField.getText()+" "+Time_TextField.getText();
            
            float sumPayment = 0;

            String userName = UserName_TextField.getText();
            Users user = UserDAO.getUserByUserName(userName);
            int userId = user.getId();
            
            int rs = PhieuXuatDAO.insert(id,dateOut,sumPayment,userId);
            if (1 == rs)
                JOptionPane.showMessageDialog(null,"Thêm thành công !");
            else 
                JOptionPane.showMessageDialog(null,"Lỗi");
            Reload_View();
        } 
        else JOptionPane.showMessageDialog(null,"Vui lòng nhập đủ thông tin");   
    }//GEN-LAST:event_Insert_ButtonActionPerformed

    private void PhieuXuat_TableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PhieuXuat_TableMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_PhieuXuat_TableMouseExited

    private void PhieuXuat_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PhieuXuat_TableMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_PhieuXuat_TableMouseClicked

    private void Delete_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_ButtonActionPerformed
        // TODO add your handling code here:
        int yes_no = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn không ?","Xác nhận xóa",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(yes_no == JOptionPane.YES_OPTION){
            if(!PhieuXuat_Table.getSelectionModel().isSelectionEmpty()){ 
                int i = PhieuXuat_Table.getSelectedRow();
                TableModel model = PhieuXuat_Table.getModel();
                int id =(int) model.getValueAt(i, 0);
                PhieuXuat px = PhieuXuatDAO.getById(id);
                if(px != null){
                    int rs = PhieuXuatDAO.deleteById(id);
                    if (1 == rs)
                        JOptionPane.showMessageDialog(null,"Xóa thành công !");
                    else 
                        JOptionPane.showMessageDialog(null,"Lỗi");
                    Reload_View();
                }else JOptionPane.showMessageDialog(null,"Ko tìm thấy phiếu xuất mã id:"+id);

            }else JOptionPane.showMessageDialog(null,"Vui lòng chọn phiếu");
        }
    }//GEN-LAST:event_Delete_ButtonActionPerformed
    // Nút reload
    private void Reload_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reload_ButtonActionPerformed
            // TODO add your handling code here:
        Reload_View();
    }//GEN-LAST:event_Reload_ButtonActionPerformed

    private void Search_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search_ButtonActionPerformed
        // TODO add your handling code here:
        if(IdPhieuXuat_TextField.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Vui lòng nhập mã phiếu");
        }
        else {
            int id = Integer.parseInt(IdPhieuXuat_TextField.getText());
            
            //Xóa bảng
            DefaultTableModel dm = (DefaultTableModel) PhieuXuat_Table.getModel();
            int rowCount = dm.getRowCount();
            //Remove rows one by one from the end of the table
            for (int i = rowCount - 1; i >= 0; i--) {
                dm.removeRow(i);
            }
            
            //hiển thị dữ liệu
            try {
                String query = "SELECT *"
                        + " FROM phieuxuat "
                        + " INNER JOIN users ON phieuxuat.userId = users.id "
                        + "WHERE phieuxuat.id = "+id;//maPhieuXuat
                Connection cnt = Connect.getConnection();
                Statement stm = cnt.createStatement();
                ResultSet rs = stm.executeQuery(query);
                DefaultTableModel model=(DefaultTableModel) PhieuXuat_Table.getModel(); //tạo liên kết model với User_Table
                // hoặc sau khi gán cho model thì có thể User_Table.setModel(model);
                while (rs.next()){
                    Object objList[] = {
                        rs.getInt("id"),
                        rs.getDate("dateOut")+" | "+rs.getTime("dateOut"),
                        rs.getString("fullname"),
                        rs.getInt("sumPayment")
                    };
                    model.addRow(objList);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        }
    }//GEN-LAST:event_Search_ButtonActionPerformed

    private void SearchByMY_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchByMY_ButtonActionPerformed
        // TODO add your handling code here:
        if(Month_TextField.getText().equals("") || Year_TextField.getText().equals("") ){
            JOptionPane.showMessageDialog(null,"Vui lòng nhập vào dòng tháng năm");
        }
        else {            
            int m = Integer.parseInt(Month_TextField.getText());
            if(m == 0 || m>12) JOptionPane.showMessageDialog(null,"Tháng từ 1->12");
            int y = Integer.parseInt(Year_TextField.getText());
            
            //Xóa bảng
            DefaultTableModel dm = (DefaultTableModel) PhieuXuat_Table.getModel();
            int rowCount = dm.getRowCount();
            //Remove rows one by one from the end of the table
            for (int i = rowCount - 1; i >= 0; i--) {
                dm.removeRow(i);
            }
            
            //hiển thị dữ liệu
            try {
                String query = "SELECT *"
                        + " FROM phieuxuat "
                        + " INNER JOIN users ON phieuxuat.userId = users.id "
                        + "WHERE MONTH(dateOut) = "+m+" AND YEAR(dateOut) = "+y;
                Connection cnt = Connect.getConnection();
                Statement stm = cnt.createStatement();
                ResultSet rs = stm.executeQuery(query);
                DefaultTableModel model=(DefaultTableModel) PhieuXuat_Table.getModel(); //tạo liên kết model với User_Table
                // hoặc sau khi gán cho model thì có thể User_Table.setModel(model);
                while (rs.next()){
                    Object objList[] = {
                        rs.getInt("id"),
                        rs.getDate("dateOut")+" | "+rs.getTime("dateOut"),
                        rs.getString("fullname"),
                        rs.getInt("sumPayment")
                    };
                    model.addRow(objList);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        }
    }//GEN-LAST:event_SearchByMY_ButtonActionPerformed

    private void IdPhieuXuat_TextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IdPhieuXuat_TextFieldKeyPressed
        // TODO add your handling code here:
        String value = IdPhieuXuat_TextField.getText();
        MesId_Label.setForeground(Color.RED);
        int l = value.length();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'|| evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            IdPhieuXuat_TextField.setEditable(true);
            MesId_Label.setText("");
        } else {
            IdPhieuXuat_TextField.setEditable(false);
            MesId_Label.setText("Chỉ nhập số(0-9)");
        }
    }//GEN-LAST:event_IdPhieuXuat_TextFieldKeyPressed

    private void Month_TextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Month_TextFieldKeyPressed
        // TODO add your handling code here:
        String value = Month_TextField.getText();
        MesM_Label.setForeground(Color.RED);
        int l = value.length();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9' || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            Month_TextField.setEditable(true);
            MesM_Label.setText("");
        } else {
            Month_TextField.setEditable(false);
            MesM_Label.setText("Chỉ nhập số(0-9)");
        }
    }//GEN-LAST:event_Month_TextFieldKeyPressed

    private void Year_TextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Year_TextFieldKeyPressed
        // TODO add your handling code here:
        String value = Year_TextField.getText();
        MesY_Label.setForeground(Color.RED);
        int l = value.length();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9' || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            Year_TextField.setEditable(true);
            MesY_Label.setText("");
        } else {
            Year_TextField.setEditable(false);
            MesY_Label.setText("Chỉ nhập số(0-9)");
        }
    }//GEN-LAST:event_Year_TextFieldKeyPressed

    private void Excel_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Excel_ButtonActionPerformed
        // TODO add your handling code here:
        exportExcel(PhieuXuat_Table);
    }//GEN-LAST:event_Excel_ButtonActionPerformed
    
    
        
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
            java.util.logging.Logger.getLogger(QLyPhieuXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLyPhieuXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLyPhieuXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLyPhieuXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLyPhieuXuat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DateOut_TextField;
    private javax.swing.JButton Delete_Button;
    private javax.swing.JButton Excel_Button;
    private javax.swing.JTextField IdPhieuXuat_TextField;
    private javax.swing.JButton Insert_Button;
    private javax.swing.JLabel MesId_Label;
    private javax.swing.JLabel MesM_Label;
    private javax.swing.JLabel MesY_Label;
    private javax.swing.JTextField Month_TextField;
    private javax.swing.JTable PhieuXuat_Table;
    private javax.swing.JButton Reload_Button;
    private javax.swing.JButton SearchByMY_Button;
    private javax.swing.JButton Search_Button;
    private javax.swing.JButton Select_Button;
    private javax.swing.JTextField Time_TextField;
    private javax.swing.JTextField UserName_TextField;
    private javax.swing.JTextField Year_TextField;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

}
