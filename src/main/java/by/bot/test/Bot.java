package by.bot.test;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Bot extends TelegramLongPollingBot {

    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();



    //бот получает соощения выполн. ф-ия
    @Override
    public void onUpdateReceived(Update update) {
        update.getUpdateId();   //обновл. инф. о юзере

        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());

//        if(update.getMessage().getText().equals("Москва")){
//            sendMessage.setText("Не забудьте посетить Красную Площадь. Ну а в ЦУМ можно и не заходить)))");
//           }

        Map<String, SendMessage> map = new HashMap<>(20);

        switch (update.getMessage().getText()){
            case "Питер" :
                sendMessage.setText("Посетите Петергоф");
                map.put(update.getMessage().getText(), sendMessage.setText("Посетите Петергоф"));
                break;

            case "Москва" :
                sendMessage.setText("Не забудьте посетить Красную Площадь");
                map.put(update.getMessage().getText(), sendMessage.setText("Не забудьте посетить Красную Площадь"));

                break;

            case "Минск" :
                sendMessage.setText("Сгоняй в национальную библиотеку");
                break;


            case "Инфо" :
                sendMessage.setText("Ваша информация: ");
                map.put(update.getMessage().getText(), sendMessage.setText("Получение инфы"));
//                for(Map.Entry<String,SendMessage> entry: map.entrySet())
//                    sendMessage.setText(entry.getKey() + " " + entry.getValue());

                break;

            default:
                sendMessage.setText("Некорректный ввод!");
                break;
        }


//        public static void String Info(){
//            for(Map.Entry<String,SendMessage> entry: map.entrySet())
//                sendMessage.setText(entry.getKey() + " " + entry.getValue());
//        }

//        for(Map.Entry<String,SendMessage> entry: map.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }


            try {
                execute(sendMessage);
            }catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    @Override
    public String toString() {
        return "Bot{" +
                "replyKeyboardMarkup=" + replyKeyboardMarkup +
                ", exe=" + exe +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bot bot = (Bot) o;
        return Objects.equals(replyKeyboardMarkup, bot.replyKeyboardMarkup);
    }


    @Override
    public int hashCode() {
        return Objects.hash(replyKeyboardMarkup);
    }

    //получение имени бота
    @Override
    public String getBotUsername() {
        return "@BestTouristBot";
    }

 //получение токена бота
    @Override
    public String getBotToken() {
        return "1529852801:AAELj5FDxkz65oHZ4c8OcvY72G5COJ5uohc";
    }
}
