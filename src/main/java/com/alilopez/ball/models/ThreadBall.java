package com.alilopez.ball.models;

import java.util.Observable;

public class ThreadBall extends Observable implements Runnable{
    private int x;
    private int y;
    private boolean status;
    public ThreadBall(){
         x = 100;
         y = 100;
         status = true;
     }

     @Override
    public void run() {
        int incX = 1;
        int incY = 1;
        while (status) {
            try {
                Thread.sleep(100);
                if (x > 585 || x < 15)
                    incX *= -1;
                if (y > 385 || y < 15)
                    incY *= -1;
                x += (incX*10);
                y += (incY*10);
                this.setChanged();
                this.notifyObservers(x + ":" + y);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setStatus(boolean status){
        this.status = status;
    }

}
