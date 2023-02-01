package Client;

import Manager.MaterialManager;
import Materials.Material;
import Materials.Meat;
import Materials.CrispyFlour;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.LinkedList;

public class Main {
    public static LinkedList<Material>materials=new LinkedList<>();

    public static MaterialManager manager=new MaterialManager(materials);
    public static void main(String[] args) {
        initialData(materials);
        System.out.println(manager);
        Menu();
    }

    private static void Menu() {
        System.out.println("Chose your action");
        System.out.println("1. Add new material");
        System.out.println("2. Delete new material");

    }

    public static void initialData(LinkedList<Material>materials){
        materials.add(new Meat("33","meat", LocalDate.of(2023,1,30),200,10));
        materials.add(new CrispyFlour("12","flour",LocalDate.of(2022,10,22),100,10));
        System.out.println("Data initialized");
    }
}
