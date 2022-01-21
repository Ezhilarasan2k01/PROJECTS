import java.util.*;
class admin1 {
    String EmailId;
    int Password;
    admin1(String EmailId,int Password){
        this.EmailId=EmailId;
        this.Password=Password;
    }
    
}
class extend{
    int isbn;
    String Book_Name;
    String Date;
}
class Borrow{
    int isbn;
    String Book_Name;
    String Auther_Name;
    String Borrowed_Date;
    String Return_Date;
    String Category1;
    Borrow(int isbn,String Book_Name,String Borrowed_Date,String Return_Date,String Category1){
    this.isbn=isbn;
    this.Book_Name=Book_Name;
    
    this.Borrowed_Date=Borrowed_Date;
    this.Return_Date=Return_Date;
    this.Category1=Category1;
    }
}
class userData{
    String Username;
    String Emailid;
    int Password;
    int deposit;
    ArrayList<Borrow>Borrowed_Books;
    ArrayList<String>fines;
    ArrayList<String>extend_book;
    ArrayList<String>History;
    userData(String Username,String Emailid,int Password,int deposit,ArrayList<Borrow>Borrowed_Books,ArrayList<String>fines,ArrayList<String>extend_book,ArrayList<String>History){
        this.Username=Username;
        this.Emailid=Emailid;
        this.Password=Password;
        this.deposit=deposit;
        this.Borrowed_Books=Borrowed_Books;
        this.fines=fines;
        this.extend_book=extend_book;
        this.History=History;
    }
}
class books{
    int isbn;
    String Book_Name;
    String Auther_Name;
    int Book_Quantity;
    books(int isbn,String Book_Name,String Auther_Name,int Book_Quantity){
        this.isbn=isbn;
        this.Book_Name=Book_Name;
        this.Auther_Name=Auther_Name;
        this.Book_Quantity=Book_Quantity;
    }
}

