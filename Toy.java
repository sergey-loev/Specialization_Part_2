public class Toy {
    private static int tmpId;
    private int id;
    private String name;
    private int quantity;
    private int chance;

    public Toy(String name, int quantity, int chance) {
        this.id = ++tmpId;
        this.name = name;
        this.quantity = quantity;
        this.chance = chance;
    }

    public int getId() {
        return id;
    }

    public int getChance() {
        return chance;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Игрушка - " + name + ". (Идентификатор = " + id + ", Количество = " + quantity + ", Шанс выпадения = " + chance + ')';
    }

    public void addQuantity(int quantity){
        this.quantity += quantity;
    }

    public void changeChance(int chance){
        this.chance = chance;
    }

    public void reduceQuantity(){
        this.quantity--;
    }
}
