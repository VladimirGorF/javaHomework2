// 3.** Дана json строка (можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.
public class task2_3 {
    public static void main(String[] args) {

        String jsonString = "{'фамилия':'Иванов','оценка':'5','предмет':'Математика'}, {'фамилия':'Петров','оценка':'3','предмет':'Пение'}, {'фамилия':'Краснов','оценка':'5','предмет':'Физика'}";

        String [] helpString = new String[3]; // создаем вспомогательный массив из трех элементов
        for (int i = 0; i < 1; i++) {
            helpString[0] = "Студент ";
            helpString[1] = "получил ";
            helpString[2] = "по предмету ";
        }

        String[] jsonArr = jsonString.split(","); // распарсили на блоки

        System.out.println();
        StringBuilder sb = new StringBuilder(); // создаем хранилище данных

        for (String string : jsonArr) { // работаем с отдельными блоками
            String[] jsonArrBlock = string.split(""); // разбил блок на символы

            for (int i = 0; i < jsonArrBlock.length; i++) {
                if (jsonArrBlock[i].equals(":")) {
                    for (int j = i + 2; j < jsonArrBlock.length; j++) {
                        if (jsonArrBlock[j].equals("'")) {
                            break;
                        } else {
                            sb.append(jsonArrBlock[j]);  // берем символы имен и тащим в хранилище
                        }
                    }
                    sb.append(" ");
                }
            }
        }
        String arr = sb.toString();
        String [] arrStorage = arr.split(" ");  // здесь хранилище входных данных из json строки
        
        String [] finishArr = new String [arrStorage.length * 2];  // теперь надо штмаповать строки
        
        int counter = 0;
        int k = 0;
        int l = 0;
        for (int i = 0; i < arrStorage.length * 2; i++) {  
            if(i%2 == 0){                          // если индекс четный, то добавляем элемент из HelpString, иначе элемент из Storage
                finishArr[i] = helpString[k];
                k++;
                counter++;
                if (counter == 3){              // если счетчик дошел до 3, обнуляем индексы 
                    k = 0;
                    counter = 0;
                }
            } else{
                finishArr[i] = arrStorage[l];
                l++;
            }
        }
        int count = 0;
        for (String string : finishArr) {     // форматированный вывод строк
            System.out.printf("%s ", string);
            count++;
            if (count == 6){
                System.out.println();
                count = 0;
            }
            

           
        } 

       

        System.out.println();
    }
}
