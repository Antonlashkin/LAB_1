package bsu.rfe.java.group7.lab1.Lashkin.varC3;

public class Cheese extends Food {
    public Cheese(){
        super("Сыр");
        num_of_parameters = 0;
    }

    public void consume(){
        System.out.println(this + " съеден");
    }
    @Override
    public int calculateCalories(){
        return 300;
    }

}

