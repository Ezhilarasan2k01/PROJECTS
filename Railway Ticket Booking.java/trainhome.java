import java.util.*;
public class trainhome {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        admin AdminPage=new admin();
        user UserPage=new user();
        boolean intialCondition=true;
        int Selector;
        do{
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("<--Welcome to Train Reservation App-->");
            System.out.println();
            System.out.println("1.Admin");
            System.out.println();
            System.out.println("2.User");
            System.out.println();
            System.out.println("3.Exit");
            System.out.println();
            System.out.println("Enter Your Choice:");
            Selector=sc.nextInt();
            sc.nextLine();
            switch(Selector){
                case 1:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("<---Admin Login--->");
                System.out.println();
                System.out.println("Enter The Username of Admin:");
                String AdminName=sc.nextLine();
                System.out.println();
                System.out.println("Enter the Password of Admin:");
                int AdminPassword=sc.nextInt();
                sc.nextLine();
                System.out.println();
                if(AdminName.equals("e")&&AdminPassword==2){
                   AdminPage.AdminHome();
                }
                else{
                    System.out.println("Invalid Username or Password");
                    System.out.println("Press Enter to Continue...");
                    sc.nextLine();
                    
                }
                break;
                case 2:
                UserPage.Authentication();
                
                break;
                case 3:
                intialCondition=false;
                break;

                

            }
        }while(intialCondition);
        sc.close();
    }
    
}
