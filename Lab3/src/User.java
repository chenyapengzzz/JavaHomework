@Table("user")
public class User {
    @Column("id")
    private int id;

    @Column("username")
    private String username;

    @Column("age")
    private String age;

    @Column("email")
    private String email;

    @Column("telephone")
    private String telephone;

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
