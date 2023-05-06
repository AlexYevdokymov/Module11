package mainPackage;


import java.util.stream.Stream;

public class Randomizer {
    private long a, c, m;

    public Randomizer(long a, long c, long m) {
        this.a = a;
        this.m = m;
        this.c = c;
    }

    public Stream<Long> createStream(long seed) {
        return Stream.iterate(seed, s -> (a * s + c) % m);
    }
}
