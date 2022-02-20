import java.util.Scanner;


class Animal {
    String a = "animal";
    Cat c;
}

class Cat extends Animal {
    String a = "cat";
}

public class Main {


    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println(new Animal().a);
        System.out.println(new Animal().c.a);
    }

}
