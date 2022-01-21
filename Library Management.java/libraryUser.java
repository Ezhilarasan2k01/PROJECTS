import java.util.*;

public class libraryUser {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<userData> UserCollection = new ArrayList<>();
    static libraryUser user = new libraryUser();
    static String User_Emailid;
    static int User_Extend;

    public void User_page() {
        boolean kpr = true;
        int UserChoice;
        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("<--- Welcome to Library App --->\n");
            System.out.print(
                    "1.View Books\n\n2.Borrow Books\n\n3.Borrowed Books\n\n4.Return Book\n\n5.Extend Time\n\n6.History\n\n7.Deposit\n\n8.Fines\n\n9.Exit\n\nEnter your Choice -> ");
            UserChoice = sc.nextInt();
            sc.nextLine();
            switch (UserChoice) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("<--- Welcome to Library App --->\n");
                    System.out.println("<--- Categories --->\n");
                    int serialnum = 0;
                    for (int i = 0; i < libraryadmin.SerialRef.size(); i++) {
                        System.out.println((++serialnum) + "." + libraryadmin.SerialRef.get(i) + "\n");
                    }
                    System.out.println("Select the Category ->");
                    int Userctry = sc.nextInt();
                    sc.nextLine();
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("<--- Welcome to Library App --->\n");
                    System.out.println("Category -> " + libraryadmin.SerialRef.get(Userctry - 1));
                    System.out.println(
                            "\n");
                    System.out.printf("%7s %24s %28s %20s", "ISBN", "BOOK NAME", "BOOK AUTHOR", "BOOK QUANTITY" + "\n");
                    System.out.println(
                            "\n");
                    for (int i = 0; i < libraryadmin.Category.get(libraryadmin.SerialRef.get(Userctry - 1))
                            .size(); i++) {
                        System.out.printf("%7s %24s %28s %20s",
                                libraryadmin.Category.get(libraryadmin.SerialRef.get(Userctry - 1)).get(i).isbn,
                                libraryadmin.Category.get(libraryadmin.SerialRef.get(Userctry - 1)).get(i).Book_Name,
                                libraryadmin.Category.get(libraryadmin.SerialRef.get(Userctry - 1)).get(i).Auther_Name,
                                libraryadmin.Category.get(libraryadmin.SerialRef.get(Userctry - 1)).get(i).Book_Quantity
                                        + "\n");
                    }
                    System.out.print(
                            "\n");
                    System.out.println("\npress Enter to continue!!!");
                    sc.nextLine();
                    break;
                case 2:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("<--- Welcome to Library App --->\n");
                    System.out.println("<--- Categories --->\n");
                    int serialnum1 = 0;
                    int serial2 = 0;
                    for (int i = 0; i < libraryadmin.SerialRef.size(); i++) {
                        System.out.println((++serialnum1) + "." + libraryadmin.SerialRef.get(i) + "\n");
                    }
                    System.out.println("Select the Category ->");
                    Userctry = sc.nextInt();
                    sc.nextLine();
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("<--- Welcome to Library App --->\n");
                    System.out.println("Category -> " + libraryadmin.SerialRef.get(Userctry - 1));
                    System.out.println(
                            "");
                    System.out.printf("%3s %7s %24s %28s %20s", "S.No", "ISBN", "BOOK NAME", "BOOK AUTHOR",
                            "BOOK QUANTITY");
                    System.out.println(
                            "\n");
                    for (int i = 0; i < libraryadmin.Category.get(libraryadmin.SerialRef.get(Userctry - 1))
                            .size(); i++) {
                        System.out.printf("%3s %7s %24s %28s %20s", (++serial2) + ".",
                                libraryadmin.Category.get(libraryadmin.SerialRef.get(Userctry - 1)).get(i).isbn,
                                libraryadmin.Category.get(libraryadmin.SerialRef.get(Userctry - 1)).get(i).Book_Name,
                                libraryadmin.Category.get(libraryadmin.SerialRef.get(Userctry - 1)).get(i).Auther_Name,
                                libraryadmin.Category.get(libraryadmin.SerialRef.get(Userctry - 1)).get(i).Book_Quantity
                                        + "\n");
                    }
                    System.out.print(
                            "\n");
                    System.out.print("Select the Book to Borrow -> ");
                    boolean status = true;
                    int User_Choice = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < UserCollection.size(); i++) {
                        if (UserCollection.get(i).Emailid.equals(User_Emailid)) {
                            for (int ki = 0; ki < UserCollection.get(i).Borrowed_Books.size(); ki++) {
                                if (UserCollection.get(i).Borrowed_Books.get(ki).Book_Name
                                        .equals(libraryadmin.Category.get(libraryadmin.SerialRef.get(Userctry - 1))
                                                .get(User_Choice - 1).Book_Name)) {
                                    status = false;
                                    System.out.println("Book already in your borrowed list!!!");
                                    break;

                                }

                            }
                        }

                    }
                    if (status) {
                        if (libraryadmin.Category.get(libraryadmin.SerialRef.get(Userctry - 1))
                                .get(User_Choice - 1).Book_Quantity >= 1) {
                            for (int i = 0; i < UserCollection.size(); i++) {
                                if (UserCollection.get(i).Emailid.equals(User_Emailid)) {
                                    if (UserCollection.get(i).deposit >= 500) {
                                        if (UserCollection.get(i).Borrowed_Books.size() != 3) {
                                            String Date_Borrow = "01/01/2022";
                                            String dd[] = Date_Borrow.split("/");
                                            int a = Integer.parseInt(dd[0]) + 15;
                                            String return_Date = a + "" + "/" + dd[1] + "/" + dd[2];
                                            System.out.println("Your Borrowed Date is " + Date_Borrow);
                                            System.out.println("Your Return Date is " + return_Date);
                                            System.out.println("Books Borrowed Successfully!!!!");
                                            UserCollection.get(i).History.add(
                                                    libraryadmin.Category.get(libraryadmin.SerialRef.get(Userctry - 1))
                                                            .get(User_Choice - 1).Book_Name + " Book Borrowerd "
                                                            + Date_Borrow);
                                            libraryadmin.Category.get(libraryadmin.SerialRef.get(Userctry - 1))
                                                    .get(User_Choice - 1).Book_Quantity--;
                                            libraryadmin.IsbnSearch.get(
                                                    libraryadmin.Category.get(libraryadmin.SerialRef.get(Userctry - 1))
                                                            .get(User_Choice - 1).isbn).Book_Quantity--;
                                            UserCollection
                                                    .get(i).Borrowed_Books
                                                            .add(new Borrow(
                                                                    libraryadmin.Category
                                                                            .get(libraryadmin.SerialRef
                                                                                    .get(Userctry - 1))
                                                                            .get(User_Choice - 1).isbn,
                                                                    libraryadmin.Category
                                                                            .get(libraryadmin.SerialRef
                                                                                    .get(Userctry - 1))
                                                                            .get(User_Choice - 1).Book_Name,
                                                                    Date_Borrow, return_Date,
                                                                    libraryadmin.SerialRef.get(Userctry - 1)));
                                            break;
                                        } else {
                                            System.out.println(
                                                    "Maximum Borrow Limit Reached!!!pls return Book to New Book!!!");
                                            break;
                                        }

                                    } else {
                                        System.out.println("Add the Amount to Deposit to Borrow!!!!");
                                    }
                                }
                            }
                            // System.out.println("Book borrowed success!!!");
                        }
                    }
                    System.out.println("\npress Enter to continue!!!");
                    sc.nextLine();
                    break;
                case 3:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("<--- Welcome to Library App --->\n");
                    int Serial_Num = 0;
                    for (int i = 0; i < UserCollection.size(); i++) {
                        if (UserCollection.get(i).Emailid.equals(User_Emailid)) {
                            if (UserCollection.get(i).Borrowed_Books.size() >= 1) {
                                System.out.println("<--- Borrowed Books --->");
                                System.out.println(
                                        "\n");
                                System.out.printf("%3s %7s %24s %28s %20s", "S.No", "ISBN", "BOOK NAME",
                                        "BORROWED DATE", "RETURN DATE");
                                System.out.println(
                                        "\n");
                                for (int j = 0; j < UserCollection.get(i).Borrowed_Books.size(); j++) {
                                    System.out.printf("%3s %7s %24s %28s %21s", (++Serial_Num) + ".",
                                            UserCollection.get(i).Borrowed_Books.get(j).isbn,
                                            UserCollection.get(i).Borrowed_Books.get(j).Book_Name,
                                            UserCollection.get(i).Borrowed_Books.get(j).Borrowed_Date,
                                            UserCollection.get(i).Borrowed_Books.get(j).Return_Date + "\n");
                                }
                                System.out.println(
                                        "");
                            } else {
                                System.out.println("No Books Borrowed!!!!");
                            }
                            break;
                        }
                    }
                    System.out.println("press Enter to continue!!!");
                    sc.nextLine();
                    break;
                case 4:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("<--- Welcome to Library App --->\n");
                    int Serial_Num2 = 0;
                    boolean status1 = false;
                    int index = 0;
                    for (int i = 0; i < UserCollection.size(); i++) {
                        if (UserCollection.get(i).Emailid.equals(User_Emailid)) {
                            if (UserCollection.get(i).Borrowed_Books.size() >= 1) {
                                System.out.println("<--- Borrowed Books --->");
                                System.out.println(
                                        "\n");
                                System.out.printf("%3s %7s %24s %28s %20s", "S.No", "ISBN", "BOOK NAME",
                                        "BORROWED DATE", "RETURN DATE");
                                System.out.println(
                                        "\n");
                                for (int j = 0; j < UserCollection.get(i).Borrowed_Books.size(); j++) {
                                    index = i;
                                    status1 = true;
                                    System.out.printf("%3s %7s %24s %28s %21s", (++Serial_Num2) + ".",
                                            UserCollection.get(i).Borrowed_Books.get(j).isbn,
                                            UserCollection.get(i).Borrowed_Books.get(j).Book_Name,
                                            UserCollection.get(i).Borrowed_Books.get(j).Borrowed_Date,
                                            UserCollection.get(i).Borrowed_Books.get(j).Return_Date + "\n");
                                }
                                System.out.println(
                                        "");
                            } else {
                                System.out.println("No Books Borrowed!!!!");
                            }
                            break;
                        }
                    }
                    if (status1) {
                        System.out.print("Select the Book You want to Return ->");
                        int User_Choice_Return = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter the Return Date (dd/mm/yyyy) ->");
                        String Return_Date = sc.nextLine();
                        String Return[] = Return_Date.split("/");
                        String Official_Return[] = UserCollection.get(index).Borrowed_Books
                                .get(User_Choice_Return - 1).Borrowed_Date.split("/");

                        String Off_Ret[] = UserCollection.get(index).Borrowed_Books
                                .get(User_Choice_Return - 1).Return_Date.split("/");
                        int Difference_Days = Math.abs(Integer.parseInt(Return[0]) - Integer.parseInt(Off_Ret[0]));
                        if (Integer.parseInt(Return[0]) <= Integer.parseInt(Off_Ret[0])) {

                            int size = libraryadmin.Category
                                    .get(UserCollection.get(index).Borrowed_Books.get(User_Choice_Return - 1).Category1)
                                    .size();
                            for (int i = 0; i < size; i++) {
                                if (libraryadmin.Category.get(
                                        UserCollection.get(index).Borrowed_Books.get(User_Choice_Return - 1).Category1)
                                        .get(i).Book_Name
                                                .equals(UserCollection.get(index).Borrowed_Books
                                                        .get(User_Choice_Return - 1).Book_Name)) {
                                    libraryadmin.Category.get(UserCollection.get(index).Borrowed_Books
                                            .get(User_Choice_Return - 1).Category1).get(i).Book_Quantity++;
                                    libraryadmin.IsbnSearch.get(UserCollection.get(index).Borrowed_Books
                                            .get(User_Choice_Return - 1).isbn).Book_Quantity++;
                                    break;
                                }
                            }

                            System.out.println("Book Returned Successfully!!!");
                            UserCollection.get(index).History.add(UserCollection.get(index).Borrowed_Books
                                    .get(User_Choice_Return - 1).Book_Name + " Books Returned  on "
                                    + UserCollection.get(index).Borrowed_Books.get(User_Choice_Return - 1).Return_Date);
                            if (UserCollection.get(index).fines.contains(
                                    UserCollection.get(index).Borrowed_Books.get(User_Choice_Return - 1).Book_Name)) {
                                UserCollection.get(index).fines.remove(
                                        UserCollection.get(index).Borrowed_Books.get(User_Choice_Return - 1).Book_Name);
                            }
                            UserCollection.get(index).Borrowed_Books.remove(User_Choice_Return - 1);

                        } else {
                            int fine_Amount = (Difference_Days) * 10;
                            System.out.println("Return date is over So Rs." + fine_Amount + " is debited from account");
                            ;
                            UserCollection.get(index).fines.add("Late Return fine =" + fine_Amount);
                            UserCollection.get(index).deposit = UserCollection.get(index).deposit - fine_Amount;
                            int size = libraryadmin.Category
                                    .get(UserCollection.get(index).Borrowed_Books.get(User_Choice_Return - 1).Category1)
                                    .size();
                            for (int i = 0; i < size; i++) {

                                if (libraryadmin.Category.get(
                                        UserCollection.get(index).Borrowed_Books.get(User_Choice_Return - 1).Category1)
                                        .get(i).Book_Name
                                                .equals(UserCollection.get(index).Borrowed_Books
                                                        .get(User_Choice_Return - 1).Book_Name)) {
                                    libraryadmin.Category.get(UserCollection.get(index).Borrowed_Books
                                            .get(User_Choice_Return - 1).Category1).get(i).Book_Quantity++;
                                    libraryadmin.IsbnSearch.get(UserCollection.get(index).Borrowed_Books
                                            .get(User_Choice_Return - 1).isbn).Book_Quantity++;
                                    break;
                                }
                            }

                            System.out.println("Book Returned Successfully!!!");
                            UserCollection.get(index).History.add(UserCollection.get(index).Borrowed_Books
                                    .get(User_Choice_Return - 1).Book_Name + " Books Returned  on "
                                    + UserCollection.get(index).Borrowed_Books.get(User_Choice_Return - 1).Return_Date);

                            if (UserCollection.get(index).fines.contains(
                                    UserCollection.get(index).Borrowed_Books.get(User_Choice_Return - 1).Book_Name)) {
                                UserCollection.get(index).fines.remove(
                                        UserCollection.get(index).Borrowed_Books.get(User_Choice_Return - 1).Book_Name);
                            }
                            UserCollection.get(index).Borrowed_Books.remove(User_Choice_Return - 1);
                        }
                    }

                    System.out.println("press Enter to continue!!!");
                    sc.nextLine();
                    break;
                case 5:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("<--- Welcome to Library App --->\n");
                    boolean status2 = false;
                    int Serial_Num3 = 0;
                    int index1 = 0;
                    for (int i = 0; i < UserCollection.size(); i++) {
                        if (UserCollection.get(i).Emailid.equals(User_Emailid)) {
                            if (UserCollection.get(i).Borrowed_Books.size() >= 1) {
                                System.out.println("<--- Borrowed Books --->");
                                System.out.println(
                                        "\n");
                                System.out.printf("%3s %7s %24s %28s %20s", "S.No", "ISBN", "BOOK NAME",
                                        "BORROWED DATE", "RETURN DATE");
                                System.out.println(
                                        "\n");
                                for (int j = 0; j < UserCollection.get(i).Borrowed_Books.size(); j++) {
                                    index1 = i;
                                    status2 = true;
                                    ArrayList<Borrow> book = UserCollection.get(i).Borrowed_Books;
                                    System.out.printf("%3s %7s %24s %28s %21s", (++Serial_Num3) + ".", book.get(j).isbn,
                                            book.get(j).Book_Name, book.get(j).Borrowed_Date,
                                            book.get(j).Return_Date + "\n");
                                }
                                System.out.println(
                                        "");
                            } else {
                                System.out.println("No Books Borrowed!!!!");
                            }
                            break;
                        }
                    }
                    if (status2) {
                        System.out.println("Select the books to extend time ->");
                        User_Extend = sc.nextInt();
                        sc.nextLine();
                        System.out
                                .println("Enter the No.Of.Days to Extend (Maximum extend oer book is 5 days only) ->");
                        int extend = sc.nextInt();
                        sc.nextLine();
                        if (extend <= 5) {
                            if (!UserCollection.get(index1).extend_book.contains(
                                    UserCollection.get(index1).Borrowed_Books.get(User_Extend - 1).Book_Name)) {
                                String ab[] = UserCollection.get(index1).Borrowed_Books.get(User_Extend - 1).Return_Date
                                        .split("/");
                                int New_Date = Integer.parseInt(ab[0]) + extend;
                                UserCollection.get(index1).Borrowed_Books.get(User_Extend - 1).Return_Date = New_Date
                                        + "" + "/" + ab[1] + "/" + ab[2];
                                System.out.println("Date Extended Successfully!!!");
                                UserCollection.get(index1).extend_book
                                        .add(UserCollection.get(index1).Borrowed_Books.get(User_Extend - 1).Book_Name);

                            } else {
                                System.out.println("Already Date Extended For Book!!!");
                            }
                        }

                    }
                    System.out.println("press Enter to continue!!!");
                    sc.nextLine();
                    break;
                case 6:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("<--- Welcome to Library App --->\n");
                    System.out.println("<--- Your History --->\n");
                    int serial_Num4 = 0;
                    for (int i = 0; i < UserCollection.size(); i++) {
                        if (UserCollection.get(i).Emailid.equals(User_Emailid)) {
                            for (int j = 0; j < UserCollection.get(i).History.size(); j++) {
                                System.out.println(++serial_Num4 + "." + UserCollection.get(i).History.get(j));
                            }
                        }
                    }
                    System.out.println("press Enter to continue!!!");
                    sc.nextLine();
                    break;
                case 7:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("<--- Welcome to Library App --->\n");
                    for (int i = 0; i < UserCollection.size(); i++) {
                        if (UserCollection.get(i).Emailid.equals(User_Emailid)) {
                            System.out.println("Your available Deposit is -> " + UserCollection.get(i).deposit);
                            System.out.println("Enter 1 to add extra amount or 0 to exit!!!");
                            int User_Choice3 = sc.nextInt();
                            if (User_Choice3 == 1) {
                                System.out.print("\nEnter the Amount to Add -> ");
                                int New_Deposit = sc.nextInt();
                                sc.nextLine();
                                UserCollection.get(i).deposit = UserCollection.get(i).deposit + New_Deposit;
                                System.out.println("\nYour Amount Deposited Successfully!!!\n");
                            } else {
                                break;
                            }
                        }
                    }
                    System.out.println("press Enter to continue!!!");
                    sc.nextLine();
                    break;
                case 8:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("<--- Welcome to Library App --->\n");
                System.out.println("<--- collected Fines --->");
                int serial_Num5=0;
                for (int i = 0; i < UserCollection.size(); i++) {
                    if (UserCollection.get(i).Emailid.equals(User_Emailid)) {
                        for(int j=0;j<UserCollection.get(i).fines.size();j++){
                            System.out.println(++serial_Num5+"."+UserCollection.get(i).fines.get(j));
                        }
                    }
                }
                   System.out.println("press Enter to continue!!!");
                   sc.nextLine();
                    break;
                    case 9:
                    kpr = false;
                    break;
            }
        } while (kpr);
    }

    public void library_user_home() {
        int UserChoice;
        boolean kpr = true;
        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("<--- Welcome to Library App --->");
            System.out.print("\n1.New User\n\n2.Existing User\n\n3.Exit\n\nEnter your Choice -> ");
            UserChoice = sc.nextInt();
            sc.nextLine();
            switch (UserChoice) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("<--- Welcome to Library App --->");
                    System.out.println(
                            "\nRules And Regulations:\n\ni)User Should Deposit 1500 as intial Deposit and Maintain 500 in each Book Borrow\n\nii)User Should be able to borrow 3 Books only at a time\n\nEnter 0 to Exit or Enter 1 to Continue");
                    int Accept = sc.nextInt();
                    sc.nextLine();
                    if (Accept == 0) {
                        break;
                    } else {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("<--- Welcome to Library App --->");
                        System.out.print("\nEnter Your Name ->");
                        String User_Name = sc.nextLine();
                        System.out.print("\nEnter Your Email Id ->");
                        String User_Emailid = sc.nextLine();
                        System.out.print("\nEnter Your Password ->");
                        int User_Password = sc.nextInt();
                        sc.nextLine();
                        System.out.print("\nEnter Your Deposit(Deposit Should be >=1500) ->");
                        int User_Deposit = sc.nextInt();
                        sc.nextLine();
                        if (User_Deposit >= 1500) {
                            UserCollection.add(new userData(User_Name, User_Emailid, User_Password, User_Deposit,
                                    new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
                            System.out.println("\nUser Registerd Successfully");
                        } else {
                            System.out.println("Pls Enter Deposit more than 1500!!!");
                        }
                        System.out.println("\npress Enter to continue!!!");
                        sc.nextLine();
                    }
                    break;
                case 2:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    boolean status = false;
                    System.out.println("<--- Welcome to Library App --->");
                    System.out.print("\nEnter Your Email Id ->");
                    User_Emailid = sc.nextLine();
                    System.out.print("\nEnter Your Password ->");
                    int User_Password = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < UserCollection.size(); i++) {
                        if (UserCollection.get(i).Emailid.equals(User_Emailid)) {
                            if (UserCollection.get(i).Password == User_Password) {
                                status = true;
                                user.User_page();
                            }
                        }
                    }
                    if (!status) {
                        System.out.println("\nInvalid Username or Password!!!");
                        System.out.println("\npress Enter to continue!!!");
                        sc.nextLine();
                    }
                    break;
                case 3:
                    kpr = false;
                    break;
            }
        } while (kpr);
    }
}
