public class PoliticDebates {
    public static int totalCountSpeeches = 200;
    public static int soundInOneSpeech = 1000000;

    public static void main(String[] args) throws InterruptedException {
        Politic ivanov = new Politic("Ivanov");
        ivanov.join();
        Politic petrov = new Politic("Petrov");
        Politic sidorov = new Politic("Sidorov");
        while (ivanov.getCountSounds() + petrov.getCountSounds() + sidorov.getCountSounds() < totalCountSpeeches) {
        }
        System.out.println(ivanov.toString());
        System.out.println(petrov.toString());
        System.out.println(sidorov.toString());

    }

    public static class Politic extends Thread {
        private int countSounds;

        public Politic(String name) {
            super(name);
            this.start();
        }

        @Override
        public void run() {
            while (countSounds < totalCountSpeeches * soundInOneSpeech) {
                countSounds++;
            }
        }

        public int getCountSounds() {
            return countSounds / soundInOneSpeech;
        }

        public String toString() {
            return String.format("%s said speech %d time", getName(), getCountSounds());
        }
    }
}
