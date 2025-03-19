package org.full.cycle.domain.category;

import org.full.cycle.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

public class CategoryID extends Identifier {

    private final String value;

    // Tem que ser privado o construtor pois só vai ser possível criar esse objeto pelos metodos factory expostos
    private CategoryID(String value) {
        // O id não pode ser nulo
        Objects.requireNonNull(value);
        this.value = value;
    }

    // vai ser chamado toda vez que for criado um id novo
    public static CategoryID unique() {
        return CategoryID.from(UUID.randomUUID());
    }

    // vai converter uma string que vem do banco de dados em um id válido
    public static CategoryID from(final String anId) {
        return new CategoryID(anId);
    }

    // recebe um id e converte em uma string
    public static CategoryID from(final UUID anId) {
        return new CategoryID(anId.toString().toLowerCase());
    }

    public String getValue(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CategoryID that = (CategoryID) o;
        return getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
