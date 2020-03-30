package es.ulpgc.eite.cleancode.clickcounter.detail;

import com.mauriciotogneri.greencoffee.GreenCoffeeSteps;
import com.mauriciotogneri.greencoffee.annotations.And;
import com.mauriciotogneri.greencoffee.annotations.Given;
import com.mauriciotogneri.greencoffee.annotations.Then;
import com.mauriciotogneri.greencoffee.annotations.When;

import es.ulpgc.eite.cleancode.clickcounter.InstrumentedRobot;

@SuppressWarnings("unused")
class DetailInstrumentedSteps extends GreenCoffeeSteps {

  InstrumentedRobot robot = new InstrumentedRobot();

  @Given("^iniciando pantalla detalle$")
  public void iniciandoPantallaDetalle() {

  }

  @And("^mostrando contador con valor \"([^\"]*)\"$")
  public void mostrandoContadorConValor(String text) {
    
    robot.mostrarContadorConValor(text);
  }

  @And("^mostrando numero de clicks con valor \"([^\"]*)\"$")
  public void mostrandoNumeroDeClicksConValor(String text) {
    
    robot.mostrarNumeroDeClicksConValor(text);
  }

  @When("^pulsamos boton detalle$")
  public void pulsamosBotonDetalle() {
    robot.pulsarBotonDetalle();
  }

  @Then("^mostraremos contador con valor \"([^\"]*)\"$")
  public void mostraremosContadorConValor(String text) {
    
    robot.mostrarContadorConValor(text);
  }

  @And("^mostraremos numero de clicks con valor \"([^\"]*)\"$")
  public void mostraremosNumeroDeClicksConValor(String text) {
    
    robot.mostrarNumeroDeClicksConValor(text);
  }
}
