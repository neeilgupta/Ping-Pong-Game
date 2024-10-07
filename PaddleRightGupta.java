import java.awt.Color;
import java.awt.Graphics;

public class PaddleRightGupta extends BlockGupta {
    private int speed;
    private int yPos;
    private int width;
    private int height;
    private BallGupta ball;
    private int ySpeed = 0;
    private CentralGameGupta central;

    private long lastUpdateTime = 0;
    private long updateInterval = 16; // Approx 60 FPS

    public PaddleRightGupta(int x, int y, int width) {
        super(x, y);
        this.width = width;
        speed = 5;
    }

    public PaddleRightGupta(int x, int y, int width, int height, CentralGameGupta hub, BallGupta ball) {
        super(x, y);
        this.width = width;
        this.height = height;
        speed = 5;
        this.ball = ball;
        central = hub;
    }

    public CentralGameGupta getParent() {
        return central;
    }

    public void setSpeed(int speed) {
        // Cap the speed to avoid excessive movement
        if (speed > 10) {
            this.speed = 10;
        } else {
            this.speed = speed;
        }
    }

    public void draw(Graphics window) {
        drawRect(window);
    }

    public void drawRect(Graphics window) {
        window.setColor(Color.WHITE);
        window.fillRect(getX(), yPos, width, height);
    }

    public void update() {
        // Ensures consistent update rate to avoid lag
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastUpdateTime >= updateInterval) {
            if (ball.getY() < yPos) {
                ySpeed = -speed;
            } else if (ball.getY() > yPos) {
                ySpeed = speed;
            }
            yPos = yPos + ySpeed;

            lastUpdateTime = currentTime; // Update the last update time
        }
    }
}
