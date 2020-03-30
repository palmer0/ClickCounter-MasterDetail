package es.ulpgc.eite.cleancode.clickcounter;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.rule.ActivityTestRule;

import com.mauriciotogneri.greencoffee.GreenCoffeeSteps;
import com.mauriciotogneri.greencoffee.annotations.And;
import com.mauriciotogneri.greencoffee.annotations.Given;
import com.mauriciotogneri.greencoffee.annotations.Then;
import com.mauriciotogneri.greencoffee.annotations.When;

@SuppressWarnings("unused")
public class InstrumentedSteps extends GreenCoffeeSteps {

  private InstrumentedRobot robot = new InstrumentedRobot();
  private ActivityTestRule rule;

  public InstrumentedSteps(ActivityTestRule rule) {
    this.rule = rule;
  }

  private void rotarPantalla() {

    Context context = ApplicationProvider.getApplicationContext();
    int orientation = context.getResources().getConfiguration().orientation;
    Activity activity = rule.getActivity();

    if(orientation  == Configuration.ORIENTATION_PORTRAIT) {
      activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    } else {
      activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
  }

  @When("^rotamos pantalla$")
  public void rotamosPantalla() {

    rotarPantalla();
  }

  @Given("^iniciando pantalla maestro$")
  public void iniciandoPantallaMaestro() {

  }

  @And("^mostrando lista con numero de contadores \"([^\"]*)\"$")
  public void mostrandoListaConNumeroDeContadores(String arg0) {
    
    robot.mostrarListaConNumeroDeContadores(arg0);
  }

  @When("^pulsamos boton master$")
  public void pulsamosBotonMaster() {
    robot.pulsarBotonMaster();
  }

  @Then("^mostraremos contador en lista en posicion \"([^\"]*)\" con valor \"([^\"]*)\"$")
  public void mostraremosContadorEnListaEnPosicionConValor(String arg0, String arg1) {
    robot.mostrarContadorEnListaEnPosicionConValor(arg0, arg1);
    
  }

  @And("^mostraremos lista con numero de contadores \"([^\"]*)\"$")
  public void mostraremosListaConNumeroDeContadores(String arg0) {
    robot.mostrarListaConNumeroDeContadores(arg0);
    
  }

  @And("^pulsando boton master$")
  public void pulsandoBotonMaster() {
    robot.pulsarBotonMaster();
  }

  @And("^mostrando contador en lista en posicion \"([^\"]*)\" con valor \"([^\"]*)\"$")
  public void mostrandoContadorEnListaEnPosicionConValor(String arg0, String arg1) {
    robot.mostrarContadorEnListaEnPosicionConValor(arg0, arg1);
    
  }

  @When("^pulsamos boton contador en posicion \"([^\"]*)\"$")
  public void pulsamosBotonContadorEnPosicion(String arg0) {
    robot.pulsarBotonContadorEnPosicion(arg0);
    
  }

  @Then("^iniciaremos pantalla detalle$")
  public void iniciaremosPantallaDetalle() {

  }

  @And("^mostraremos contador con valor \"([^\"]*)\"$")
  public void mostraremosContadorConValor(String arg0) {
    robot.mostrarContadorConValor(arg0);
    
  }

  @And("^mostraremos numero de clicks con valor \"([^\"]*)\"$")
  public void mostraremosNumeroDeClicksConValor(String arg0) {
    robot.mostrarNumeroDeClicksConValor(arg0);
    
  }

  @And("^pulsando boton contador en posicion \"([^\"]*)\"$")
  public void pulsandoBotonContadorEnPosicion(String arg0) {
    robot.pulsarBotonContadorEnPosicion(arg0);
    
  }

  @And("^iniciando pantalla detalle$")
  public void iniciandoPantallaDetalle() {

  }

  @And("^mostrando contador con valor \"([^\"]*)\"$")
  public void mostrandoContadorConValor(String arg0) {
    robot.mostrarContadorConValor(arg0);
    
  }

  @And("^mostrando numero de clicks con valor \"([^\"]*)\"$")
  public void mostrandoNumeroDeClicksConValor(String arg0) {
    robot.mostrarNumeroDeClicksConValor(arg0);
    
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

  }

  @And("^resumiremos pantalla maestro$")
  public void resumiremosPantallaMaestro() {
  }

}
