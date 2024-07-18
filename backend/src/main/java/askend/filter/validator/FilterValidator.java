package askend.filter.validator;

import askend.filter.dto.CriteriaDto;
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
        FilterDto filter = (FilterDto) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", MANDATORY_MESSAGE);

        if (filter.getCriterias() == null || filter.getCriterias().isEmpty() ||
                filter.getCriterias().stream().anyMatch(x -> x.getCriteriaType() == null || x.getCondition() == null || x.getValue() == null)) {
            errors.rejectValue("criterias", MANDATORY_MESSAGE);
        }

        if (filter.getCriterias().stream().map(CriteriaDto::getIsSelected).findAny().isEmpty()) {
            errors.rejectValue("selection", MANDATORY_MESSAGE);
        }
    }
}
