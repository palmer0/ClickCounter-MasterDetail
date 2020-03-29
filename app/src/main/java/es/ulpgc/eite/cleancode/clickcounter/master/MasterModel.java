package es.ulpgc.eite.cleancode.clickcounter.master;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.clickcounter.app.CounterData;

public class MasterModel implements MasterContract.Model {

  public static String TAG = MasterModel.class.getSimpleName();

  private List<CounterData> dataSource;
  //private List<Integer> dataSource;

  public MasterModel() {
    dataSource = new ArrayList<>();
    //dataSource = new ArrayList<>();
  }

//  @Override
//  public List<Integer> getStoredDataSource() {
//    return dataSource;
//  }
//
//  @Override
//  public void onDataFromNextScreen(Integer counter) {
//
//  }
//
//  @Override
//  public void onRestartScreen(List<Integer> dataSource) {
//
//  }
//
//  @Override
//  public void onAddCounter(Integer counter) {
//    dataSource.add(counter);
//  }

  @Override
  public List<CounterData> getStoredDataSource() {
    // Log.e(TAG, "getStoredDataSource()");
    return dataSource;
  }

  @Override
  public void onRestartScreen(List<CounterData> dataSource) {
    // Log.e(TAG, "onRestartScreen()");
  }

  @Override
  public void onAddData(CounterData data) {
    dataSource.add(data);
  }

  @Override
  public void onDataFromNextScreen(CounterData data) {
    // Log.e(TAG, "onDataFromNextScreen()");
  }

  /*
  @Override
  public void onDataFromPreviousScreen(String dataSource) {
    // Log.e(TAG, "onDataFromPreviousScreen()");
  }
  */
}
