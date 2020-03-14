package io.aaron.benson.on.code.functions;

import io.aaron.benson.on.code.model.Game;
import io.aaron.benson.on.code.model.Move;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestRpsFunction {
  @LocalServerPort private int port;
  private TestRestTemplate restTemplate = new TestRestTemplate();

  @Test
  public void test_given_http_function_returns_game_result() throws Exception {
    Game testGame = new Game("testPlayer", Move.randomMove());
    Assertions.assertThat(
            this.restTemplate.postForObject(
                "http://localhost:" + this.port + "/rpsFunction", testGame, String.class))
        .containsPattern(
            "(It's a draw)|"
                + "(You won, you played (PAPER|ROCK|SCISSORS),"
                + " the computer played (PAPER|ROCK|SCISSORS))|"
                + "(You lost, you played (PAPER|ROCK|SCISSORS), "
                + "the computer played (PAPER|ROCK|SCISSORS))");
  }
}
