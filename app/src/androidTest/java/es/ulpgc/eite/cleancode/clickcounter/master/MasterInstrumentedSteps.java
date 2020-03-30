package es.ulpgc.eite.cleancode.clickcounter.master;

import com.mauriciotogneri.greencoffee.GreenCoffeeSteps;
import com.mauriciotogneri.greencoffee.annotations.And;
import com.mauriciotogneri.greencoffee.annotations.Given;
import com.mauriciotogneri.greencoffee.annotations.Then;
import com.mauriciotogneri.greencoffee.annotations.When;

import es.ulpgc.eite.cleancode.clickcounter.InstrumentedRobot;

@SuppressWarnings("unused")
public class MasterInstrumentedSteps extends GreenCoffeeSteps {

  InstrumentedRobot robot = new InstrumentedRobot();

  @Given("^iniciando pantalla maestro$")
  public void iniciandoPantallaMaestro() {
    robot.iniciarPantallaMaestro();
  }

  @And("^mostrando lista con numero de contadores \"([^\"]*)\"$")
  public void mostrandoListaConNumeroDeContadores(String text)  {
    robot.mostrarListaConNumeroDeContadores(text);
    
  }

  @When("^pulsamos boton master$")
  public void pulsamosBotonMaster() {
    robot.pulsarBotonMaster();
  }

  @Then("^incluiremos nuevo contador en lista en posicion \"([^\"]*)\"$")
  public void incluiremosNuevoContadorEnListaEnPosicion(String text)  {
    robot.incluirNuevoContadorEnListaEnPosicion(text);
    
  }

  @And("^mostraremos contador con valor \"([^\"]*)\"$")
  public void mostraremosContadorConValor(String text)  {
    robot.mostrarContadorConValor(text);
    
  }

  @When("^pulsamos boton contador en posicion \"([^\"]*)\"$")
  public void pulsamosBotonContadorEnPosicion(String text)  {
    robot.pulsarBotonContadorEnPosicion(text);
    
  }

  @Then("^iniciaremos pantalla detalle$")
  public void iniciaremosPantallaDetalle() {
    robot.iniciarPantallaDetalle();
  }

  @And("^mostraremos numero de clicks con valor \"([^\"]*)\"$")
  public void mostraremosNumeroDeClicksConValor(String text)  {
    robot.mostrarNumeroDeClicksConValor(text);
    
  }

  @And("^pulsando boton contador en posicion \"([^\"]*)\"$")
  public void pulsandoBotonContadorEnPosicion(String text)  {
    robot.pulsarBotonContadorEnPosicion(text);
    
  }

  @And("^iniciando pantalla detalle$")
  public void iniciandoPantallaDetalle() {
    robot.iniciarPantallaDetalle();
  }

  @And("^mostrando contador con valor \"([^\"]*)\"$")
  public void mostrandoContadorConValor(String text)  {
    robot.mostrarContadorConValor(text);
    
  }

  @And("^mostrando numero de clicks con valor \"([^\"]*)\"$")
  public void mostrandoNumeroDeClicksConValor(String text)  {
    robot.mostrarNumeroDeClicksConValor(text);
    
  }

  @When("^pulsamos boton detalle$")
  public void pulsamosBotonDetalle() {
    robot.pulsarBotonDetalle();
  }

  @And("^pulsando boton detalle$")
  public void pulsandoBotonDetalle() {
    robot.pulsarBotonDetalle();
  }

  @When("^pulsamos boton regresar$")
  public void pulsamosBotonRegresar() {
    robot.pulsarBotonRegresar();
  }

  @Then("^finalizaremos pantalla detalle$")
  public void finalizaremosPantallaDetalle() {
    robot.finalizarPantallaDetalle();
  }

  @And("^resumiremos pantalla maestro$")
  public void resumiremosPantallaMaestro() {
    robot.resumirPantallaMaestro();
  }


}
