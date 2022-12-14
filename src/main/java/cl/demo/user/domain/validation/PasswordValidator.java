package cl.demo.user.domain.validation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Configuration
@PropertySource("classpath:configuration.properties")
public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    @Value("${regexp.password}")
    private String regexp;

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        return password != null && password.matches(regexp);
    }
}
