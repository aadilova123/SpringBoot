package com.example.practical1.sales;

import com.example.practical1.Practical1Application;
import com.example.practical1.models.*;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Map;

@ContextConfiguration(classes = Practical1Application.class)
@WebAppConfiguration
public class CreationOfPurchaseOrderSteps {

    @Autowired
    private WebApplicationContext wac;

    private WebClient customerBrowser;
    HtmlPage customerPage;

    @Autowired
    PlantInventoryEntryRepository plantInventoryEntryRepository;
    @Autowired
    PlantInventoryItemRepository plantInventoryItemRepository;

    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;

    @Before
    public void setUp() {
        customerBrowser = MockMvcWebClientBuilder.webAppContextSetup(wac).build();
    }

    @After  // Use `After` from Cucumber library
    public void tearOff() {
        purchaseOrderRepository.deleteAll();
        plantInventoryItemRepository.deleteAll();
        plantInventoryEntryRepository.deleteAll();
    }

    @Given("^the following plant catalog$")
    public void the_following_plant_catalog(List<PlantInventoryEntry> entries) throws Throwable {
        plantInventoryEntryRepository.saveAll(entries);
    }
    @Given("^the following inventory$")
    public void the_following_inventory(DataTable table) throws Throwable {
        for (Map<String, String> row: table.asMaps(String.class, String.class))
            plantInventoryItemRepository.save(
                    PlantInventoryItem.of(
                            Long.parseLong(row.get("id")),
                            row.get("serialNumber"),
                            EquipmentCondition.valueOf(row.get("equipmentCondition")),
                            plantInventoryEntryRepository.findById(Long.parseLong(row.get("plantInfo"))).orElse(null)
                    )
            );
    }

    @Given("^a customer is in the \"([^\"]*)\" web page$")
    public void a_customer_is_in_the_web_page(String arg1) throws Throwable {
        customerPage = customerBrowser.getPage("http://localhost/dashboard/catalog/form");
    }

    @Given("^no purchase order exists in the system$")
    public void no_purchase_order_exists_in_the_system() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
    @When("^the customer queries the plant catalog for an \"([^\"]*)\" available from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void the_customer_queries_the_plant_catalog_for_an_available_from_to(String arg1, String arg2, String arg3) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^(\\d+) plants are shown$")
    public void plants_are_shown(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^the customer selects a \"([^\"]*)\"$")
    public void the_customer_selects_a(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^a purchase order should be created with a total price of (\\d+)\\.(\\d+)$")
    public void a_purchase_order_should_be_created_with_a_total_price_of(int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
