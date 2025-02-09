import java.util.*;

public class Menu {
    Scanner sc = new Scanner(System.in);
    List<Contacs> contacs = new ArrayList<>();

    public int menu(){

        System.out.println("Menu");
        System.out.println("1 - Show contacts");
        System.out.println("2 - Add a contact");
        System.out.println("3 - Edit a contact");
        System.out.println("4 - Remove a contact");
        System.out.println("5 - Exit");

        System.out.print("Enter your option:");
        int option = sc.nextInt();
        sc.nextLine();

        switch (option){
            case 1:
                Collections.sort(contacs);

                //todo exibir contatos
                if (contacs.isEmpty()){
                    System.out.println("Contact list is empty!");
                }else {
                    showContacs(contacs);
                    System.out.println("Press enter to continue!");
                }

                sc.nextLine();

                break;

            case 2:
                // adicionar contato
                contacs.add(addContacs());
                System.out.println("Contact added!");
                break;

            case 3:
                // editar contato
                if (contacs.isEmpty()){
                    System.out.println("Contact list is empty!");
                }else {
                    showContacs(contacs);
                    System.out.print("Select the ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    if(id >= 0 && id <= contacs.size()){

                        Contacs editedContact = addContacs();
                        contacs.set(id, editedContact);
                        System.out.println("Contact edited!");
                    }else {
                        System.out.println("Invalid ID!");
                    }
                }
                break;

            case 4:
                // remover contato
                if (contacs.isEmpty()){
                    System.out.println("Contact list is empty!");
                }else {
                    showContacs(contacs);
                    System.out.print("Select the ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    if(id >= 0 && id <= contacs.size()){
                        contacs.remove(id);
                        System.out.println("Contact removed!");
                    }else {
                        System.out.println("Invalid ID!");
                    }
                }
                break;

            case 5:
                return 5;

        }
        return option;
    }

    public void showContacs(List<Contacs> contacs){

        Collections.sort(contacs);

        int id = 0;
        for (Contacs contact : contacs){
            System.out.println(id + " - "+ contact);
            id += 1;
        }
    }

    public Contacs addContacs(){

        System.out.print("Enter the name: ");
        String name = sc.nextLine();

        System.out.print("Enter the age: ");
        String age = sc.nextLine();

        System.out.print("Enter the email: ");
        String email = sc.nextLine();

        return new Contacs(name, age, email);
    }
}
