package edu.neu.csye7374;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum BikeCategory {
    RoadBikes,
    MountainBikes,
    HybridBikes,
    TouringBikes,
    CrossBikes;

    public static List<String> getBikeCategoryList() {

        return Stream.of(BikeCategory.values()).map(BikeCategory::name).collect(Collectors.toList());
    }

    public static String[] getBikeCategoryArray() {

        return Arrays.stream(BikeCategory.values()).map(BikeCategory::name).toArray(String[]::new);
    }

    public static BikeCategory getBikeCategory(String s) {
        BikeCategory result = null;
        switch (s.toLowerCase()) {
            case "mountain":
                result = BikeCategory.MountainBikes;
                break;
            case "hybrid":
                result = BikeCategory.HybridBikes;
                break;
            case "touring":
                result = BikeCategory.TouringBikes;
                break;
            case "cross":
                result = BikeCategory.CrossBikes;
                break;
            default:
                result = BikeCategory.RoadBikes;
                break;
        }
        return result;
    }
}
