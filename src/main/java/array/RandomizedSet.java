package array;

import java.util.*;

/**
 * @author wsh
 * @date 2024/1/5
 */
public class RandomizedSet {

    private List<Integer> array;
    private Map<Integer, Integer> map;

    private Random random;

    public RandomizedSet() {
        array = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        int l = array.size();
        array.add(val);
        map.put(val, l);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int last = array.get(array.size() - 1);
        // 更新交换的数据
        array.set(index, last);
        map.put(last, index);
        // 移除最后一个元素
        array.remove(array.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int size = array.size();
        return array.get(random.nextInt(size));
    }


    public static void main(String[] args) {
        RandomizedSet r = new RandomizedSet();
        r.insert(0);
        r.insert(1);
        r.remove(0);
        r.insert(2);
        r.remove(1);
        System.out.println(r.getRandom());
    }
}
