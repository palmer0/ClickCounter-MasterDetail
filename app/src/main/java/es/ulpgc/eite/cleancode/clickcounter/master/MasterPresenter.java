package es.ulpgc.eite.cleancode.clickcounter.master;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.clickcounter.data.CounterData;
import es.ulpgc.eite.cleancode.clickcounter.app.DetailToMasterState;
import es.ulpgc.eite.cleancode.clickcounter.app.MasterToDetailState;

public class MasterPresenter implements MasterContract.Presenter {

  public static String TAG = MasterPresenter.class.getSimpleName();

  private WeakReference<MasterContract.View> view;
  private MasterState state;
  private MasterContract.Model model;
  private MasterContract.Router router;

  public MasterPresenter(MasterState state) {
    this.state = state;
  }

  @Override
  public void onStart() {
    // Log.e(TAG, "onStart()");

    // initialize the state if is necessary
    if (state == null) {
      state = new MasterState();
    }

  }

  @Override
  public void onRestart() {
    // Log.e(TAG, "onRestart()");

    // update the model if is necessary
    model.onRestartScreen(state.counters, state.clicks);
  }

  @Override
  public void onResume() {
    // Log.e(TAG, "onResume()");

    // use passed state if is necessary
    DetailToMasterState savedState = router.getStateFromNextScreen();
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
  public void onBackPressed() {
    // Log.e(TAG, "onBackPressed()");
  }

  @Override
  public void onPause() {
    // Log.e(TAG, "onPause()");
  }

  @Override
  public void onDestroy() {
    // Log.e(TAG, "onDestroy()");
  }

  @Override
  public void onButtonPressed() {
    // Log.e(TAG, "onButtonPressed()");

    model.onAddCounter(new CounterData());

    onResume();
  }

  @Override
  public void onListPressed(CounterData counter) {
    // Log.e(TAG, "onListPressed()");

    model.onIncrementCounter(counter);
    model.onIncrementNumOfClicks();

    router.passStateToNextScreen(new MasterToDetailState(
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

  @Override
  public void injectRouter(MasterContract.Router router) {
    this.router = router;
  }
}
