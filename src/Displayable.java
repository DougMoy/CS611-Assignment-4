/*
Displayable.java
by Mark Yang (mdyang@bu.edu)
3/25/2023

Abstract class that can draw stuff onto Display

It has a position on the grid, a displacement to be drawn, and can draw something onto the grid.

References: Display, Grid
 */
public abstract class Displayable {
    Display d;
    Grid g;
    int x,y,dx,dy;
    //Hidden is exposed because it does not change any internals.
    //If you see the use case it makes sense
    public boolean hidden;
    public Displayable(Display d, int x, int y) {
        this.d = d;
        this.g = d.grid();
        this.x = x;
        this.y = y;
        this.dx = 0;
        this.dy = 0;
        this.hidden = false;
    }

    public abstract void draw();

    protected void set(String s, int x, int y) {
        x += this.x;
        x += this.dx;
        y += this.y;
        y += this.dy;
        g.set(s,y,x);
    }

    protected void setText(String text, int x, int y) {
        int dx = 0;
        int dy = 0;
        String s = "";
        for (int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            s += c;

            if (c == '\u001B'){
                StringBuilder str = new StringBuilder("" + text.charAt(i));
                i++;
                c = text.charAt(i);
                str.append(c);
                while (c != 'm'){
                    i++;
                    c = text.charAt(i);
                    str.append(c);
                }
                s += str.toString();
                continue;
            }
            else if (c == '\n'){
                dy++;
                dx = 0;
                s = "";
                continue;
            }


            set(s, x + dx, y + dy);
            s = "";
            dx++;
        }
    }

    protected void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Shift is to ensure large objects are centered.
    protected void setShift(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }
}
