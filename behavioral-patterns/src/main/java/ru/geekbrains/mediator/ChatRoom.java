package ru.geekbrains.mediator;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ChatRoom implements ChatRoomMediator{

    private Date date;

    @Override
    public void showMessage(User user, String message) {
        String timeStamp = new SimpleDateFormat("dd.MM.yyyy HH:mm").format(Calendar.getInstance().getTime());
        System.out.printf("%s: %s - %s\n", timeStamp, user.getName(), message);
    }
}
