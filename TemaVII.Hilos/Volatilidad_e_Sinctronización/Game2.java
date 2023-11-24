public class Game2 {
    private static volatile int counter = 0;

    private static class Player extends Thread {
        @Override
        public void run() {
            // Simulate some game events
            for (int i = 0; i < 1000; i++) {
                // Update the counter
                synchronized (Game.class) {
                    counter++;
                }
                System.out.println("Player updated counter: " + counter);
            }
        }
    }

    public static void main(String[] args) {
        // Create multiple player threads
        Player player1 = new Player();
        Player player2 = new Player();

        player1.start();
        player2.start();
    }
}