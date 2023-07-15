package book;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;


public class View_frame extends JFrame{
    JScrollPane j1=null;
    JTable t1;
    String[] column_name={"Book ID","Book Name","Author","Publications","Date","Price","Quantity","Total Cost"};
    View_frame(String[][] data,String[]column_name)
    {
        setLayout(new BorderLayout(0,0));
        t1=new JTable(data,this.column_name);
        Font f=new Font("Sans-serif",Font.PLAIN,16);
        Font f1=new Font("Sans-serif",Font.BOLD,18);
        t1.getTableHeader().setFont(f1);
        t1.setFont(f);
        j1=new JScrollPane(t1);
        add(j1,BorderLayout.CENTER);
        setSize(1000,400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
