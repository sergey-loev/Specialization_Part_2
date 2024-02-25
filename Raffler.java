import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

public class Raffler{
    //основная задумка в том чтобы используя вероятности доступных для розыгрыша игрушек собрать сортированную коллекцию
    //при добавлении ключ увеличиваем на вероятность выпадения конкретной игрушки,
    //общую вероятность считаем как сумму всех вероятностей доступных для розыгрыша игрушек
    //в зависимости от вероятности выпадения игрушки увеличивается диапазон для выпадения рандомного числа.
    //генерируем рандомное число в диапазоне от одного до максимального значения ключа
    //дальше перебором и сравнением ключа с рандомным числом получаем призовую игрушку.
    public static void startRaffle(ToyStorage toyStorage,QueueIssue queueIssue){
        //создаю сортированую по значению ключа коллекцию
        TreeMap<Integer, Toy> toysForRamdom = new TreeMap<>();
        //получаю игрушки из хранилища для розыгрыша
        HashMap<Integer, Toy> toys = toyStorage.getToys();
        if(toys.size() > 0){
            int keyRandom = 0;
            for(int key : toys.keySet()){
                Toy toy = toys.get(key);
                if(toy.getQuantity()>0){
                    //добавляю игрушки количество которых больше нуля, увеличиваю ключ для элемента коллекции
                    keyRandom += toy.getChance();
                    toysForRamdom.put(keyRandom,toy);
                }else System.out.println("Разыграно все выделенное количество для игрушки - " + toy + ". Игрушка в розыгрыш не включена.");
            }
            if(keyRandom > 0){
                int randomNum = ThreadLocalRandom.current().nextInt(1, keyRandom + 1);
                for(int key : toysForRamdom.keySet()){
                    if (randomNum<=key){
                        Toy winToy = toysForRamdom.get(key);
                        winToy.reduceQuantity();
                        queueIssue.add(winToy);
                        System.out.println("Разыграна игрушка - " + winToy + ". Игрушка добавлена в очередь на получение");
                        break;
                    }
                }
            }else System.out.println("Разыграны все игрушки!!!");

        }else System.out.println("Не добавлены игрушки в розагрыш.");


    }
}
