import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale.Category;
import java.util.Random;
import java.lang.Thread.State;
import java.util.*;

public class libraryadmin {
    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer, books> IsbnSearch = new HashMap<>();
    static HashMap<String, ArrayList<books>> Category = new HashMap<>();
    static ArrayList<String> SerialRef = new ArrayList<String>(List.of(("Maths"), ("Science"), ("Comics")));
    static libraryadmin Admin = new libraryadmin();
    static Main Home = new Main();
    static ArrayList<String> Catogory_Name = new ArrayList<String>();
    static ArrayList<String> report = new ArrayList<>();
    static Random rand = new Random();
    static int Random_Number = 0;

    public void modify_book() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("<--- Welcome to Library App --->");
        System.out.print("\nEnter the Isbn Number of the Book -> ");
        int Modify_bookByIsbn = sc.nextInt();
        int Serial = 0;
        sc.nextLine();
        if (IsbnSearch.containsKey(Modify_bookByIsbn)) {
            System.out.print("\n");
            System.out.printf("\n%7s %24s %28s %20s", "ISBN", "BOOK NAME", "BOOK AUTHOR", "BOOK QUANTITY");
            System.out.println("\n");
            System.out.printf("%7s %24s %28s %20s", IsbnSearch.get(Modify_bookByIsbn).isbn,
                    IsbnSearch.get(Modify_bookByIsbn).Book_Name, IsbnSearch.get(Modify_bookByIsbn).Auther_Name,
                    IsbnSearch.get(Modify_bookByIsbn).Book_Quantity);
            System.out.println("\n");
            System.out.println(
                    "1.Modify Book Name\n\n2.Modify Book AuthorName\n\n3.Modify Book Quantity\n\nEnter your Choice -> ");
            int Admin_Choice = sc.nextInt();
            sc.nextLine();
            if (Admin_Choice == 1) {
                System.out.print("\nEnter the New Name of the Book -> ");
                String New_bookname = sc.nextLine();
                IsbnSearch.get(Modify_bookByIsbn).Book_Name = New_bookname;
                for (int i = 0; i < SerialRef.size(); i++) {
                    for (int j = 0; j < Category.get(SerialRef.get(i)).size(); j++) {
                        if (Category.get(SerialRef.get(i)).get(j).isbn == Modify_bookByIsbn) {
                            Category.get(SerialRef.get(i)).get(j).Book_Name = New_bookname;
                        }
                    }
                }
                System.out.println("Name Changed Successfully");
            } else if (Admin_Choice == 2) {
                System.out.print("\nEnter the New Author Name of the Book -> ");
                String New_Authorname = sc.nextLine();
                IsbnSearch.get(Modify_bookByIsbn).Auther_Name = New_Authorname;
                for (int i = 0; i < SerialRef.size(); i++) {
                    for (int j = 0; j < Category.get(SerialRef.get(i)).size(); j++) {
                        if (Category.get(SerialRef.get(i)).get(j).isbn == Modify_bookByIsbn) {
                            Category.get(SerialRef.get(i)).get(j).Auther_Name = New_Authorname;
                        }

                    }
                }
                System.out.println("Author Name Changed Successfully");
            } else if (Admin_Choice == 3) {
                System.out.print("\nEnter the New Quantity of the Book -> ");
                int New_bookquant = sc.nextInt();
                sc.nextLine();
                IsbnSearch.get(Modify_bookByIsbn).Book_Quantity = New_bookquant;
                for (int i = 0; i < SerialRef.size(); i++) {
                    for (int j = 0; j < Category.get(SerialRef.get(i)).size(); j++) {
                        if (Category.get(SerialRef.get(i)).get(j).isbn == Modify_bookByIsbn) {
                            Category.get(SerialRef.get(i)).get(j).Book_Quantity = New_bookquant;
                        }

                    }
                }
                System.out.println("Name Changed Successfully");
            }

            else {
                System.out.println("Invalid Input!!!!");
            }
        } else {
            System.out.println("Invalid Isbn Number!!!!");
        }
        System.out.println("Press Enter Key to Continue!!!");
        sc.nextLine();
    }

    public void Addbook() {
        boolean kpr = true;
        int UserChoice;
        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("<--- Welcome to Library App --->");
            System.out.print(
                    "\n1.Add New Category\n\n2.Add Book in Exixting Category\n\n3.Exit\n\nEnter your Choice -> ");
            UserChoice = sc.nextInt();
            sc.nextLine();
            switch (UserChoice) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("<--- Welcome to Library App --->\n");
                    System.out.println("Enter Catogory Name -> ");
                    String New_Category_Name = sc.nextLine();
                    System.out.println("\nEnter Number of Book Add -> ");
                    int Number_Books = sc.nextInt();
                    for (int i = 0; i < Number_Books; i++) {
                        for (int ki = 1;; ki++) {
                            Random_Number = rand.nextInt((9999 - 100) + 1) + 10;
                            if (!IsbnSearch.containsKey(Random_Number)) {
                                break;
                            } else {
                                continue;
                            }
                        }
                        int Book_Isbn = Random_Number;
                        sc.nextLine();
                        System.out.println("\nEnter Book" + (i + 1) + " Name -> ");
                        String NewBookName = sc.nextLine();
                        System.out.println("\nEnter Author Name -> ");
                        String Book_Author_Name = sc.nextLine();
                        System.out.println("\nEnter the Quantity of " + NewBookName + " Book -> ");
                        int Book_Number = sc.nextInt();

                        IsbnSearch.put(Random_Number, new books(Book_Isbn, NewBookName, Book_Author_Name, Book_Number));
                        if (Category.containsKey(New_Category_Name)) {
                            Category.get(New_Category_Name)
                                    .add(new books(Book_Isbn, NewBookName, Book_Author_Name, Book_Number));
                        } else {

                            Category.put(New_Category_Name, new ArrayList<books>(
                                    List.of(new books(Book_Isbn, NewBookName, Book_Author_Name, Book_Number))));
                            SerialRef.add(New_Category_Name);
                        }
                    }
                    System.out.println("Your Category is Added Successfully!!!");
                    System.out.println("Press Enter Key to Continue!!!");
                    sc.nextLine();
                    sc.nextLine();
                    break;
                case 2:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("<--- Welcome to Library App --->\n");
                    int Serial = 0;
                    boolean status = false;
                    /*
                     * Set keys = Category.keySet();
                     * Iterator i = keys.iterator();
                     * while (i.hasNext()) {
                     * System.out.println((++Serial)+". "+i.next());
                     * }
                     */
                    for (int i = 0; i < SerialRef.size(); i++) {
                        System.out.println((++Serial) + "-> " + SerialRef.get(i));
                    }
                    System.out.println("Select the Catogory to Add Books -> ");
                    int Admin_AddChoice = sc.nextInt();
                    sc.nextLine();
                    if (Admin_AddChoice <= (SerialRef.size())) {
                        System.out.println("\nEnter Number of Book Add -> ");
                        Number_Books = sc.nextInt();
                        for (int i = 0; i < Number_Books; i++) {
                            for (int ki = 1;; ki++) {
                                Random_Number = rand.nextInt((9999 - 100) + 1) + 10;
                                if (!IsbnSearch.containsKey(Random_Number)) {
                                    break;
                                } else {
                                    continue;
                                }
                            }
                            status = true;
                            int Book_Isbn = Random_Number;
                            sc.nextLine();
                            System.out.println("\nEnter Book" + (i + 1) + " Name -> ");
                            String NewBookName = sc.nextLine();
                            System.out.println("\nEnter Author Name -> ");
                            String Book_Author_Name = sc.nextLine();
                            System.out.println("\nEnter the Quantity of " + NewBookName + " Book -> ");
                            int Book_Number = sc.nextInt();
                            sc.nextLine();
                            IsbnSearch.put(Random_Number,
                                    new books(Book_Isbn, NewBookName, Book_Author_Name, Book_Number));
                            Category.get(SerialRef.get(Admin_AddChoice - 1))
                                    .add(new books(Book_Isbn, NewBookName, Book_Author_Name, Book_Number));
                        }
                    } else {
                        System.out.println("Invalid Input!!!");
                    }
                    if (status) {
                        System.out.println("Books Added Successfully!!!");
                    }
                    System.out.println("Press Enter Key to Continue!!!");
                    sc.nextLine();
                    break;
                case 3:
                    kpr = false;
                    break;
            }
        } while (kpr);
    }

    public void AdminHome() {
        boolean kpr = true;
        int UserChoice;
        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("<--- Welcome to Library App --->");
            System.out.print(
                    "\n1.Add Book\n\n2.Modify Book\n\n3.Add Admin\n\n4.Add User\n\n5.Report\n\n6.Exit\n\nEnter your Choice -> ");
            UserChoice = sc.nextInt();
            sc.nextLine();
            switch (UserChoice) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    Admin.Addbook();
                    break;
                case 2:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("<--- Welcome to Library App --->");
                    Admin.modify_book();
                    break;
                case 3:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("<--- Welcome to Library App --->");
                    System.out.print("\nEnter the Emailid of New Admin ->");
                    String New_Admin = sc.nextLine();
                    System.out.print("\nEnter the Password of New Admin ->");
                    int New_AdminPass = sc.nextInt();
                    sc.nextLine();
                    Home.AdminDetails.add(new admin1(New_Admin, New_AdminPass));
                    System.out.println("Admin Account Created Successfully!!!\n\nPress Enter to Continue!!!");
                    sc.nextLine();
                    break;
                case 4:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("<--- Welcome to Library App --->");
                    System.out.println("\nEnter User Name of the User ->");
                    String User_name1 = sc.nextLine();
                    System.out.println("\nEnter User Emailid of the User ->");
                    String User_Email1 = sc.nextLine();
                    System.out.println("\nEnter User Password of the User ->");
                    int Password = sc.nextInt();
                    sc.nextLine();
                    libraryUser.UserCollection.add(new userData(User_name1, User_Email1, Password, 0, new ArrayList<>(),
                            new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
                    System.out.println("\nUser Added Successfully\n");
                    System.out.println("Press Enter Key to Continue!!!");
                    sc.nextLine();
                    break;
                case 5:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("<--- Welcome to Library App --->");
                    System.out.println("\n<---Reports--->\n");
                    Set keys = IsbnSearch.keySet();
                    Iterator i = keys.iterator();
                    while (i.hasNext()) {

                        if (IsbnSearch.get(i.next()).Book_Quantity <= 5) {
                            report.add(IsbnSearch.get(i.next()).Book_Name + " Low Quantity Available pls Refill!!!");

                        }
                    }
                    int Serial_No = 0;
                    if (report.size() >= 1) {
                        for (int ki = 0; ki < report.size(); ki++) {
                            System.out.println(++Serial_No + "." + report.get(ki));
                        }
                    }
                    System.out.println("Press Enter Key to Continue!!!");
                    sc.nextLine();
                    break;
                case 6:
                    kpr = false;
                    break;
            }
        } while (kpr);
    }
}
