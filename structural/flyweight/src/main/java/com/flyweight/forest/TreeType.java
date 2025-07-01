package com.flyweight.forest;

import java.awt.*;

public class TreeType {
    private final String name;
    private final Color color;
    private final String soilType;

    public TreeType(String name, Color color, String soilType) {
        this.name = name;
        this.color = color;
        this.soilType = soilType;
    }

    public void draw(int x, int y) {

        System.out.printf("Drawing %s tree with color %s at (%d, %d), soil: %s%n",
                name, colorToHex(color), x, y, soilType);
    }

    private String colorToHex(Color color) {
        return String.format("#%06X", (color.getRGB() & 0xFFFFFF));
    }
}