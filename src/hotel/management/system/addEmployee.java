
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class addEmployee extends JFrame implements ActionListener {
    
    
    JTextField tfname,tfemail,tfphone,tfage,tfsalary,tfaadhar;
    JRadioButton rbmale,rbfemale;
    JButton submit;
    JComboBox cbjob;
    
    
    addEmployee(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lblname=new JLabel("NAME");
        lblname.setBounds(60,30,120,30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblname);
        
        tfname=new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);
       
        
        JLabel lblage=new JLabel("AGE");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblage);
        
         tfage=new JTextField();
        tfage.setBounds(200,80,150,30);
        add(tfage);
       
        
        JLabel lblgender=new JLabel("GENDER");
        lblgender.setBounds(60,130,120,30);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblgender);
        
         rbmale=new JRadioButton("MALE");
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbmale.setBackground(Color.white);
        rbmale.setBounds(200,130,70,30);
        add(rbmale);
        
        rbfemale=new JRadioButton("FEMALE");
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
         rbfemale.setBackground(Color.white);
        rbfemale.setBounds(280,130,90,30);
        add(rbfemale);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel lbljob=new JLabel("JOB");
        lbljob.setBounds(60,180,120,30);
        lbljob.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbljob);
        
        String str[]={"Front Desk Clerks ","Porters","Husekeeping","Kitchen Staff","Room Service","Chets","Waiter/Waitress","Manager","Accountant"};
        cbjob=new  JComboBox(str);
        cbjob.setBounds(200,180,160,30);
        cbjob.setBackground(Color.white);
        add(cbjob);
        
        JLabel lblsalary=new JLabel("SALARY");
        lblsalary.setBounds(60,230,150,30);
        lblsalary.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblsalary);
        
        tfsalary=new JTextField();
        tfsalary.setBounds(200,230,150,30);
        add( tfsalary);
              
        
       JLabel lblphone=new JLabel("PHONE");
       lblphone.setBounds(60,280,120,30);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblphone);
       
        tfphone=new JTextField();
        tfphone.setBounds(200,280,150,30);
        add(tfphone);
        
        
        JLabel lblemail=new JLabel("EMAIL");
        lblemail.setBounds(60,330,120,30);
        lblemail.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblemail);
        
         tfemail=new JTextField();        
        tfemail.setBounds(200,330,150,30);
        add(tfemail);
        
        JLabel lblaadhar=new JLabel("AADHAR");
        lblaadhar.setBounds(60,380,120,30);
        lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblaadhar);
        
         tfaadhar=new JTextField();        
        tfaadhar.setBounds(200,380,150,30);
        add(tfaadhar);
        
        submit=new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setBounds(200,430,150,30);
        submit.addActionListener(this);
        add(submit);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2=i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,60,450,370);
        add(image);
   
        
        
        setBounds(200,200,850,540);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
       String name=tfname.getText();
       String age=tfage.getText();
       String phone=tfphone.getText();
       String salary=tfsalary.getText();
       String email=tfemail.getText();
       String aadhar=tfaadhar.getText();
       
       String gender=null; 
       
       //email validation
       //if(email.equals("")&& Include("@")&& include(".com")){
       
       if(name.equals("")){
           JOptionPane.showMessageDialog(null,"Name should not be empty");
           return;
       }
       
       if(age.equals("")){
           JOptionPane.showMessageDialog(null,"Age should not be empty");
           return;
       }
       
       if(phone.equals("")){
           JOptionPane.showMessageDialog(null,"Phone should not be empty");
           return;
       }
       
       if(salary.equals("")){
           JOptionPane.showMessageDialog(null,"Salary should not be empty");
           return;
       }
       
       if(aadhar.equals("")){
           JOptionPane.showMessageDialog(null,"Aadhar should not be empty");
           return;
       }
       
       if(rbmale.isSelected()){
           gender="Male";
       } else if(rbfemale.isSelected()){
           gender="Female";
       }
       
       String job= (String)cbjob.getSelectedItem();
       
       try{
           Conn conn=new Conn();
           
          String query = "insert into employee values('"+name+"','"+age+"','"+job+"','"+gender+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
           
           conn.s.executeUpdate(query);
           JOptionPane.showMessageDialog(null,"Employee Added Successfully");
           setVisible(false);
           
       } catch(Exception e){
           e.printStackTrace();
       }
        
    }
    
    public static void main(String[] args){
        new addEmployee();
    }
}
