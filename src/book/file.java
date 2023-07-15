package book;
import java.util.*;
import java.io.*;
import java.nio.*;
import javax.swing.*;
import java.awt.event.*;

public class file {
    private ArrayList<Book> books;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private File file;

    file()
    {
        try{
        books=new ArrayList<Book>();
        file=new File("Books.dat");
        ois=null;
        oos=null;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void add_books(Jframe j)
    {
        int v=Validate.validate(j);
        if(v==1)
        {
            try{
                System.out.println(books);
                int bookid=Integer.parseInt(j.t1.getText());
                String bookname=j.t2.getText();
                String authorname=j.t3.getText();
                String publication=j.t4.getText();
                String date=j.t5.getText();
                double price=Double.parseDouble(j.t6.getText());
                int tot_qty_ordered=Integer.parseInt(j.t7.getText());
                double total_cost=Double.parseDouble(j.t8.getText());
                j.f.books.add(new Book(bookid,bookname,authorname,publication,date,price,tot_qty_ordered,total_cost));
                System.out.println(j.f.books.size());
                String s1="";
                for(int i=0;i<books.size();i++)
                    s1+="Book"+(i+1)+"<br/>";
                j.l9.setText("<html>"+s1+"</html>");
//                j.setEmpty();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else
            JOptionPane.showMessageDialog(j, "Fields cannot be empty");
    }
    public void insert_all_books(Jframe j)
    {
        try{
        if(books.size()==0)
            JOptionPane.showMessageDialog(j, "Nothing to add in file");
        else
        {
            ois=new ObjectInputStream(new FileInputStream(file));
            ArrayList<Book> al=(ArrayList<Book>)ois.readObject();
            ois.close();
            for(int a=0;a<books.size();a++)
            {
                for(Book b:al)
                    if(b.bookid==books.get(a).bookid)
                    {
                        books.remove(books.get(a));
                        System.out.println("Duplicate books are not allowed "+"Book id "+b.bookid+" already exists");
                    }
            }
            books.addAll(al);
            oos=new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(books);
            oos.close();
            System.out.println(books.size());
            System.out.println("All books inserted");
            books.clear();
            j.l9.setText("No books to add");
             JOptionPane.showMessageDialog(j, "All unique books inserted successfully");
        }
        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void show_books(Jframe j)
    {
        try{
        ois=new ObjectInputStream(new FileInputStream(file));  
        books=(ArrayList)ois.readObject();
        ois.close();
            System.out.println(books);
        String[][]data;
         String[] column_name={"Book ID","Book Name","Author","Publications","Date","Price","Quantity","Total Cost"};
         int i=0;
        
         for(Book b:books)
            System.out.println(b.bookid+" "+b.bookname);
         data=new String[j.f.books.size()][8];
         for(Book b:books)
         {
             data[i][0]=String.valueOf(b.bookid);
             data[i][1]=b.bookname;
             data[i][2]=b.authorname;
             data[i][3]=b.publication;
             data[i][4]=b.date_of_pub;
             data[i][5]=String.valueOf(b.price);
             data[i][6]=String.valueOf(b.tot_qty_ordered);
             data[i][7]=String.valueOf(b.total_cost);
             i++;
         }
         books.clear();
         new View_frame(data,column_name);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(j, "File is empty: No books to display");
            System.out.println(e);
        }
    }
    
    public void delete_books(Jframe j)
    {
        Book b=null;
        try{
            ois=new ObjectInputStream(new FileInputStream(file));
            books=(ArrayList<Book>)ois.readObject();
            ois.close();
            int id=Integer.parseInt(JOptionPane.showInputDialog(j, "Enter book_id which you want to delete", "Delete",JOptionPane.PLAIN_MESSAGE ));
            for(Book b1:j.f.books)
            {
                if(b1.bookid==id)
                {
                    b=b1;
                    break;
                }
            }
            if(books.size()==0)
                 JOptionPane.showMessageDialog(j, "File is empty : No books to delete");
            else if(b==null)
                JOptionPane.showMessageDialog(j, "No such book exists");
            else
            {
                books.remove(b);
                oos=new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(books);
                oos.close();
                books.clear();
                JOptionPane.showMessageDialog(j, "Book deleted successfully");                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(j, "Enter valid bookid");
            System.out.println(e);
        }
    }
    
    public void update_books(Jframe j)
    {
        try{
           ois=new ObjectInputStream(new FileInputStream(file));
           books=(ArrayList<Book>)ois.readObject();
           ois.close();
           j.b=null;
           int bookid = Integer.parseInt(JOptionPane.showInputDialog(j, "Enter the bookid which you want to update","Update",JOptionPane.PLAIN_MESSAGE));
           for(Book b:books)
           {
               if(b.bookid==bookid)
               {
                   j.b=b;
                   break;
               }
           }
           if(j.b!=null)
           {
               j.db.update.setInt(1, bookid);
               j.uf=new Update_frame();
               j.uf.t2.setText(j.b.bookname);
               j.uf.t3.setText(j.b.authorname);
               j.uf.t4.setText(j.b.publication);
               j.uf.t5.setText(j.b.date_of_pub);
               j.uf.t6.setText(j.b.price+"");
               j.uf.t7.setText(j.b.tot_qty_ordered+"");
               j.uf.t8.setText(j.b.price*j.b.tot_qty_ordered+"");
               j.uf.b1.addActionListener((ActionEvent a)->{
                    int v=Validate.validate(j.uf);
        if(v==1)
        {
            try{
            j.b.bookname=j.uf.t2.getText();         j.b.authorname=j.uf.t3.getText();
            j.b.publication=j.uf.t4.getText();      j.b.date_of_pub=j.uf.t5.getText();
            j.b.price=Double.parseDouble(j.uf.t6.getText());    j.b.tot_qty_ordered=Integer.parseInt(j.uf.t7.getText());
            j.b.total_cost=Double.parseDouble(j.uf.t8.getText());
            
            j.db.update.setString(2, j.uf.t2.getText());        j.db.update.setString(3, j.uf.t3.getText());
            j.db.update.setString(4, j.uf.t4.getText());        j.db.update.setDate(5, java.sql.Date.valueOf(j.uf.t5.getText()));
            j.db.update.setDouble(6, Double.parseDouble(j.uf.t6.getText()));    j.db.update.setDouble(7, Integer.parseInt(j.uf.t7.getText()));
            j.db.update.setDouble(8, Double.parseDouble(j.uf.t8.getText()));
            System.out.println(j.db.update.executeUpdate());
             for(int i=0;i<books.size();i++)
           {
               if(books.get(i).bookid==j.b.bookid)
               {
                   books.set(i, j.b);
                   break;
               }
           }
             oos=new ObjectOutputStream(new FileOutputStream(file));
             oos.writeObject(books);
             oos.close();
             j.b=null;
             JOptionPane.showMessageDialog(j.uf, "Record Updated Successfully");
            j.uf.dispose();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else
            JOptionPane.showMessageDialog(j.uf, "Fields cannot be empty");
               });
           }
           else
               JOptionPane.showMessageDialog(j, "Book with bookid "+bookid+" does not exist");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(j,"Enter valid bookid");
            System.out.println(e);
        }
    } 
    
    public void search_book(Jframe j)
    {
        String selected_item=j.jc.getSelectedItem().toString();
        String field=j.ct1.getText();
        if(field.equals("")==false)
        {
            try{
            String[][]data;
            ois=new ObjectInputStream(new FileInputStream(file));
            ArrayList<Book> b1=(ArrayList<Book>)ois.readObject();
            ois.close();
            if(b1.size()!=0)
            {
                data=new String[b1.size()][8];
                int i=0;
                if(selected_item=="Authorname")
                {
                    for(Book b:b1)
                        if(b.authorname.equals(field))
                        {
                            data[i][0]=String.valueOf(b.bookid);
                            data[i][1]=b.bookname;
                            data[i][2]=b.authorname;
                            data[i][3]=b.publication;
                            data[i][4]=b.date_of_pub;
                            data[i][5]=String.valueOf(b.price);
                            data[i][6]=String.valueOf(b.tot_qty_ordered);
                            data[i][7]=String.valueOf(b.total_cost);
                            i++;
                        }
                    if(i==0)
                        JOptionPane.showMessageDialog(j, "No book exists with authorname"+field);
                    else
                    {
                        String[][] data1;
                        data1=new String[i][8];
                        for(int k=0;k<i;k++)
                        {
                            data1[k][0]=data[k][0];    data1[k][1]=data[k][1];
                            data1[k][2]=data[k][2];                   data1[k][3]=data1[k][3];
                            data1[k][4]=data[k][4];                 data1[k][5]=data[k][5];
                            data1[k][6]=data[k][6];
                            data1[k][7]=data[k][7];
                        }
                        new View_frame(data1,null);
                    }
                }
            }
            else
                JOptionPane.showMessageDialog(j, "File is empty");
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else
            JOptionPane.showMessageDialog(j, "Search field cannot be empty");
    }
}
