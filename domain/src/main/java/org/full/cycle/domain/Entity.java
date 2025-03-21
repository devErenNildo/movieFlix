package org.full.cycle.domain;

import lombok.EqualsAndHashCode;
import org.full.cycle.domain.validation.ValidationHandler;

import java.util.Objects;

//comportamento e definições do DDD
@EqualsAndHashCode
public abstract class Entity<ID extends Identifier> {

    protected final ID id;

    protected Entity(final ID id) {
        Objects.requireNonNull(id, "'id' não deve ser nulo");
        this.id = id;
    }

    public ID getId(){
        return id;
    }

    public abstract void validate(ValidationHandler handler);
}
