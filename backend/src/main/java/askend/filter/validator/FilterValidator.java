package askend.filter.validator;

import askend.filter.dto.FilterDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import static askend.core.validation.ValidatorMessage.MANDATORY_MESSAGE;

@Component
public class FilterValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return FilterDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        FilterDto kasutajaInfoDto = (FilterDto) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", MANDATORY_MESSAGE);

        if (kasutajaInfoDto.getCriterias() == null || kasutajaInfoDto.getCriterias().isEmpty()) {
            errors.rejectValue("criterias", MANDATORY_MESSAGE);
        }

        if (kasutajaInfoDto.getSelectedCriteria() == null) {
            errors.rejectValue("selectedCriteria", MANDATORY_MESSAGE);
        }
    }
}
