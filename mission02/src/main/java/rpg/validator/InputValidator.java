package rpg.validator;

import java.util.regex.Pattern;

public class InputValidator {

    private static final String REGULAR_EXPRESSION_OF_DIRECTION = "[WwAaSsDd]";//TODO : 정규식 공부하기

    public boolean AllValidation(String value) {
        if(isDirectionCommand(value)){
            return false;
        }

        return true;
    }

    private boolean isDirectionCommand(String value){
        if(Pattern.matches(REGULAR_EXPRESSION_OF_DIRECTION, value)){
            return true;
        }

        return false;
    }
}
