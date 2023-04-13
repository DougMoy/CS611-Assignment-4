/*
Grid.java
by Mark Yang (mdyang@bu.edu)
3/25/2023

2D grid of strings object

Can edit the grid by placing at each item.
Can place lines of the grid using Bresenham's Line algorithm.
Can toggle rainbows placement
 */
public class Grid {
    private int h,w;
    private Rainbow rb;
    private boolean rbOn;
    private String[][] grid;

    public Grid(int h, int w){
        this.h = h;
        this.w = w;
        rb = new Rainbow();
        rbOn = false;
        grid = new String[h][w];
        fill(" ");
    }

    public void fill(String s){
        for (int row = 0; row < h; row++){
            for (int col = 0; col < w; col++){
                grid[row][col] = s;
            }
        }
    }

    public int width(){
        return w;
    }

    public int height(){
        return h;
    }

    public void set(String s, int row, int col){
        if (col < 0 || col >= w) return;
        if (row < 0 || row >= h) return;
        if (rbOn){
            s = rb.next() + s + Colors.ANSI_RESET;
        }
        grid[row][col] = s;
    }

    public void rainbow(boolean b){
        rbOn = b;
    }

    /*
    Draws a line using Bresenham's Line Algorithm
    Flip is for slopes with magnitude > 1, default false
     */
    public void interpolate(String s, int x1, int y1, int x2, int y2, boolean flip) {
        if (x2 < x1) { //ensure x1 <= x2
            interpolate(s, x2, y2, x1, y1, flip);
            return;
        }
        if (!flip) {
            if (y2 - y1 > x2 - x1 || y1 - y2 > x2 - x1) { //ensure x1 <= x2
            interpolate(s, x1, y1, x2, y2, true);
            return;
            }
        }
        if(flip){
            int temp = x1;
            x1 = y1;
            y1 = temp;
            temp = x2;
            x2 = y2;
            y2 = temp;
        }

        int dy = 1;
        if (y2 < y1) dy = -1;
        int A = 2 * (y2 - y1) * dy;
        int B = A - 2 * (x2 - x1);
        int P = A - (x2 - x1);

        int x = x1, y = y1;
        while(x < x2){
            if(!flip) set(s, y, x);
            else set(s, x, y);
            if (P > 0) {
                x += 1;
                y += dy;
                P += B;
            }
            else {
                x += 1;
                P += A;
            }
        }
        if(!flip) set(s, y, x);
        else set(s, x, y);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (int row = 0; row < h; row++){
            for (int col = 0; col < w; col++){
                str.append(grid[row][col]);
            }
            str.append("\n");
        }
        return str.toString();
    }


    public void print() {
       System.out.print(toString());
    }
}
