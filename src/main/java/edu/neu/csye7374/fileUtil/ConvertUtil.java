package edu.neu.csye7374.fileUtil;

public class ConvertUtil {
    public static int StringToInt(String s) {
        int num = 0;

        try {
            num = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.err.println("!!ERROR!! String " + s + " doesn't contain numerical Integers");
            e.printStackTrace();
        }
        return num;
    }

    public static double StringToDouble(String s) {
        double num = 0;

        try {
            num = Double.parseDouble(s);
        } catch (NumberFormatException e) {
            System.err.println("!!ERROR!! String " + s + " doesn't contain numerical Doubles");
            e.printStackTrace();
        }
        return num;
    }

    public static String[] stringSplit(String s) {
        String[] sarray = s.split(",");

        return sarray;
    }

}
