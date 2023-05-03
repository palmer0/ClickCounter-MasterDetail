package es.ulpgc.eite.cleancode.clickcounter.detail;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.clickcounter.app.AppMediator;
import es.ulpgc.eite.cleancode.clickcounter.app.DetailToMasterState;
import es.ulpgc.eite.cleancode.clickcounter.app.MasterToDetailState;

public class DetailPresenter implements DetailContract.Presenter {

  public static String TAG = "ClickCounter-MasterDetail.DetailPresenter";

  private WeakReference<DetailContract.View> view;
  private DetailState state;
  private DetailContract.Model model;
  //private DetailContract.Router router;
  private AppMediator mediator;

  public DetailPresenter(AppMediator mediator) {
    this.mediator = mediator;
    
  }

//  public DetailPresenter(DetailState state) {
//    this.state = state;
//  }

  @Override
  public void onStart() {
    Log.e(TAG, "onStart()");

    // initialize the state 
    state = new DetailState();

    // use passed state if is necessary
    MasterToDetailState savedState = getStateFromPreviousScreen();
    //MasterToDetailState savedState = router.getStateFromPreviousScreen();
    if (savedState != null) {

      // update the model if is necessary
      model.onDataFromPreviousScreen(savedState.counter, savedState.clicks);
    }
  }

  @Override
  public void onRestart() {
    Log.e(TAG, "onRestart()");

    // get back the state 
    state = mediator.getDetailState();
    
    // update the model if is necessary
    model.onRestartScreen(state.counter, state.clicks);
  }

  @Override
  public void onResume() {
    Log.e(TAG, "onResume()");

    // call the model and update the state
    state.counter = model.getStoredCounter();
    state.clicks = model.getStoredNumOfClick();

    // update the view
    view.get().onDataUpdated(state);

  }

  @Override
  public void onBackPressed() {
    Log.e(TAG, "onBackPressed()");

    passStateToPreviousScreen(new DetailToMasterState(
        model.getStoredCounter(), model.getStoredNumOfClick()
    ));

//    router.passStateToPreviousScreen(new DetailToMasterState(
//        model.getStoredCounter(), model.getStoredNumOfClick()
//    ));
  }

  @Override
  public void onPause() {
    Log.e(TAG, "onPause()");

    mediator.setDetailState(state);
  }

  @Override
  public void onDestroy() {
    Log.e(TAG, "onDestroy()");
  }

  private void passStateToPreviousScreen(DetailToMasterState state) {
    mediator.setDetailPreviousScreenState(state);
  }

  private MasterToDetailState getStateFromPreviousScreen() {
    return mediator.getDetailPreviousScreenState();
  }

  @Override
  public void onButtonPressed() {
    Log.e(TAG, "onButtonPressed()");

    model.onIncrementCounter();
    model.onIncrementNumOfClicks();

    onResume();
  }

  @Override
  public void injectView(WeakReference<DetailContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(DetailContract.Model model) {
    this.model = model;
  }

//  @Override
//  public void injectRouter(DetailContract.Router router) {
//    this.router = router;
//  }
}
