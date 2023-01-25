/*
 * Copyright (c) 2023, Albert·Wang.
 * Open-source, MIT license.
 */

package pers.Albert.GomokuPuppy.Models;

/**
 * class Point :  用于描述棋盘上的一个点,以及这个点上的棋子颜色属性
 * @author Albert
 * @since 1.0
 * @see Color
 * @see DefaultBoardModel
 */
public class Point {
    /**
     * 这个点的x坐标
     */
    private final int x;

    /**
     * 这个点的y坐标
     */
    private final int y;

    /**
     * 这个点的颜色属性
     */
    private Color color;

    /**
     * 将字符串解析为Point[][]
     * @param board 待解析的字符串
     * @return 解析完毕的Point[][]
     */
    public static Point[][] toPoints(String board) {
        var points = new Point[DefaultBoardModel.BoardLength][DefaultBoardModel.BoardLength];
        for (int x = 0;x < points.length;x++) {
            for (int y = 0;y < points[x].length;y++) {
                points[x][y] = new Point(x, y,null);
            }
        }
        
        // TODO
        return points;
    }

    /**
     * 默认构造方法
     */
    public Point(){
        x = 0;
        y = 0;
        setColor(null);
    }

    /**
     * 不完全构造方法,颜色默认为Color.NULL
     * @param x x坐标
     * @param y y坐标
     */
    public Point(int x,int y){
        this.x = x;
        this.y = y;
        this.setColor(null);
    }

    /**
     * 完全构造方法
     * @param x x坐标
     * @param y y坐标
     * @param color 颜色
     */
    public Point(int x,int y,Color color){
        this.x = x;
        this.y = y;
        this.setColor(color);
    }

    /**
     * 获取x
     * @return x坐标
     */
    public int getX(){
        return x;
    }

    /**
     * 获取y
     * @return y坐标
     */
    public int getY(){
        return y;
    }

    /**
     * 获取颜色
     * @return 颜色
     */
    public Color getColor(){
        return color;
    }

    /**
     * 设置颜色
     * @param color 颜色,如果为NULL,颜色设置为Color.NULL
     */
    public void setColor(Color color){
        if (color == null)
            this.color = Color.NULL;
        else
            this.color = color;
    }

    @Override
    public String toString() {
        return  ( x>9? ""+x:"0"+x )
                + ","
                + ( y>9? ""+y:"0"+y )
                + ",0"
                + color.ordinal()
                + ".";
    }

}
