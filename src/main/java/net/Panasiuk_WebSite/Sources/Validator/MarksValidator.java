package net.Panasiuk_WebSite.Sources.Validator;

import net.Panasiuk_WebSite.Sources.Model.Mark;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MarksValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        Mark marks = (Mark) o;
        int math = marks.getMath();
        int history = marks.getHistory();
        int biology = marks.getBiology();
        int english = marks.getEnglish();
        int geography = marks.getGeography();
        int chemistry = marks.getChemistry();


        if (math < 1 || math > 100) {
            errors.rejectValue("math", "Mark.markForm.valid");
        }

        if (history < 1 || history > 100) {
            errors.rejectValue("history", "Mark.markForm.valid");
        }

        if (biology < 1 || biology > 100) {
            errors.rejectValue("biology", "Mark.markForm.valid");
        }

        if (english < 1 || english > 100) {
            errors.rejectValue("english", "Mark.markForm.valid");
        }

        if (geography < 1 || geography > 100) {
            errors.rejectValue("geography", "Mark.markForm.valid");
        }

        if (chemistry < 1 || chemistry > 100) {
            errors.rejectValue("chemistry", "Mark.markForm.valid");
        }

    }
}
