package org.full.cycle.domain.category;

import org.full.cycle.domain.validation.ValidationHandler;
import org.full.cycle.domain.validation.Validator;

public class CategoryValidator extends Validator {

    private final Category category;

    public CategoryValidator(final Category category, final ValidationHandler handler) {
        super(handler);
        this.category = category;
    }

    @Override
    public void validate() {

    }
}
