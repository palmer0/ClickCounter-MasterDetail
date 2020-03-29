package es.ulpgc.eite.cleancode.clickcounter.master;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.clickcounter.app.CounterData;

public class MasterModel implements MasterContract.Model {

  public static String TAG = MasterModel.class.getSimpleName();

  private List<CounterData> counters;

  public MasterModel() {
    counters = new ArrayList<>();
  }

  @Override
  public List<CounterData> getStoredDataSource() {
    // Log.e(TAG, "getStoredDataSource()");
    return counters;
  }

  @Override
  public void onRestartScreen(List<CounterData> counters) {
    // Log.e(TAG, "onRestartScreen()");
    this.counters =counters;
  }

  @Override
  public void onAddData(CounterData counter) {
    counters.add(counter);
  }

  @Override
  public void onDataFromNextScreen(CounterData counter) {
    // Log.e(TAG, "onDataFromNextScreen()");
  }

}
