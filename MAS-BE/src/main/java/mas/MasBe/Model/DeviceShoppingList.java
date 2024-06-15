package mas.MasBe.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class DeviceShoppingList extends ShoppingList implements IdGenerateable<DeviceShoppingList> {
    @Id
    private int id;
    private String description;

    @ManyToMany
    private Set<Device> devices = new HashSet<>();

    public static Set<DeviceShoppingList> extension = new HashSet<>();

    @Override
    public void display() {
        System.out.println("name:" + name + " description: " + description);
    }

    public void addDevice(Device device) {
        if (!devices.contains(device)) {
            devices.add(device);
            device.addShoppingList(this);
        }
    }

    public static DeviceShoppingList createDeviceShoppingList(String description, Device device) {
        // ik but, hibernate needs public constructor :((
        if (description == null || description.isEmpty() || device == null) {
            throw new IllegalArgumentException("cannot create list without device");
        }

        DeviceShoppingList created = new DeviceShoppingList();
        created.setId(created.generateNewId());
        created.addDevice(device);
        created.setDescription(description);

        extension.add(created);

        return created;
    }

    @Override
    public Set<DeviceShoppingList> getExtension() {
        return extension;
    }
}
