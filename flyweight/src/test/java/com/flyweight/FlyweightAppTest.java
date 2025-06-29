package com.flyweight;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.flyweight.forest.Tree;
import com.flyweight.forest.TreeType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.flyweight.forest.TreeFactory;

class FlyweightAppTest {


    @BeforeEach
    void clearCache() throws Exception {
        TreeFactory.reset();
    }


    @Test
    void testFlyweightReuse() {
        TreeType pine1 = TreeFactory.getTreeType("Pine", Color.GREEN, "sandy");
        TreeType pine2 = TreeFactory.getTreeType("Pine", Color.GREEN, "sandy");

        assertSame(pine1, pine2, "TreeFactory should return same instance for identical parameters");
    }
    @Test
    void testDifferentTypesAreDifferentInstances() {
        TreeType pine = TreeFactory.getTreeType("Pine", Color.GREEN, "sandy");
        TreeType oak = TreeFactory.getTreeType("Oak", Color.GREEN, "sandy");
        TreeType birch = TreeFactory.getTreeType("Birch", Color.WHITE, "clay");

        assertNotSame(pine, oak);
        assertNotSame(pine, birch);
        assertNotSame(oak, birch);
    }

    @Test
    void testTotalTreeTypesCount() {
        assertEquals(0, TreeFactory.getTotalTreeTypes());

        TreeFactory.getTreeType("Pine", Color.GREEN, "sandy");
        assertEquals(1, TreeFactory.getTotalTreeTypes());

        TreeFactory.getTreeType("Oak", Color.GREEN, "sandy");
        TreeFactory.getTreeType("Birch", Color.WHITE, "clay");
        assertEquals(3, TreeFactory.getTotalTreeTypes());


        TreeFactory.getTreeType("Pine", Color.GREEN, "sandy");
        assertEquals(3, TreeFactory.getTotalTreeTypes());
    }


}