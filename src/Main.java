import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        MaterialManager manager=new MaterialManager();
        manager.addMeat("33","meat", LocalDate.of(2023,1,30),200,10);
        manager.addCrispyFlour("12","flour",LocalDate.of(2022,10,22),100,10);
        System.out.println(manager);
        System.out.println(manager.getTotalDifferent());
    }
}
