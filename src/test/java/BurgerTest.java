import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.List;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredientSauce;

    @Mock
    Ingredient ingredientMeat;

    @Test
    public void setBunTest(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);

    }

    @Test
    public void addIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredientSauce);
        Assert.assertEquals(List.of(ingredientSauce), burger.ingredients);
    }

    @Test
    public void removeIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredientSauce);
        burger.removeIngredient(0);
        Assert.assertEquals(true, burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientMeat);
        burger.moveIngredient(1, 0);
        Assert.assertEquals(List.of(ingredientMeat, ingredientSauce), burger.ingredients);
    }

    @Test
    public void getPriceBurgerTest(){
        Mockito.when(bun.getPrice()).thenReturn(988f);
        Mockito.when(ingredientSauce.getPrice()).thenReturn(88f);
        Mockito.when(ingredientMeat.getPrice()).thenReturn(424f);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientMeat);
        Assert.assertEquals(2488f, burger.getPrice(),0.1);
    }

    @Test
    public void getReceiptTest(){
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("Флюоресцентная булка R2-D3");
        Mockito.when(ingredientSauce.getName()).thenReturn("Соус фирменный Space Sauce");
        Mockito.when(ingredientMeat.getName()).thenReturn("Биокотлета из марсианской Магнолии");
        Mockito.when(ingredientSauce.getType()).thenReturn(SAUCE);
        Mockito.when(ingredientMeat.getType()).thenReturn(FILLING);
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(988f);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientMeat);
        Assert.assertEquals(("(==== Флюоресцентная булка R2-D3 ====)\r\n" +
                "= sauce Соус фирменный Space Sauce =\r\n" +
                "= filling Биокотлета из марсианской Магнолии =\r\n" +
                "(==== Флюоресцентная булка R2-D3 ====)\r\n" +
                "\r\n" +
                "Price: 1976,000000\r\n"),burger.getReceipt());
    }
}
