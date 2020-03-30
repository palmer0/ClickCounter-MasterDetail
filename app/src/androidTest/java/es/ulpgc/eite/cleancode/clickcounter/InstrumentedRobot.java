package es.ulpgc.eite.cleancode.clickcounter;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class InstrumentedRobot {

  public void iniciarPantallaMaestro() {

  }

  public void mostrarListaConNumeroDeContadores(String text) {

  }

  public void pulsarBotonMaster() {

  }

  public void incluirNuevoContadorEnListaEnPosicion(String text) {

  }

  public void mostrarContadorConValor(String text) {
    onView(withId(R.id.counter))
        .check(matches(isDisplayed()))
        .check(matches(withText(text)));
  }

  public void pulsarBotonContadorEnPosicion(String text) {

  }

  public void iniciarPantallaDetalle() {

  }

  public void mostrarNumeroDeClicksConValor(String text) {
    onView(withId(R.id.clicks))
        .check(matches(isDisplayed()))
        .check(matches(withText(text)));
  }

  public void pulsarBotonDetalle() {
    onView(withId(R.id.detail)).perform(click());
  }

  public void pulsarBotonRegresar() {
    //pressBack();
  }

  public void finalizarPantallaDetalle() {

  }

  public void resumirPantallaMaestro() {

  }


}
