package ValidatorTest;

import org.junit.Test;
import rpg.validator.InputValidator;

import static org.junit.Assert.assertTrue;

public class InputValidatorTest {
    @Test
    public void allValidationTest(){
        assertTrue(new InputValidator().AllValidation("W"));
    }
}
