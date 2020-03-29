package es.ulpgc.eite.cleancode.clickcounter.master;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.clickcounter.app.CounterData;

public class MasterModel implements MasterContract.Model {

  public static String TAG = MasterModel.class.getSimpleName();

  private List<CounterData> counters;
  public Integer clicks;

  public MasterModel() {
    counters = new ArrayList<>();
    clicks=0;
  }

  @Override
  public List<CounterData> getStoredCounterList() {
    // Log.e(TAG, "getStoredCounterList()");
    return counters;
  }


  @Override
  public Integer getStoredNumOfClick() {
    // Log.e(TAG, "getStoredNumOfClick()");
    return clicks;
  }

  @Override
  public void onUpdateCounter(CounterData counter) {
    counters.get(counters.indexOf(counter)).value++;
  }

  @Override
  public void onIncrementNumOfClicks() {
    clicks++;
  }

  @Override
  public void onRestartScreen(List<CounterData> counters) {
    // Log.e(TAG, "onRestartScreen()");
    this.counters =counters;
  }

  @Override
  public void onAddCounter(CounterData counter) {
    counters.add(counter);
  }

  @Override
  public void onDataFromNextScreen(Integer clicks) {
    // Log.e(TAG, "onDataFromNextScreen()");
    this.clicks=clicks;
  }

  /*
  @Override
  public void onDataFromNextScreen(CounterData counter) {
    // Log.e(TAG, "onDataFromNextScreen()");
  }
  */
}
