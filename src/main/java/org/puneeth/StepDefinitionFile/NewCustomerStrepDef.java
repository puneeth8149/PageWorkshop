package org.puneeth.StepDefinitionFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.puneeth.ElementsLocators.NewCustomer;
import org.puneeth.Utilities.WebUtilities;

public class NewCustomerStrepDef {
    public BaseClass base;

    @Given("user launch naveen automation lab {string}")
    public void user_launch_naveen_automation_lab(String URL) {
        base= new BaseClass();
        System.out.printf("driver:- "+base.driver);

    }

    @When("user click on new customer button")
    public void user_click_on_new_customer_button() {

       WebUtilities.waitAndClick(NewCustomer.landingPageElements.btnContinue);
    }

    @Then("user verify {string} of the page")
    public void user_verify_of_the_page(String string) {
        System.out.printf("title" +base.driver.getTitle());
    }

}
