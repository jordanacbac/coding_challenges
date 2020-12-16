import java.util.LinkedList;
import java.util.Scanner;

class Person {
    String name;
    int value;
    Person(String name, int value) {
        this.name = name;
        this.value = value;
    }
}

public class Main {

    public static Person search(String name, Person[] listPeople) {
        for (int i = 0; i < listPeople.length; i++) {
            if (name.equals(listPeople[i].name)) {
                return listPeople[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        LinkedList<Person> people = new LinkedList<Person>();
        while (true) {
            Person[] listPeople = new Person[count];
            for (int i = 0; i < count; i++) {
                listPeople[i] = new Person(scan.next(), 0);
            }
            Person id;
            int total, div, res = 0;
            for (int i = 0; i < count; i++) {
                id = search(scan.next(), listPeople);
                total = scan.nextInt();
                div = scan.nextInt();
                if (div != 0) {
                    res = total / div;
                } else {
                    continue;
                }
                for (int j = 0; j < div; j++) {
                    Person temp = search(scan.next(), listPeople);
                    temp.value = temp.value + res;
                }
                id.value = id.value - (div * res);
            }
            for (int k = 0; k < listPeople.length; k++) {
                System.out.println(listPeople[k].name + " " + listPeople[k].value);
            }
            try {
                count = scan.nextInt();
            } catch (Exception e) {
                return;
            }
            System.out.println();
        }
    }

}
