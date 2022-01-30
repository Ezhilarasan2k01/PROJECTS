
import java.util.ArrayList;
// class pending{
//     Stri
// }
class Exp{
    String Des;
    String User_Spend;
    int Amount;
    Exp(String Des,String User_Spend,int Amount){
        this.Des=Des;
        this.User_Spend=User_Spend;
        this.Amount=Amount;
    }
}
class Group{
    String Description;
    ArrayList<String> Friends;
    ArrayList<Exp> Expense;
    ArrayList<Exp> Pending_Dues;
    
    Group(String Description,ArrayList<String> Friends,ArrayList<Exp> Expense,ArrayList<Exp> Pending_Dues){
        this.Description=Description;
        this.Friends=Friends;
        this.Expense=Expense;
        this.Pending_Dues=Pending_Dues;
    }  
}

class user{
    String User_Name;
    String Password;
    int Wallet;
    ArrayList<String> Frnd_List;
    ArrayList<Group> Group_List;
    ArrayList<Exp> History;
    user(String User_Name,String Password,int Wallet,ArrayList<String> Frnd_List,ArrayList<Group> Group_List,ArrayList<Exp> History){
        this.User_Name=User_Name;
        this.Password=Password;
        this.Wallet=Wallet;
        this.Frnd_List=Frnd_List;
        this.Group_List=Group_List;
        this.History=History;
    }
}
    

