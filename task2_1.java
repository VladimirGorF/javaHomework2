// Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
//  Данные для фильтрации приведены ниже в виде json строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

public class task2_1 {
   
    public static String where(String str) {
        
        String[] arr = str.split(" ", 0);
        StringBuilder sb = new StringBuilder();

        for (int index = 0; index < arr.length; index++) {
            if (arr[index].equals("where")) {
                String s = "'null'";

                for (int i = index + 1; i < arr.length - 3; i++) {
                    if (arr[i + 2].contains(s)) {
                        i += 2;
                    } else {
                        sb.append(arr[i]);
                        sb.append(" ");
                    }
                }
                for (int j = arr.length - 3; j < arr.length; j++) {
                    if (arr[arr.length - 1].contains(s)) {
                        System.out.println();
                        break;
                    } else {
                        sb.append(arr[j]);
                    }
                }
            }
        }
        String res = null;
        String newString = sb.toString();
        String[] arr2 = newString.split("");

        for (int i = 0; i < arr2.length; i++) {
            if (i == arr2.length - 2 && arr2[i].equals(",")) {
                String[] result = new String[arr2.length - 2];
                System.arraycopy(arr2, 0, result, 0, arr2.length - 2);

                res = String.join("", result);
                break;
            } else {
                res = String.join("", arr2);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String str = "Select * from students where name = 'Ivanov', country = 'Russia', city = 'Moscow', age = 'null'";
        System.out.println(where(str)); 
    }
}