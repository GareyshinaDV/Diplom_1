import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    IngredientType type;

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(type, "Соус традиционный галактический", 15f);
        Assert.assertEquals(15, ingredient.getPrice(), 0.1);
    }

    @Test
    public void getNameTest(){
        Ingredient ingredient = new Ingredient(type, "Соус традиционный галактический", 15f);
        Assert.assertEquals("Соус традиционный галактический", ingredient.getName());
    }

    @Test
    public void getTypeTest(){
        Ingredient ingredient = new Ingredient(type, "Соус традиционный галактический", 15f);
        Assert.assertEquals(type, ingredient.getType());
    }

}