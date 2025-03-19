package org.full.cycle.domain.category;

import org.junit.Assert;
import org.junit.Test;

public class CategoryTest {

    @Test
    public void givenAValidParams_whenCallNewCategory_thenInstantiateACategory(){
        final var expectedName = "Filmes";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;

        final var actualCategory =
                Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        Assert.assertNotNull(actualCategory);
        Assert.assertNotNull(actualCategory.getId());
        Assert.assertEquals(expectedName, actualCategory.getName());
        Assert.assertEquals(expectedDescription, actualCategory.getDescription());
        Assert.assertEquals(expectedIsActive, actualCategory.isActive());
        Assert.assertNotNull(actualCategory.getCreatedAt());
        Assert.assertNotNull(actualCategory.getUpdatedAt());
        Assert.assertNull(actualCategory.getDeletedAt());
    }

    @Test
    public void givenAnInvalidNullName_whenCallNewCategoryAndValidate_thenShouldReceiveError() {
        final String expectedName = null;
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'name' não pode ser nulo";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;

        final var actualCategory =
                Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        final var actualException =
                Assert.assertThrows(DomainException.class, () -> actualCategory.validate(new ThrowsValidationHandler()));

        Assert.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assert.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }
}
