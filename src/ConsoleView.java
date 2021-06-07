import java.util.LinkedList;

public class ConsoleView {
    private Model model;
    private char[][] screen;
    private int width;
    private int height;
    private static final int WIDTH = 80;
    private static final int HEIGHT = 24;

    public ConsoleView(Model model){
        this(model,WIDTH,HEIGHT);
    }
    public ConsoleView(Model model,int width,int height){
        this.model=model;
        this.width=width;
        this.height=height;
        screen = new char[width][height];
        clear();
    }
    public void clear(){
        for(int i = 0;i<width;i++){
            for(int j = 0;j<height;j++){
                screen[i][j]=' ';
            }
        }
    }
    public void paint(){
        for(int i = 0;i<height;i++){
            for(int j = 0;j<width;j++){
                System.out.print(screen[j][i]);
            }
            System.out.print('\n');
        }
    }
    public void put(char c, int x, int y){
        if(x<0 || width<=x || y<0 || height<= y){
            return;
        }
        screen[x][y]=c;
    }
    public void drawString(String s, int x, int y){
        for(int i = 0;i<s.length();i++){
            put(s.charAt(i),x+i,y);
        }
    }
    public void drawRect(char c, int x, int y, int w, int h){
        for(int i = 0;i<w;i++){
            for(int j =0;j<h;j++){
                if(i==0 || i ==w-1 || j ==0 || j==h-1){
                    put(c,x+i,y+j);
                }
            }
        }
    }
    public void drawFramedString(String s, char c, int x, int y){
        drawRect(c, x-1, y-1, s.length()+2, 3);
        drawString(s, x, y);
    }
    public void drawOval(char c, int x, int y, int w, int h){
        for(int i = -w;i<=w;i++){
            double y_1 = h*Math.sqrt(1-(double)(i*i)/((double)(w*w)));
            put(c,x+i,y+(int)Math.round(y_1));
            put(c,x+i,y-(int)Math.round(y_1));
        }
        for(int i = -h;i<=h;i++){
            double x_1 = w*Math.sqrt(1-(double)(i*i)/((double)(h*h)));
            put(c,x+(int)Math.round(x_1),y+i);
            put(c,x-(int)Math.round(x_1),y+i);
        }
    }
    public void MakeMap(){
        drawRect('_', 15, 23, 30, 1);
        drawRect('_', 10, 19, 10, 1);
        drawRect('_', 40, 19, 10, 1);
        drawRect('_', 20, 15, 20, 1);
        drawRect('_', 10, 11, 10, 1);
        drawRect('_', 40, 11, 10, 1);
        drawRect('_', 20, 07, 20, 1);
    }
    public void update(){
        // 画面クリア
        clear();
        MakeMap();
        LinkedList<Bullet> bullets = model.getBullets();
        for(Bullet b:bullets){
            b.paint(this);
        }
        PlayerCharacter player = model.getplayer();
        player.paint(this);
        paint();
    }
    public static void main(String[] args) throws Exception {
        Model model = new Model();
        model.run();
        ConsoleView view = new ConsoleView(model,80, 24);
        view.clear();
        view.paint();
    }
}

