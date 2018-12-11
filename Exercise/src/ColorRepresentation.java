import edu.princeton.cs.algs4.Picture;

import java.awt.Color;
public class ColorRepresentation {
    public static Color coloRepres(int r, int g, int b)
    {
        Color c1 = new Color(r, g, b);
        return c1;

    }

    public static void main(String[] args){
        Picture picture = new Picture(args[0]);

        int r = Integer.parseInt(args[1]);
        int g = Integer.parseInt(args[2]);
        int b = Integer.parseInt(args[3]);



        for(int col = 0; col < picture.width();col++){
            for(int row = 0; row < picture.height(); row++){
                Color color = picture.get(col, row);
                picture.set(col, row, coloRepres(r,g,b));
            }
        picture.show();
        }
    }


}