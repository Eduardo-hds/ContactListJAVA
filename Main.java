import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        List<User> users = new ArrayList<>();
        users.add(new User("Admin", "1234"));
        users.add(new User("Eduardo", "1234"));

        Scanner sc = new Scanner(System.in);
        LoginPage loginPage = new LoginPage();
        Menu menu = new Menu();

        int option = loginPage.loginPage();

        boolean logginAproved = false;

        while (!logginAproved){

            if (option == 1){
                List<String> credentials = loginPage.loginNamePassword();

                for (User user : users){
                    if(credentials.get(0).equals(user.getName())){
                        String loopName = credentials.get(0);
                        String loopPassword = credentials.get(1);
                        Autenticator loopAutenticator = user;

                        boolean loginTeste = loginPage.login(loopName, loopPassword, loopAutenticator);

                        if(loginTeste){
                            logginAproved = true;
                            break;
                        }
                    }
                }
                if (!logginAproved){
                    System.out.println("User or password wrong!");
                    System.out.print("Enter 1 to try again, or 2 to create a new user!");
                    option = sc.nextInt();
                    sc.nextLine();
                }
            } else if (option == 2) {
                List<String> credentials = loginPage.loginNamePassword();
                try {
                    boolean userExistence = false;
                    boolean nameExist = false;

                    while (!userExistence){

                        for (User user : users){
                            if(user.getName().equalsIgnoreCase(credentials.getFirst())){
                                System.out.println("Name already exist! Try again!");
                                credentials = loginPage.loginNamePassword();

                                nameExist = true;
                                break;
                            }
                        }

                        if(!nameExist){

                            users.add(new User(credentials.get(0), credentials.get(1)));
                            System.out.println("Successful user creation!");
                            System.out.println("Enter your credentials!");

                            option = 1;
                            userExistence = true;
                        }else{
                            nameExist = false;
                        }
                    }

                } catch (Exception e) {
                    System.out.println("ERROR to create a user!");
                }
            }
        }

        if (logginAproved){
            System.out.println("Initializing the system!");

            int menuOption = 0;

            while (menuOption != 5){
                menuOption = menu.menu();
            }
            System.out.println("See you soon!");
            System.out.println("Closing ...");
        }
    }
}
