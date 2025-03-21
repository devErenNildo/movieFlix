package org.full.cycle.domain;

import org.full.cycle.domain.validation.ValidationHandler;

// Indica que é o nosso agregado raiz
public abstract class AggregateRoot<ID extends Identifier> extends Entity<ID> {

    protected AggregateRoot(final ID id) {
        super(id);
    }
}
