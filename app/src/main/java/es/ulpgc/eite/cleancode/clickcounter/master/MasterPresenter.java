package es.ulpgc.eite.cleancode.clickcounter.master;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.clickcounter.app.AppMediator;
import es.ulpgc.eite.cleancode.clickcounter.data.CounterData;
import es.ulpgc.eite.cleancode.clickcounter.app.DetailToMasterState;
import es.ulpgc.eite.cleancode.clickcounter.app.MasterToDetailState;

public class MasterPresenter implements MasterContract.Presenter {

  public static String TAG = "ClickCounter-MasterDetail.MasterPresenter";

  private WeakReference<MasterContract.View> view;
  private MasterState state;
  private MasterContract.Model model;
  private AppMediator mediator;

  public MasterPresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getMasterState();
  }

  @Override
  public void onCreateCalled() {
    Log.e(TAG, "onCreateCalled()");

    // initialize the state 
    state = new MasterState();

  }

  @Override
  public void onRecreateCalled() {
    Log.e(TAG, "onRecreateCalled()");

    // get back the state 
    state = mediator.getMasterState();
    
    // update the model if is necessary
    model.onRestartScreen(state.counters, state.clicks);
  }

  @Override
  public void onResumeCalled() {
    Log.e(TAG, "onResumeCalled()");

    // use passed state if is necessary
    DetailToMasterState savedState = getStateFromNextScreen();
    //DetailToMasterState savedState = router.getStateFromNextScreen();
    if (savedState != null) {

      // update the model if is necessary
      model.onDataFromNextScreen(savedState.counter, savedState.clicks);
    }


    // call the model and update the state
    state.counters = model.getStoredCounterList();
    state.clicks = model.getStoredNumOfClick();

    // update the view
    view.get().onDataUpdated(state);

  }

  @Override
  public void onBackPressedCalled() {
    Log.e(TAG, "onBackPressedCalled()");
  }

  @Override
  public void onPauseCalled() {
    Log.e(TAG, "onPauseCalled()");

    mediator.setMasterState(state);
  }

  @Override
  public void onDestroyCalled() {
    Log.e(TAG, "onDestroyCalled()");
  }

  private void passStateToNextScreen(MasterToDetailState state) {
    Log.e(TAG, "counter: " + state.counter);
    Log.e(TAG, "clicks: " + state.clicks);

    mediator.setMasterNextScreenState(state);
  }


  private DetailToMasterState getStateFromNextScreen() {
    return mediator.getMasterNextScreenState();
  }

  @Override
  public void onButtonPressed() {
    Log.e(TAG, "onButtonPressed()");

    model.onAddCounter(new CounterData());

    onResumeCalled();
  }

  @Override
  public void onListPressed(CounterData counter) {
    Log.e(TAG, "onListPressed()");

    model.onIncrementCounter(counter);
    model.onIncrementNumOfClicks();

    passStateToNextScreen(new MasterToDetailState(
        model.getStoredCounter(counter.id), model.getStoredNumOfClick()
    ));

    view.get().navigateToNextScreen();
  }

  @Override
  public void injectView(WeakReference<MasterContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(MasterContract.Model model) {
    this.model = model;
  }

}
