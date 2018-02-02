package com.teamtyphoon.im;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        MsgReciever msgReciever = new MsgReciever();
        msgReciever.start();
        MsgSender msgSender = new MsgSender();
        msgSender.start();
    }
}
