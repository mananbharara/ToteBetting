package domain.product;

import domain.Bet;
import domain.Dividend;
import domain.Result;

import java.util.List;

public class PlaceProduct implements Product {
  private List<Bet> bets;

  public PlaceProduct(List<Bet> bets) {
    this.bets = bets;
  }

  @Override
  public List<Dividend> processDividends(Result result) {
    return null;
  }
}
