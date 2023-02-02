package material;

import materials.CrispyFlour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CrispyFlourTest {
    CrispyFlour test1=new CrispyFlour();
    CrispyFlour test2=new CrispyFlour("01","test2", LocalDate.of(2023,1,15),200,10);
    @BeforeEach
    void init(){
        test1.setId("00");
        test1.setCost(100);
        test1.setManufacturingDate(LocalDate.of(2022,3,12));
        test1.setName("test1");
        test1.setQuantity(15);
    }
    @Test
    void testGetSet(){
        assertEquals("00",test1.getId());
        assertEquals(100, test1.getCost());
        assertEquals(LocalDate.of(2022,3,12),test1.getManufacturingDate());
        assertEquals("test1",test1.getName());
        assertEquals(15,test1.getQuantity());

        assertEquals("01",test2.getId());
        assertEquals(200, test2.getCost());
        assertEquals(LocalDate.of(2023,1,15),test2.getManufacturingDate());
        assertEquals("test2",test2.getName());
        assertEquals(10,test2.getQuantity());

        test2.setId("02");
        test2.setCost(300);
        test2.setManufacturingDate(LocalDate.of(2024,7,14));
        test2.setName("test3");
        test2.setQuantity(30);

        assertEquals("02",test2.getId());
        assertEquals(300, test2.getCost());
        assertEquals(LocalDate.of(2024,7,14),test2.getManufacturingDate());
        assertEquals("test3",test2.getName());
        assertEquals(30,test2.getQuantity());
    }
    @Test
    void testGetAmount(){
        assertEquals(1500,test1.getAmount());
        assertEquals(2000,test2.getAmount());
    }
    @Test
    void testGetExpiryDate(){
        assertEquals(LocalDate.of(2023,3,12),test1.getExpiryDate());
        assertEquals(LocalDate.of(2024,1,15),test2.getExpiryDate());
    }
    @Test
    void testDiscount(){
        assertEquals(900,test1.getRealMoney());
        assertEquals(1900,test2.getRealMoney());
        CrispyFlour test3=new CrispyFlour("01","test2", LocalDate.of(2022,5,15),200,10);
        assertEquals(1600,test3.getRealMoney());
    }
}