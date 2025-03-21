package org.full.cycle.domain.validation;

import java.util.List;

// É uma interface fluente, que pode ser chamada a propria instancia e encadear metodos
public interface ValidationHandler {

    ValidationHandler append(Error anError);

    ValidationHandler append(ValidationHandler anHandler);

    ValidationHandler validate(Validation aValidation);

    List<Error> getErrors();

    default boolean hasError(){
        return getErrors() != null && !getErrors().isEmpty();
    }

    public interface Validation{
        void validate();
    }

}
