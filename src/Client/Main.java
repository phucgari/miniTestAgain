package Client;

import Manager.MaterialManager;
import Materials.Material;

import java.time.LocalDate;
import java.util.LinkedList;

public class Main {
    public static LinkedList<Material>materials=new LinkedList<>();
    public static MaterialManager manager=new MaterialManager(materials);
    public static void main(String[] args) {
        manager.addMeat("33","meat", LocalDate.of(2023,1,30),200,10);
        manager.addCrispyFlour("12","flour",LocalDate.of(2022,10,22),100,10);
        System.out.println(manager);
        System.out.println(manager.getTotalDifferent());
    }
}
