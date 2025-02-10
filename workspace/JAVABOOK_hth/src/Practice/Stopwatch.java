package Practice;

public class Stopwatch {
    private long startTime;
    private long elapsedTime;
    private boolean running;

    // 스톱워치 시작
    public void start() {
        if (!running) {
            startTime = System.currentTimeMillis() - elapsedTime;
            running = true;
        }
    }

    // 스톱워치 정지
    public void stop() {
        if (running) {
            elapsedTime = System.currentTimeMillis() - startTime;
            running = false;
        }
    }

    // 스톱워치 리셋
    public void reset() {
        elapsedTime = 0;
        running = false;
    }

    // 현재 경과 시간 (초 단위)
    public long getElapsedTime() {
        return running ? (System.currentTimeMillis() - startTime) / 1000 : elapsedTime / 1000;
    }

    public static void main(String[] args) throws InterruptedException {
        Stopwatch stopwatch = new Stopwatch();
        
        stopwatch.start();
        Thread.sleep(3000);  // 3초 기다림
        stopwatch.stop();
        
        System.out.println("경과 시간: " + stopwatch.getElapsedTime() + "초");

        stopwatch.reset();
        System.out.println("리셋 후: " + stopwatch.getElapsedTime() + "초");
    }
}