package com.teamtyphoon.im;

class MsgSender extends Thread{

    private boolean isStopped=false;
    MsgSender() {

    }
    @Override
    public void run() {
        while(!isStopped) {
           Msg msg = MsgQueue.getMsgQueue().take();
           send(msg);
        }
    }

    void stopRunning() {
        isStopped=true;
    }

    private void send(Msg msg) {
    }
}
