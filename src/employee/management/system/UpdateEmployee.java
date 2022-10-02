
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
   
    JTextField tfeducation,tffname,tfaddress,tfsalary,tfphone,tfemail,tfaadhar,tfdesignation;
        
    JLabel lblempID;
    JButton add,back;
    String empId;
    
    UpdateEmployee(String empId) {
        this.empId = empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("UPDATE EMPLOYEE DETAILS");
        heading.setBounds(320,20,500,50);
        heading.setFont(new Font("ROBOTO", Font.BOLD,25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200,150,150,30);
        add(lblname);
        
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(labelfname);
        
        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(labeldob);
        
        JLabel lbldob = new JLabel();
        lbldob.setBounds(200,200,150,30);
        add(lbldob);
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
        
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400,200,150,30);
        labelsalary.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400,250,150,30);
        labelphone.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);
        
        JLabel labelemail = new JLabel("E-mail");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);
        
        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(400,300,150,30);
        labeleducation.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(labeleducation);
            
                
        tfeducation = new JTextField();
        //tfeducation.setBackground(Color.WHITE);
        tfeducation.setBounds(600,300,150,30);
        add(tfeducation);
        
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50,350,150,30);
        labeldesignation.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(labeldesignation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        add(tfdesignation);
        
        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(400,350,150,30);
        labelaadhar.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(labelaadhar);
        
        JLabel lblaadhar = new JLabel();
        lblaadhar.setBounds(600,350,150,30);
        add(lblaadhar);
        
        JLabel labelempID = new JLabel("Employee ID");
        labelempID.setBounds(50,400,150,30);
        labelempID.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(labelempID);
        
        lblempID = new JLabel();
        lblempID.setBounds(200,400,150,30);
        lblempID.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(lblempID);
        
        try{
            Conn c = new Conn();
            String query ="select * from employee where empID = '"+empId+"' ";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfsalary.setText(rs.getString("salary"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                lblaadhar.setText(rs.getString("aadhar"));
                lblempID.setText(rs.getString("empID"));
                tfdesignation.setText(rs.getString("designation"));
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        add = new JButton("UPDATE DETAILS");
        add.setFont(new Font("Tahoma", Font.BOLD, 15));
        add.setBounds(250,550,180,40);
        add.addActionListener(this);
        add(add);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        
        back = new JButton("BACK");
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.setBounds(450,550,150,40); 
        back.addActionListener(this);
        add(back);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        
        setSize(900,750);
        setLocation(300,60);
        setVisible(true);
}
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            
            String fname = tffname.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdesignation.getText();
                        
            try{
                Conn conn = new Conn();
                String query = "update employee set fname = '"+fname+"',salary = '"+salary+"',address = '"+address+"', phone = '"+phone+"' ,email = '"+email+"',education = '"+education+"',designation = '"+designation+"' where empID = '"+empId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Updated Successfully");
                setVisible(false);
                new Home();
            }catch (Exception e){
                e.printStackTrace();
            }
            
        } else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args){
        new UpdateEmployee("");
    }
}
