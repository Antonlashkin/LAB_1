package bsu.rfe.java.group7.lab1.Lashkin.varC3;

public abstract class Food implements Consumable, Nutritious {
    private String name;
    public int num_of_parameters;
    public Food(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Food)) return false;
        if(name == null || ((Food)obj).name == null) return false;
        return name.equals(((Food)obj).name);
    }

    @Override
    public String toString(){
        return name;
    }
}
