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
  private AppMediator mediator;

  public DetailPresenter(AppMediator mediator) {
    this.mediator = mediator;
    
  }

  @Override
  public void onCreateCalled() {
    Log.e(TAG, "onCreateCalled()");

    // initialize the state 
    state = new DetailState();

    // use passed state if is necessary
    MasterToDetailState savedState = getStateFromPreviousScreen();
    if (savedState != null) {

      // update the model if is necessary
      model.onDataFromPreviousScreen(savedState.counter, savedState.clicks);
    }
  }

  @Override
  public void onRecreateCalled() {
    Log.e(TAG, "onRecreateCalled()");

    // get back the state 
    state = mediator.getDetailState();
    
    // update the model if is necessary
    model.onRestartScreen(state.counter, state.clicks);
  }

  @Override
  public void onResumeCalled() {
    Log.e(TAG, "onResumeCalled()");

    // call the model and update the state
    state.counter = model.getStoredCounter();
    state.clicks = model.getStoredNumOfClick();

    // update the view
    view.get().onDataUpdated(state);

  }

  @Override
  public void onBackPressedCalled() {
    Log.e(TAG, "onBackPressedCalled()");

    passStateToPreviousScreen(new DetailToMasterState(
        model.getStoredCounter(), model.getStoredNumOfClick()
    ));

  }

  @Override
  public void onPauseCalled() {
    Log.e(TAG, "onPauseCalled()");

    mediator.setDetailState(state);
  }

  @Override
  public void onDestroyCalled() {
    Log.e(TAG, "onDestroyCalled()");
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

    onResumeCalled();
  }

  @Override
  public void injectView(WeakReference<DetailContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(DetailContract.Model model) {
    this.model = model;
  }

}
