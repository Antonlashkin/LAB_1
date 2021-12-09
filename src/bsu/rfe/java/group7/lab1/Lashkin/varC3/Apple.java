package bsu.rfe.java.group7.lab1.Lashkin.varC3;

public class Apple extends Food {
    private String size;

    public Apple(String size){
        super("Яблоко");
        this.size = size;
        num_of_parameters = 1;

    }

    public String getSize(){
        return size;
    }
    public void setSize(String size){
        this.size = size;
    }

    @Override
    public void consume(){
        System.out.println(this + " съедено");
    }

    @Override
    public int calculateCalories() {
        int calories = 0;
        if(size.equals("большое")){
            calories+=50;
        }else if(size.equals("небольшое")){
            calories+=30;
        }else{
            calories+=10;
        }
        return calories;
    }

    @Override
    public String toString(){
        return super.toString() + " размера '" + size.toUpperCase() + "'";
    }

    @Override
    public boolean equals(Object obj){
        if(!super.equals(obj)) return false;
        if(!(obj instanceof Apple)) return false;
        return size.equals(((Apple)obj).size);
    }
}

