package bsu.rfe.java.group7.lab1.Lashkin.varC3;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Comparator;

//Apple/большое Dessert/мороженное/апельсин Cheese Apple/небольшое Dessert/пирог/малина Колбаса -sort -calories
public class Main {
    public static void main(String[] args) {

        Food[] breakfast = new Food[20];
        boolean sort_needed = false;
        boolean calories_needed = false;
        //System.out.println("длина массива аргументов: " + args.length);

        int count_breakfast = 0;

        //композиция
        for (int itemIndex = 0; itemIndex < args.length; itemIndex++) {
            if (args[itemIndex].equals("-calories")) {
                calories_needed = true;
            } else if(args[itemIndex].equals("-sort")) {
                sort_needed = true;
            } else{
                String[] parts = args[itemIndex].split("/");
                String[] param = new String[parts.length -1];
                for(int i = 0; i< parts.length-1; i++){
                    param[i] = parts[i+1];
                }
                //System.out.println(param.length);

                //обработка исключений
                try {
                    Class myClass = Class.forName("com.company." + parts[0]);
                    breakfast[count_breakfast] = (Food) myClass.getConstructor(myClass.getConstructors()[0].getParameterTypes()).newInstance(param);
                    count_breakfast++;
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException  ex) {
                    System.out.print(ex);
                } catch (ClassNotFoundException ex) {
                    System.out.println("Введите существующий класс!");
                } catch(NoSuchMethodException ex){
                    System.out.println("Введите правильные параметры класса!");
                }
            }
        }

        //употребление
        System.out.println("\nЧто съедено:");
        for (int i = 0; i < breakfast.length; i++) {
            if (breakfast[i] == null) break;
            breakfast[i].consume();
        }

        //подсчет сколько чего съедено
        int count = 0;
        Food[] breakfast_diff = new Food[count_breakfast];

        System.out.println("\nСколько чего съедено:");
        for (int i = 0; i < count_breakfast; i++) {
            count = 1;
            boolean to_continue = false;

            for(int j = 0; j < count_breakfast; j++)
            {
                if(breakfast_diff[j] == null) continue;
                if(breakfast_diff[j].equals(breakfast[i])){
                    to_continue = true;
                }
            }

            if(to_continue) continue;
            for (int j = i + 1; j < count_breakfast; j++) {
                if ((breakfast[j].equals(breakfast[i]))) {
                    count++;
                }
            }

            breakfast_diff[i] = breakfast[i];
            System.out.println();
            breakfast[i].consume();
            System.out.println(count + " раз(а)");
        }

        //подсчет калорий
        if(calories_needed){
            int calorii = 0;
            for (int i = 0; i < count_breakfast; i++) calorii += breakfast[i].calculateCalories();
            System.out.println("\nКалорийность: " + calorii);
        }

        //употребление
        /*for (int i = 0; i < breakfast.length; i++) {
            if (breakfast[i] == null) break;
            breakfast[i].consume();
        }*/

        //сортировка
        if(sort_needed){
            Arrays.sort(breakfast, new Comparator(){
                public int compare(Object f1, Object f2){
                    if(f1==null) return 1;
                    if(f2==null) return -1;
                    if(((Food)f1).num_of_parameters ==((Food)f2).num_of_parameters) return 0;
                    if(((Food)f1).num_of_parameters>((Food)f2).num_of_parameters) return -1;
                    return 1;
                }
            });
        }
        //отсортированное
        System.out.println("\nОтсортированные продукты:\n");
        for (int i = 0; i < breakfast.length; i++) {
            if (breakfast[i] == null) continue;
            System.out.println(breakfast[i].toString() + " " + breakfast[i].calculateCalories());
            //breakfast[i].consume();
        }
        System.out.print("\nСъедено продуктов: " + count_breakfast);
        System.out.print("\n\nПриходите еще!");
    }
}

