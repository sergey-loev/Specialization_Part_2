import java.util.HashMap;

public class ToyStorage {
    private HashMap<Integer, Toy> toys = new HashMap<>();

    public void add(Toy toy) {
        toys.put(toy.getId(), toy);
    }

    public void showToysList() {
        for (int key : toys.keySet()){
            System.out.println(toys.get(key));
        }
    }

    public void addToyQuantity(int keyToy,int quantity){
        Toy toy = toys.get(keyToy);
        toy.addQuantity(quantity);
    }

    public void changeToyChance(int keyToy,int chance){
        Toy toy = toys.get(keyToy);
        toy.changeChance(chance);
    }

    public HashMap<Integer, Toy> getToys() {
        return toys;
    }
}
