package com.teamtyphoon.im;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO:同步
 */
class MsgQueue {

    private static final MsgQueue msgQueue=new MsgQueue();
    private static List<Msg> msgList = new ArrayList<Msg>();

    private MsgQueue() {

    }

    static MsgQueue getMsgQueue() {
        return msgQueue;
    }

    void put(Msg msg) {
        msgList.add(msg);
    }

    Msg take() {
        return msgList.remove(0);
    }

}
