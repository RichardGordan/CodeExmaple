package Barsick;

public class Cat implements Speakable {
    String name;
    int age;

    @Override
    public void speak(String str) {

        System.out.println("Hello my name is " + this.name + " " + str);
    }

    @Override
    public String toString() {
        return   this.name + this.age;
    }

    public static void main(String[] args) {
        Cat pushok = new Cat();
        pushok.name = "Pushok";
        pushok.age = 99;
        pushok.speak("Meow meow");
        System.out.println(pushok.toString());
    }

}
