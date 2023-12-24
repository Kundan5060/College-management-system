
package hotel.management.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class HotelManagementSystem extends JFrame implements ActionListener{
    HotelManagementSystem(){
        setSize(1360,565);
       setLocation(100,100);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image=new JLabel(i1);
       image.setBounds(0,0,1360,565);
        add(image);
        //text
        JLabel text=new JLabel("Hotel Management System");
        text.setBounds(20,430,1000,90);
        text.setForeground(Color.white);
        text.setFont(new Font("serif",Font.BOLD,50));
        image.add(text);
        
        JButton next=new JButton("NEXT");
        next.setBounds(1050,430,130,40);
        next.setBackground(Color.green);
        next.setForeground(Color.black);
        next.addActionListener(this);
        next.setFont(new Font("serif",Font.BOLD,20));
        image.add(next);
        
    setVisible(true);
    while(true){
        text.setVisible(false);
        try{
            Thread.sleep(500);
        }
        catch (Exception e){
            e.printStackTrace();
            
        }
        text.setVisible(true);
        try{
            Thread.sleep(500);
        }
        catch (Exception e){
            e.printStackTrace();
            
        }
    }
    
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
        
    }
    public static void main(String[] args) {
        new HotelManagementSystem();
        
    }
    
}
