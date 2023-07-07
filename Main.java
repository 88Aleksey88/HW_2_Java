package org.example;
// Дана строка sql-запроса "select * from students where ".
// Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// select * from students where 'name=Ivanov' and 'country=Russia' and...

public class Main {
    public static void main(String[] args) {
    System.out.println(Task1("{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}"));
    }
    static String Task1(String str){
        StringBuilder stringBuilder = new StringBuilder("select * from students where ");
        str = str.replaceAll("\\{|\\}|\"","");
        String[] pairs = str.split(",");
        for (String s : pairs){
            String[]pair = s.split(":");
            if (!pair[1].equals("null")){
                if (stringBuilder.indexOf("=")>0) stringBuilder.append("and");
                stringBuilder.append("'").append(pair[0].trim()).append("=").append(pair[1].trim()).append("'");
            }
        }
        return stringBuilder.toString();
    }
}