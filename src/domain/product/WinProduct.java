package domain.product;

import domain.Bet;
import domain.Dividend;
import domain.Result;

import java.util.List;

import static java.util.Collections.singletonList;

public class WinProduct implements Product {
  public static final double WIN_BOOKIE_CUT = .15;
  public static final String PRODUCT_INITIAL = "W";

  private List<Bet> bets;

  public WinProduct(List<Bet> bets) {
    this.bets = bets;
  }

  @Override
  public List<Dividend> processDividends(Result result) {
    final double winningBetMoney = bets
      .stream()
      .filter(b -> b.getSelection().equals(result.getFirst()))
      .mapToDouble(Bet::getStake)
      .sum();

    final Double poolMoney = moneyInThePool(bets);

    return singletonList(new Dividend(PRODUCT_INITIAL, result.getFirst(), poolMoney / winningBetMoney));
  }

  private Double moneyInThePool(List<Bet> bet) {
    final double totalInThePool = bet
      .stream()
      .mapToDouble(Bet::getStake)
      .sum();

    return totalInThePool - WIN_BOOKIE_CUT * (totalInThePool);
  }
}
