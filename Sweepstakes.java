import java.util.Scanner;

public class Sweepstakes {
    public static void run() {
        String menu = """
                Комманды:
                1 - Добавить новую игрушку в розыгрыш
                2 - Добавить игрушек в розыгрыш по id
                3 - Изменить частоту выпадения
                4 - Разыграть игрушку
                5 - Посмотреть список разыгранных игрушек
                6 - Выдать разыгранную игрушку
                7 - Показать игрушки для розыгрыша
                0 - Завершить программу
                """;

        System.out.print("Розыгрыш игрушек!\n");
        boolean run = true;
        String command;
        ToyStorage toyStorage = new ToyStorage();
        QueueIssue queueIssue = new QueueIssue();
        while (run) {
            System.out.print(menu);
            command = input("Введите команду: ");
            switch (command) {
                case "1" -> {
                    Toy newToy = createToy();
                    toyStorage.add(newToy);
                }
                case "2" -> {
                    toyStorage.showToysList();
                    int toyId = intInput("Ввидите ID продукта из списка:");
                    int quantity = intInput("Ввидите количество для добавления:");
                    toyStorage.addToyQuantity(toyId, quantity);
                }
                case "3" -> {
                    toyStorage.showToysList();
                    int toyId = intInput("Ввидите ID продукта из списка:");
                    int quantity = intInput("Введите частоту выпадения игрушки (число от 1 до 100):");
                    toyStorage.changeToyChance(toyId, quantity);
                }
                case "4" -> Raffler.startRaffle(toyStorage, queueIssue);
                case "5" -> queueIssue.showQueue();
                case "6" -> queueIssue.issueToy();
                case "7" -> toyStorage.showToysList();
                case "0" -> run = false;
                default -> System.out.print("Такой команды не существует. Введите команду из списка!\n");
            }
            System.out.println("\n\n");
        }
    }
    public static String input(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
    public static int intInput(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextInt();
    }
    public static Toy createToy(){
        String name = input("Введите наименование игрушки:");
        int quantity = intInput("Введите количество игрушек для розыгрыша:");
        int chance = intInput("Введите частоту выпадения игрушки (число от 1 до 100):");
        return new Toy(name, quantity, chance);
    }
}
