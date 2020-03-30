package es.ulpgc.eite.cleancode.clickcounter;

import androidx.test.rule.ActivityTestRule;

import com.mauriciotogneri.greencoffee.GreenCoffeeConfig;
import com.mauriciotogneri.greencoffee.GreenCoffeeTest;
import com.mauriciotogneri.greencoffee.ScenarioConfig;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Locale;

import es.ulpgc.eite.cleancode.clickcounter.master.MasterActivity;

@RunWith(Parameterized.class)
public class InstrumentedTests extends GreenCoffeeTest {

  @Rule
  public ActivityTestRule activity = new ActivityTestRule(MasterActivity.class);

  public InstrumentedTests(ScenarioConfig scenarioConfig) {
    super(scenarioConfig);
  }

  @Parameterized.Parameters(name = "{0}")
  public static Iterable scenarios() throws IOException {
    // automatically take a screenshot if a test fails
    return new GreenCoffeeConfig(true)
        .withFeatureFromAssets("assets/clickcounter.feature")
        .scenarios(
            //new Locale("en", "GB"),
            new Locale("es", "ES")
        ); // the locales used to run the scenarios (optional)
  }

  @Test
  public void test() {
    start(new InstrumentedSteps());
  }
}
