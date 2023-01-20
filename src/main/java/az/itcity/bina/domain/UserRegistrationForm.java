package az.itcity.bina.domain;

import az.itcity.bina.validator.EqualFields;
import az.itcity.bina.validator.UniqueEmail;
import az.itcity.bina.validator.ValidationConstants;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@EqualFields(field1 = "password", field2 = "passwordConfirm")
public class UserRegistrationForm {


    @UniqueEmail(message = "{registrationForm.email.unique}")
    @Email(message = "{registrationForm.email.invalid}")
    @NotBlank(message = "{registrationForm.email.required}")
    private String email;


    @NotBlank(message = "{registrationForm.name.required}")
    @Size(min = ValidationConstants.NAME_MIN_LENGTH, max = ValidationConstants.NAME_MAX_LENGTH, message = "{registrationForm.name.length}")
    @Pattern(regexp = "[a-zA-Z]+", message = "{registrationForm.name.alpha}")
    private String name;

    @NotBlank
    @Size(min = ValidationConstants.NAME_MIN_LENGTH, max = ValidationConstants.NAME_MAX_LENGTH, message = "{registrationForm.name.length}")
    private String surname;

    @NotBlank
    @Size(min = ValidationConstants.PASSWORD_MIN_LENGTH, max = ValidationConstants.PASSWORD_MAX_LENGTH)
    private String password;

    @NotBlank
    @Size(min = ValidationConstants.PASSWORD_MIN_LENGTH, max = ValidationConstants.PASSWORD_MAX_LENGTH)
    private String passwordConfirm;

    @NotBlank
    private String mobile;
}
