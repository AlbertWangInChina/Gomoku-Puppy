/*
 * Copyright (c) 2023, Albert·Wang.
 * Open-source, MIT license.
 */

package pers.Albert.GomokuPuppy.Models;

/**
 * interface BoardModel : 用于描述棋盘应有的能力
 * @author Albert
 * @since 1.0
 * @see Point
 * @see DefaultBoardModel
 */
public interface BoardModel {
    void setAllPoints(Point[][] points);
    Point[][] getAllPoints();
    void setPointColor(int x,int y,Color color);
    Color getPointColor(int x,int y);
    Point getPoint(int x,int y);
    void cleanAll();
    void addAStep(AStep aStep);
    StepList getStepList();
}
