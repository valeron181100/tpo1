package third;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Tests for Third Part")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ThirdTests {

    private MetalStream metalStream;
    private Building building;
    private BombAttack attack;

    @Before
    public void init() {
        metalStream = new MetalStream();
        building = new CompBank("Компьютерный банк", 32);
        attack = new BombAttack(building, metalStream);
    }


    @Test
    public void testAttack() {
        assertEquals("Было нанесено " + attack.getDamage() + " урона бомбой.", attack.attack());
    }

    @Test
    public void testTooManyAttacks() {
        for (int i = 0; i < 10; i++)
            attack.attack();
        assertEquals("Здание уже разрушено!", attack.attack());
    }



}
