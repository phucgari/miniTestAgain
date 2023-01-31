import Materials.CrispyFlour;
import Materials.Material;
import Materials.Meat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;

public class MaterialManager {
    LinkedList<Material> materials=new LinkedList<>();

    public void addCrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, double quantity) {
        materials.add(new CrispyFlour(id,name,manufacturingDate,cost,quantity));
    }
    public void addMeat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        materials.add(new Meat(id,name,manufacturingDate,cost,weight));
    }
    @Override
    public String toString(){
        String result="";
        for (Material material:materials) {
            if (material instanceof CrispyFlour){
                result+="CrispyFlour ";
            }
            if (material instanceof Meat){
                result+="Meat ";
            }
            result+="id="+material.getId()+",name="+material.getName()+",date="
                +material.getManufacturingDate().toString()
                +",cost="+material.getCost();
            if (material instanceof CrispyFlour){
                result+=",quantity="+((CrispyFlour) material).getQuantity()+"\n";
            }
            if (material instanceof Meat){
                result+=",weight="+((Meat) material).getWeight()+"\n";
            }
        }
        return result;
    }
    public double getTotalDifferent(){
        double result=0;
        for (Material material:materials) {
            result+=(material.getAmount()-material.getRealMoney());
        }
        return result;
    }
}
