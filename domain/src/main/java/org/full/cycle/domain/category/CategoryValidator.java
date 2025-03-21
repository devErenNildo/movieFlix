package org.full.cycle.domain.category;

import org.full.cycle.domain.validation.Error;
import org.full.cycle.domain.validation.ValidationHandler;
import org.full.cycle.domain.validation.Validator;

public class CategoryValidator extends Validator {

    public static final int NAME_MAX_LENGTH = 255;
    public static final int NAME_MIN_LENGTH = 3;

    private final Category category;

    public CategoryValidator(final Category category, final ValidationHandler handler) {
        super(handler);
        this.category = category;
    }

    @Override
    public void validate() {
        checkNameConstraints();
    }

    private void checkNameConstraints(){
        final var name = this.category.getName();
        if (name == null) {
            this.validationHandler().append(new Error("'nome' não pode ser null"));
            return;
        }

        if (name.isBlank()){
            this.validationHandler().append(new Error("'name' não pode ficar em branco"));
            return;
        }

        final int length = name.trim().length();
        if (length > NAME_MAX_LENGTH || length < NAME_MIN_LENGTH){
            this.validationHandler().append(new Error("'name' tem que ter pelo menos 3 caracteres e no máximo 255"));
        }
    }
}
