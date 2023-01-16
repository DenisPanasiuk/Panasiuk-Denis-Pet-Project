package net.Panasiuk_WebSite.Sources.Validator;

import net.Panasiuk_WebSite.Logic.Authorization.service.UserService;
import net.Panasiuk_WebSite.Sources.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.apache.commons.lang3.StringUtils;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        User user = (User) o;

        String username = user.getUsername();

        String name = user.getName();
        boolean nameHasDigits = false;
        for (int i = 0; i < name.length() && !nameHasDigits; i++) {
            if (Character.isDigit(name.charAt(i))) {
                nameHasDigits = true;
            }
        }

        String surname = user.getSurname();
        boolean surnameHasDigits = false;
        for (int i = 0; i < surname.length() && !surnameHasDigits; i++) {
            if (Character.isDigit(surname.charAt(i))) {
                surnameHasDigits = true;
            }
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "Required");

        if (username.length() < 8 || username.length() > 32 || !(StringUtils.isAlphanumeric(username))) {
            errors.rejectValue("username", "Size.userForm.username");
        }

        if (nameHasDigits || !(StringUtils.isAlphanumeric(name))) {
            errors.rejectValue("name", "User.userForm");
        }

        if (surnameHasDigits || !(StringUtils.isAlphanumeric(surname))) {
            errors.rejectValue("surname", "User.userForm");
        }

        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        if (!(StringUtils.isAlphanumeric(user.getPassword()))) {
            errors.rejectValue("password", "Special.userForm.password");
        }

        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "Different.userForm.password");
        }

        if (user.getSex().equals("m") || user.getSex().equals("f")) {

        } else {
            errors.rejectValue("sex", "Gender.userForm.sex");
        }

        System.out.println(!(StringUtils.isAlphanumeric(user.getCourse())));

        if (!(user.getCourse().isEmpty())) {
            if (!(StringUtils.isAlphanumeric(user.getCourse()))) {
                errors.rejectValue("course", "Course.userForm.course");
            } else if (Integer.parseInt(user.getCourse()) < 1 || Integer.parseInt(user.getCourse()) > 6) {
                errors.rejectValue("course", "Course.userForm.course");
            }
        } else {
            errors.rejectValue("course", "Required");
        }

    }
}
