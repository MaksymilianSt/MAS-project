package mas.MasBe.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Device {
    @Id
    private int id;
    private String name;
    private String description;
    @Null
    @Lob
    private byte[] image;
    @Transient
    public static Set<Device> extension = new HashSet<>();

    @ManyToMany
    private Set<DeviceShoppingList> deviceShoppingLists;

    public Optional<byte[]> getImage() {
        return Optional.ofNullable(image);
    }

    public static void displayAllDevices() {
        extension.forEach(System.out::println);
    }

    public void addShoppingList(DeviceShoppingList deviceShoppingList) {
        if (!deviceShoppingLists.contains(deviceShoppingList)) {
            deviceShoppingLists.add(deviceShoppingList);
            deviceShoppingList.addDevice(this);
        }
    }
}

