import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class QueueIssue {
    private Queue<Toy> queue = new LinkedList<>();
    private final String file_name = "issue_toys.txt";

    public void add(Toy toy) {
        queue.add(toy);
    }
    public void issueToy(){
        if (queue.size() > 0) {
            Toy toy = queue.poll();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_name, true))) {
                writer.write(toy.toString() + "\n");
                System.out.print("Игрушка - " + toy + " успешно выдана победителю.");
            } catch (IOException e) {
                System.out.println("Ошибка при записи файла: " + e.getMessage());
            }
        } else {
            System.out.print("В выдаче нет игрушек!\n");
        }
    }

    public void showQueue() {
        System.out.println("Очередь на вручение:");
        Object[] arrQueue= queue.toArray();
        for (int i = 0; i < arrQueue.length; i++) {
            Toy toy = (Toy) arrQueue[i];
            System.out.println( Integer.toString(1+i) + ". " + toy);
        }
    }

}
