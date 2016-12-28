package domain;

public class Dividend {

  private String product;
  private Integer selection;
  private Double value;

  public Dividend(String product, Integer selection, Double value) {
    this.product = product;
    this.selection = selection;
    this.value = value;
  }

  public String getProduct() {
    return product;
  }

  public Integer getSelection() {
    return selection;
  }

  public Double getValue() {
    return value;
  }
}
