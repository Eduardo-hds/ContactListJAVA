
import java.lang.Comparable;

public class Contacs implements Comparable<Contacs>{
    private String name;
    private String age;
    private String email;

    public Contacs(String name, String age, String email){
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return " Name: " + name + ", Age: " + age + ", E-mail: " + email;
    }

    @Override
    public int compareTo(Contacs otherContact) {
        char firstContactLetter = Character.toLowerCase(this.name.charAt(0));
        char secondContactLetter = Character.toLowerCase(otherContact.name.charAt(0));

        int comparison = firstContactLetter - secondContactLetter;

        if (comparison == 0){
            return this.name.compareTo(otherContact.name);
        }

        return comparison;
    }
}
