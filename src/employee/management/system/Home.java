
package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
    
    JButton add,view,update,remove;
    
    
    Home(){
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1130,630);
        add(image);
     
        
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(620,20,400,40);
        heading.setFont(new Font("Roboto", Font.BOLD, 25));
        image.add(heading);
        
        add = new JButton("ADD EMPLOYEE");
        add.setFont(new Font("Tahoma", Font.BOLD, 11));
        add.setBounds(650,80,150,40);
        add.addActionListener(this);
        image.add(add);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        
        view = new JButton("VIEW EMPLOYEES");
        view.setFont(new Font("Tahoma", Font.BOLD, 11));
        view.setBounds(820,80,150,40);
        view.addActionListener(this);
        image.add(view);
        view.setBackground(Color.BLACK);
        view.setForeground(Color.WHITE);
        
        update = new JButton("UPDATE EMPLOYEE");
        update.setFont(new Font("Tahoma", Font.BOLD, 11));
        update.setBounds(650,140,150,40);
        update.addActionListener(this);
        image.add(update);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        
        remove = new JButton("REMOVE EMPLOYEE");
        remove.setFont(new Font("Tahoma", Font.BOLD, 11));
        remove.setBounds(820,140,150,40);
        remove.addActionListener(this);
        image.add(remove);
        remove.setBackground(Color.BLACK);
        remove.setForeground(Color.WHITE);
                     
        setSize(1120,630);
        setLocation(250,100);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== add){
            setVisible(false);
            new AddEmployee();
            
        } else if (ae.getSource()== view){
            setVisible(false);
            new ViewEmployee();
            
        } else if (ae.getSource()== update){
            setVisible(false);
            new ViewEmployee();
        } else {
            setVisible(false);
            new RemoveEmployee();
        }
    }
    
    public static void main(String[] args){
        new Home();
    }
}
