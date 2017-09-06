package pl.bartekdrzazgowski.beanvalidation;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Main {

    public static void main(String[] args) {
        new Main().validate();
    }

    private void validate() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Project project = new Project();
        project.setCreatedAt(LocalDateTime.now().plus(1, ChronoUnit.DAYS));
        project.setEmails(new HashSet<>(Arrays.asList("notemail")));
        printConstraintViolations(validator.validate(project));
    }

    private <T> void printConstraintViolations(Set<ConstraintViolation<T>> violations) {
        for (ConstraintViolation<T> violation : violations) {
            System.out.println(violation.getPropertyPath() + " " + violation.getMessage());
        }
        System.out.println("---");
    }
}
