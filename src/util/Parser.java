package util;

import domain.Bet;
import domain.Dividend;
import domain.Result;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static util.Pair.of;

public class Parser {

  public static final String BET = "Bet";
  public static final String RESULT = "Result";

  public static Pair<List<Bet>, Result> parse(List<String> allLines) {
    final List<Pair<String, String[]>> linesByType = allLines
      .stream()
      .map(line -> {
        final String[] splitLine = line.split(":");
        return of(splitLine[0], splitLine);
      })
      .collect(Collectors.toList());

    final List<Bet> bets = linesByType
      .stream()
      .filter(line -> BET.equals(line._1()))
      .map(Pair::_2)
      .map(line -> new Bet(line[1], Integer.valueOf(line[2]), Double.valueOf(line[3])))
      .collect(Collectors.toList());

    final Result result = linesByType
      .stream()
      .filter(line -> RESULT.equals(line._1()))
      .map(Pair::_2)
      .map(line -> new Result(Integer.valueOf(line[1]), Integer.valueOf(line[2]), Integer.valueOf(line[3])))
      .findFirst()
      .orElseThrow(RuntimeException::new);

    return of(bets, result);
  }

  public static String stringify(List<Dividend> dividends) {
    return dividends
      .stream()
      .map(d -> String.join(":", asList(d.getProduct(), d.getSelection().toString(), d.getValue().toString())))
      .collect(Collectors.joining("\n"));
  }
}
