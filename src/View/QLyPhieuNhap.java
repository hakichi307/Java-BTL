/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.java to edit this template
 */
package View;

import ConnectDatabase.Connect;
import DAO.*;
import Entity.*;
import Entity.Users;
import static ExportExcel.ExportExcel.exportExcel;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author MRSTHAO
 */
public class QLyPhieuNhap extends javax.swing.JFrame {

    /**
     * Creates new form QLyPhieuNhap
     */
    public void JTable_ConnectDb(){
        try {
            String query = "SELECT *"
                    + " FROM phieunhap "
                    + " INNER JOIN users ON phieunhap.userId = users.id ";
            Connection cnt = Connect.getConnection();
            Statement stm = cnt.createStatement();
            ResultSet rs = stm.executeQuery(query);
            DefaultTableModel model=(DefaultTableModel) PhieuNhap_Table.getModel(); //tạo liên kết model với User_Table
            // hoặc sau khi gán cho model thì có thể User_Table.setModel(model);
            while (rs.next()){
                Object objList[] = {
                    rs.getInt("id"),
                    rs.getDate("dateIn")+" | "+rs.getTime("dateIn"),
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
        IdPhieuNhap_TextField.setText("");
        Date date = new Date();
        SimpleDateFormat datesf = new SimpleDateFormat("yyyy/MM/dd");
        DateIn_TextField.setText(datesf.format(date));
        SimpleDateFormat timesf = new SimpleDateFormat("HH:mm:ss");
        Time_TextField.setText(timesf.format(date));
        //Remove all row of jtable and connect again;
        DefaultTableModel dm = (DefaultTableModel) PhieuNhap_Table.getModel();
        int rowCount = dm.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
        
        JTable_ConnectDb();
    }
    
    
    public QLyPhieuNhap() {
        initComponents();
    }
    String user_used;
    QLyPhieuNhap(String username_used){
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PhieuNhap_Table = new javax.swing.JTable();
        IdPhieuNhap_TextField = new javax.swing.JTextField();
        DateIn_TextField = new javax.swing.JTextField();
        UserName_TextField = new javax.swing.JTextField();
        Insert_Button = new javax.swing.JButton();
        Select_Button = new javax.swing.JButton();
        Delete_Button = new javax.swing.JButton();
        Search_Button = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Month_TextField = new javax.swing.JTextField();
        Year_TextField = new javax.swing.JTextField();
        MesId_Label = new javax.swing.JLabel();
        MesM_Label = new javax.swing.JLabel();
        MesY_Label = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Time_TextField = new javax.swing.JTextField();
        SearchByMY_Button = new javax.swing.JButton();
        Reload_Button = new javax.swing.JButton();
        Excel_Button = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("NHẬP HÀNG");

        jLabel2.setText("Mã phiếu nhập");

        jLabel3.setText("Ngày nhập");

        jLabel5.setText("Người nhập");

        PhieuNhap_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phiếu nhập", "Ngày nhập", "Người nhập", "Tổng tiền hàng"
            }
        ));
        jScrollPane1.setViewportView(PhieuNhap_Table);

        IdPhieuNhap_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                IdPhieuNhap_TextFieldKeyPressed(evt);
            }
        });

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

        Delete_Button.setText("Xóa");
        Delete_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_ButtonActionPerformed(evt);
            }
        });

        Search_Button.setText("Tìm");
        Search_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_ButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Tháng");

        jLabel7.setText("Năm");

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

        MesId_Label.setText("    ");

        MesM_Label.setText("    ");

        MesY_Label.setText("    ");

        jLabel8.setText("Thời gian");

        Time_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Time_TextFieldActionPerformed(evt);
            }
        });

        SearchByMY_Button.setText("Lọc");
        SearchByMY_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchByMY_ButtonActionPerformed(evt);
            }
        });

        Reload_Button.setText("Reload");
        Reload_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reload_ButtonActionPerformed(evt);
            }
        });

        Excel_Button.setText("Xuất báo cáo");
        Excel_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Excel_ButtonActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(Insert_Button)
                        .addGap(70, 70, 70)
                        .addComponent(Select_Button)
                        .addGap(72, 72, 72)
                        .addComponent(Delete_Button)
                        .addGap(72, 72, 72)
                        .addComponent(Reload_Button)
                        .addGap(73, 73, 73)
                        .addComponent(Excel_Button))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(385, 385, 385)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(UserName_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Time_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DateIn_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addComponent(jLabel7))
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Month_TextField)
                                            .addComponent(Year_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(89, 89, 89)
                                            .addComponent(IdPhieuNhap_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(MesId_Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(MesM_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(MesY_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Search_Button)
                                    .addComponent(SearchByMY_Button))
                                .addGap(2, 2, 2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)))))
                .addGap(0, 36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IdPhieuNhap_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(Search_Button)
                            .addComponent(MesId_Label))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(MesM_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(MesY_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(SearchByMY_Button)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Month_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(Year_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(255, 255, 255))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Insert_Button)
                                    .addComponent(Select_Button)
                                    .addComponent(Delete_Button)
                                    .addComponent(Reload_Button)
                                    .addComponent(Excel_Button))
                                .addContainerGap(28, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DateIn_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(Time_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(UserName_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
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

    private void Insert_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Insert_ButtonActionPerformed
        // TODO add your handling code here:
        if(!DateIn_TextField.getText().equals("")
            ||Time_TextField.getText().equals(""))
        {   
            //auto get next id
            int id = -1;
            String queryId = "SELECT MAX(id) FROM phieunhap";
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

            String dateIn = DateIn_TextField.getText()+" "+Time_TextField.getText();
            
            float sumPayment = 0;

            String userName = UserName_TextField.getText();
            Users user = UserDAO.getUserByUserName(userName);
            int userId = user.getId();
            
            //
            int rs = PhieuNhapDAO.insert(id,dateIn,sumPayment,userId);
            if (1 == rs)
                JOptionPane.showMessageDialog(null,"Thêm thành công !");
            else 
                JOptionPane.showMessageDialog(null,"Lỗi");
            Reload_View();
            
        } 
        else JOptionPane.showMessageDialog(null,"Vui lòng nhập đủ thông tin"); 
    }//GEN-LAST:event_Insert_ButtonActionPerformed

    private void Search_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search_ButtonActionPerformed
        // TODO add your handling code here:
        if(IdPhieuNhap_TextField.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Vui lòng nhập mã phiếu");
        }
        else {
            int id = Integer.parseInt(IdPhieuNhap_TextField.getText());
            
            //Xóa bảng
            DefaultTableModel dm = (DefaultTableModel) PhieuNhap_Table.getModel();
            int rowCount = dm.getRowCount();
            //Remove rows one by one from the end of the table
            for (int i = rowCount - 1; i >= 0; i--) {
                dm.removeRow(i);
            }
            
            //hiển thị dữ liệu
            try {
                String query = "SELECT *"
                        + " FROM phieunhap "
                        + " INNER JOIN users ON phieunhap.userId = users.id "
                        + "WHERE phieunhap.id = "+id;
                Connection cnt = Connect.getConnection();
                Statement stm = cnt.createStatement();
                ResultSet rs = stm.executeQuery(query);
                DefaultTableModel model=(DefaultTableModel) PhieuNhap_Table.getModel();
                while (rs.next()){
                    Object objList[] = {
                        rs.getInt("id"),
                        rs.getDate("dateIn")+" | "+rs.getTime("dateIn"),
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

    private void Time_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Time_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Time_TextFieldActionPerformed

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
            DefaultTableModel dm = (DefaultTableModel) PhieuNhap_Table.getModel();
            int rowCount = dm.getRowCount();
            //Remove rows one by one from the end of the table
            for (int i = rowCount - 1; i >= 0; i--) {
                dm.removeRow(i);
            }
            
            //hiển thị dữ liệu
            try {
                String query = "SELECT *"
                        + " FROM phieunhap "
                        + " INNER JOIN users ON phieunhap.userId = users.id "
                        + "WHERE MONTH(dateIn) = "+m+" AND YEAR(dateIn) = "+y;
                Connection cnt = Connect.getConnection();
                Statement stm = cnt.createStatement();
                ResultSet rs = stm.executeQuery(query);
                DefaultTableModel model=(DefaultTableModel) PhieuNhap_Table.getModel();
                while (rs.next()){
                    Object objList[] = {
                        rs.getInt("id"),
                        rs.getDate("dateIn")+" | "+rs.getTime("dateIn"),
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

    private void IdPhieuNhap_TextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IdPhieuNhap_TextFieldKeyPressed
        // TODO add your handling code here:
        String value = IdPhieuNhap_TextField.getText();
        MesId_Label.setForeground(Color.RED);
        int l = value.length();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'|| evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            IdPhieuNhap_TextField.setEditable(true);
            MesId_Label.setText("");
        } else {
            IdPhieuNhap_TextField.setEditable(false);
            MesId_Label.setText("Chỉ nhập số(0-9)");
        }
    }//GEN-LAST:event_IdPhieuNhap_TextFieldKeyPressed

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

    private void Reload_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reload_ButtonActionPerformed
        // TODO add your handling code here:
        Reload_View();
    }//GEN-LAST:event_Reload_ButtonActionPerformed

    private void Delete_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_ButtonActionPerformed
        // TODO add your handling code here:
        int yes_no = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn không ?","Xác nhận xóa",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(yes_no == JOptionPane.YES_OPTION){
            if(!PhieuNhap_Table.getSelectionModel().isSelectionEmpty()){ 
                int i = PhieuNhap_Table.getSelectedRow();
                TableModel model = PhieuNhap_Table.getModel();
                int id =(int) model.getValueAt(i, 0);
                PhieuNhap pn = PhieuNhapDAO.getById(id);
                if(pn != null){
                    int rs = PhieuNhapDAO.deleteById(id);
                    if (1 == rs)
                        JOptionPane.showMessageDialog(null,"Xóa thành công !");
                    else 
                        JOptionPane.showMessageDialog(null,"Lỗi");
                    Reload_View();
                }else JOptionPane.showMessageDialog(null,"Ko tìm thấy phiếu nhập mã id:"+id);

            }else JOptionPane.showMessageDialog(null,"Vui lòng chọn phiếu"); 
        }                                   
    }//GEN-LAST:event_Delete_ButtonActionPerformed

    private void Select_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Select_ButtonActionPerformed
        // TODO add your handling code here:
        if(!PhieuNhap_Table.getSelectionModel().isSelectionEmpty()){ 
            int i = PhieuNhap_Table.getSelectedRow();
            TableModel model = PhieuNhap_Table.getModel();
            int id =(int) model.getValueAt(i, 0);
            PhieuNhap pn = PhieuNhapDAO.getById(id);
            if(pn != null){
                Nhap_SanPham NhapSP_View = new Nhap_SanPham(id);
                NhapSP_View.setVisible(rootPaneCheckingEnabled);
                NhapSP_View.setDefaultCloseOperation(HIDE_ON_CLOSE);
            }else JOptionPane.showMessageDialog(null,"Ko tìm thấy phiếu nhập mã id:"+id);
            
        }else JOptionPane.showMessageDialog(null,"Vui lòng chọn phiếu");
    }//GEN-LAST:event_Select_ButtonActionPerformed

    private void Excel_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Excel_ButtonActionPerformed
        // TODO add your handling code here:
        exportExcel(PhieuNhap_Table);
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
            java.util.logging.Logger.getLogger(QLyPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLyPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLyPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLyPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLyPhieuNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DateIn_TextField;
    private javax.swing.JButton Delete_Button;
    private javax.swing.JButton Excel_Button;
    private javax.swing.JTextField IdPhieuNhap_TextField;
    private javax.swing.JButton Insert_Button;
    private javax.swing.JLabel MesId_Label;
    private javax.swing.JLabel MesM_Label;
    private javax.swing.JLabel MesY_Label;
    private javax.swing.JTextField Month_TextField;
    private javax.swing.JTable PhieuNhap_Table;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

}
