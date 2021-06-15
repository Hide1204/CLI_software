import java.util.LinkedList;
import java.util.Random;

public class Model {
    private final static int WIDTH = 80;
    private final static int HEIGHT = 24;
    private final static Random random = new Random();
    private ConsoleView view;
    private LinkedList<Bullet> bullets;
    private PlayerCharacter player;
    private ConsoleController controller;
    public Model() {
        view = new ConsoleView(this, WIDTH, HEIGHT);
        bullets = new LinkedList<Bullet>();
        controller = new ConsoleController(this);
        player = new PlayerCharacter(30,20);
    }
    public Bullet makeBullet(){
        int x = random.nextInt(WIDTH);
        int y = random.nextInt(HEIGHT);
        int dx = random.nextInt(2)+1;
        int dy = random.nextInt(2)+1;
        if(random.nextInt(2)==0){
            dx*=-1;
        }
        if(random.nextInt(2)==0){
            dy*=-1;
        }
        return new Bullet(x, y, dx, dy);
    }
    public synchronized void process(String event) {
        if (event.equals("TIME_ELAPSED")){
            if(view.get_c(player.get_x(), player.get_y()+1)!='_'){
                player.moveDown();
            }// 時間経過時の処理
        }
        else{
            if(event.equals("RIGHT")){
                if(view.get_c(player.get_x()+1, player.get_y())!='_'){
                    player.moveRight();
                }
            }
            if(event.equals("LEFT")){
                if(view.get_c(player.get_x()-1, player.get_y())!='_'){
                    player.moveLeft();
                }
            }
            if(event.equals("UP")){
                if(view.get_c(player.get_x(), player.get_y()-1)!='_'){
                    player.moveUp();
                }
            }
            if(event.equals("DOWN")){
                if(view.get_c(player.get_x(), player.get_y()+1)!='_'){
                    player.moveDown();
                }
            }
            
        }// タイプ時の処理
        view.update();
    }
    public void run()throws Exception{
        controller.run();
    }
    public LinkedList<Bullet> getBullets(){
        return bullets;
    }
    public PlayerCharacter getplayer(){
        return player;
    }
    public static void main(String[] args) throws Exception{
        Model model = new Model();
        model.run();
    }
}