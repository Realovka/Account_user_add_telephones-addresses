package by.realovka.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "TELEPHONES")
@NamedQuery(name = "Telephone.updateTelephone", query = "update Telephone  set number =: number where id =: id")
@NamedQuery(name = "Telephone.deleteTelephone", query = "delete from Telephone  where id =: id")
public class Telephone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Version
//    private int version;
    private String number;
    private String category;

    public Telephone(String number, String category) {
        this.number = number;
        this.category = category;
    }
}
