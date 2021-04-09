package blueOrigin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceshipTests {

    private  String name = "Gigi";
    private int capacity = 3;
    private Spaceship spaceship;
   private Astronaut astronaut;

    @Before
    public void setUp(){
         this.spaceship = new Spaceship(name,capacity);
         astronaut = new Astronaut("Emo",25.3);
    }

    @Test
    public void testConstructorShouldInitializeCollection(){
        assertNotNull(spaceship.getCount());
    }


    @Test
    public void testGetNameWorksProperly(){
       assertEquals(name, spaceship.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testGetNameThrowExceptionNameNull(){
        Spaceship spaceship1 = new Spaceship(null,2);
        assertNull(spaceship1.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testGetNameThrowExceptionNameEmpty(){
        Spaceship spaceship1 = new Spaceship("",2);
        assertTrue(spaceship1.getName().isEmpty());
    }

    @Test
    public void testSetCapacityWorkProperly(){
        assertEquals(capacity,spaceship.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityBelowZero(){
        Spaceship spaceship1 = new Spaceship("gigi",-1);
        assertEquals(0,spaceship1.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautShipFull(){
        Astronaut astronaut1 = new Astronaut("Petar",30.7);
        Astronaut astronaut2 = new Astronaut("Mimi",38.7);
        Astronaut astronaut3 = new Astronaut("Pepi",48.7);
       spaceship.add(astronaut1);
       spaceship.add(astronaut2);
       spaceship.add(astronaut3);
       spaceship.add(astronaut);
        assertEquals(capacity,spaceship.getCount());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautAlreadyExist(){
        spaceship.add(astronaut);
        spaceship.add(astronaut);
    }


    @Test
    public void testAddWorkProperly(){
        Astronaut astronaut1 = new Astronaut("Petar",30.7);
        spaceship.add(astronaut);
        spaceship.add(astronaut1);
        assertEquals(2, spaceship.getCount());
    }

    @Test
    public void testRemove(){
        spaceship.add(astronaut);
        assertTrue(spaceship.remove("Emo"));
    }
}
