package book;
/**
 *
 * @author shrey
 */
import java.io.*;
public class Book implements Serializable {
    public int bookid;
    public String bookname;
    public String authorname;
    public String publication;
    public String date_of_pub;
    public double price;
    public int tot_qty_ordered;
    public double total_cost;
    
    Book(int bid,String bname,String aname,String p,String date,double price,int qty_order,double total_cost)
    {
        this.bookid=bid;
        this.bookname=bname;
        this.authorname=aname;
        this.publication=p;
        this.date_of_pub=date;
        this.price=price;
        this.tot_qty_ordered=qty_order;
        this.total_cost=total_cost;
    }
    public static void main(String[] args) {
    }
    
}
