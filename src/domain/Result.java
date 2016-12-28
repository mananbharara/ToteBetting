package domain;

public class Result {
  private final Integer first;
  private final Integer second;
  private final Integer third;

  public Result(Integer first, Integer second, Integer third) {
    this.first = first;
    this.second = second;
    this.third = third;
  }

  public Integer getFirst() {
    return first;
  }
}
