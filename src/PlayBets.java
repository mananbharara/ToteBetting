import domain.Bet;
import domain.Dividend;
import domain.Result;
import util.Pair;
import util.Parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PlayBets {
  public static void main(String[] args) throws IOException {
    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    final List<String> allLines = readAllInput(reader);

    Pair<List<Bet>, Result> betsAndResult = Parser.parse(allLines);

    final ToteBetEngine toteBetEngine = new ToteBetEngine();

    final List<Dividend> dividends = toteBetEngine.processDividends(betsAndResult._1(), betsAndResult._2());

    System.out.println(Parser.stringify(dividends));
  }

  private static List<String> readAllInput(BufferedReader reader) throws IOException {
    List<String> lines = new ArrayList<>();

    String line;
    while (!(line = reader.readLine()).trim().equals("")) {
      lines.add(line);
    }

    return lines;
  }
}

