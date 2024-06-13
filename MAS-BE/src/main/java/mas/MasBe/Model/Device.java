package mas.MasBe.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    @Null
    @Lob
    private byte [] image;

    @ManyToMany
    private Set<DeviceShoppingList> deviceShoppingLists;

}

