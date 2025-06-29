package com.flyweight.forest;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class TreeFactory {
    private static final Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, Color color, String soilType) {

        String key = name + "-" + color.getRGB() + "-" + soilType;
        return treeTypes.computeIfAbsent(key, k -> new TreeType(name, color, soilType));
    }

    public static int getTotalTreeTypes() {
        return treeTypes.size();
    }
}
