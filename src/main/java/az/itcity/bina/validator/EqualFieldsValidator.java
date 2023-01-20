package az.itcity.bina.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

@Component
public class EqualFieldsValidator implements ConstraintValidator<EqualFields, Object> {

    private  String field1;
    private String field2;

    @Override
    public void initialize(EqualFields constraintAnnotation) {
        field1 = constraintAnnotation.field1();
        field2 = constraintAnnotation.field2();
    }

    private Object getFieldValue(Object object, String fieldName) throws Exception{
        Class<?> clazz = object.getClass();
        Field passwordField = clazz.getDeclaredField(fieldName);
        passwordField.setAccessible(true);
        return passwordField.get(object);
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        try {
            Object field1Value = getFieldValue(object, field1);
            Object field2Value = getFieldValue(object, field2);
            System.out.println("Cross field validator isledi. f1 = " + field1Value + " f2 = " + field2Value);
            return field1Value != null && field1Value.equals(field2Value);
        }catch (Exception e){
            // log error
            e.printStackTrace();
            return false;
        }

    }
}
