package by.realovka.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "ADDRESSES")
@NamedQuery(name = "Address.updateCity", query = "update Address set city =:city where id =: id")
@NamedQuery(name = "Address.updateStreet", query = "update Address set street =:street where id =: id")
@NamedQuery(name = "Address.updateHouse", query = "update Address set house =:house where id =: id")
@NamedQuery(name = "Address.updateFlat", query = "update Address set flat =:flat where id =: id")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String street;  
    private String house;
    private String flat;
    private String category;

    public Address(String city, String street, String house, String flat, String category) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.category = category;
    }
}