
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class splitwisemethods {
    static String Username;
    static String Password;
    static Scanner sc=new Scanner(System.in);
    int UserIndex=0;
    static ArrayList<user> User_Details=new ArrayList<>();
    // static splitwisemethods methods=new splitwisemethods();
    public void view_History(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("!!! Welcome To Splitwise App !!!\n");
        System.out.println("!!! Transaction Histoies !!!\n");
        int serial=0;
        for(int i=0;i<User_Details.get(UserIndex).History.size();i++){
            System.out.println(++serial+"."+"Rs."+User_Details.get(UserIndex).History.get(i).Amount+" is received from "+User_Details.get(UserIndex).History.get(i).User_Spend+" for "+User_Details.get(UserIndex).History.get(i).Des);

        }
        System.out.println("\nPress Enter Key to continue!!!");
        sc.nextLine();

    }
    public void Pending_List(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("!!! Welcome To Splitwise App !!!\n");
        System.out.println("!!! Groups !!!\n");
        int serial4=0;
        int UserIndex=find_index(Username);
        for(int i=0;i<User_Details.get(UserIndex).Group_List.size();i++){
            System.out.println((++serial4)+"."+User_Details.get(UserIndex).Group_List.get(i).Description);
        }
        int serial5=0;
        System.out.print("\nSelect the Group >>");
        int User_Choice=sc.nextInt();sc.nextLine();
        for(int i=0;i<User_Details.get(UserIndex).Group_List.get(User_Choice-1).Pending_Dues.size();i++){
            System.out.println(++serial5+". Your Share is Rs."+User_Details.get(UserIndex).Group_List.get(User_Choice-1).Pending_Dues.get(i).Amount+" for "+User_Details.get(UserIndex).Group_List.get(User_Choice-1).Pending_Dues.get(i).Des+" to "+User_Details.get(UserIndex).Group_List.get(User_Choice-1).Pending_Dues.get(i).User_Spend);
        }
        if(User_Details.get(UserIndex).Group_List.get(User_Choice-1).Pending_Dues.size()>=1){
        System.out.print("\nSelect the Group >>");
        int User_Choice_payment=sc.nextInt();sc.nextLine();
        if(User_Details.get(UserIndex).Group_List.get(User_Choice-1).Pending_Dues.get(User_Choice_payment-1).Amount<=User_Details.get(UserIndex).Wallet){
            System.out.println("Amount >>"+User_Details.get(UserIndex).Group_List.get(User_Choice-1).Pending_Dues.get(User_Choice_payment-1).Amount);
            System.out.println("For >>"+User_Details.get(UserIndex).Group_List.get(User_Choice-1).Pending_Dues.get(User_Choice_payment-1).Des);
            System.out.println("To >>"+User_Details.get(UserIndex).Group_List.get(User_Choice-1).Pending_Dues.get(User_Choice_payment-1).User_Spend);
            System.out.println("Enter Confirm to Pay >>");
            String Payment=sc.nextLine();
            int index=find_index(User_Details.get(UserIndex).Group_List.get(User_Choice-1).Pending_Dues.get(User_Choice_payment-1).User_Spend);
            if(Payment.equals("Confirm")){
                User_Details.get(index).Wallet=User_Details.get(index).Wallet+User_Details.get(UserIndex).Group_List.get(User_Choice-1).Pending_Dues.get(User_Choice_payment-1).Amount;
                User_Details.get(index).History.add(new Exp(User_Details.get(UserIndex).Group_List.get(User_Choice-1).Pending_Dues.get(User_Choice_payment-1).Des,Username, User_Details.get(UserIndex).Group_List.get(User_Choice-1).Pending_Dues.get(User_Choice_payment-1).Amount));
            }
            
            System.out.println("Amount sended successfully !!!");
            User_Details.get(UserIndex).Wallet=User_Details.get(UserIndex).Wallet-User_Details.get(UserIndex).Group_List.get(User_Choice-1).Pending_Dues.get(User_Choice_payment-1).Amount;
            User_Details.get(UserIndex).Group_List.get(User_Choice-1).Pending_Dues.remove(User_Choice_payment-1);
        }
        else{
            System.out.println("Low Amount in your wallet !!!");
        }
        }
        System.out.println("\nPress Enter Key to continue!!!");
        sc.nextLine();
    }
    public void View_group_expence(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("!!! Welcome To Splitwise App !!!\n");
        System.out.println("!!! Groups !!!\n");
        int serial4=0;
        int UserIndex=find_index(Username);
        for(int i=0;i<User_Details.get(UserIndex).Group_List.size();i++){
            System.out.println((++serial4)+"."+User_Details.get(UserIndex).Group_List.get(i).Description);
        }
        int serial5=0;
        System.out.print("\nSelect the Group >>");
        int User_Choice=sc.nextInt();sc.nextLine();
        for(int i=0;i<User_Details.get(UserIndex).Group_List.get(User_Choice-1).Expense.size();i++){
            System.out.println(++serial5+". "+User_Details.get(UserIndex).Group_List.get(User_Choice-1).Expense.get(i).User_Spend+" Spend Rs."+User_Details.get(UserIndex).Group_List.get(User_Choice-1).Expense.get(i).Amount+" for "+User_Details.get(UserIndex).Group_List.get(User_Choice-1).Expense.get(i).Des);
        } 
        // System.out.println(++serial5+". "+User_Details.get(UserIndex).Group_List.get(User_Choice-1).Expense.size());
        System.out.println("\nPress Enter Key to continue!!!");
        sc.nextLine();
    }
   public void pair_expence(){
    System.out.print("\033[H\033[2J");
    System.out.flush();
    System.out.println("!!! Welcome To Splitwise App !!!\n");
    System.out.println("!!! Groups !!!\n");
    int Serial3=0;
    int ref2=find_index(Username);
    for(int i=0;i<User_Details.get(ref2).Group_List.size();i++){
        System.out.println((++Serial3)+"."+User_Details.get(ref2).Group_List.get(i).Description);
    }
    System.out.print("\nSelect the Group to add Expense >>");
    int User_choice=sc.nextInt();sc.nextLine();
    System.out.print("\nEnter the name of the Expense >>");
    String Purpose=sc.nextLine();
    System.out.print("\nEnter the Amount to Spent >>");
    int Expense=sc.nextInt();sc.nextLine();
    // int Payment=0;
    // User_Details.get(ref2).Group_List.get(User_choice-1).Expense.add(new Exp(Purpose,Username, Expense));
    if(User_Details.get(ref2).Group_List.size()>=1){
    if(Expense<=User_Details.get(ref2).Wallet){
        User_Details.get(ref2).Wallet=User_Details.get(ref2).Wallet-Expense;
        // Payment=Expense/User_Details.get(ref2).Group_List.get(User_choice-1).Friends.size();
        User_Details.get(ref2).Group_List.get(User_choice-1).Expense.add(new Exp(Purpose,Username, Expense));   
    }
    // for(int i=0;i<User_Details.size();i++){
    //     if((!User_Details.get(i).User_Name.equals(Username)) && (User_Details.get(ref2).Group_List.get(User_choice-1).Friends.contains(User_Details.get(i).User_Name))){
    //     for(int j=0;j<User_Details.get(i).Group_List.size();j++){
    //         if(User_Details.get(i).Group_List.get(j).Description.equals(User_Details.get(ref2).Group_List.get(User_choice-1).Description)){
    //             User_Details.get(i).Group_List.get(j).Expense.add(new Exp(Purpose,Username, Expense));
    //             User_Details.get(i).Group_List.get(j).Pending_Dues.add(new Exp(Purpose,Username,Payment));
    //             break;
    //         }
    //     }
    // }
    // }
}
else{
    System.out.println("No Groups Available !!!");
}
    System.out.println("\nPress Enter Key to continue!!!");
    sc.nextLine();
   }
    public void group_expense(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("!!! Welcome To Splitwise App !!!\n");
        System.out.println("!!! Groups !!!\n");
        int Serial3=0;
        int ref2=find_index(Username);
        for(int i=0;i<User_Details.get(ref2).Group_List.size();i++){
            System.out.println((++Serial3)+"."+User_Details.get(ref2).Group_List.get(i).Description);
        }
        System.out.print("\nSelect the Group to add Expense >>");
        int User_choice=sc.nextInt();sc.nextLine();
        System.out.print("\nEnter the name of the Expense >>");
        String Purpose=sc.nextLine();
        System.out.print("\nEnter the Amount to Spent >>");
        int Expense=sc.nextInt();sc.nextLine();
        int Payment=0;
        // User_Details.get(ref2).Group_List.get(User_choice-1).Expense.add(new Exp(Purpose,Username, Expense));
        if(User_Details.get(ref2).Group_List.size()>=1){
        if(Expense<=User_Details.get(ref2).Wallet){
            User_Details.get(ref2).Wallet=User_Details.get(ref2).Wallet-Expense;
            Payment=Expense/User_Details.get(ref2).Group_List.get(User_choice-1).Friends.size();
            User_Details.get(ref2).Group_List.get(User_choice-1).Expense.add(new Exp(Purpose,Username, Expense));   
        }
        for(int i=0;i<User_Details.size();i++){
            if((!User_Details.get(i).User_Name.equals(Username)) && (User_Details.get(ref2).Group_List.get(User_choice-1).Friends.contains(User_Details.get(i).User_Name))){
            for(int j=0;j<User_Details.get(i).Group_List.size();j++){
                if(User_Details.get(i).Group_List.get(j).Description.equals(User_Details.get(ref2).Group_List.get(User_choice-1).Description)){
                    User_Details.get(i).Group_List.get(j).Expense.add(new Exp(Purpose,Username, Expense));
                    User_Details.get(i).Group_List.get(j).Pending_Dues.add(new Exp(Purpose,Username,Payment));
                    break;
                }
            }
        }
        }
    }
    else{
        System.out.println("No Groups Available !!!");
    }
        System.out.println("\nPress Enter Key to continue!!!");
        sc.nextLine();

    }
    public int find_index(String a){
        int m=0;
        for(int i=0;i<User_Details.size();i++){
            if(User_Details.get(i).User_Name.equals(a)){
                m=i;
                break;
            }
        }
        return m;
    }
    public void View_group(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("!!! Welcome To Splitwise App !!!\n");
        int ref=find_index(Username);
        if(User_Details.get(ref).Group_List.size()>=1){
            for(int i=0;i<User_Details.get(ref).Group_List.size();i++){
            System.out.println("Group Name >> "+User_Details.get(ref).Group_List.get(i).Description);
            for(int k=0;k<User_Details.get(ref).Group_List.get(i).Friends.size();k++){
                System.out.println("Friends >>"+User_Details.get(ref).Group_List.get(i).Friends.get(k));
            }
            }
            System.out.println("\nPress Enter Key to continue!!!");
            sc.nextLine();
        }
        else{
            System.out.println("Group list is empty!!!");
            System.out.println("\nPress Enter Key to continue!!!");
            sc.nextLine();
        }

    }
    // public void pair_Group(){
    //     System.out.print("\033[H\033[2J");
    //     System.out.flush();
    //     System.out.println("!!! Welcome To Splitwise App !!!\n");
    //     int ref=find_index(Username);
    //     if(User_Details.get(ref).Frnd_List.size()>=1){
    //     System.out.println("\nEnter the Group Name >>");
    //     String Group_Name=sc.nextLine();
    //     int Serial2=0;
    //     // System.out.println("\nHow many Friends Add in the Group >>");
    //     // int No_Of_Friends=sc.nextInt();sc.nextLine();
    //     if(2<=User_Details.get(ref).Frnd_List.size()){
    //     User_Details.get(ref).Group_List.add(new Group(Group_Name,new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
    //     for(int i=0;i<User_Details.get(ref).Frnd_List.size();i++){
    //         System.out.println(++Serial2+")"+User_Details.get(ref).Frnd_List.get(i));
    //     }
    //     int ref1=0;
    //     for(int i=0;i<2;i++){
    //         System.out.println("\nSelect the friend No"+(i+1)+" >>");
    //         int Choose_Frnd=sc.nextInt();sc.nextLine();
    //         for(int j=0;j<User_Details.get(ref).Group_List.size();j++){
    //             if(User_Details.get(ref).Group_List.get(j).Description.equals(Group_Name)){
    //                 ref1=j;
    //                 User_Details.get(ref).Group_List.get(j).Friends.add(User_Details.get(ref).Frnd_List.get(Choose_Frnd-1));
    //             }
    //         }
    //     }
    //      User_Details.get(ref).Group_List.get(ref1).Friends.add(Username);
    //     // for(int i=0;i<User_Details.get(ref).Group_List.get(ref1).Friends.size();i++){
    //         for(int j=0;j<User_Details.size();j++){
    //             if((User_Details.get(ref).Group_List.get(ref1).Friends).contains((User_Details.get(j).User_Name))){
    //                 if(User_Details.get(j).User_Name.equals(Username)){
    //                     continue;
    //                 }
    //                 else{
    //                     User_Details.get(j).Group_List.add(new Group(User_Details.get(ref).Group_List.get(ref1).Description,User_Details.get(ref).Group_List.get(ref1).Friends, new ArrayList<>(), new ArrayList<>())) ;
    //                     // add(User_Details.get(ref).Group_List.get(ref1));    
    //                 // User_Details.get(j).Group_List.add(User_Details.get(ref).Group_List.get(ref1));
    //                 }

    //             }
                
    //         }
    //         System.out.println("\nGroup Created Successfully!!!");
    //         System.out.println("\nPress Enter Key to continue!!!");
    //         sc.nextLine();
    //     }
    //     else{
    //         System.out.println("\nYour Friend List is Empty ! Pls Add Friends in your List !!!");
    //         System.out.println("\nPress Enter Key to continue!!!");
    //         sc.nextLine();
    //     }
    // }
    // else{
    //     System.out.println("Low Friends Available in your Friend list Add more Friends!!!");
    //     System.out.println("\nPress Enter Key to continue!!!");
    //     sc.nextLine();
    // }
    // }
    public void create_group(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("!!! Welcome To Splitwise App !!!\n");
        int ref=find_index(Username);
        if(User_Details.get(ref).Frnd_List.size()>=1){
        System.out.println("\nEnter the Group Name >>");
        String Group_Name=sc.nextLine();
        int Serial2=0;
        System.out.println("\nHow many Friends Add in the Group >>");
        int No_Of_Friends=sc.nextInt();sc.nextLine();
        if(No_Of_Friends<=User_Details.get(ref).Frnd_List.size()){
        User_Details.get(ref).Group_List.add(new Group(Group_Name,new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
        for(int i=0;i<User_Details.get(ref).Frnd_List.size();i++){
            System.out.println(++Serial2+")"+User_Details.get(ref).Frnd_List.get(i));
        }
        int ref1=0;
        for(int i=0;i<No_Of_Friends;i++){
            System.out.println("\nSelect the friend No"+(i+1)+" >>");
            int Choose_Frnd=sc.nextInt();sc.nextLine();
            for(int j=0;j<User_Details.get(ref).Group_List.size();j++){
                if(User_Details.get(ref).Group_List.get(j).Description.equals(Group_Name)){
                    ref1=j;
                    User_Details.get(ref).Group_List.get(j).Friends.add(User_Details.get(ref).Frnd_List.get(Choose_Frnd-1));
                }
            }
        }
         User_Details.get(ref).Group_List.get(ref1).Friends.add(Username);
        // for(int i=0;i<User_Details.get(ref).Group_List.get(ref1).Friends.size();i++){
            for(int j=0;j<User_Details.size();j++){
                if((User_Details.get(ref).Group_List.get(ref1).Friends).contains((User_Details.get(j).User_Name))){
                    if(User_Details.get(j).User_Name.equals(Username)){
                        continue;
                    }
                    else{
                        User_Details.get(j).Group_List.add(new Group(User_Details.get(ref).Group_List.get(ref1).Description,User_Details.get(ref).Group_List.get(ref1).Friends, new ArrayList<>(), new ArrayList<>())) ;
                        // add(User_Details.get(ref).Group_List.get(ref1));    
                    // User_Details.get(j).Group_List.add(User_Details.get(ref).Group_List.get(ref1));
                    }

                }
                
            }
            // }
            System.out.println("\nGroup Created Successfully!!!");
            System.out.println("\nPress Enter Key to continue!!!");
            sc.nextLine();
        }
        else{
            System.out.println("\nYour Friend List is Empty ! Pls Add Friends in your List !!!");
            System.out.println("\nPress Enter Key to continue!!!");
            sc.nextLine();
        }
    }
    else{
        System.out.println("Low Friends Available in your Friend list Add more Friends!!!");
        System.out.println("\nPress Enter Key to continue!!!");
        sc.nextLine();
    }
    }
    public void Wallet(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("!!! Welcome To Splitwise App !!!\n");
        for(int i=0;i<User_Details.size();i++){
            if(User_Details.get(i).User_Name.equals(Username)){
                if(User_Details.get(i).Password.equals(Password)){
                    System.out.println("Your Available Wallet Amount is >> "+User_Details.get(i).Wallet);
                    break;
                }
            }
        }
        System.out.print("\n1.Add amount\n\n2.Exit\n\nSelect your choice >>");
        int User_Choice=sc.nextInt();
        if(User_Choice==1){
            System.out.print("\nEnter amount to Add >>");
            int Add_Amount=sc.nextInt();sc.nextLine();
            int index=find_index(Username);
            User_Details.get(index).Wallet=User_Details.get(index).Wallet+Add_Amount;
            System.out.println("Amount Added successfull!!!");


        }
        System.out.println("\nPress Enter Key to continue!!!");
        sc.nextLine();
    }
    public void Add_Friends(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("!!! Welcome To Splitwise App !!!\n");
        System.out.print("1.Show Friends List\n\n2.Add Friends\n\nEnter Your Choice >> ");
        int User_Choice2=sc.nextInt();sc.nextLine();
        int serial1=0;
        if(User_Choice2==1){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("!!! Welcome To Splitwise App !!!\n");
            if(User_Details.get(UserIndex).Frnd_List.size()==0){
                System.out.println("Friend list is empty!!!");
                System.out.println("\nPress Enter Key to continue!!!");
                sc.nextLine();
            }
            else{
            for(int i=0;i<User_Details.get(UserIndex).Frnd_List.size();i++){
                System.out.println((++serial1)+"."+User_Details.get(UserIndex).Frnd_List.get(i));
            }
            System.out.println("\nPress Enter Key to continue!!!");
            sc.nextLine();
        }
        }
        else{
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("!!! Welcome To Splitwise App !!!\n");
        int Serial=0;
        for(int i=0;i<User_Details.size();i++){
            if(!Username.equals(User_Details.get(i).User_Name)){
                System.out.println((++Serial)+"."+User_Details.get(i).User_Name);
            }
        }
        System.out.print("\nEnter the No.of.friends to Add >>");
        int No_Friends=sc.nextInt();sc.nextLine();
        for(int i=0;i<No_Friends;i++){
            System.out.print("\nEnter Friend "+(i+1)+" Name >>");
            String New_Frnd_Name=sc.nextLine();
            for(int ki=0;ki<User_Details.size();ki++){
                if(User_Details.get(ki).User_Name.equals(New_Frnd_Name) && (!New_Frnd_Name.equals(Username)) ){
                    User_Details.get(UserIndex).Frnd_List.add(User_Details.get(ki).User_Name);
                    break;
                }
            }
        }
        System.out.println("\nSuccessfully Added in your friend list!!!");
        System.out.println("\nPress Enter Key to continue!!!");
        sc.nextLine();
        }
        }
    public void newuser(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("!!! Welcome To Splitwise App !!!\n");
        System.out.print("Enter the Username -> ");
        Username=sc.nextLine();
        boolean jk=true;
        for(int i=0;i<User_Details.size();i++){
            if(User_Details.get(i).User_Name.equals(Username)){
                  jk=false;
            }
        }
        if(jk){
        System.out.print("\nEnter Password -> ");
        Password=sc.nextLine();
        User_Details.add(new user(Username, Password,0,new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
        System.out.println("\nUser Created Successfully!!!!");
        System.out.println("\nPress Enter Key to continue!!!");
        sc.nextLine();
        }
        else{
            System.out.println("\nUsername Already Exists!!!");
            System.out.println("\nPress Enter Key to continue!!!");
            sc.nextLine();
        }
    }
    public void Existing_user(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("!!! Welcome To Splitwise App !!!\n");
        System.out.print("Enter the Username -> ");
        Username=sc.nextLine();
        System.out.print("\nEnter Password -> ");
        Password=sc.nextLine();
        boolean Status=false;
        for(int i=0;i<User_Details.size();i++){
            if(User_Details.get(i).User_Name.equals(Username)){
                if(User_Details.get(i).Password.equals(Password)){
                    UserIndex=i;
                    Status=true;
                    this.User_home();
                }
            }
        }
        if(!Status){
            System.out.println("\nInvalid Username or Password!!!");
            System.out.println("\nPress Enter Key to continue!!!");
            sc.nextLine();
        }
    } 
    public void User_home(){
        boolean kpr=true;
        int User_Choice1;
        do{
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("!!! Welcome To Splitwise App !!!\n");
        System.out.println("1.Add Expense\n\n2.Add Wallet Amount\n\n3.Groups\n\n4.Pending Dues\n\n5.Add Friends\n\n6.Remove Friends\n\n7.View Transaction\n\n8.Received History\n\n9.Logout");
        System.out.print("\nSelect Your Choice >>");
        User_Choice1=sc.nextInt();sc.nextLine();
        switch(User_Choice1){
            case 1:
            int User_Choice;
            boolean kpr1=true;
            do{
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("!!! Welcome To Splitwise App !!!\n");
                System.out.print("1.Group Expence\n\n2.Non-Group Expense\n\n3.Exit\n\nSelect your Choice >>");
                User_Choice=sc.nextInt();sc.nextLine();
                switch(User_Choice){
                    case 1:
                    this.group_expense();

                    break;
                    case 2:
                    this.pair_expence();
                    break;
                    case 3:
                    kpr1=false;
                    break;

                }
                


            }while(kpr1);
            break;
            case 2:
            this.Wallet();
            
            break;
            case 3:
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("!!! Welcome To Splitwise App !!!\n");
            System.out.println("1.View Groups\n\n2.Create Group");
            System.out.println("\nSelect Your Choice >>");
            int User_Choice4=sc.nextInt();sc.nextLine();
            if(User_Choice4==2){
                this.create_group();
            }
            else if(User_Choice4==1){
                this.View_group();
            }
            // else{
            //     // this.pair_Group();
            // }
            break;
            case 4:
            this.Pending_List();

            break;
            case 5:
            this.Add_Friends();

            break;
            case 6:

            break;
            case 7:
            boolean kpr3=true;
            int User_choic=0;
            do{
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("!!! Welcome To Splitwise App !!!\n");
            System.out.print("1.Group Transaction\n\n2.Exit\n\nEnter your choice >>");
            User_choic=sc.nextInt();sc.nextLine();
            switch(User_choic){
                case 1:
                this.View_group_expence();
                break;
                case 2:
                kpr3=false;
                break;

            }
            }while(kpr3);


            break;
            case 8:
            this.view_History();
            break;
            case 9:
            kpr=false;
            break;   
        }
    }while(kpr);
    }
 
}
