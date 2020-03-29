package es.ulpgc.eite.cleancode.clickcounter.detail;

import es.ulpgc.eite.cleancode.clickcounter.app.CounterData;

public class DetailModel implements DetailContract.Model {

  public static String TAG = DetailModel.class.getSimpleName();

  private CounterData data;


  @Override
  public CounterData getStoredData() {
    // Log.e(TAG, "getStoredDataSource()");
    return data;
  }

  @Override
  public void onRestartScreen(CounterData data) {
    // Log.e(TAG, "onRestartScreen()");
  }

  @Override
  public void onDataFromPreviousScreen(CounterData data) {
    // Log.e(TAG, "onDataFromPreviousScreen()");
  }
}
