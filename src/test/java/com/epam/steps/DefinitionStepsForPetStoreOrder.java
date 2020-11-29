package com.epam.steps;

import com.epam.EnvironmentPropertyLoader;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.epam.steps.serenity.EndUserSteps;

import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class DefinitionStepsForPetStoreOrder {

    protected static Properties envProperties = EnvironmentPropertyLoader.loadByEnvironment();

    private String getBaseUrl(){
        String propertyValue = envProperties.getProperty("baseURL");
        return propertyValue;
    }

    @Steps
    EndUserSteps endUser;

    @Given("the valid Pet")
    public void createPet() { endUser.postPet(getBaseUrl());
    }

    @When("I create order for pet")
    public void createPetOrder() {
        endUser.postPetOrder(getBaseUrl());
    }

    @Then("the order is saved on server")
    public void comparePetOrders() {

        assertEquals("Pet orders are equals", endUser.getTestPetOrder(), endUser.getPetOrder(getBaseUrl()));

    }

    @AfterScenario()
    public void deletePetAndPetOrder(){
        endUser.deletePetOrder(getBaseUrl());
        endUser.deletePet(getBaseUrl());
    }

}

