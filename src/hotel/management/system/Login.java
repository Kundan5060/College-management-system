package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JTextField username;
    JPasswordField password;
    JButton login,cancle;
    Login(){
         setLayout(null);
        getContentPane().setBackground(Color.WHITE);
       
        // text
        JLabel user=new JLabel("Username");
        user.setBounds(40,20,100,30);
        add(user);
        //input text box
        username=new JTextField();
        username.setBounds(160, 20, 150, 30);
        add(username);
        
        JLabel pass=new JLabel("Password"); 
        pass.setBounds(40,70,100,30);
        add(pass);
        
        //input text box
         password=new JPasswordField();
        password.setBounds(160, 70, 150, 30);
        add(password);
        
        login=new JButton("Login");
        login.setBounds(80,150,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        cancle=new JButton("Cancle");
        cancle.setBounds(190,150,100,30);
        cancle.setBackground(Color.BLACK);
        cancle.setForeground(Color.WHITE);
        cancle.addActionListener(this);
        add(cancle);
        
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
       Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2); 
       JLabel image=new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);
        
        
       
        
        
       setBounds(500,200,600,300);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
         String user= username.getText();
         String pass=password.getText();
         
         try{
             Conn c=new Conn();
             
             String query="SELECT * FROM LOGIN WHERE username = '"+ user+"' and password='"+pass+"'";
             
             ResultSet rs=c.s.executeQuery(query);
             if(rs.next()){
                 setVisible(false);
                 new Dashboard();
             }else{
                
                 JOptionPane.showMessageDialog(null,"Invaild username or password");
             setVisible(false);
             }
             
         } catch (Exception e){
             e.getStackTrace();
         }
            
        }else if(ae.getSource()==cancle){
            setVisible(false);
            
        }
        
    }
    public static void main(String[] args){
        new Login();
    }
    
}
