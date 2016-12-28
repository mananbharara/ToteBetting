package util;

public class Pair<K, V> {
  private K _1;
  private V _2;

  private Pair(K _1, V _2) {
    this._1 = _1;
    this._2 = _2;
  }

  public static <V1, V2> Pair<V1, V2> of(V1 _1, V2 _2) {
    return new Pair<>(_1, _2);
  }

  public K _1() {
    return _1;
  }

  public V _2() {
    return _2;
  }
}
