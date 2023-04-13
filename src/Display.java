import java.util.ArrayList;
import java.util.List;
/*
Diplay.java
by Mark Yang (mdyang@bu.edu)
3/25/2023

Terminal bitmap graphic display

A Display object has a grid g of pixels and a list of Displayable objects.
It can print out the pixel grid, change the pixel grid, or make Displayable objects change the pixel grid.

Calling render redraws a base along with all displayables.

Displayables can be added or removed with add or remove.

References: Displayable, Grid
 */
public class Display {
    Grid g;
    List<Displayable> displayables = new ArrayList<>();
    public Display(){
        g = new Grid(23,80);
        g.fill(".");
        renderBase();
    }

    public void renderBase(){
        g.fill(" ");
        makeBorder();
    }
    public void render(){
        renderBase();
        for (Displayable d : displayables) {
            if (!d.hidden) {
                d.draw();
            }
        }
    }
    public void showScreen(){
        g.print();
    }

    private void makeBorder(){
        g.rainbow(true);
    }

    public void drawLine(String s, int x1, int y1, int x2, int y2){
        g.interpolate(s, x1, y1, x2, y2, false);
    }

    public void pauseScreen() {
    }

    public boolean exitScreen() {
        render();
        //return Input.queryStatic("CONFIRM: ").equals("exit");
        return false;
    }

    public Grid grid() {
        return g;
    }

    public void add(Displayable d){
        displayables.add(d);
    }

    public boolean remove(Displayable d){
        return displayables.remove(d);
    }

    public void titleScreen() {
        new SpriteDisplayer(this, 0,0,"rsc/sprite/title.txt").draw();
    }

    public void message(String s) {
        System.out.println(s);
    }

    public void helpScreen() {
        new SpriteDisplayer(this, 0,0,"rsc/sprite/help.txt").draw();
    }
}
