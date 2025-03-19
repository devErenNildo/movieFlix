package org.full.cycle.domain;

import lombok.EqualsAndHashCode;

import java.util.Objects;

//comportamento e definições do DDD
@EqualsAndHashCode
public abstract class Entity<ID extends Identifier> {
    // A entidade é definida pelo seu identificador, no caso p ID

    // O identifier é o primeiro objeto de valor, ou seja ele vai ser um identificador do ID
    //O id não existe, mas como ele é uma classe generica temos que instanciar ele como um generico
    // Ou seja, o id pode ser qualquer tipo, contando que esse tipo extenda o tipo identificador, ou seja, isso é uma proteção para que não seja feito qualquer coisa na modelagem
    protected final ID id;

    protected Entity(final ID id) {
        // Essa abordagem permite criar objetos de forma correta e fazendo validação no próprio construtor
        Objects.requireNonNull(id, "'id' não deve ser nulo");
        this.id = id;
    }

    public ID getId(){
        return id;
    }
}
