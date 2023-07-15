package book;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
/**
 *
 * @author shrey
 */
public class Jframe extends JFrame {
    Book b=null;
    JPanel p1,p2,p3,p4;
    JComboBox jc;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,ct1;
    JButton b1,b2,b3,b4,b5,cb1;
    DB db=null;
    file f=null;
    Update_frame uf=null;
       
    JOptionPane j1=new JOptionPane();
    Jframe(){
    super("Book_details");
    f=new file();
    db=new DB();
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(750,500);
   
    p1=new JPanel();
    p2=new JPanel();
    p3=new JPanel();
    p4=new JPanel();
    
    jc=new JComboBox(new String[]{"Bookid","Bookname","Authorname","Publications"});
//    jc.setBackground(Color.blue);
    Font f=new Font("Sans-serif",Font.BOLD,16);
    jc.setFont(f);
    l1=new JLabel("Enter Book ID");                     l1.setFont(f);   
    l2=new JLabel("Enter Book Name");                   l2.setFont(f); 
    l3=new JLabel("Enter Auhtor Name");                 l3.setFont(f);
    l4=new JLabel("Enter Publication");                 l4.setFont(f);
    l5=new JLabel("Enter Date of Publication");         l5.setFont(f);
    l6=new JLabel("Enter Price");                       l6.setFont(f);
    l7=new JLabel("Enter Total Quantity Ordered");      l7.setFont(f);
    l8=new JLabel("Total Cost");                  l8.setFont(f);
    l9=new JLabel("<html>No books<br/> to add</html>");       l9.setFont(f);
    
    b1=new JButton("Add Book");
    b2=new JButton("Insert All Books");
    b3=new JButton("Show all abooks");
    b4=new JButton("Delete books");
    b5=new JButton("Update books");
    b1.setVisible(true);
    b2.setVisible(true);
    b3.setVisible(true);
    b4.setVisible(true);
    b5.setVisible(true);
    cb1=new JButton("Search");
    
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
    ct1=new JTextField(); ct1.setFont(f1);
    
    
    setLayout(new BorderLayout(20,20));
    p1.setBorder(new EmptyBorder(10,20,10,10));
    p3.setBorder(new EmptyBorder(10,10,10,10));
    p3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    getRootPane().setBorder(new EmptyBorder(10,10,10,10));
    add(p1,BorderLayout.CENTER);
    add(p2,BorderLayout.SOUTH);
    add(p3,BorderLayout.WEST);
    add(p4,BorderLayout.NORTH);
     
    
    p1.setLayout(new GridLayout(8,2,0,15));
    p4.setLayout(new GridLayout(1,3,5,0));
    p1.add(l1);     p1.add(t1);
    p1.add(l2);     p1.add(t2);
    p1.add(l3);     p1.add(t3);
    p1.add(l4);     p1.add(t4);
    p1.add(l5);     p1.add(t5);
    p1.add(l6);     p1.add(t6);
    p1.add(l7);     p1.add(t7);
    p1.add(l8);     p1.add(t8);
    p3.add(l9);
    p2.add(b1);     p2.add(b2);
    p2.add(b3);     p2.add(b4);
    p2.add(b5);
    p3.setBackground(Color.WHITE);
    p3.setPreferredSize(new Dimension(150,500));
    p4.add(jc);
    p4.add(ct1);
    p4.add(cb1);
    
    t1.addFocusListener(new FE(this));
    t2.addFocusListener(new FE(this));
    t5.addFocusListener(new FE(this));
    t6.addFocusListener(new FE(this));
    t7.addFocusListener(new FE(this));
    
    b1.addActionListener(new Actionevent(this));
    b2.addActionListener(new Actionevent(this));
    b3.addActionListener(new Actionevent(this));
    b4.addActionListener(new Actionevent(this));
    b5.addActionListener(new Actionevent(this));
    cb1.addActionListener(new Actionevent(this));
    cb1.setFont(f);
    cb1.setBackground(Color.PINK);
    b1.setBackground(Color.ORANGE);
    b2.setBackground(Color.green);
    b3.setBackground(Color.yellow);
    b4.setBackground(Color.red);
    b5.setBackground(Color.CYAN);
    b1.setFont(f);
    b2.setFont(f);
    b3.setFont(f);
    b4.setFont(f);
    b5.setFont(f);
//    b1.setBounds(50, 20, 40, 20);
    setVisible(true);
    }
    
    void setEmpty()
    {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText(""); 
        t5.setText("");
        t6.setText("");
        t7.setText("");
        t8.setText("");
    }
    
    public static void main(String args[])
    {
        Jframe j=new Jframe();
    }
}
