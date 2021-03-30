package randomPool;

import java.util.HashMap;

public class RandomPool<K> {
    private HashMap<K, Integer> keyIndexMap;
    private HashMap<Integer, K> indexKeyMap;
    private int size;

    public RandomPool() {
        keyIndexMap = new HashMap<>();
        indexKeyMap = new HashMap<>();
        size = 0;
    }

    public void insert(K key) {
        int index = size;
        keyIndexMap.put(key, index);
        indexKeyMap.put(index, key);
        size++;
    }

    public void delete(K key) {
        if (keyIndexMap.containsKey(key)) {
            int lastIndex = size - 1;
            K lastKey = indexKeyMap.get(lastIndex);

            int deleteIndex = keyIndexMap.get(key);

            indexKeyMap.put(deleteIndex, lastKey);
            keyIndexMap.put(lastKey, deleteIndex);

            indexKeyMap.remove(lastIndex);
            keyIndexMap.remove(key);

            size--;
        }
    }

    public K getRandom() {
        if (size == 0) {
            return null;
        }
        int randomIndex = (int)(Math.random() * size);
        return indexKeyMap.get(randomIndex);
    }

    public static void main(String[] args) {
        RandomPool<String> pool = new RandomPool<>();
        pool.insert("zuo");
        pool.insert("cheng");
        pool.insert("yun");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
    }
}
