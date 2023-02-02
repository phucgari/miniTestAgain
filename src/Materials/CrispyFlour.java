package materials;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CrispyFlour extends Material{
    private double quantity;
    public CrispyFlour() {}
    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, double quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return super.getCost()*quantity;
    }

    @Override
    public LocalDate getExpiryDate() {
        return super.getManufacturingDate().plusYears(1);
    }

    @Override
    public double getRealMoney() {
        return getAmount()*getDiscountRate();
    }

    private double getDiscountRate() {
        double monthDiff=ChronoUnit.MONTHS.between(LocalDate.now(),getExpiryDate());
        if (monthDiff<2)return 0.6;
        else if (monthDiff<4) return 0.8;
        else return 0.95;
    }
}
