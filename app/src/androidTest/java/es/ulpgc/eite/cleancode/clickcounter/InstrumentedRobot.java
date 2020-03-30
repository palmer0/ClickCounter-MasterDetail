package es.ulpgc.eite.cleancode.clickcounter;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.view.View;
import android.widget.ListView;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.rule.ActivityTestRule;

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

  private ActivityTestRule rule;

  public InstrumentedRobot(ActivityTestRule rule) {
    this.rule = rule;
  }

  private static Matcher<View> withListSize(final int size) {

    return new TypeSafeMatcher<View>() {

      @Override public boolean matchesSafely (final View view) {
        return ((ListView) view).getCount() == size;
      }

      @Override public void describeTo (final Description description) {
        description.appendText("ListView should have " + size + " items");
      }
    };
  }

  private static Matcher<View> withValueAtPosition(final int val, final int pos) {

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


  public void rotateScreen() {

    Context context = ApplicationProvider.getApplicationContext();
    int orientation = context.getResources().getConfiguration().orientation;
    Activity activity = rule.getActivity();

    if(orientation  == Configuration.ORIENTATION_PORTRAIT) {
      activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    } else {
      activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
  }

  public void mostrarListaConNumeroDeContadores(String arg0) {

    int size = Integer.valueOf(arg0);

    onView (withId (R.id.list)).check (matches (withListSize (size)));
  }

  public void pulsarBotonMaster() {
    onView(withId(R.id.master)).perform(click());

  }


  public void pulsarBotonMasterNumeroDeVeces(String arg0) {
    int length = Integer.valueOf(arg0);

    for(int index=0; index < length; index++){
      pulsarBotonMaster();
    }
  }

  public void mostrarContadorEnListaEnPosicionConValor(String arg0, String arg1) {

    int pos = Integer.valueOf(arg0);
    int val = Integer.valueOf(arg1);

    onView (withId (R.id.list)).check (matches (withValueAtPosition(val,pos)));
  }

 

  public void mostrarContadorConValor(String s) {
    onView(withId(R.id.counter))
        .check(matches(isDisplayed()))
        .check(matches(withText(s)));
  }

  public void pulsarBotonContadorEnPosicion(String arg0) {

    int pos = Integer.valueOf(arg0);

    onData(allOf())
        .inAdapterView(withId(R.id.list))
        .atPosition(pos)
        .perform(click());
  }

  public void pulsarBotonContadorEnPosicionNumeroDeVeces(String arg0, String arg1) {

    int length = Integer.valueOf(arg1);

    for(int index=0; index < length; index++){
      pulsarBotonContadorEnPosicion(arg0);
      pulsarBotonRegresar();
    }
  }

  public void mostrarNumeroDeClicksConValor(String arg0) {
    onView(withId(R.id.clicks))
        .check(matches(isDisplayed()))
        .check(matches(withText(arg0)));
  }

  public void pulsarBotonDetalle() {
    onView(withId(R.id.detail)).perform(click());
  }

  public void pulsarBotonRegresar() {
    pressBack();
  }


  public void pulsarBotonDetalleNumeroDeVeces(String arg0) {
    int length = Integer.valueOf(arg0);

    for(int index=0; index < length; index++){
      pulsarBotonDetalle();
    }
  }
}
