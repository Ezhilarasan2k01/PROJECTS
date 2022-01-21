import java.util.*;

public class Main {
    static ArrayList<admin1> AdminDetails = new ArrayList<admin1>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AdminDetails.add(new admin1("e@gmail.com", 1));
        libraryUser.UserCollection.add(new userData("az", "ez@gmail.com", 1, 1500, new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>()));
        libraryUser.UserCollection.get(0).Borrowed_Books
                .add(new Borrow(1111, "Atomic Structure", "01/01/2022", "16/01/2022", "Science"));
        // System.out.println(libraryUser.UserCollection.get(0).Borrowed_Books.get(0).Book_Name);
        libraryadmin.Category.put("Science",
                new ArrayList<>(List.of(new books(1111, "Atomic Structure", "Luies Caron", 12),
                        new books(5555, "Cosmos", "Carl Sagan", 2),
                        new books(6666, "God Of Science", "Luies Califer", 35))));
        libraryadmin.Category.put("Maths",
                new ArrayList<>(List.of(new books(2222, "Algebra", "Luies Caron", 12),
                        new books(7777, "Trignometry", "Carl Sagan", 23),
                        new books(8888, "Father of Maths", "Luies Califer", 55))));
        libraryadmin.Category.put("Comics",
                new ArrayList<>(List.of(new books(3333, "Funny Blasters", "Luies Caron", 18),
                        new books(9999, "God of War", "Carl Sagan", 23),
                        new books(1114, "Funny Stories", "Luies Califer", 75))));
        libraryadmin.IsbnSearch.put(1111, (new books(1111, "Atomic Structure", "Luies Caron", 12)));
        libraryadmin.IsbnSearch.put(5555, (new books(5555, "Cosmos", "Carl Sagan", 2)));
        libraryadmin.IsbnSearch.put(6666, (new books(6666, "God Of Science", "Luies Califer", 35)));
        libraryadmin.IsbnSearch.put(3333, (new books(3333, "Funny Blasters", "Luies Caron", 18)));
        libraryadmin.IsbnSearch.put(2222, (new books(2222, "Algebra", "Luies Caron", 12)));
        libraryadmin.IsbnSearch.put(7777, (new books(7777, "Trignometry", "Carl Sagan", 23)));
        libraryadmin.IsbnSearch.put(8888, (new books(8888, "Father of Maths", "Luies Califer", 55)));
        libraryadmin.IsbnSearch.put(9999, (new books(9999, "God of War", "Carl Sagan", 23)));
        libraryadmin.IsbnSearch.put(1114, (new books(1114, "Funny Stories", "Luies Califer", 75)));
        libraryUser UserPage = new libraryUser();
        libraryadmin AdminPage = new libraryadmin();
        boolean kpr = true;
        int UserChoice;
        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("<--- Welcome to Library App --->");
            System.out.println("\n1.Admin\n\n2.User\n\n3.Exit\n");
            System.out.print("Enter Your Choice : ");
            UserChoice = sc.nextInt();
            sc.nextLine();
            switch (UserChoice) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("<--- Welcome to Library App --->" + "\n");
                    System.out.print("Enter Email id -> ");
                    String EmailId = sc.nextLine();
                    System.out.print("\nEnter Password -> ");
                    int Password = sc.nextInt();
                    sc.nextLine();
                    boolean Status = false;
                    for (int i = 0; i < AdminDetails.size(); i++) {
                        if (AdminDetails.get(i).EmailId.equals(EmailId)) {
                            if (AdminDetails.get(i).Password == Password) {
                                Status = true;
                                break;
                            }
                        }

                    }
                    if (Status) {
                        AdminPage.AdminHome();
                    } else {
                        System.out.println("\nInvalid Password or Userid");
                        System.out.println("\npress Enter to continue!!!");
                        sc.nextLine();
                    }
                    break;
                case 2:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    UserPage.library_user_home();
                    break;
                case 3:
                    kpr = false;
                    break;
            }
        } while (kpr);
    }
}
