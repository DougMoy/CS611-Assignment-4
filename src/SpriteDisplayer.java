import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
SpriteDisplayer.java
by Mark Yang (mdyang@bu.edu)
3/25/2023

Object of type Displayable able to take sprite from a text file and show it

Text file format:
First line: 2 int, horizontal and vertical displacement
Second+ lines: Each line of the sprite
Takes the character '¬' as an empty character and doesn't draw anything using it.
 */
public class SpriteDisplayer extends Displayable {
    private final char EMPTYCHAR = '?';
    private List<String> lines;
    public SpriteDisplayer(Display d, int x, int y, String filepath){
        super(d,x,y);
        lines = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);

            this.dx = Integer.parseInt(st.nextToken());
            this.dy = Integer.parseInt(st.nextToken());

            while ((str = br.readLine()) != null)
                lines.add(str);
        }
        catch(Exception e){
            System.out.println(e);
        }
        //System.out.println("DEBUGGING" + this.dx + this.dy);
    }
    @Override
    public void draw() {
        for (int row = 0; row < lines.size(); row++){
            String text = lines.get(row);
            setText(text, x, y+row);
        }
    }

    public String getSprite(){
        String s = dx + " " + dy + "\n";
        for (int i = 0; i < lines.size(); i++){
            s += lines.get(i);
        }
        return s;
    }
    public void setSprite(String s){
        lines = new ArrayList<>();
        try{
            StringTokenizer br = new StringTokenizer(s,  "\n");
            String str = br.nextToken();
            StringTokenizer st = new StringTokenizer(str);

            this.dx = Integer.parseInt(st.nextToken());
            this.dy = Integer.parseInt(st.nextToken());

            while ((str = br.nextToken()) != null)
                lines.add(str);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
