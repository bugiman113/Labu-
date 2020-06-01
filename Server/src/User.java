/**
 * Именно объекты этого класса находятся в коллекции пользователей
 */
public class User {
    private String Login;
    private String Parol;
    private Long Idus;
    private int color;
    public User(String login,String parol,Long idus,int color){
        this.Idus=idus;
        this.Login=login;
        this.Parol=parol;
        this.color=color;
    }
    public Long getIdus() { return Idus; }

    public String getLogin() { return Login; }

    public String getParol() {return Parol; }

    public int getColor(){return color;}
}
