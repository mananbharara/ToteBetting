import domain.Bet;
import domain.Dividend;
import domain.Result;
import domain.product.PlaceProduct;
import domain.product.Product;
import domain.product.WinProduct;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ToteBetEngine {

  public List<Dividend> processDividends(List<Bet> bets, Result result) {
    final Map<String, List<Bet>> betsPerProduct = bets
      .stream()
      .collect(Collectors.groupingBy(Bet::getProduct));

    return betsPerProduct
      .entrySet()
      .stream()
      .map(productProcessor())
      .flatMap(product -> product.processDividends(result).stream())
      .collect(Collectors.toList());
  }

  private Function<Map.Entry<String, List<Bet>>, Product> productProcessor() {
    return e -> {
      final List<Bet> bets = e.getValue();
      if (WinProduct.PRODUCT_INITIAL.equals(e.getKey())) {
        return new WinProduct(bets);
      }
      return new PlaceProduct(bets);
    };
  }
}

//Bet:W:1:3
//Bet:W:2:4
//Bet:W:3:5
//Bet:W:4:5
//Bet:W:1:16
//Bet:W:2:8
//Bet:W:3:22
//Bet:W:4:57
//Bet:W:1:42
//Bet:W:2:98
//Bet:W:3:63
//Bet:W:4:15
//Result:2:3:1