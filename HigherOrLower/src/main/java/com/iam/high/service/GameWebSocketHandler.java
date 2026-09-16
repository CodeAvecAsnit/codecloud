package com.iam.high.service;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class GameWebSocketHandler extends TextWebSocketHandler {

    private static final String GAME_KEY = "GAME_SESSION";

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        HighService service = new HighService();
        session.getAttributes().put(GAME_KEY, service);
        session.sendMessage(new TextMessage("Game started! Guess a number (1-100). Tries left: 7"));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        HighService service = (HighService) session.getAttributes().get(GAME_KEY);

        if (service == null) {
            session.sendMessage(new TextMessage("No active game found."));
            return;
        }

        try {
            int guess = Integer.parseInt(message.getPayload().trim());
            Result result = service.guessNum(guess);

            switch (result) {
                case CORRECT -> {
                    session.sendMessage(new TextMessage("Correct! You won!"));
                    session.close(CloseStatus.NORMAL);
                }
                case HIGHER -> session.sendMessage(new TextMessage(
                        "Higher! Tries left: " + service.getRemainingTries()
                ));
                case LOWER -> session.sendMessage(new TextMessage(
                        "Lower! Tries left: " + service.getRemainingTries()
                ));
                case OUT_OF_TRIES -> {
                    session.sendMessage(new TextMessage("Out of tries! Game over."));
                    session.close(CloseStatus.NORMAL);
                }
                case ALREADY_OVER -> session.sendMessage(new TextMessage("Game has already ended."));
            }
        } catch (NumberFormatException e) {
            session.sendMessage(new TextMessage("Invalid input. Please send a valid integer."));
        }
    }
}