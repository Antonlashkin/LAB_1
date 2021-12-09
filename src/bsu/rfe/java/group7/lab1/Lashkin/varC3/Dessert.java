package bsu.rfe.java.group7.lab1.Lashkin.varC3;

public class Dessert extends Food {
    private String filling1;
    private String filling2;

    public Dessert(String drink, String fruit){
        super("Десерт");
        this.filling1 = drink;
        this.filling2 = fruit;
        num_of_parameters = 2;
    }

    public String getDrink(){
        return filling1;
    }
    public String getFruit(){
        return filling2;
    }
    public void setDrink(String drink){
        this.filling1 = drink;
    }
    public void setFruit(String fruit){
        this.filling2 = fruit;
    }

    public void consume(){
        System.out.println(this + " съеден");
    }

    public String toString(){
        return super.toString() + " состоящий из '" + filling1.toUpperCase() + "'" + " и '" + filling2.toUpperCase() + "'";
    }

    @Override
    public int calculateCalories(){
        int calories = 0;

        //Напиток
        if(filling1.equals("вафли")){
            calories += 210;
        }else if(filling1.equals("мороженное")){
            calories+=205;
        }else if(filling1.equals("торт")){
            calories += 240;
        }else if(filling1.equals("пирог")){
        calories += 255;
    }

        //Фрукт
        if(filling2.equals("апельсин")){
            calories += 45;
        }else if(filling2.equals("банан")){
            calories += 100;
        }else if(filling2.equals("киви")){
            calories += 50;
        }else if(filling2.equals("малина")) {
            calories += 55;
        }

        return calories;
    }

    @Override
    public boolean equals(Object obj){
        if(!super.equals(obj)) return false;
        if(!(obj instanceof Dessert)) return false;
        return (filling1.equals(((Dessert)obj).filling1) && (filling2.equals(((Dessert)obj).filling2)));
    }
}
