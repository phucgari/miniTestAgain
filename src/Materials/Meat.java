package Materials;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Meat extends Material{
    double weight;

    public Meat() {}

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return super.getCost()*weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return super.getManufacturingDate().plusDays(7);
    }

    @Override
    public double getRealMoney() {
        return getAmount()* getDiscountRate();
    }

    private double getDiscountRate() {
        double dayDiff=ChronoUnit.DAYS.between(LocalDate.now(),getExpiryDate());
        return dayDiff<5?0.7:0.9;
    }
}

