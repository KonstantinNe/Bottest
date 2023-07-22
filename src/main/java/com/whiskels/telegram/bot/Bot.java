package com.whiskels.telegram.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

    // ��������� @Component ����������, ����� ��� ����� ������������� Spring, ��� ������������ Bean
    @Component
// ����������� �� TelegramLongPollingBot - ������������ ������ Telegram API
    public class Bot extends TelegramLongPollingBot {
        // ��������� @Value ��������� �������� �������� ���� ����� ���������� �� application.yaml
        @Value("${bot.name}")
        private String botUsername;

        @Value("${bot.token}")
        private String botToken;

        /* ����������� ����� ���������� LongPollingBot
        ������ ��� ��������� ��������� ��� ��� ����� �������� ���������� Hi!
         */
        @Override
        public void onUpdateReceived(Update update) {
            try {
                execute(new SendMessage().setChatId(update.getMessage().getChatId())
                        .setText("Hi!"));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

        // �������, ������� ���������� ��� ������������ �� TelegramLongPollingBot
        public String getBotUsername() {
            return botUsername;
        }

        public String getBotToken() {
            return botToken;
        }
    }
}
