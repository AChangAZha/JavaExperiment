public class AddNum {
    public static Object LOCK = new Object();

    class AddThread extends Thread {

        private int begin;
        private int end;
        public int sum = 0;

        public void run() {
            synchronized (LOCK) {
                for (int i = begin; i <= end; i++) {
                    sum += i;
                }
                System.out.println(Thread.currentThread().getName() + ":" + sum);
            }
        }

        public AddThread(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        AddNum addNum = new AddNum();
        AddThread[] addThreads = new AddThread[10];
        for (int i = 0; i < addThreads.length; i++) {
            addThreads[i] = addNum.new AddThread(i * 10 + 1, (i + 1) * 10);
            addThreads[i].setName((i + 1) + "号");
        }
        for (int i = 0; i < addThreads.length; i++) {
            addThreads[i].start();
        }
        for (int i = 0; i < addThreads.length; i++) {
            addThreads[i].join();
        }
        int sum = 0;
        for (int i = 0; i < addThreads.length; i++) {
            sum += addThreads[i].sum;
        }
        System.out.println("总和：" + sum);
    }
}