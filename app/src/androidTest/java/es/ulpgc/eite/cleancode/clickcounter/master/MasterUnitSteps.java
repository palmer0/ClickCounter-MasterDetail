package es.ulpgc.eite.cleancode.clickcounter.master;

import com.mauriciotogneri.greencoffee.GreenCoffeeSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class MasterUnitSteps extends GreenCoffeeSteps {

//  private ActivityTestRule<MasterActivity> testRule =
//      new ActivityTestRule<>(MasterActivity.class, false, false);

  MasterUnitRobot robot = new MasterUnitRobot();



  //private ActivityController<MasterActivity> testCtrl;

  @Given("iniciando pantalla maestro")
  public void iniciando_pantalla_maestro() {

    //robot.iniciar_pantalla_maestro(testCtrl);
    robot.iniciar_pantalla_maestro();
  }

  @Given("mostrando lista con numero de contadores {string}")
  public void mostrando_lista_con_numero_de_contadores(String string) {

    robot.mostrar_lista_con_numero_de_contadores(string);
  }

  @When("pulsamos boton master")
  public void pulsamos_boton_master() {

    robot.pulsar_boton_master();
  }

  @Then("incluiremos nuevo contador en lista en posicion {string}")
  public void incluiremos_nuevo_contador_en_lista_en_posicion(String string) {

    robot.incluir_nuevo_contador_en_lista_en_posicion(string);
  }

  @Then("mostraremos contador con valor {string}")
  public void mostraremos_contador_con_valor(String string) {

    robot.mostrar_contador_con_valor(string);
  }

  @When("pulsamos boton contador en posicion {string}")
  public void pulsamos_boton_contador_en_posicion(String string) {

    robot.pulsar_boton_contador_en_posicion(string);
  }

  @Then("iniciaremos pantalla detalle")
  public void iniciaremos_pantalla_detalle() {

    robot.iniciar_pantalla_detalle();
  }

  @Then("mostraremos numero de clicks con valor {string}")
  public void mostraremos_numero_de_clicks_con_valor(String string) {

    robot.mostrar_numero_de_clicks_con_valor(string);
  }

  @Given("pulsando boton contador en posicion {string}")
  public void pulsando_boton_contador_en_posicion(String string) {

    robot.pulsar_boton_contador_en_posicion(string);
  }

  @Given("iniciando pantalla detalle")
  public void iniciando_pantalla_detalle() {

    robot.iniciar_pantalla_detalle();
  }

  @Given("mostrando contador con valor {string}")
  public void mostrando_contador_con_valor(String string) {

    robot.mostrar_contador_con_valor(string);
  }

  @Given("mostrando numero de clicks con valor {string}")
  public void mostrando_numero_de_clicks_con_valor(String string) {

    robot.mostrar_numero_de_clicks_con_valor(string);
  }

  @When("pulsamos boton detalle")
  public void pulsamos_boton_contador() {

    robot.pulsar_boton_detalle();
  }

  @Given("pulsando boton detalle")
  public void pulsando_boton_contador() {

    robot.pulsar_boton_detalle();
  }

  @When("pulsamos boton regresar")
  public void pulsamos_boton_regresar() {

    robot.pulsar_boton_regresar();
  }

  @Then("finalizaremos pantalla detalle")
  public void finalizaremos_pantalla_detalle() {

    robot.finalizar_pantalla_detalle();
  }

  @Then("resumiremos pantalla maestro")
  public void resumiremos_pantalla_maestro() {

    robot.resumir_pantalla_maestro();
  }


}
