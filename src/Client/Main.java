package client;

import manager.MaterialManager;
import materials.Material;
import materials.Meat;
import materials.CrispyFlour;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static LinkedList<Material>materials=new LinkedList<>();

    public static MaterialManager manager=new MaterialManager(materials);
    public static void main(String[] args) {
        initialData(materials);
        System.out.println(manager);
        checkAction(Menu());
    }

    private static void checkAction(int menu) {
        switch(menu){
            case 1:
                addMaterial();
                checkAction(Menu());
            case 2:
                deleteMaterial();
                checkAction(Menu());
            case 3:
                System.out.println(manager.toString());
                checkAction(Menu());
            case 4:
                updateMaterial();
                checkAction(Menu());
            case 5:
                break;
        }
    }

    private static void updateMaterial() {
        System.out.println("Update material chosen");
        Scanner scanner=new Scanner(System.in);
        Material newMaterial=inputNewMaterial();
        int index = getIndex(scanner);
        if(index!=-1)manager.updateByIndex(index,newMaterial);
    }

    private static int getIndex(Scanner scanner) {
        System.out.println("enter index to change");
        int index= Integer.parseInt(scanner.nextLine());
        if(index>=0&&index<materials.size());
        else {
            System.out.println("Error. invalid index");
            return -1;
        }
        return index;
    }

    private static void deleteMaterial() {
        System.out.println("Delete chosen");
        System.out.println("input id to delete");
        Scanner scanner=new Scanner(System.in);
        int index = getIndex(scanner);
        if (index!=-1) manager.deleteByIndex(index);
    }

    private static void addMaterial() {
        System.out.println("Add new material chosen");
        Material newMaterial=inputNewMaterial();
        manager.add(newMaterial);
        System.out.println("Added item!");
    }

    private static Material inputNewMaterial() {
        System.out.println("Which material do you want to get");
        System.out.println("1 for CrispyFlour");
        System.out.println("2 for Meat");
        System.out.println("others for exit");
        Scanner scanner=new Scanner(System.in);
        int choice= Integer.parseInt(scanner.nextLine());
        if(choice==1) System.out.println("CrispyFlour chosen");
        else if(choice==2) System.out.println("Meat chosen");
        else return null;
        return getInputFromUser(choice);
    }

    private static Material getInputFromUser(int choice) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("input id");
        String id= scanner.nextLine();
        System.out.println("input name");
        String name= scanner.nextLine();
        System.out.println("input Date");
        LocalDate date;
        date=getDate();
        System.out.println("input cost");
        int cost= Integer.parseInt(scanner.nextLine());
        if(choice ==1){
            System.out.println("input quantity");
            double quantity= Double.parseDouble(scanner.nextLine());
            return new CrispyFlour(id,name,date,cost,quantity);
        }
        else {
            System.out.println("input weight");
            double weight= Double.parseDouble(scanner.nextLine());
            return new Meat(id,name,date,cost,weight);
        }
    }

    private static LocalDate getDate() {
        LocalDate result;
        try{
        Scanner scanner=new Scanner(System.in);
        System.out.println("Warning! your input should looks like 2011-12-03 !");
        String date=scanner.nextLine();
        result=LocalDate.parse(date);
        return result;
        }catch (DateTimeParseException e){
            getDate();
        }
        return null;
    }

    private static int Menu() {
        System.out.println("Chose your action");
        System.out.println("1. Add new material");
        System.out.println("2. Delete new material");
        System.out.println("3. Get your materials");
        System.out.println("4. Update database");
        System.out.println("5. Get out of here");
        Scanner scanner=new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public static void initialData(LinkedList<Material>materials){
        materials.add(new Meat("33","meat", LocalDate.of(2023,1,30),200,10));
        materials.add(new CrispyFlour("12","flour",LocalDate.of(2022,10,22),100,10));
        System.out.println("Data initialized");
    }
}
