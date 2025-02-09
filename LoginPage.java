
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LoginPage {
    Scanner sc = new Scanner(System.in);


    public int loginPage(){

        int autenticationPage= 0;
        int option = 0;

        while (autenticationPage != 10){
            System.out.println("Autentication page!");
            System.out.println("1 - I already have an account!");
            System.out.println("2 - Create an account!");

            boolean optionExit = false;

            while (!optionExit){
                try {
                    System.out.print("Enter your option ( 1 / 2 )");
                    option = sc.nextInt();
                    if (option == 1 || option == 2){
                        optionExit = true;
                    }else {
                        option = 0;
                        sc.nextLine();
                    }

                }catch (InputMismatchException e){
                    System.out.print("Invalid input! Please enter one of the two values!");
                    sc.nextLine();

                }catch (Exception e) {
                    System.out.print("Something went worng!");
                    sc.nextLine();
                }

            }

            optionExit = false;

            try {
                if (option == 1){
                    autenticationPage = 10;
                    sc.nextLine();

                } else if (option == 2) {
                    autenticationPage = 10;
                    sc.nextLine();

                }

            }catch (Exception e){
                System.out.print("Something went wrong!");
                sc.nextLine();

            }

        }
        return  option;
    }

    public List<String> loginNamePassword(){
        String name = "";
        String password = "";
        List<String> credentials = new ArrayList<>();


            System.out.print("Enter your user: ");
            name = sc.nextLine();

            System.out.print("Enter your password: ");
            password = sc.nextLine();

            credentials.add(name);
            credentials.add(password);

        return credentials;
    }


    public boolean login(String name, String password, Autenticator autenticator){
        boolean loginAutentication = false;

        while(!loginAutentication){
            try{
                if (autenticator.autenticator(name, password)){
                    System.out.println("Logging!");
                    return true;
                }else {
                    return false;
                }

            } catch (Exception e) {
                System.out.println("Login error!");
                sc.nextLine();
            }
        }
        return true;
    }

}
