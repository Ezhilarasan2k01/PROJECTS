import java.util.*;
public class main{
    static splitwisemethods methods=new splitwisemethods();
    public static void main(String[] args){
        splitwisemethods.User_Details.add(new user("a", "1234", 2000,new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
        splitwisemethods.User_Details.add(new user("b", "1234", 2000,new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
        splitwisemethods.User_Details.add(new user("c", "1234", 2000,new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
        splitwisemethods.User_Details.add(new user("d", "1234", 2000,new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
        splitwisemethods.User_Details.add(new user("e", "1234", 2000,new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
        splitwisemethods.User_Details.add(new user("f", "1234", 2000,new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
        Scanner sc=new Scanner(System.in);
        boolean kpr=true;
        System.out.println("!!! Welcome To Splitwise App !!!");
        int User_Choice;
        do{
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("!!! Welcome To Splitwise App !!!");
            System.out.println("\n1.New User\n\n2.Existing User");
            System.out.print("\nEnter Your Choice >> ");
            User_Choice=sc.nextInt();sc.nextLine();
            switch(User_Choice){
                case 1:
                methods.newuser();
                break;
                case 2:
                methods.Existing_user();
                break;
            }
        }while(kpr);
    }
    
}
