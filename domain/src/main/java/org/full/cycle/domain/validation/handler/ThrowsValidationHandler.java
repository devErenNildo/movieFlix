package org.full.cycle.domain.validation.handler;

import org.full.cycle.domain.exceptions.DomainException;
import org.full.cycle.domain.validation.Error;
import org.full.cycle.domain.validation.ValidationHandler;

import java.util.List;

public class ThrowsValidationHandler implements ValidationHandler {
    @Override
    public ValidationHandler append(final Error anError) {
        throw DomainException.with(anError);
    }

    @Override
    public ValidationHandler append(ValidationHandler anHandler) {
        return null;
    }

    @Override
    public ValidationHandler validate(Validation aValidation) {
        return null;
    }

    @Override
    public List<Error> getErrors() {
        return List.of();
    }
}
