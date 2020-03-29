package es.ulpgc.eite.cleancode.clickcounter.master;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.clickcounter.detail.DetailViewModel;

public class MasterModel implements MasterContract.Model {

  public static String TAG = MasterModel.class.getSimpleName();

  private List<DetailViewModel> datasource;

  public MasterModel() {
    datasource = new ArrayList<>();
  }

  @Override
  public List<DetailViewModel> getStoredData() {
    // Log.e(TAG, "getStoredData()");
    return datasource;
  }

  @Override
  public void onRestartScreen(List<DetailViewModel> datasource) {
    // Log.e(TAG, "onRestartScreen()");
  }

  @Override
  public void onAddData(DetailViewModel data) {
    datasource.add(data);
  }

  @Override
  public void onDataFromNextScreen(DetailViewModel data) {
    // Log.e(TAG, "onDataFromNextScreen()");
  }

  /*
  @Override
  public void onDataFromPreviousScreen(String datasource) {
    // Log.e(TAG, "onDataFromPreviousScreen()");
  }
  */
}
