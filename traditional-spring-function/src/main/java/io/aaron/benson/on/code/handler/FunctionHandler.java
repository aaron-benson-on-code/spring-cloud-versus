package io.aaron.benson.on.code.handler;

import io.aaron.benson.on.code.model.Game;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class FunctionHandler extends SpringBootRequestHandler<Game, String> {}
