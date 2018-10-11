package CompositePattern;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory duckFactory1 = new DuckFactory();
        AbstractDuckFactory duckFactory2 = new DuckFactory();
        AbstractDuckFactory duckFactory3 = new DuckFactory();
        simulator.simulate1(duckFactory1);
        simulator.simulate2(duckFactory2);
        simulator.simulate3(duckFactory3);
    }
    void simulate1(AbstractDuckFactory duckFactory1){
        System.out.println("Duck Factory no.1");
        Quackable mallardOne = duckFactory1.createMallardDuck();
        Quackable mallardTwo = duckFactory1.createMallardDuck();
        Quackable mallardThree = duckFactory1.createMallardDuck();
        Quackable mallardFour = duckFactory1.createMallardDuck();
        Quackable redheadDuck = duckFactory1.createRedheadDuck();
        Quackable duckCall = duckFactory1.createDuckCall();
        Quackable rubberDuck = duckFactory1.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());
        Flock flockOfDucks = new Flock();
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);
        Flock flockOfMallards = new Flock();
        flockOfMallards.add(mallardOne);
        flockOfMallards.add(mallardTwo);
        flockOfMallards.add(mallardThree);
        flockOfMallards.add(mallardFour);
        flockOfDucks.add(flockOfMallards);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
        System.out.println("\nDuck Simulator: Whole Flock Simulation");
        simulate(flockOfDucks);
        System.out.println("\nDuck Simulator: Mallard Flock Simulation");
        simulate(flockOfMallards);

    }
    void simulate2(AbstractDuckFactory duckFactory2){
        System.out.println("\nDuck Factory no.2");

        Quackable mallardDuck = new QuackCounter(duckFactory2.createMallardDuck());
        Quackable redheadDuck = new QuackCounter(duckFactory2.createRedheadDuck());
        Quackable duckCall = new QuackCounter(duckFactory2.createDuckCall());
        Quackable rubberDuck = new QuackCounter(duckFactory2.createRubberDuck());
        Quackable gooseDuck = new GooseAdapter(new Goose());
        Quackable pigeonDuck = new PigeonAdapter(new Pigeon());

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
        simulate(pigeonDuck);
        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
    }
    void simulate3(AbstractDuckFactory duckFactory3){
        System.out.println("\nDuck Factory no.3");
        Quackable mallardDuck = new QuackEcho(new QuackCounter(new MallardDuck()));
        Quackable redheadDuck = new QuackCounter(new QuackEcho(new RedheadDuck()));
        Quackable duckCall = new QuackEcho(new QuackCounter(new DuckCall()));
        Quackable rubberDuck = new QuackEcho(new QuackCounter(new RubberDuck()));
        Quackable gooseDuck = new GooseAdapter(new Goose());
        Quackable pigeonDuck = new PigeonAdapter(new Pigeon());
        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
        simulate(pigeonDuck);
        System.out.println("The ducks quacked " + QuackEcho.getQuacks() + " times");
    }
    void simulate(Quackable duck){
        duck.quack();
    }
}
