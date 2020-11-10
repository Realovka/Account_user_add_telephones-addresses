package by.realovka.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "USERS")
@NamedQuery(name = "User.findByLogin", query = "from User where login=: login")
@NamedQuery(name = "User.findByLoginAndPassword", query = "from User where login=: login and password=: password")
@NamedQuery(name = "User.findUserByLogin", query = "from User where login=: login")
@NamedQuery(name = "User.findAll",query = "from User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String login;
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private List<Telephone> telephones = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private List<Address> addresses = new ArrayList<>();

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }
}
