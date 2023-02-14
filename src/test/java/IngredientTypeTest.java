import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String typeOfFood;

    public IngredientTypeTest(String typeOfFood){
        this.typeOfFood = typeOfFood;
    }

    @Parameterized.Parameters
    public static Object[][] getEnumData() {
        return new Object[][] {
                {"SAUCE"},
                {"FILLING"},
        };
    }

    @Test
    public void ingredientTypeReturnsValueTest(){
        Assert.assertEquals(typeOfFood, IngredientType.valueOf(typeOfFood).toString());
    }

}
