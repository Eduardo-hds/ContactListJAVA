public class User implements Autenticator{

    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean autenticator(String name, String password) {
        return this.name.equals(name) && this.password.equals(password);
    }

    @Override
    public String toString(){
        return "Nome: " + name;
    }

}
