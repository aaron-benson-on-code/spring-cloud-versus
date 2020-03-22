package io.aaron.benson.on.code.functions;

import io.aaron.benson.on.code.model.Game;
import io.aaron.benson.on.code.model.GameResult;
import io.aaron.benson.on.code.model.Move;
import io.aaron.benson.on.code.model.Result;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component(value = "rpsFunction")
public class RockPaperScissors implements Function<Game, String> {

  @Override
  public String apply(Game game) {
    GameResult result = new GameResult();
    Move cpuMove = getCpuMove();
    result.setUserMove(game.getMove());
    result.setCpuMove(cpuMove);
    result.setFinalResult(calculateWinner(game.getMove(), cpuMove));
    return this.buildGameResponse(result);
  }

  private Result calculateWinner(Move userMove, Move cpuMove) {
    if (userMove.equals(Move.ROCK) && cpuMove.equals(Move.PAPER)) {
      return Result.LOSE;
    } else if (userMove.equals(Move.PAPER) && cpuMove.equals(Move.SCISSORS)) {
      return Result.LOSE;
    } else if (userMove.equals(Move.SCISSORS) && cpuMove.equals(Move.ROCK)) {
      return Result.LOSE;
    } else if (userMove.equals(Move.ROCK) && cpuMove.equals(Move.SCISSORS)) {
      return Result.WIN;
    } else if (userMove.equals(Move.PAPER) && cpuMove.equals(Move.ROCK)) {
      return Result.WIN;
    } else if (userMove.equals(Move.SCISSORS) && cpuMove.equals(Move.PAPER)) {
      return Result.WIN;
    } else {
      return Result.DRAW;
    }
  }

  private Move getCpuMove() {
    return Move.randomMove();
  }

  private String buildGameResponse(GameResult result) {
    if (result.getFinalResult().equals(Result.WIN)) {
      return String.format(
          "You won, you played %s, the computer played %s",
          result.getUserMove(), result.getCpuMove());
    } else if (result.getFinalResult().equals(Result.LOSE)) {
      return String.format(
          "You lost, you played %s, the computer played %s",
          result.getUserMove(), result.getCpuMove());
    } else {
      return "It's a draw";
    }
  }
}
