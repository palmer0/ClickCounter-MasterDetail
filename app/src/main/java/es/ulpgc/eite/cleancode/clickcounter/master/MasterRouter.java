package es.ulpgc.eite.cleancode.clickcounter.master;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.eite.cleancode.clickcounter.app.AppMediator;
import es.ulpgc.eite.cleancode.clickcounter.app.DetailToMasterState;
import es.ulpgc.eite.cleancode.clickcounter.app.MasterToDetailState;

public class MasterRouter implements MasterContract.Router {

  public static String TAG = MasterRouter.class.getSimpleName();

  private AppMediator mediator;

  public MasterRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, MasterActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  public void passStateToNextScreen(MasterToDetailState state) {
    mediator.setMasterNextScreenState(state);
  }

//  @Override
//  public void passStateToPreviousScreen(MasterState state) {
//    mediator.setMasterPreviousScreenState(state);
//  }

//  @Override
//  public MasterState getStateFromPreviousScreen() {
//    return mediator.getMasterPreviousScreenState();
//  }

  @Override
  public DetailToMasterState getStateFromNextScreen() {
    return mediator.getMasterNextScreenState();
  }
}