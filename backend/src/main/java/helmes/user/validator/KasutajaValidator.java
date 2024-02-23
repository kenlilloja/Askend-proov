package helmes.user.validator;

import helmes.user.dto.KasutajaInfoDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import static helmes.core.validation.ValidatorMessage.MANDATORY_MESSAGE;

@Component
public class KasutajaValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return KasutajaInfoDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        KasutajaInfoDto kasutajaInfoDto = (KasutajaInfoDto) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nimi", MANDATORY_MESSAGE);

        if (kasutajaInfoDto.getOnNousTingimustega() == null) {
            errors.rejectValue("onNousTingimustega", MANDATORY_MESSAGE);
        }

        if (kasutajaInfoDto.getSektorid() == null || kasutajaInfoDto.getSektorid().isEmpty()) {
            errors.rejectValue("sektorid", MANDATORY_MESSAGE);
        }
    }
}
