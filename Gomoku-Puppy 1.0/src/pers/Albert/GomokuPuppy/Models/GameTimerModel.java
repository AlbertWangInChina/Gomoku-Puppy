/*
 * Copyright (c) 2023, Albert·Wang.
 * Open-source, MIT license.
 */

package pers.Albert.GomokuPuppy.Models;

public interface GameTimerModel {
    void start();
    void stop();
    void reStart();
    void setTime(int delay);
    int getTime();
    


}
