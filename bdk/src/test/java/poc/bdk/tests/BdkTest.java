package poc.bdk.tests;

import com.symphony.bdk.core.SymphonyBdk;
import com.symphony.bdk.core.auth.exception.AuthInitializationException;
import com.symphony.bdk.core.auth.exception.AuthUnauthorizedException;
import com.symphony.bdk.core.config.BdkConfigLoader;
import com.symphony.bdk.core.config.exception.BdkConfigException;
import com.symphony.bdk.core.config.model.BdkConfig;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions()
public class BdkTest {

  private SymphonyBdk bdk;
  private BdkConfig config;

  @Given("a bot")
  public void aBot() throws BdkConfigException {
    config = BdkConfigLoader.loadFromClasspath("/config.yaml");
  }

  @When("bot authenticates")
  public void botAuthenticates() throws AuthUnauthorizedException, AuthInitializationException {
    bdk = new SymphonyBdk(config);
  }

  @Then("a session is created")
  public void aSessionIsCreated() {
    Assert.assertNotNull(bdk.botSession());
  }
}
