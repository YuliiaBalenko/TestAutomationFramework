package definitions;

import steps.EndUserSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertEquals;

public class DefinitionStepsForPetStoreOrder {


    @Steps
    EndUserSteps endUser;

    @Given("the valid Pet")
    public void createPet() {
        endUser.postPet();
    }

    @When("I create order for pet")
    public void createPetOrder() {
        endUser.postPetOrder();
    }

    @Then("the order is saved on server")
    public void comparePetOrders() {

        assertEquals("Pet orders are equals", endUser.getTestPetOrder(), endUser.getPetOrder());

    }

    @AfterScenario()
    public void deletePetAndPetOrder() {
        endUser.deletePetOrder();
        endUser.deletePet();
    }

}

