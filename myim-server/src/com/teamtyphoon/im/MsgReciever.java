package com.teamtyphoon.im;

public class MsgReciever extends Thread{
    private boolean isStopped=false;
    public void run() {
        while (!isStopped) {
            Msg msg=new Msg(); //TODO:complete
            save(msg);
            MsgQueue.getMsgQueue().put(msg);
        }
    }

    private void save(Msg msg) {
        //TODO:save msg
    }

    void stopRunning() {
        isStopped=true;
    }
}
