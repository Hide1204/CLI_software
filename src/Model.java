import java.util.LinkedList;
import java.util.Random;

public class Model {
    private final static int WIDTH = 80;
    private final static int HEIGHT = 24;
    private final static int BULLETCOUNT = 00;
    private final static Random random = new Random();
    private ConsoleView view;
    private LinkedList<Bullet> bullets;
    private PlayerCharacter player;
    public Model() {
        view = new ConsoleView(this, WIDTH, HEIGHT);
        bullets = new LinkedList<Bullet>();
        for(int i=0;i<BULLETCOUNT;i++){
            bullets.add(makeBullet());
        }
        player = new PlayerCharacter(30,22);
    }
    public Bullet makeBullet(char c){
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
        return new Bullet(c,x, y, dx, dy);
    }
    public void run()throws Exception{
        while (true){
            for(Bullet b : bullets){
                b.update();
            }
            LinkedList<Bullet> newBullets = new LinkedList<Bullet>();
            for(Bullet b : bullets){
                if(!b.isOutOfRange(WIDTH, HEIGHT)){
                    newBullets.add(b);
                }
            }
            bullets=newBullets;
            while(bullets.size()<BULLETCOUNT){
                bullets.add(makeBullet());
            }
            view.update();
            Thread.sleep(50);
        }
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