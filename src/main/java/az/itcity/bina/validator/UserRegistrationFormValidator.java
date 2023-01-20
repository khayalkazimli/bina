package az.itcity.bina.validator;

import az.itcity.bina.domain.UserRegistrationForm;
import org.apache.commons.validator.GenericValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import static az.itcity.bina.validator.ValidationConstants.NAME_MAX_LENGTH;
import static az.itcity.bina.validator.ValidationConstants.NAME_MIN_LENGTH;

@Component

public class UserRegistrationFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UserRegistrationForm.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserRegistrationForm form = (UserRegistrationForm) o;
        System.out.println("form validator isleyir " + form);



        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "registrationForm.surname.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "registrationForm.password.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "registrationForm.passwordConfirm.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobile", "registrationForm.mobile.required");

        /*
         * 1.validate first name
         *   a) not null
         *   b) not empty
         *   c) is alpha
         *   d) min/max length
         * 2.validate last name
         *   a) not null
         *   b) not empty
         *   c) is alpha
         *   d) min/max length
         * 3.validate email
         *   a) not null
         *   b) not empty
         *   c) is valid email ( regex)
         *   d) is duplicate email

         * 4.validate password and confirmation
         *   a) not null
         *   b) not empty
         *   c) is complex password
         *   d) min/max length
         *   e) password == confirmation
         *
         * 5.validate mobile number
         *   a) not null
         *   b) not empty
         *   c) regex pattern +994 50
         *   d) min/max length
         * */

        /*
         *  * 1.validate first name
         *   a) not null
         *   b) not empty
         *   c) is alpha
         *   d) min/max length
         * */

        /*
        *   * 1.validate first name
         *   a) not null
         *   b) not empty
         *   c) is alpha
         *   d) min/max length
        * */



        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "registrationForm.name.required");

        if(!GenericValidator.isInRange(form.getName().length(), NAME_MIN_LENGTH, NAME_MAX_LENGTH)) {
            errors.rejectValue("name", "registrationForm.name.length");
        }

        if(!GenericValidator.matchRegexp(form.getName(), "[a-zA-Z]+")) {
            errors.rejectValue("name", "registrationForm.name.alpha");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "registrationForm.email.required");

    }
}
