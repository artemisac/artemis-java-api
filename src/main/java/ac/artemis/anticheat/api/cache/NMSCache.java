package ac.artemis.anticheat.api.cache;

import ac.artemis.packet.protocol.ProtocolVersion;
import ac.artemis.packet.spigot.utils.ServerUtil;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @author Ghast
 * @since 30-Mar-20
 */


public class NMSCache<K, V> implements ICache<K, V> {
    private final ICache<K, V> list;

    public <K, V> NMSCache() {
        this.list = ServerUtil.getGameVersion().isOrAbove(ProtocolVersion.V1_8)
                ? new ModernCache<>() : new LegacyCache<>();
    }

    @Override
    public NMSCache<K, V> expireAfterWrite(long time, TimeUnit unit) {
        list.expireAfterWrite(time, unit);
        return this;
    }

    @Override
    public NMSCache<K, V> expireAfterAccess(long time, TimeUnit unit) {
        list.expireAfterAccess(time, unit);
        return this;
    }

    @Override
    public NMSCache<K, V> softValues() {
        list.softValues();
        return this;
    }

    @Override
    public NMSCache<K, V> concurrencyLevel(int i) {
        list.concurrencyLevel(i);
        return this;
    }

    @Override
    public NMSCache<K, V> build() {
        list.build();
        return this;
    }

    @Override
    public NMSCache<K, V> build(Function<K, V> cacheLoader) {
        list.build(cacheLoader);
        return this;
    }

    @Override
    public void put(K k, V v) {
        list.put(k, v);
    }

    @Override
    public void remove(K k) {
        list.remove(k);
    }

    @Override
    public boolean containsKey(K k) {
        return list.containsKey(k);
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
