package testData;

import com.google.common.collect.ImmutableList;
import enumsPetStoreOrder.PetStatuses;
import enumsPetStoreOrder.OrderStatuses;
import models.Category;
import models.Pet;
import models.PetStoreOrder;
import models.Tag;

public class PetStoreTestData {
    private Pet pet;
    private PetStoreOrder petStoreOrder;

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public PetStoreOrder getPetStoreOrder() {
        return petStoreOrder;
    }

    public void setPetStoreOrder(PetStoreOrder petStoreOrder) {
        this.petStoreOrder = petStoreOrder;
    }

    public Pet createTestPetObject() {
        Pet pet = new Pet();

        Category category = new Category();
        category.setId(123010);
        category.setName("Cats");
        pet.setCategory(category);

        Tag tag = new Tag();
        tag.setId(88);
        tag.setName("hot proposition");
        pet.setTags(ImmutableList.of(tag));

        pet.setId(4568260);
        pet.setName("Barsik");
        pet.setStatus(PetStatuses.AVAILABLE.status());
        pet.setPhotoUrls(ImmutableList.of("someUrl"));

        setPet(pet);

        return pet;
    }

    public PetStoreOrder createTestPetOrderObject() {
        PetStoreOrder petStoreOrder = new PetStoreOrder();
        petStoreOrder.setId(pet.getId());
        petStoreOrder.setPetId(3477);
        petStoreOrder.setQuantity(333);
        petStoreOrder.setStatus(OrderStatuses.DELIVERED.orderStatus());
        petStoreOrder.setComplete(true);

        setPetStoreOrder(petStoreOrder);

        return petStoreOrder;
    }
}
