public class Bullet {
    private int x;
    private int y;
    private int dx;
    private int dy;
    public Bullet(int x,int y,int dx,int dy){
        this.x=x;
        this.y=y;
        this.dx=dx;
        this.dy=dy;
    }
    public void update(){
        x+=dx;
        y+=dy;
    }
    public void paint(ConsoleView view){
        view.put('*',x,y);
    }
    public boolean isOutOfRange(int width,int height){
        return (x<0 || y<0 || x>=width || y>=height);
    }
}
