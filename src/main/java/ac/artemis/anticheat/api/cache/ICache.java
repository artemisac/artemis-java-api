package ac.artemis.anticheat.api.cache;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public interface ICache<K, V> {
    void put(K k, V v);

    void remove(K k);

    boolean containsKey(K k);

    V getIfPresent(K k);

    ICache<K, V> expireAfterWrite(long time, TimeUnit unit);

    ICache<K, V> expireAfterAccess(long time, TimeUnit unit);

    ICache<K, V> softValues();

    ICache<K, V> concurrencyLevel(int i);

    ICache<K, V> build();

    ICache<K, V> build(Function<K, V> cacheLoader);

    Map<K, V> asMap();
}
