package dossoccer.gameengine.state;

import dossoccer.gameengine.gameactor.player.Player;

/**
 * Created by rafael on 13/04/17.
 */
public class Square {

    private FieldSquare fieldSquare;

    private Player dominator;

    public Square(FieldSquare fieldSquare){
        this.fieldSquare = fieldSquare;
    }


    public FieldSquare getFieldSquare() {
        return fieldSquare;
    }


    public Player getDominator() {
        return dominator;
    }




    public int calculateDistance(FieldSquare fieldSquare){
        int c1 = getX(fieldSquare) - getX(this.fieldSquare);
        int c2 = getY(fieldSquare) - getY(this.fieldSquare);

        Double h =  Math.sqrt(Math.pow(Math.abs(c1),2)) + Math.sqrt(Math.pow(Math.abs(c2),2));

        return Math.round(h.floatValue());

    }

    private int getX(FieldSquare fieldSquare){
        try {
            String name = fieldSquare.toString();
            String x = name.substring(name.lastIndexOf("_"));
            return  Integer.parseInt(x);
        } catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    private int getY(FieldSquare fieldSquare){
        try {
            String name = fieldSquare.toString();
            String y = name.substring(name.indexOf("SQUARE_"), 1);
            return  Integer.parseInt(y);
        } catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }



    public void setDominator(Player dominator) {
        this.dominator = dominator;
    }

    public int calculateXDistance(FieldSquare target) {
        return Math.abs(getX(target) - getX(this.fieldSquare));
    }
    public int calculateYDistance(FieldSquare target) {
        return Math.abs(getY(target) - getY(this.fieldSquare));
    }

    public FieldSquare getRelativeSquare(int xDistance, int yDistance) {
        int x = getX(this.fieldSquare);
        int y = getY(this.fieldSquare);

        int newx = xDistance + x;
        int newy = yDistance + y;

        String name = "SQUARE_" + newy + "_" + newx;

        return FieldSquare.valueOf(name);
    }
}
