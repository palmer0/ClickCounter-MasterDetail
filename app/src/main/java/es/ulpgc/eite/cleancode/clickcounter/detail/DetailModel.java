package es.ulpgc.eite.cleancode.clickcounter.detail;

public class DetailModel implements DetailContract.Model {

  public static String TAG = DetailModel.class.getSimpleName();

  private DetailViewModel data;


  @Override
  public DetailViewModel getStoredData() {
    // Log.e(TAG, "getStoredData()");
    return data;
  }

  @Override
  public void onRestartScreen(DetailViewModel data) {
    // Log.e(TAG, "onRestartScreen()");
  }

//  @Override
//  public void onDataFromNextScreen(String datasource) {
//    // Log.e(TAG, "onDataFromNextScreen()");
//  }

  @Override
  public void onDataFromPreviousScreen(DetailViewModel data) {
    // Log.e(TAG, "onDataFromPreviousScreen()");
  }
}
