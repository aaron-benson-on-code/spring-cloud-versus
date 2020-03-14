package io.aaron.benson.on.code;

import io.aaron.benson.on.code.functions.RockPaperScissors;
import io.aaron.benson.on.code.model.Game;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionRegistration;
import org.springframework.cloud.function.context.FunctionType;
import org.springframework.cloud.function.context.FunctionalSpringApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootApplication
public class FunctionalApplication
    implements ApplicationContextInitializer<GenericApplicationContext> {

  public static void main(String[] args) {
    FunctionalSpringApplication.run(FunctionalApplication.class, args);
  }

  @Override
  public void initialize(GenericApplicationContext context) {
    context.registerBean(
        "rpsFunction",
        FunctionRegistration.class,
        () ->
            new FunctionRegistration<>(new RockPaperScissors())
                .type(FunctionType.from(Game.class).to(String.class)));
  }
}
