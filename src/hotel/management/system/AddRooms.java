package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener{
    
    JButton add,cancle;
    JTextField tfroom,tfprice;
    JComboBox typecombo,availabelcombo,cleancombo;
    
    AddRooms(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading=new JLabel("Add Rooms");
        heading .setFont(new Font("Tohoma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);
        
        JLabel lblroomno=new JLabel("Room Number");
        lblroomno.setFont(new Font("Tohoma",Font.PLAIN,16));
        lblroomno.setBounds(60,80,120,30);
        add(lblroomno);
        
        tfroom=new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);
        
        JLabel lblavailabel=new JLabel("Availabel");
        lblavailabel.setFont(new Font("Tohoma",Font.PLAIN,16));
        lblavailabel.setBounds(60,130,120,30);
        add(lblavailabel);
        
        String availabelOptions[]={"Available","Occupied"};
        availabelcombo=new JComboBox(availabelOptions);
        availabelcombo.setBounds(200,130,150,30);
        availabelcombo.setBackground(Color.white);
        add(availabelcombo);
        
        JLabel lblclean=new JLabel("Cleaning Status");
       lblclean.setFont(new Font("Tohoma",Font.PLAIN,16));
        lblclean.setBounds(60,180,120,30);
        add(lblclean);
        
        String cleanOptions[]={"Cleaned","Dirty"};
        cleancombo=new JComboBox(cleanOptions);
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.white);
        add( cleancombo);
        
        JLabel lbltype=new JLabel("Bed Type");
        lbltype.setFont(new Font("Tohoma",Font.PLAIN,16));
        lbltype.setBounds(60,230,120,30);
        add(lbltype);
        
        String typeOptions[]={"Single Bed","Double Bed"};
        typecombo=new JComboBox(typeOptions);
        typecombo.setBounds(200,230,150,30);
        typecombo.setBackground(Color.white);
        add( typecombo);
        
        JLabel lblprice=new JLabel("Price");
        lblprice.setFont(new Font("Tohoma",Font.PLAIN,18));
        lblprice.setBounds(60,280,120,30);
        add(lblprice);
        
        tfprice=new JTextField();
        tfprice.setBounds(200,280,150,30);
        add(tfprice);
        
        add=new JButton("Add Room");
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);
        
        cancle=new JButton("Cancle");
        cancle.setForeground(Color.white);
        cancle.setBackground(Color.black);
        cancle.setBounds(220,350,130,30);
        cancle.addActionListener(this);
        add(cancle);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);
        
        
        
        setBounds(200,200,940,470);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String roomnumber= tfroom.getText();
            String availability=(String) availabelcombo.getSelectedItem();
            String status=(String) cleancombo.getSelectedItem();
            String price= tfprice.getText();
            String type= (String) typecombo.getSelectedItem();
            
            try{
            
                Conn conn =new Conn();
                String str="insert into room values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+type+"')";
                conn.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null, "New Room Added Successfully");
                
                setVisible(false);
                
            }catch(Exception e){
                
            e.printStackTrace();
            
            }
            
            }
            
        
    else{
            setVisible(false);
        }
    }
    
    
    public static void main(String[] args){
        new AddRooms();
    }
    
}
