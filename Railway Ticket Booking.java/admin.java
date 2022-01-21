import java.util.*;
public class admin {
    static Scanner sc=new Scanner(System.in);
    static traindetails Train_Details=new traindetails();
    public void AdminHome(){
        int AdminChoice;
        boolean intialCondition=true;
        do{
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("<---Welcome Admin--->");
            System.out.println();
            System.out.println("1.Train Details");
            System.out.println();
            System.out.println("2.Seat Status");
            System.out.println();
            /*System.out.println("3.Ticket Details");
            System.out.println();
            System.out.println("4.Total Collections");
            System.out.println();*/
            System.out.println("3.Exit");
            System.out.println();
            System.out.println("Enter Your Choice:");
            AdminChoice=sc.nextInt();
            sc.nextLine();
            switch(AdminChoice){
                case 1:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Train Id"+"      "+"Train Name");
                System.out.println("2727"+"          "+"Chennai Express");
                System.out.println();
                System.out.println("Enter the Train Id to get train details");
                int TrainId=sc.nextInt();
                sc.nextLine();
                Train_Details.trains();
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("<---Train Details--->");
                System.out.println();
                Train_Details.display(TrainId);
                System.out.println("Press Enter to contine...");
                sc.nextLine();
                break;
                case 2:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                //Train_Details.SeatDetails();
                for(int i=0;i<10;i++){
                    for(int j=0;j<10;j++){
                        System.out.print(Train_Details.Seats[i][j]+" ");
                    }
                    System.out.println();
                }
                System.out.println("Press Enter to contine...");
                sc.nextLine();
                break;
                case 3:
                intialCondition=false;
                break;
                /*case 4:
                break;
                case 5:
                
                break;*/


            }
        }while(intialCondition);
    }
    
}
