package az.itcity.bina.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EqualFieldsValidator.class})
public @interface EqualFields {
    String message() default "Fields are not equal";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String field1();
    String field2();
}
