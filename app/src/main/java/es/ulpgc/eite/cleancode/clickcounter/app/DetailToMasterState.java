package es.ulpgc.eite.cleancode.clickcounter.app;

public class DetailToMasterState {

  public CounterData counter;
  public Integer clicks;

  public DetailToMasterState(CounterData counter, Integer clicks) {
    this.clicks=clicks;
    this.counter=counter;
  }
}
