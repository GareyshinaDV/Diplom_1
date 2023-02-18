import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    @Test
    public void getNameBunTest(){
        Bun bun = new Bun("Краторная булка N-200i", 1255f);
        Assert.assertEquals("Краторная булка N-200i", bun.getName());
    }

    @Test
    public void getPriceBunTest(){
        Bun bun = new Bun("Краторная булка N-200i", 1255f);
        Assert.assertEquals(1255f, bun.getPrice(), 0.1);
    }

}
