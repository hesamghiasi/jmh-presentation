package manual;

public class WrongBench {

    public static void bench(String name, long runMillis, int loop, int warmup, int repeat, Runnable runnable) {
        System.out.println("Running: " + name);
        int max = repeat + warmup;
        long average = 0L;
        for (int i = 0; i < max; i++) {
            long nops = 0;
            long duration = 0L;
            long start = System.currentTimeMillis();
            while (duration < runMillis) {
                for (int j = 0; j < loop; j++) {
                    runnable.run();
                    nops++;
                }
                duration = System.currentTimeMillis() - start;
            }
            long throughput = nops / duration;
            boolean benchRun = i >= warmup;
            if (benchRun) {
                average = average + throughput;
            }
            System.out.print(throughput + " ops/ms" + (
                    !benchRun ? " (warmup) | " : " | "));
        }
        average = average / repeat;
        System.out.println("\n[ ~" + average + " ops/ms ]\n");
    }
}