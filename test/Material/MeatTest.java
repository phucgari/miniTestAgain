package material;

import materials.Meat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MeatTest {
    Meat meat1=new Meat();
    Meat meat2=new Meat("1","meat2", LocalDate.of(2023,1,27),200,10);
    @BeforeEach
    void init(){
        meat1.setId("0");
        meat1.setCost(100);
        meat1.setManufacturingDate(LocalDate.of(2023,1,30));
        meat1.setName("meat1");
        meat1.setWeight(15);
    }
    @Test
    void testGetSet(){
        assertEquals("0",meat1.getId());
        assertEquals(100,meat1.getCost());
        assertEquals(LocalDate.of(2023,1,30),meat1.getManufacturingDate());
        assertEquals("meat1",meat1.getName());
        assertEquals(15,meat1.getWeight());

        assertEquals("1",meat2.getId());
        assertEquals(200,meat2.getCost());
        assertEquals(LocalDate.of(2023,1,27),meat2.getManufacturingDate());
        assertEquals("meat2",meat2.getName());
        assertEquals(10,meat2.getWeight());

        meat2.setId("2");
        meat2.setCost(150);
        meat2.setManufacturingDate(LocalDate.of(2022,1,28));
        meat2.setName("meat3");
        meat2.setWeight(20);

        assertEquals("2",meat2.getId());
        assertEquals(150,meat2.getCost());
        assertEquals(LocalDate.of(2022,1,28),meat2.getManufacturingDate());
        assertEquals("meat3",meat2.getName());
        assertEquals(20,meat2.getWeight());
    }
    @Test
    void testGetAmount(){
        assertEquals(1500,meat1.getAmount());
        assertEquals(2000,meat2.getAmount());
    }
    @Test
    void testGetExpiryDate(){
        assertEquals(LocalDate.of(2023,2,6),meat1.getExpiryDate());
        assertEquals(LocalDate.of(2023,2,3),meat2.getExpiryDate());
    }
    @Test
    void testDiscount(){
        assertEquals(1350,meat1.getRealMoney());
        assertEquals(1400,meat2.getRealMoney());
    }
}