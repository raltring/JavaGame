package src.GameAttempt;

public class MainThread extends Thread{
    MainPanel panel;
    boolean running = true;
    long previousTime = 0;
    long timeSinceLastDraw = 0;
    short setFPS = 60;
    float milliPerFrame = 1000.0f / setFPS;

    public MainThread(MainPanel panel){
        this.panel = panel;
    }

    public void run() {
        while(running){
            update();
            if (timeSinceLastDraw >= milliPerFrame) {
                draw();
            }
        }
    }

    public void update(){
        long currentTime = System.currentTimeMillis();
        long deltaTime = currentTime - previousTime;
        previousTime = currentTime;
        panel.update(deltaTime);
        timeSinceLastDraw += deltaTime;
    }

    public void draw(){
        timeSinceLastDraw = 0;
        panel.repaint();
    }
}
