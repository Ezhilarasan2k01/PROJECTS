import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.sound.midi.SysexMessage;

public class user {
    static Scanner sc=new Scanner(System.in);
    static HashMap<String,ArrayList<Object>> UserDetails=new HashMap<String,ArrayList<Object>>();
    static HashMap<String,ArrayList<Integer>> User_Seat_Details=new HashMap<String,ArrayList<Integer>>();
    static HashMap<String,ArrayList<Integer>> Waiting_Seat_Details=new HashMap<String,ArrayList<Integer>>();

    static user UserClass=new user(); 
    static traindetails TrainClass=new traindetails();
    
    static int SeatArr[][]=new int[10][10]; 
    static ArrayList<String> Waiting=new ArrayList<String>();
    
    static String UserMobileLogin="";
    static int StationFrom=0;
    static int StationTo=0;
    static int SeatNo=0;
    static int one=0;
    static int two=0;
    static int Amount=0;
    static int count=0;
    static String arr[]={"Tiruppur","Erode","Salem","Dharmapuri","Krishnagiri","Jolarpet","Ambur","Vellore","Arakonam","Chennai"};
    /*public void SeatArray(){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                
            }
        }
    }*/
    public int FindIndex(int a){
        if(a==1){
            return a-1;
        }
        else if(a==2){
            return a*2;
        }
        else{
            int k=0;
            for(int i=3;i<=a;i++){
                for(int j=k;j<=k;j++){
                    if(i==a){
                        return ((a*2)+j+2);
                    }
                }
                k=k+2;
            }
            return 0;
        }
    }
    public void WaitingToBook(){
        for(int i=1;i<Waiting.size();i=i+4){
            for(int j=i+1;j<=i+1;j=j+4){
                int from=Integer.parseInt(Waiting.get(i))-1;
                int to=Integer.parseInt(Waiting.get(j))-1;
                int diff=(to-from)+1;
                int AmountWaiting =diff*100;

                for(int ki=0;ki<10;ki++){
                    int Available1=0;
                    for(int kj=0;kj<10;kj++){
                        if(kj>=from && kj<=to){
                            if(SeatArr[ki][kj]==0){
                                Available1++;
                            }
                        }
                    }
                    if(Available1==diff){
                        int SeatNum=ki;
                        for(int li=0;li<10;li++){
                            for(int lj=0;lj<10;lj++){
                                if((li==SeatNum)&&(lj>=from)&&(lj<=to)){
                                    SeatArr[li][lj]=1;
                                }
                            }
                        }
                        if(User_Seat_Details.containsKey(Waiting.get(i-1))){
                            User_Seat_Details.get(Waiting.get(i-1)).add(from+1);
                            User_Seat_Details.get(Waiting.get(i-1)).add(to+1);
                            User_Seat_Details.get(Waiting.get(i-1)).add(SeatNum+1);
                            User_Seat_Details.get(Waiting.get(i-1)).add(AmountWaiting);
                        }
                        else{
                            ArrayList<Integer> ttf=new ArrayList<Integer>();
                            ttf.add(from+1);
                            ttf.add(to+1);
                            ttf.add(SeatNum+1);
                            ttf.add(AmountWaiting);
                            User_Seat_Details.put(Waiting.get(i-1),ttf);
                        }
                        if(Waiting_Seat_Details.containsKey(Waiting.get(i-1))){
                            if(Waiting_Seat_Details.get(Waiting.get(i-1)).size()==3){
                                Waiting_Seat_Details.remove(Waiting.get(i-1));
                            }
                            else{
                                ArrayList<Integer> Temporary=Waiting_Seat_Details.get(Waiting.get(i-1));
                                for(int mi=0;mi<Temporary.size();mi=mi+3){
                                    if((Temporary.get(mi)==(from+1)) && (Temporary.get(mi+1)==(to+1))&&(Temporary.get(mi+2)==(AmountWaiting))){
                                        Temporary.remove(mi);
                                        Temporary.remove(mi);
                                        Temporary.remove(mi); 
                                        Waiting_Seat_Details.put(Waiting.get(i-1), Temporary); 

                                    }
                                }
                            }
                        }
                        if(Waiting.size()==4){
                            Waiting.clear();
                        }
                        else{
                            Waiting.remove(i);
                            Waiting.remove(i);
                            Waiting.remove(i);
                            Waiting.remove(i-1);
                        }
                    }
                }
            }
        }
    }
    public void sample1arr(){
        Waiting.add(UserMobileLogin);
        Waiting.add(StationFrom+"");
        Waiting.add(StationTo+"");
        Waiting.add(Amount+"");
    }

    public void sample(){
        ArrayList<Object> kpr=new ArrayList<Object>();
        kpr.add(2001);
        kpr.add("man");
        UserDetails.put("842", kpr);
        /*for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(i==j){
                SeatArr[i][j]=1;
                }
                else{
                    SeatArr[i][j]=0; 
                }
            }
        }*/
    }
    //Authentication
    public void Authentication(){
        boolean intialCondition=true;
        int UserChoice;
        do{
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("<---Welcome User--->");
            System.out.println();
            System.out.println("1.New User"+"\n"+"\n"+"2.Existing User"+"\n"+"\n"+"3.Exit");
            System.out.println();
            System.out.println("Enter Your Choice....");
            UserChoice=sc.nextInt();
            sc.nextLine();
            switch(UserChoice){
                case 1:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("<---Welcome User--->");
                System.out.println();
                System.out.println("Enter Your Mobile Number:");
                String UserMobile=sc.nextLine();
                System.out.println();
                System.out.println("Enter Your Name:");
                String UserName=sc.nextLine();
                System.out.println();
                System.out.println("Enter Your Age:");
                int UserAge=sc.nextInt();
                sc.nextLine();
                System.out.println();
                System.out.println("Enter Your Gender[Male,Female]:");
                String UserGender=sc.nextLine();
                System.out.println();
                System.out.println("Enter Your Pin Number:");
                int UserPin=sc.nextInt();
                sc.nextLine();
                System.out.println();
                System.out.println("Enter Your Pin Number Again to Confirm:");
                int UserPinConfirm=sc.nextInt();
                sc.nextLine();
                System.out.println();
                if(UserPin==UserPinConfirm){
                    ArrayList<Object> TempUser=new ArrayList<Object>();
                    TempUser.add(UserPin);
                    TempUser.add(UserName);
                    TempUser.add(UserAge);
                    TempUser.add(UserGender);
                    UserDetails.put(UserMobile,TempUser);
                    System.out.println("Hello Mr."+UserName+" You Registerd Sucessfully...");
                    System.out.println();
                    System.out.println("Press Enter to Continue...");
                    sc.nextLine();
                }
                break;
                case 2:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                UserClass.sample();
                System.out.println("<---Welcome User--->");
                System.out.println();
                System.out.println("Enter Mobile Number:");
                UserMobileLogin=sc.nextLine();
                System.out.println();
                if(UserDetails.containsKey(UserMobileLogin)){
                    System.out.println("Enter your Pin Number:");
                    int UserPinLogin=sc.nextInt();
                sc.nextLine();
                if(UserDetails.get(UserMobileLogin).contains(UserPinLogin)){
                    UserClass.UserHome();

                }
                else{
                    System.out.println("Invalid Username or Password...");
                }
                }
                else{
                    System.out.println("Mobile Number is Wrong Pls try Again After New User Registration...");
                }
                System.out.println("Press Enter to Continue...");
                sc.nextLine();
                break;
                case 3:
                intialCondition=false;
                break;
            }
        }while(intialCondition);
    }
    public void WaitingSeat_Details(){
        if(Waiting_Seat_Details.containsKey(UserMobileLogin)){
            Waiting_Seat_Details.get(UserMobileLogin).add(StationFrom);
            Waiting_Seat_Details.get(UserMobileLogin).add(StationTo);
            
            Waiting_Seat_Details.get(UserMobileLogin).add(Amount);
        }
        else{
            ArrayList<Integer> temp=new ArrayList<Integer>();
            temp.add(StationFrom);
            temp.add(StationTo);
            
            temp.add(Amount);
            Waiting_Seat_Details.put(UserMobileLogin, temp);
        }
    }
    public void UserSeat_Details(){
        if(User_Seat_Details.containsKey(UserMobileLogin)){
            User_Seat_Details.get(UserMobileLogin).add(StationFrom);
            User_Seat_Details.get(UserMobileLogin).add(StationTo);
            User_Seat_Details.get(UserMobileLogin).add(SeatNo);
            User_Seat_Details.get(UserMobileLogin).add(Amount);
        }
        else{
            ArrayList<Integer> temp=new ArrayList<Integer>();
            temp.add(StationFrom);
            temp.add(StationTo);
            temp.add(SeatNo);
            temp.add(Amount);
            User_Seat_Details.put(UserMobileLogin, temp);
        }
    }
    public void UserHome(){
        int UserChoice;
        boolean intialCondition=true;
        
        do{
            System.out.print("\033[H\033[2J");
            System.out.flush();
            Object temp=UserDetails.get(UserMobileLogin).get(1);
            System.out.println("<---Welcome Mr."+temp+" --->");
            System.out.println();
            System.out.println("1.Book Ticket"+"\n"+"\n"+"2.Cancel Ticket"+"\n"+"\n"+"3.view Tickets"+"\n"+"\n"+"4.Seat Availability"+"\n"+"\n"+"5.Exit");
            System.out.println();
            System.out.println("Enter Your Choice....");
            UserChoice=sc.nextInt();
            switch(UserChoice){
                case 1:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("<---Welcome Mr."+temp+" --->"+"\n");
                System.out.println("Train Id"+"      "+"Train Name");
                System.out.println("2727"+"          "+"Chennai Express");
                System.out.println();
                System.out.println("Enter Train Id to Check the Station and Book Ticket..");
                int TrainId=sc.nextInt();
                sc.nextLine();
                System.out.println();
                TrainClass.trains();
                System.out.println("<---Train Details--->"+"\n");
                for(int i=1;i<TrainClass.trainDetails.get(TrainId).size();i++){
                    System.out.println(TrainClass.trainDetails.get(TrainId).get(i)+"\n");  
                }
                System.out.println("From:(Enter Station Number)");
                StationFrom=sc.nextInt();
                sc.nextLine();
                System.out.println("\n"+"To:(Enter Station Number)");
                StationTo=sc.nextInt();
                sc.nextLine();
                System.out.println();
                int ck=0;
                int StationCount=0;
                for(int i=StationFrom-1;i<=StationTo-1;i++){
                    StationCount++;
                }
                //System.out.println(StationCount);
                
                //checking purpose
                /*for(int i=0;i<10;i++){
                    for(int j=0;j<10;j++){
                        if(i==1 && j==StationFrom-1){
                            SeatArr[i][j]=1;
                        }
                    }
                }*/
                
                for(int i=0;i<10;i++){
                    int Available=0;
                    for(int j=0;j<10;j++){
                        if(j>=StationFrom-1 && j<=StationTo-1){
                            if(SeatArr[i][j]==0){
                                Available++;
                            }
                        }
                    }
                    if(Available==StationCount){
                        ck++;
                        SeatNo=i+1;
                        Amount=StationCount*100;
                        System.out.println("Seat available seat num="+(i+1)+"\n");
                        System.out.println("Ticket Price:"+Amount+"\n");
                        System.out.println("Enter confirm to book ticktets:");
                        String isUserConfirm=sc.nextLine();
                        if(isUserConfirm.equals("confirm")){
                            System.out.println("\n"+"Ticket Booked Succesfully !!! Enjoy Your Journey !!!");
                            UserClass.UserSeat_Details();
                            for(int k=0;k<10;k++){
                                for(int l=0;l<10;l++){
                                    if((k==i)&&(l>=StationFrom-1)&&(l<=StationTo-1)){
                                        SeatArr[k][l]=1;
                                    }
                                }
                            }
                            break;
                        }
                        else{
                            System.out.println("Invalid Input...");
                            break;
                        }
                    }
                   /* else if(Available==StationCount-1){
                        if(SeatArr[i][StationFrom-1]==1){
                        SeatNo=i+1;
                        System.out.println("Seat available seat num="+(i+1)+"\n");
                        System.out.println("Enter confirm to book ticktets:");
                        String isUserConfirm=sc.nextLine();
                        System.out.println();
                        if(isUserConfirm.equals("confirm")){
                            System.out.println("\n"+"Ticket Booked Succesfully !!! Enjoy Your Journey !!!");
                            UserClass.UserSeat_Details();
                            for(int k=0;k<10;k++){
                                for(int l=0;l<10;l++){
                                    if((k==i)&&(l>=StationFrom-1)&&(l<=StationTo-1)){
                                        SeatArr[k][l]=1;
                                    }
                                }
                            }
                        }
                        else{
                            System.out.println("Invalid Input...");
                        }
                        break;
                        }
                    }*/ 
                        
                }
                if(ck==0){
                    count++;
                    if(count>2){
                        System.out.println("No Tickets Available");
                        System.out.println("\n"+"Press Enter to Continue...");
                        sc.nextLine();
                        break;
                    }
                    Amount=StationCount*100;
                    System.out.println("Ticket not available You can Wait in Waiting List"+"\n");
                    System.out.println("Ticket Price:"+Amount+"\n");
                    System.out.println("Enter confirm to book or Press Enter exit");
                    String User=sc.nextLine();
                    if(User.equals("confirm")){
                        UserClass.WaitingSeat_Details();
                        System.out.println("\n"+"Sucessfully Booked You are in Waiting List");
                        UserClass.sample1arr();
                        // for(int i=0;i<Waiting.size();i++){
                        //     System.out.print(Waiting.get(i)+" ");
                        // }
                    }
                    else{
                        System.out.println("Invalid Input");
                        System.out.println("\n"+"Press Enter to Continue...");
                        sc.nextLine();
                        break;
                    }
                }
                    

                
               
               
                System.out.println("\n"+"Press Enter to Continue...");
                sc.nextLine();

                break;
                case 2:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("<---Welcome Mr."+temp+" --->"+"\n");
                if(User_Seat_Details.containsKey(UserMobileLogin)){
                    for(int i=0;i<User_Seat_Details.get(UserMobileLogin).size();i=i+4){
                        for(int j=i+1;j<=i+1;j=j+4){
                            for(int k=j+1;k<=j+1;k=k+4){
                                for(int m=k+1;m<=k+1;m=m+4){
                                one=one+1;
                                System.out.println((one)+"."+"From:"+arr[(User_Seat_Details.get(UserMobileLogin).get(i))-1]+"   "+"To:"+arr[(User_Seat_Details.get(UserMobileLogin).get(j))-1]+"   "+"Seat No:"+(User_Seat_Details.get(UserMobileLogin).get(k))+"   "+"Ticket Price:"+(User_Seat_Details.get(UserMobileLogin).get(m))+"\n");
                                }
                            }
                        }
                    }
                    one=0;
                    sc.nextLine();
                    System.out.println("Enter 1 to cancel or 0 to exit:");
                    int ChoiceUser=sc.nextInt();
                    sc.nextLine();
                    if(ChoiceUser==1){
                    System.out.println("Choose the Ticket That You Want to Cancel:");
                    int SerialNum=sc.nextInt();
                    int ListIndex=FindIndex(SerialNum);
                    Integer[] arrTemp={User_Seat_Details.get(UserMobileLogin).get(ListIndex),User_Seat_Details.get(UserMobileLogin).get(ListIndex+1),User_Seat_Details.get(UserMobileLogin).get(ListIndex+2),User_Seat_Details.get(UserMobileLogin).get(ListIndex+3)};
                   /* for(int i=0;i<4;i++){
                        System.out.print(arrTemp[i]+" ");
                    }*/
                    for(int i=0;i<10;i++){
                        for(int j=0;j<10;j++){
                            if(i==(arrTemp[2]-1) && (j>=(arrTemp[0]-1) && j<=(arrTemp[1]-1))){
                                SeatArr[i][j]=0;
                            }
                        }
                    }
                    System.out.println("Sucessfully Cancelled");
                    if(User_Seat_Details.get(UserMobileLogin).size()==4){
                        User_Seat_Details.remove(UserMobileLogin);
                        sc.nextLine();
                    }
                    else{
                        
                        User_Seat_Details.get(UserMobileLogin).remove(ListIndex);
                        User_Seat_Details.get(UserMobileLogin).remove(ListIndex);
                        User_Seat_Details.get(UserMobileLogin).remove(ListIndex);
                        User_Seat_Details.get(UserMobileLogin).remove(ListIndex);
                    }
                    
                    UserClass.WaitingToBook();


                    
                    
                    }
                    else{
                        break;
                    }
                    }
                    else{
                        System.out.println("No Tickets Booked");
                        sc.nextLine();
                    }
                    System.out.println("Press Enter to Continue...");
                    sc.nextLine();
                    break;
                case 3:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("<---Welcome Mr."+temp+" --->"+"\n");
                if(User_Seat_Details.containsKey(UserMobileLogin)||Waiting_Seat_Details.containsKey(UserMobileLogin)){
                    if(User_Seat_Details.containsKey(UserMobileLogin)){
                    System.out.println("<---Booked Tickets--->"+"\n");
                    for(int i=0;i<User_Seat_Details.get(UserMobileLogin).size();i=i+4){
                        for(int j=i+1;j<=i+1;j=j+4){
                            for(int k=j+1;k<=j+1;k=k+4){
                                for(int m=k+1;m<=k+1;m=m+4){
                                one=one+1;
                                System.out.println((one)+"."+"From:"+arr[(User_Seat_Details.get(UserMobileLogin).get(i))-1]+"   "+"To:"+arr[(User_Seat_Details.get(UserMobileLogin).get(j))-1]+"   "+"Seat No:"+(User_Seat_Details.get(UserMobileLogin).get(k))+"   "+"Ticket Price:"+(User_Seat_Details.get(UserMobileLogin).get(m))+"\n");
                                }
                            }
                        }
                    }
                }
                    
                    if(Waiting_Seat_Details.containsKey(UserMobileLogin)){
                        System.out.println("<---Waiting List--->"+"\n");

                        for(int i=0;i<Waiting_Seat_Details.get(UserMobileLogin).size();i=i+3){
                            for(int j=i+1;j<=i+1;j=j+3){
                                
                                    for(int m=j+1;m<=j+1;m=m+3){
                                    
                                    System.out.println("From:"+arr[(Waiting_Seat_Details.get(UserMobileLogin).get(i))-1]+"   "+"To:"+arr[(Waiting_Seat_Details.get(UserMobileLogin).get(j))-1]+"   "+"Ticket Price:"+(Waiting_Seat_Details.get(UserMobileLogin).get(m))+"\n");
                                    }
                                
                            }
                        }
                    }
                }
                    else{
                        System.out.println("No Tickets Booked");
                    }
                    one=0;
                sc.nextLine();
                System.out.println("Press Enter to Continue...");
                sc.nextLine();
                break;
                
                case 4:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("<---Welcome Mr."+temp+" --->"+"\n");
                System.out.println("<---Seat Details--->");
                for(int i=0;i<10;i++){
                    for(int j=0;j<10;j++){
                        System.out.print(SeatArr[i][j]+" ");
                        
                    }
                    System.out.println();
                }
                sc.nextLine();
                System.out.println();
                System.out.println("Press Enter to Continue...");
                sc.nextLine();
                break;
                case 5:
                intialCondition=false;
                break;
            }
        }while(intialCondition);
    }
}
