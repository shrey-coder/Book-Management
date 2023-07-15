package book;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Date;

 class FE implements FocusListener{
     Jframe j;
     FE(Jframe j)
     {
         this.j=j;
     }
     public void focusGained(FocusEvent e)
     {}
   
    public void focusLost(FocusEvent e)
    {
        if(e.getSource()==j.t1 && j.t1.getText().equals("")==false)
        {
           String id=j.t1.getText();
           try{
               Integer.parseInt(id);
           }
           catch(Exception ex)
           {
               JOptionPane.showMessageDialog(j,"Enter valid bookid\n"+"Eg 1,100,23,...." ,"Vook_id" , JOptionPane.INFORMATION_MESSAGE);
               j.t1.grabFocus();
           }
        }
        else if(e.getSource()==j.t5 && j.t5.getText().equals("")==false)
        {
            String date=j.t5.getText();
            try
            {
                Date.valueOf(date);
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(j,"Enter date in given format: YYYY-MM-DD\n EG 2023-01-22");
                j.t5.grabFocus();
            }
        }
        else if(e.getSource()==j.t6 && j.t6.getText().equals("")==false)
        {
            try
            {
                Double.parseDouble(j.t6.getText());
                if(j.t7.getText().equals("")==false)
                {
                    double tot_price=Integer.parseInt(j.t7.getText())*Double.parseDouble(j.t6.getText());
                    j.t8.setText(""+tot_price);
                }
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(j,"Enter valid price\nEg 250.50,250,...");
                j.t6.grabFocus();
            }
        }
        else if(e.getSource()==j.t7 && j.t7.getText().equals("")==false)
        {
            try{
                Integer.parseInt(j.t7.getText());
                if(j.t6.getText().equals("")==false)
                {
                    double tot_price=Integer.parseInt(j.t7.getText())*Double.parseDouble(j.t6.getText());
                    j.t8.setText(""+tot_price);
                }
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(j,"Enter valid quantity\nEg 5,10,50...");
                j.t6.grabFocus();
            }
        }
    }
}
