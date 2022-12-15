import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

// 4*. К калькулятору из предыдущего дз добавить логирование.
// Реализовать простой калькулятор




public class task2_4 {

    public static void logger(int arg) {
        try (FileWriter fw = new FileWriter("file.txt", true)) {

            StringBuilder sb = new StringBuilder(); // создаем строку стрингбилдер для записи массива в строку         
            sb.append(arg);
            fw.write("Резултат вычислений = ");
            fw.append(sb);
            fw.append("\n");

            StringBuilder sb2 = new StringBuilder(); // создаем еще стрингбилдер для передачи даты и времени события
            sb2.append(LocalDateTime.now());
            fw.append(sb2);
            fw.append("\n");
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            Scanner iScanner = new Scanner(System.in);
            System.out.printf("Введите число: ");
            int n = iScanner.nextInt();
            System.out.printf("Введите второе число ");
            int c = iScanner.nextInt();
            System.out.printf("Введите действие ");
            String oper = iScanner.next();
            iScanner.close();

            int sum = n + c;
            int dif = n - c;
            int div = n / c;
            int mult = n * c;

            switch (oper) {
                case "+":
                    System.out.printf("%d + %d = %d\n", n, c, sum);
                    logger(sum);
                    break;
                case "-":
                    System.out.printf("%d - %d = %d\n", n, c, dif);
                    logger(dif);
                    break;
                case "*":
                    System.out.printf("%d * %d = %d\n", n, c, mult);
                    logger(mult);
                    break;
                case "/":
                    System.out.printf("%d / %d = %d\n", n, c, div);
                    logger(div);
                    break;
            }
            
        } catch (Exception e) {
            System.out.println("Please use an integers only! Try again!");
        }

    }
}
