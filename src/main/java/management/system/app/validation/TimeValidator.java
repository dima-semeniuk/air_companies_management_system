package management.system.app.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TimeValidator implements ConstraintValidator<CorrectFormat,
        String> {
    @Override
    public boolean isValid(String estimatedFlightTime,
                           ConstraintValidatorContext constraintValidatorContext) {
        String regexPattern = "([0-9][0-9]):[0-5][0-9]";
        return estimatedFlightTime.matches(regexPattern);
    }
}
