package book;
import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Update_frame extends JFrame {
    JPanel p1,p2,p3;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JButton b1;
    Book b;
    Update_frame()
    {
        super("Update");
     
    p1=new JPanel();
    p2=new JPanel();
    p3=new JPanel();
    
    setLayout(new BorderLayout(20,10));
    p1.setBorder(new EmptyBorder(30,20,0,10));
    getRootPane().setBorder(new EmptyBorder(10,10,10,10));
    add(p1,BorderLayout.CENTER);
    add(p2,BorderLayout.SOUTH);
    add(p3,BorderLayout.NORTH);
     
    Font f=new Font("Sans-serif",Font.BOLD,16);
    Font f2=new Font("Sans-serif",Font.BOLD,26);
    l1=new JLabel("Insert new data");                   l1.setFont(f2);   
    l2=new JLabel("Enter Book Name");                   l2.setFont(f); 
    l3=new JLabel("Enter Auhtor Name");                 l3.setFont(f);
    l4=new JLabel("Enter Publication");                 l4.setFont(f);
    l5=new JLabel("Enter Date of Publication");         l5.setFont(f);
    l6=new JLabel("Enter Price");                       l6.setFont(f);
    l7=new JLabel("Enter Total Quantity Ordered");      l7.setFont(f);
    l8=new JLabel("Total Cost");                        l8.setFont(f);
    l9=new JLabel("<html>No books<br/> to add</html>"); l9.setFont(f);
    
    Font f1=new Font("Sans-serif",Font.PLAIN,14);
    t1=new JTextField();  t1.setFont(f1);
    t2=new JTextField();  t2.setFont(f1);
    t3=new JTextField();  t3.setFont(f1);
    t4=new JTextField();  t4.setFont(f1);
    t5=new JTextField();  t5.setFont(f1);
    t6=new JTextField();  t6.setFont(f1);
    t7=new JTextField();  t7.setFont(f1);
    t8=new JTextField();  t8.setFont(f1);
    t8.setEditable(false);
    
    t2.addFocusListener(new Update_FE(this));
    t5.addFocusListener(new Update_FE(this));
    t6.addFocusListener(new Update_FE(this));
    t7.addFocusListener(new Update_FE(this));
    
    b1=new JButton("Update Record");
    b1.setFont(f);
    b1.setBackground(Color.MAGENTA);
    b1.setPreferredSize(new Dimension(250,40));
    
    
    p1.setLayout(new GridLayout(8,2,0,30));
    p1.add(l2);     p1.add(t2);
    p1.add(l3);     p1.add(t3);
    p1.add(l4);     p1.add(t4);
    p1.add(l5);     p1.add(t5);
    p1.add(l6);     p1.add(t6);
    p1.add(l7);     p1.add(t7);
    p1.add(l8);     p1.add(t8);
    
    p2.add(b1);
    p2.setBorder(new EmptyBorder(0,20,20,10));
    p3.add(l1);
    
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(600,650);
     setVisible(true);
    }
}
