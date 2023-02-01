package Manager;

import Materials.CrispyFlour;
import Materials.Material;
import Materials.Meat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class MaterialManagerTest {
    MaterialManager manager=new MaterialManager();
    @BeforeEach
    void init(){
        manager.addCrispyFlour("1","test1", LocalDate.of(2022,7,20),200,10);
        manager.addMeat("2","test2",LocalDate.of(2023,1,30),100,5);
    }
    @Test
    void testNewConstructor(){
        LinkedList<Material> materials=new LinkedList<>();
        materials.add(new CrispyFlour("99","test91", LocalDate.of(2022,7,20),200,10));
        manager=new MaterialManager(materials);
        materials.add(new Meat("2","test2",LocalDate.of(2023,1,30),100,5));

        String expected="CrispyFlour id=99,name=test91,date=2022-07-20,cost=200,quantity=10.0\nMeat id=2,name=test2,date=2023-01-30,cost=100,weight=5.0\n";
        assertEquals(expected,manager.toString());
        assertEquals(150,manager.getTotalDifferent());
    }
    @Test
    void testPrinter(){
        String expected="CrispyFlour id=1,name=test1,date=2022-07-20,cost=200,quantity=10.0\nMeat id=2,name=test2,date=2023-01-30,cost=100,weight=5.0\n";
        assertEquals(expected,manager.toString());
        manager.addMeat("3","test3",LocalDate.of(2023,1,29),150,10);
        expected+="Meat id=3,name=test3,date=2023-01-29,cost=150,weight=10.0\n";
        assertEquals(expected,manager.toString());
    }
    @Test
    void testUpdate(){
        Material newMeat=new Meat("3","test3",LocalDate.of(2023,2,1),200,10);
        manager.updateByIndex(1,newMeat);
        Material newCrispyFlour=new CrispyFlour("4","test4",LocalDate.of(2022,10,4),100,5);
        manager.updateByIndex(0,newCrispyFlour);
        String expected="CrispyFlour id=4,name=test4,date=2022-10-04,cost=100,quantity=5.0\n" +
                "Meat id=3,name=test3,date=2023-02-01,cost=200,weight=10.0\n";
        assertEquals(expected,manager.toString());
    }

    @Test
    void testDelete(){
        manager.deleteByIndex(0);
        String expected="Meat id=2,name=test2,date=2023-01-30,cost=100,weight=5.0\n";
        assertEquals(expected,manager.toString());
        manager.deleteByIndex(0);
        expected="";
        assertEquals(expected,manager.toString());
        init();
        manager.deleteByIndex(1);
        expected="CrispyFlour id=1,name=test1,date=2022-07-20,cost=200,quantity=10.0\n";
    }

    @Test
    void testGetDiff(){
        assertEquals(150,manager.getTotalDifferent());
        manager.addMeat("3","test3",LocalDate.of(2023,1,28),150,10);
        assertEquals(600,manager.getTotalDifferent());
    }
}