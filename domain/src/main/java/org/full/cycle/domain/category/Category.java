package org.full.cycle.domain.category;

import lombok.Getter;
import org.full.cycle.domain.AggregateRoot;
import org.full.cycle.domain.validation.ValidationHandler;

import java.time.Instant;

// especificando que a classe categoria é um agregado
@Getter
public class Category extends AggregateRoot<CategoryID> {
    private String name;
    private String description;
    private boolean active;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    private Category(
            final CategoryID anId,
            final String aName,
            final String aDescription,
            final boolean isActive,
            final Instant aCreationDate,
            final Instant aUpdateDate,
            final Instant aDeleteDate
    ) {
        super(anId);
        this.name = aName;
        this.description = aDescription;
        this.active = isActive;
        this.createdAt = aCreationDate;
        this.updatedAt = aUpdateDate;
        this.deletedAt = aDeleteDate;
    }

    public static Category newCategory(final String aName, final String aDescription, final boolean isActive){
        final var id = CategoryID.unique();
        final var now = Instant.now();
        return new Category(id, aName, aDescription, isActive, now, now, null);
    }


    @Override
    public void validate(final ValidationHandler handler) {
        new CategoryValidator(this, handler).validate();
    }

    public Category activate(){
        this.deletedAt = null;
        this.active = true;
        this.updatedAt = Instant.now();
        return this;
    }

    public Category deactivate(){
        if (getDeletedAt() == null) {
            this.deletedAt = Instant.now();
        }

        this.active = false;
        this.updatedAt = Instant.now();
        return this;
    }

    public Category update(
            final String aName,
            final String aDescription,
            final boolean isActive
    ){
        if (isActive) {
            activate();
        }else {
            deactivate();
        }
        this.name = aName;
        this.description = aDescription;
        this.updatedAt= Instant.now();
        return this;
    }
}
