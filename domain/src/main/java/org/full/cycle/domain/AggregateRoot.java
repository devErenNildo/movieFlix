package org.full.cycle.domain;

// Indica que é o nosso agregado raiz
public class AggregateRoot<ID extends Identifier> extends Entity<ID> {

    protected AggregateRoot(final ID id) {
        super(id);
    }
}
