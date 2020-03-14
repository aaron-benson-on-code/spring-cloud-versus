package io.aaron.benson.on.code.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameResult {
  private Move userMove;
  private Move cpuMove;
  private Result finalResult;
}
