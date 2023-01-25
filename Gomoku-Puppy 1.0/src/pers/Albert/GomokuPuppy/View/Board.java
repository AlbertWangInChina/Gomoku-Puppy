package pers.Albert.GomokuPuppy.View;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

import pers.Albert.GomokuPuppy.Models.DefaultBoardModel;

public class Board extends JComponent{
    private DefaultBoardModel model;

    public Board(){
        model = new DefaultBoardModel();
        ui = new BoardUI();
    }

    public void setModel(DefaultBoardModel model){
        this.model = model;
    }

    public DefaultBoardModel getModel(){
        return model;
    }

    @Override
    protected void paintComponent(Graphics g) {
        ui.paint(g, this);
    }

    @Override
    public Dimension getPreferredSize() {
        return ui.getPreferredSize(this);
    }
}
