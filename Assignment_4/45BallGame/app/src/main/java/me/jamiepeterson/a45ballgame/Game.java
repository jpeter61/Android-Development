package me.jamiepeterson.a45ballgame;


public class Game {
    private double ballX;
    private double ballY;
    private double ballSpeed;

    private double bulletX;
    private double bulletY;
    private double bulletSpeed;
    private double bulletAngle;

    private double gunX;
    private double gunY;

    private double radius;
    private double distanceThreshold;

    private boolean fired;
    private boolean hit;

    public Game(){
        initializeGame();
    }

    public void update(){
        moveBall();
        if (fired)
            moveBullet();
        if (isSceneClear())
            initializeGame();
    }

    public boolean isHit() {
        return hit;
    }

    public void fire(){
        fired = true;
    }

    public double getBallX() {
        return ballX;
    }

    public double getBallY() {
        return ballY;
    }

    public double getBulletX() {
        return bulletX;
    }

    public double getBulletY() {
        return bulletY;
    }

    public double getGunX() {
        return gunX;
    }

    public double getGunY() {
        return gunY;
    }

    public double getRadius() {
        return radius;
    }

    private void moveBall(){
        if (!hit){
            ballY = ballY - ballSpeed;
            hit = checkHit();
        } else
            ballY = ballY - ballSpeed;
        //The ball still needs to go off screen even though it
        // will not be drawn.
    }

    private void moveBullet(){
        bulletX = bulletX + bulletSpeed*Math.cos(bulletAngle*Math.PI/180);
        bulletY = bulletY + bulletSpeed*Math.sin(bulletAngle*Math.PI/180);
    }

    private boolean checkHit(){
        double distance = Math.sqrt(Math.pow(ballX - bulletX, 2)
                + Math.pow(ballY - bulletY, 2));
        return distance <= distanceThreshold;
    }

    private boolean isSceneClear(){
        //only check ball and subtract radius so to wait until
        // ball is entirely off screen
        return (ballX < 0 - radius || ballY < 0 - radius);
    }

    private void initializeGame(){
        double screenWidth = 1800;
        double screenHeight = 1000;
        double gunLength = 200;
        double gunAngle = 30 + 25 * Math.random();

        radius = 50;
        ballX = 1350 - 900 * Math.random();
        ballY = screenHeight - radius;
        ballSpeed = 10 + 10 * Math.random();

        gunX = gunLength * Math.cos(gunAngle*Math.PI/180);
        gunY = gunLength * Math.sin(gunAngle*Math.PI/180);

        bulletX = gunX;
        bulletY = gunY;
        bulletSpeed = 30;
        bulletAngle = gunAngle;

        distanceThreshold = 100;
        fired = false;
        hit = false;
    }

}
