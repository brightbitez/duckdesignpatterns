package AbstractFactoryPattern;

public class QuackEcho implements Quackable {
    Quackable duck;
    static int numberOfQuacks;
    public QuackEcho(Quackable duck){
        this.duck = duck;
    }
    public void quack() {
        duck.quack();
        System.out.print("(Echo sound)");
        duck.quack();
        numberOfQuacks++;
    }
    public static int getQuacks(){
        return numberOfQuacks;
    }
}
