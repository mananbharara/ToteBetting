package domain.product;

import domain.Dividend;
import domain.Result;

import java.util.List;

public interface Product {
  List<Dividend> processDividends(Result result);
}
