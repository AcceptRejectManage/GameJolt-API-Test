package com.epicness.gamejoltapitest;

import static com.epicness.gamejoltapitest.Constants.CIRCLE_OFFSET;
import static com.epicness.gamejoltapitest.Constants.CIRCLE_RADIUS;
import static com.epicness.gamejoltapitest.Constants.CROSS_OFFSET;
import static com.epicness.gamejoltapitest.Constants.CROSS_SIZE;
import static com.epicness.gamejoltapitest.Constants.GRID_COLS;
import static com.epicness.gamejoltapitest.Constants.GRID_ROWS;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Vector2;
import com.epicness.gamejoltapitest.stuff.Cell;
import com.epicness.gamejoltapitest.stuff.Circle;
import com.epicness.gamejoltapitest.stuff.Cross;
import com.epicness.gamejoltapitest.stuff.Grid;
import com.epicness.gamejoltapitest.stuff.Shape;

public class Utils {

    public static Vector2 getTextSize(BitmapFont font, String text) {
        Vector2 textSize = new Vector2();
        GlyphLayout layout = new GlyphLayout(font, text);
        textSize.x = layout.width;
        textSize.y = layout.height;
        return textSize;
    }

    public static void loadGridData(Grid grid, String gridData) {
        char c;
        Cell cell;
        for (int col = 0; col < GRID_COLS; col++) {
            for (int row = 0; row < GRID_ROWS; row++) {
                c = gridData.charAt(col * GRID_ROWS + row);
                cell = grid.cells[col][row];
                cell.shape = getShapeFromChar(c, cell);
            }
        }
    }

    private static Shape getShapeFromChar(char c, Cell cell) {
        float x = cell.x;
        float y = cell.y;
        if (c == 'X') {
            return new Cross(x + CROSS_OFFSET, y + CROSS_OFFSET, CROSS_SIZE);
        } else if (c == 'O') {
            return new Circle(x + CIRCLE_OFFSET, y + CIRCLE_OFFSET, CIRCLE_RADIUS);
        }
        return null;
    }
}