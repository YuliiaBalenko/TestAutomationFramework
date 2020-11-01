package com.epam.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.epam.steps.serenity.EndUserSteps;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.steps.Parameters;

public class DefinitionSteps {

    @Steps
    EndUserSteps endUser;

    @Given("the user is on the Wikionary home page")
    public void givenTheUserIsOnTheWikionaryHomePage() {
        endUser.is_the_home_page();
    }

    @When("the user looks up the definition of the word '$word'")
    public void whenTheUserLooksUpTheDefinitionOf(String word) {
        endUser.looks_for(word);
    }

    @When("the user looks up the definition of the word: $wordTable")
    public void whenTheUserLooksUpTheDefinitionOfTableValues(ExamplesTable wordTable) {
        for (Parameters row1 : wordTable.getRowsAsParameters()) {
            String word = row1.valueAs("word", String.class);
            endUser.looks_for(word);
        }

    }
    @Then("they should see the definition: $definitionTable")
    public void thenTheyShouldSeeATableDefinitionContainingTheWords(ExamplesTable definitionTable) {
        for (Parameters row : definitionTable.getRowsAsParameters()) {
            String definition = row.valueAs("definition", String.class);
            endUser.should_see_definition(definition);
        }
    }


    @Then("they should see the definition '$definition'")
    public void thenTheyShouldSeeADefinitionContainingTheWords(String definition) {
        endUser.should_see_definition(definition);
    }

}
