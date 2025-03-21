package org.full.cycle.domain.exceptions;

import org.full.cycle.domain.validation.Error;

import java.util.List;

public class DomainException extends NoStacktraceException{

    private final List<Error> errors;

    private DomainException(final String aMessage, final List<Error> anErrors) {
        super(aMessage);
        this.errors = anErrors;
    }

    public static DomainException with(final Error anErrors) {
        return new DomainException(anErrors.message(), List.of(anErrors));
    }

    public List<Error> getErrors(){
        return errors;
    }

}
