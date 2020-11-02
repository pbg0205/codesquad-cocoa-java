package Validator;

import gugudan.validator.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {
    @Test
    public void validationTest(){
        assertTrue(new Validator("3 4").AllValidation());
    }
}
