/*
Rainbow.java
by Mark Yang (mdyang@bu.edu)
3/25/2023

Small color utility class
 */
public class Rainbow {
    private int i;
    //ROYGBIV 8-bit colors, 16 + 36 × r + 6 × g + b (0 ≤ r, g, b ≤ 5)
    final String[] COLORS = {"\u001B[38;5;196m", "\u001B[38;5;214m",
            "\u001B[38;5;11m","\u001B[38;5;34m","\u001B[38;5;21m",
            "\u001B[38;5;91m", "\u001B[38;5;164m"};
    public Rainbow(){
        i = -1;
    }

    public String next(){
        if (++i >= COLORS.length) i = 0;
        return COLORS[i];
    }
}
