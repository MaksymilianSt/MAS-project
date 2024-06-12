package mas.MasBe.Models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
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
    @Nullable
    @Lob
    private byte [] image;

    @ManyToMany
    private Set<DeviceShoppingList> deviceShoppingLists;

}

