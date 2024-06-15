package mas.MasBe.Model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ShoppingList {
    protected String name;

    protected void display() {
        System.out.println("name: " + name);
    }
}
