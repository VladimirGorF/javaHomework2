import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации
//  запишите в лог-файл.
public class task2_2 {
    public static int[] bubble(int[] arr) {
        System.out.println();

        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    logger(arr); // передаем в логер наш ситерированный массив
                }
            }
        }

        for (int i : arr) {
            System.out.printf("%d ", i);
        }
        System.out.println();
        return arr;
    }

    public static Logger log = Logger.getLogger(task2_2.class.getName());

    public static void someMethod() {
        log.setLevel(Level.INFO);
        log.info("Итерации завершены.");
    }

    public static void logger(int[] arg) {
        try (FileWriter fw = new FileWriter("file.txt", true)) {

            StringBuilder sb = new StringBuilder(); // создаем строку стрингбилдер для записи массива в строку
            for (int i = 0; i < arg.length; i++) {
                sb.append(arg[i]);
            }
            fw.append(sb);
            fw.append("\n");

            StringBuilder sb2 = new StringBuilder(); // создаем еще стрингбилдер для передачи даты и времени события
            for (int i = 0; i < 1; i++) {
                sb2.append(LocalDateTime.now());
            }
            fw.append(sb2);
            fw.append("\n");
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 9, 4, 7, 1, 0, 5, 3 };
        bubble(arr);
        someMethod(); // вызываем логирование в консольку
    }

}
