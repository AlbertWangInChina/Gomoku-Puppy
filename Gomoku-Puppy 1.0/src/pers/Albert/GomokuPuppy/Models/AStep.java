/*
 * Copyright (c) 2023, Albert·Wang.
 * Open-source, MIT license.
 */

package pers.Albert.GomokuPuppy.Models;

/**
 * record AStep : 用于记录玩家或Puppy下的一步棋
 * @author Albert
 * @since 1.0
 * @see StepList
 */
public record AStep(Point point,int round) {

    public Point point(){
        return point;
    }

    public int round(){
        return round;
    }

    @Override
    public String toString(){
        return  point.toString()
                +(round()>9? round():"0"+round())
                + ";";
    }

    public Point toPoint(){
        return point();
    }
}
