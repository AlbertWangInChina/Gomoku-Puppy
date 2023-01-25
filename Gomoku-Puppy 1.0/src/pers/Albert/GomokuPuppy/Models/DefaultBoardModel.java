/*
 * Copyright (c) 2023, Albert·Wang.
 * Open-source, MIT license.
 */

package pers.Albert.GomokuPuppy.Models;

/**
 * class DefaultBoardModel : 用于实现BoardModel接口,并作为Board类的模型,
 * 包括了一个棋盘及上面的所有棋子和一个棋步列表
 * @author Albert
 * @since 1.0
 * @see BoardModel
 * @see pers.Albert.GomokuPuppy.View.Board
 * @see Point
 */
public class DefaultBoardModel implements BoardModel{
    private Point[][] points;
    private StepList steps;
    public static int BoardLength = 15;

    public DefaultBoardModel(){
        points = new Point[BoardLength][BoardLength];

        for (int x = 0;x < points.length;x++) {
            for (int y = 0;y < points[x].length;y++) {
                points[x][y] = new Point(x, y,null);
            }
        }
        steps = new StepList();
    }

        public DefaultBoardModel(Point[][] points){
        setAllPoints(points);
        setBoardLength(points.length);
        steps = new StepList();
    }

    public static void setBoardLength(int length){
        BoardLength = length;
    }

    public static int getBoardLength(){
        return BoardLength;
    }


    public void setAllPoints(Point[][] points){
        setBoardLength(points.length);
        this.points = points;
    }

    public Point[][] getAllPoints(){
        return points;
    }

    public void setPointColor(int x,int y,Color color){
        points[x][y].setColor(color);
    }

    public Color getPointColor(int x,int y){
        return points[x][y].getColor();
    }

    public Point getPoint(int x,int y){
        return points[x][y];
    }

    public void cleanAll(){
        for(int x = 0;x<points.length;x++){
            for(int y = 0;y<points[y].length;y++){
                points[x][y].setColor(null);
            }
        }
    }
    
    public void addAStep(AStep aStep){
        steps.add(aStep);
    }

    public StepList getStepList(){
        return steps;
    }

    @Override
    public String toString(){
        var strings = new StringBuilder();
        for (Point[] apoints : points) {
            for (Point point : apoints) {
                strings.append(point.toString()+"\n");
            }
        }
        strings.append("\n");
        strings.append(steps.toString());
        return strings.toString();
    }

    /**
     * 测试用,编译时会删除
     */
    public static void main(String[] args) {
        var test = new DefaultBoardModel();
        for(int n = 0;n<30;n++){
            test.addAStep(new AStep(new Point(n, n, null), n));
        }
        System.out.println(test.toString());
        System.out.println(test.getPoint(10, 9));
        test.cleanAll();
    }
}
