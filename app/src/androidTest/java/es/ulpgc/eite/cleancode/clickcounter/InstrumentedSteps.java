package es.ulpgc.eite.cleancode.clickcounter;

import androidx.test.rule.ActivityTestRule;

import com.mauriciotogneri.greencoffee.GreenCoffeeSteps;
import com.mauriciotogneri.greencoffee.annotations.And;
import com.mauriciotogneri.greencoffee.annotations.Given;
import com.mauriciotogneri.greencoffee.annotations.Then;
import com.mauriciotogneri.greencoffee.annotations.When;

@SuppressWarnings("unused")
public class InstrumentedSteps extends GreenCoffeeSteps {

  private InstrumentedRobot robot;

  public InstrumentedSteps(ActivityTestRule rule) {
    robot = new InstrumentedRobot(rule);
  }


  @Given("^dado mostrar lista con numero de contadores \"([^\"]*)\"$")
  public void dadoMostrarListaConNumeroDeContadores(String arg0) {
    robot.mostrarListaConNumeroDeContadores(arg0);

  }

  @When("^cuando pulsar boton master$")
  public void cuandoPulsarBotonMaster() {
    robot.pulsarBotonMaster();
  }

  @Then("^entonces mostrar contador en lista en posicion \"([^\"]*)\" con valor \"([^\"]*)\"$")
  public void entoncesMostrarContadorEnListaEnPosicionConValor(String arg0, String arg1) {

    robot.mostrarContadorEnListaEnPosicionConValor(arg0, arg1);
  }

  @And("^y mostrar lista con numero de contadores \"([^\"]*)\"$")
  public void yMostrarListaConNumeroDeContadores(String arg0) {

    robot.mostrarListaConNumeroDeContadores(arg0);
  }

  @And("^y pulsar boton master$")
  public void yPulsarBotonMaster() {
    robot.pulsarBotonMaster();
  }

  @When("^cuando rotar pantalla$")
  public void cuandoRotarPantalla() {
    robot.rotateScreen();
  }

  @And("^y mostrar contador en lista en posicion \"([^\"]*)\" con valor \"([^\"]*)\"$")
  public void yMostrarContadorEnListaEnPosicionConValor(String arg0, String arg1) {
    robot.mostrarContadorEnListaEnPosicionConValor(arg0, arg1);

  }

  @When("^cuando pulsar boton detalle numero de veces \"([^\"]*)\"$")
  public void cuandoPulsarBotonDetalleNumeroDeVeces(String arg0) {
    robot.pulsarBotonDetalleNumeroDeVeces(arg0);
  }
    
  @When("^cuando pulsar boton contador en posicion \"([^\"]*)\"$")
  public void cuandoPulsarBotonContadorEnPosicion(String arg0) {
    robot.pulsarBotonContadorEnPosicion(arg0);

  }

  @When("^cuando pulsar boton contador en posicion \"([^\"]*)\" numero de veces \"([^\"]*)\"$")
  public void cuandoPulsarBotonContadorEnPosicionNumeroDeVeces(String arg0, String arg1) {

    robot.pulsarBotonContadorEnPosicionNumeroDeVeces(arg0, arg1);
  }

    @And("^y mostrar contador con valor \"([^\"]*)\"$")
  public void yMostrarContadorConValor(String arg0) {
    robot.mostrarContadorConValor(arg0);

  }

  @And("^y mostrar numero de clicks con valor \"([^\"]*)\"$")
  public void yMostrarNumeroDeClicksConValor(String arg0) {

    robot.mostrarNumeroDeClicksConValor(arg0);
  }

  @And("^y pulsar boton contador en posicion \"([^\"]*)\"$")
  public void yPulsarBotonContadorEnPosicion(String arg0) {

    robot.pulsarBotonContadorEnPosicion(arg0);
  }

  @When("^cuando pulsar boton detalle$")
  public void cuandoPulsarBotonDetalle() {
    robot.pulsarBotonDetalle();
  }

  @Then("^entonces mostrar contador con valor \"([^\"]*)\"$")
  public void entoncesMostrarContadorConValor(String arg0) {

    robot.mostrarContadorConValor(arg0);
  }

  @And("^y pulsar boton detalle$")
  public void yPulsarBotonDetalle() {
    robot.pulsarBotonDetalle();
  }

  @When("^cuando pulsar boton regresar$")
  public void cuandoPulsarBotonRegresar() {
    robot.pulsarBotonRegresar();
  }

  @And("^y pulsar boton regresar$")
  public void yPulsarBotonRegresar() {
    robot.pulsarBotonRegresar();
  }

  @When("^cuando pulsar boton master numero de veces \"([^\"]*)\"$")
  public void cuandoPulsarBotonMasterNumeroDeVeces(String arg0) {
    robot.pulsarBotonMasterNumeroDeVeces(arg0);

  }

  @And("^y pulsar boton master numero de veces \"([^\"]*)\"$")
  public void yPulsarBotonMasterNumeroDeVeces(String arg0) {

    robot.pulsarBotonMasterNumeroDeVeces(arg0);
  }

  @And("^y pulsar boton contador en posicion \"([^\"]*)\" numero de veces \"([^\"]*)\"$")
  public void yPulsarBotonContadorEnPosicionNumeroDeVeces(String arg0, String arg1) {

    robot.pulsarBotonContadorEnPosicionNumeroDeVeces(arg0, arg1);
  }

}
