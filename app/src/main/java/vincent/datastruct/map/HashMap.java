package vincent.datastruct.map;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by vincent on 2017/4/17.
 * email-address:674928145@qq.com
 * description:自定义实现简单的HashMap
 */

public class HashMap<K, V> extends AbstractMap<K, V> {

    static final int MAXIMUM_CAPACITY = 1 << 30;
    private int threshold;//容量极限，到达极限扩容
    private Entry<K, V>[] table;
    private transient int size;//实际table数组被占用的大小

    public HashMap() {
        this(4, 0.75f);//默认初始容量为4,加载因子为0.75
    }

    public HashMap(int initialCapacity, float loadFactor) {
        //①规范初始容量和加载因子的值
        //初始容量不能为<0
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        }
        //加载因子最大为2^30
        if (initialCapacity > MAXIMUM_CAPACITY) {
            initialCapacity = MAXIMUM_CAPACITY;
        }
        if (loadFactor < 0 || Float.isNaN(loadFactor)) {
            throw new IllegalArgumentException("Illegal loadFactor: " + loadFactor);
        }
        int capacity = 1;//capacity的值就是table数组的大小,即hash桶的个数
        //规范容量为2的n次方，便于与hash值进行与运算的时候均匀分布散列数据和充分利用空间
        while (capacity < initialCapacity) {
            capacity = capacity << 1;
        }
        threshold = (int) (capacity * loadFactor);
        //初始化table数组
        table = new Entry[capacity];
    }

    static class Entry<K, V> implements Map.Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;//指向下一个Entry,链表
        int hash;

        public Entry(K key, V value, Entry<K, V> next, int hash) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = hash;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            return null;
        }
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return null;
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public boolean containsValue(Object value) {
        return super.containsValue(value);
    }

    @Override
    public boolean containsKey(Object key) {
        return super.containsKey(key);
    }

    @Override
    public V get(Object key) {
        int hash = hash(key.hashCode());
        int index = indexFor(hash, table.length);
        for (Entry<K, V> e = table[index]; e != null; e = e.next) {
            if (e.getKey() == key) {
                return (V) e.getValue();
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        if (key == null) {
            return putForNullKey(value);
        }
        //计算key的hash值，2次hash
        int hash = hash(key.hashCode());
        //根据key的hashcode的hash值，和table的长度，找到所在table的位置
        int i = indexFor(hash, table.length);
        for (Entry<K, V> entry = table[i]; entry != null; entry = entry.next) {
            if (entry.key == key) {
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }
        //往该hash桶添加链表元素
        addEntry(hash, key, value, i);
        return null;
    }

    private static int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private static int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    private V putForNullKey(V value) {
        //遍历table[0]的hash桶上的所有Entry,若果存在key为null的Entry，则替换旧值并返回
        for (Entry<K, V> entry = table[0]; entry != null; entry = entry.next) {
            if (entry.key == null) {
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }
        addEntry(0, null, value, 0);
        return null;
    }

    void addEntry(int hash, K key, V value, int bucketIndex) {
        //Entry的大小达到极限值，进行扩容
        if (size >= threshold && table[bucketIndex] != null) {
            resize(table.length << 1);
            //重新查找桶的下标值
            bucketIndex = indexFor(hash, table.length);
        }
        createEntry(hash, key, value, bucketIndex);
    }

    /**
     * 重点理解！扩容,扩容后元素所在的hash桶位置也应该有所改变
     */
    void resize(int capacity) {
        Entry newTable[] = new Entry[capacity];
        for (Entry<K, V> e : table) {
            while (e != null) {
                Entry<K, V> next = e.next;
                int i = indexFor(e.hash, newTable.length);
                e.next = newTable[i];
                newTable[i] = e;
                e = next;
            }
        }
        table = newTable;
        System.out.println("扩容咯 " + table.length);
    }

    void createEntry(int hash, K key, V value, int bucketIndex) {
        //得到目前在链头的Entry
        Entry<K, V> entry = table[bucketIndex];
        //让新插入的元素位于链头
        table[bucketIndex] = new Entry<>(key, value, entry, hash);
        size++;
        System.out.println("size " + size + " bucketIndex " + bucketIndex + " key " + key + " value " + value);
    }

    @Override
    public V remove(Object key) {
        return super.remove(key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        super.putAll(m);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public Set<K> keySet() {
        return super.keySet();
    }

    @Override
    public Collection<V> values() {
        return super.values();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String arg[]) {
        System.out.println(1.0f / 0);
        System.out.println(-1.0f / 0);
        System.out.println(0.0 / 0.0);
    }
}
