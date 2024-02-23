package helmes.core.controller;

import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.List;

@ControllerAdvice
public class ControllerBinding {

    private final List<Validator> validators;

    public ControllerBinding(final List<Validator> validators) {
        this.validators = validators;
    }

    @InitBinder
    public void binder(WebDataBinder binder) {
        if (binder == null || binder.getTarget() == null) {
            return;
        }

        for (Validator validator : validators) {
            if (validator.supports(binder.getTarget().getClass())) {
                binder.addValidators(validator);
            }
        }
    }
}
