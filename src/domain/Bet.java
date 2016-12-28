package domain;

public class Bet {
  private String product;
  private Integer selection;
  private Double stake;

  public Bet(String product, Integer selection, Double stake) {
    this.product = product;
    this.selection = selection;
    this.stake = stake;
  }

  public Double getStake() {
    return stake;
  }

  public String getProduct() {
    return product;
  }

  public Integer getSelection() {
    return selection;
  }
}
