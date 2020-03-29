package es.ulpgc.eite.cleancode.clickcounter.detail;

import es.ulpgc.eite.cleancode.clickcounter.app.CounterData;

public class DetailModel implements DetailContract.Model {

  public static String TAG = DetailModel.class.getSimpleName();

  private CounterData counter;

  @Override
  public CounterData getStoredData() {
    // Log.e(TAG, "getStoredData()");
    return counter;
  }

  @Override
  public void onRestartScreen(CounterData counter) {
    // Log.e(TAG, "onRestartScreen()");
    this.counter =counter;
  }

  @Override
  public void onDataFromPreviousScreen(CounterData counter) {
    // Log.e(TAG, "onDataFromPreviousScreen()");
    this.counter =counter;
  }
}
