/*
 * Copyright (c) 2023, Albert·Wang.
 * Open-source, MIT license.
 */

package pers.Albert.GomokuPuppy.Models;

import java.util.Arrays;

/**
 * class StepList : 用于记录一局游戏的所有步
 * @author Albert
 * @since 1.0
 * @see DefaultBoardModel
 * @see AStep
 */
public class StepList {
    private AStep[] steps;
    private final int DefaultArrayLength = 20;
    private int ArrayLength;
    private int nextStepIndex;

    public StepList(){
        steps = new AStep[DefaultArrayLength];
        nextStepIndex = 0;
        ArrayLength = DefaultArrayLength;
    }

    public void add(AStep aStep){
        steps[nextStepIndex] = aStep;
        nextStepIndex++;
        if(nextStepIndex > (DefaultArrayLength - 1))
            ArrayLength += 10; 
            steps = Arrays.copyOf(steps, ArrayLength);
    }

    public int getArrayLength() {
        return ArrayLength;
    }

    @Override
    public String toString(){
        var strings = new StringBuilder();
        int n = 0;
        for (AStep aStep : steps) {
            n++;
            if(aStep == null)
                break;
            strings.append(aStep.toString() + (n == 5? "\n":""));
            if(n == 5) n = 0;
        }
        return strings.toString();
    }

    public Point[][] toPoints(){
        Point[][] points= new Point[DefaultBoardModel.BoardLength][DefaultBoardModel.BoardLength];
        
        for (int x = 0;x < points.length;x++) {
            for (int y = 0;y < points[x].length;y++) {
                points[x][y] = new Point(x, y,null);
            }
        }
        
        for (AStep aStep : steps) {
            var point = aStep.toPoint();
            int x = point.getX();
            int y = point.getY();
            points[x][y] = point;
        }
        return points;
    }

    /**
     * 测试用,编译时会删除
     */
    public static void main(String[] args) {
        var test = new StepList();
        for(int n = 0;n<30;n++){
            test.add(new AStep(new Point(n, n, null), n));
        }
        System.out.println(test.toString());
    }

}
