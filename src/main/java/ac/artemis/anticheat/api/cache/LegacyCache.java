package ac.artemis.anticheat.api.cache;

import net.minecraft.util.com.google.common.cache.Cache;
import net.minecraft.util.com.google.common.cache.CacheBuilder;
import net.minecraft.util.com.google.common.cache.CacheLoader;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @author Ghast
 * @since 30-Mar-20
 */
public class LegacyCache<K, V> implements ICache<K, V> {
    private Cache<K, V> list;
    private final CacheBuilder builder;

    public LegacyCache() {
        this.builder = CacheBuilder.newBuilder();
    }

    @Override
    public ICache<K, V> expireAfterWrite(long time, TimeUnit unit) {
        builder.expireAfterWrite(time, unit);
        return this;
    }

    @Override
    public ICache<K, V> expireAfterAccess(long time, TimeUnit unit) {
        builder.expireAfterAccess(time, unit);
        return this;
    }

    @Override
    public ICache<K, V> softValues() {
        builder.softValues();
        return this;
    }

    @Override
    public ICache<K, V> concurrencyLevel(int i) {
        builder.concurrencyLevel(i);
        return this;
    }

    @Override
    public ICache<K, V> build() {
        this.list = builder.build();
        return this;
    }

    @Override
    public ICache<K, V> build(Function<K, V> cacheLoader) {
        this.list = builder.build(new CacheLoader<K, V>() {
            @Override
            public V load(K key) throws Exception {
                return cacheLoader.apply(key);
            }
        });
        return this;
    }

    @Override
    public void put(K k, V v) {
        list.put(k, v);
    }

    @Override
    public void remove(K k) {
        list.asMap().remove(k);
    }

    @Override
    public boolean containsKey(K k) {
        return list.asMap().containsKey(k);
    }


    @Override
    public V getIfPresent(K k) {
        return list.getIfPresent(k);
    }

    @Override
    public Map<K, V> asMap() {
        return list.asMap();
    }
}
