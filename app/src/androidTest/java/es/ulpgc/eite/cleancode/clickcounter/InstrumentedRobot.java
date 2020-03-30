package es.ulpgc.eite.cleancode.clickcounter;

import android.view.View;
import android.widget.ListView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import es.ulpgc.eite.cleancode.clickcounter.app.CounterData;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

public class InstrumentedRobot {

  private static Matcher<View> withListSize (final int size) {

    return new TypeSafeMatcher<View>() {

      @Override public boolean matchesSafely (final View view) {
        return ((ListView) view).getCount() == size;
      }

      @Override public void describeTo (final Description description) {
        description.appendText("ListView should have " + size + " items");
      }
    };
  }

  private static Matcher<View> withValueAtPosition (final int val, final int pos) {

    return new TypeSafeMatcher<View>() {

      @Override public boolean matchesSafely (final View view) {
        Object obj = ((ListView) view).getItemAtPosition(pos);
        CounterData item = (CounterData) obj;
        return item.value == val;
      }

      @Override public void describeTo (final Description description) {
        description.appendText(
            "ListView should have " + val + " item at position " + pos
        );
      }
    };
  }


  public void mostrarListaConNumeroDeContadores(String s) {

    int size = Integer.valueOf(s);

    onView (withId (R.id.list)).check (matches (withListSize (size)));
  }

  public void pulsarBotonMaster() {
    onView(withId(R.id.master)).perform(click());

  }


  public void mostrarContadorEnListaEnPosicionConValor(String s1, String s2) {

    int pos = Integer.valueOf(s1);
    int val = Integer.valueOf(s2);

    onView (withId (R.id.list)).check (matches (withValueAtPosition(val,pos)));
  }

 

  public void mostrarContadorConValor(String s) {
    onView(withId(R.id.counter))
        .check(matches(isDisplayed()))
        .check(matches(withText(s)));
  }

  public void pulsarBotonContadorEnPosicion(String s) {

    int pos = Integer.valueOf(s);

    onData(allOf())
        .inAdapterView(withId(R.id.list))
        .atPosition(pos)
        .perform(click());
  }

  public void mostrarNumeroDeClicksConValor(String s) {
    onView(withId(R.id.clicks))
        .check(matches(isDisplayed()))
        .check(matches(withText(s)));
  }

  public void pulsarBotonDetalle() {
    onView(withId(R.id.detail)).perform(click());
  }

  public void pulsarBotonRegresar() {
    pressBack();
  }

}
