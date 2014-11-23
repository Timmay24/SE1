package edu.haw.util;

public class Oracle {

    public Oracle() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static boolean toBoolean(int i) {
        if (1 == i) {
            return true;
        }
        return false;
    }
    
    public static int toInt(boolean i) {
        if (i) {
            return 1;
        }
        return 0;
    }

}
