public class PlayerCharacter {
    private int x;
    private int y;
    private int nowJumpDistance;
    private static final int jumpPower = 7;

    public PlayerCharacter(int x,int y){
        this.x=x;
        this.y=y;
        this.nowJumpDistance=0;
    }

    public void moveRight(){
        x+=1;
    }
    public void moveLeft(){
        x-=1;
    }
    public void moveUp(){
        y-=1;
    }
    public void moveDown(){
        y+=1;
    }
    public int get_x(){
        return x;
    }
    public int get_y(){
        return y;
    }
    public int get_jumpPower(){
        return jumpPower;
    }
    public int get_nowJumpDistance(){
        return nowJumpDistance;
    }
    public int set_x(int x){
        this.x=x;
        return x;
    }
    public int set_y(int y){
        this.y=y;
        return y;
    }
    public int set_nowJumpDistance(int num){
        this.nowJumpDistance=num;
        return nowJumpDistance;
    }
    public void paint(ConsoleView view){
        view.put('*',x,y);
    }
    public boolean isOutOfRange(int width,int height){
        return (x<0 || y<0 || x>=width || y>=height);
    }
}
