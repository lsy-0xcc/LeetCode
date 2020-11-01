//设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。 
//
// 注意: 允许出现重复元素。 
//
// 
// insert(val)：向集合中插入元素 val。 
// remove(val)：当 val 存在时，从集合中移除一个 val。 
// getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。 
// 
//
// 示例: 
//
// // 初始化一个空的集合。
//RandomizedCollection collection = new RandomizedCollection();
//
//// 向集合中插入 1 。返回 true 表示集合不包含 1 。
//collection.insert(1);
//
//// 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
//collection.insert(1);
//
//// 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
//collection.insert(2);
//
//// getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
//collection.getRandom();
//
//// 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
//collection.remove(1);
//
//// getRandom 应有相同概率返回 1 和 2 。
//collection.getRandom();
// 
// Related Topics 设计 数组 哈希表 
// 👍 165 👎 0

package editor.cn;

import java.util.*;

//Java：O(1) 时间插入、删除和获取随机元素 - 允许重复
public class Q381InsertDeleteGetrandomO1DuplicatesAllowed {
    public static void main(String[] args) {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
//        System.out.println(randomizedCollection.remove(1));
//        System.out.println(randomizedCollection.insert(1));
//        System.out.println(randomizedCollection.insert(1));
//        System.out.println(randomizedCollection.remove(1));
//        System.out.println(randomizedCollection.insert(1));
//        System.out.println(randomizedCollection.remove(1));
        System.out.println(randomizedCollection.insert(1));
        System.out.println(randomizedCollection.insert(1));
        System.out.println(randomizedCollection.insert(2));
        System.out.println(randomizedCollection.insert(1));
        System.out.println(randomizedCollection.insert(2));
        System.out.println(randomizedCollection.insert(2));
        System.out.println(randomizedCollection.remove(1));
        System.out.println(randomizedCollection.remove(2));
        System.out.println(randomizedCollection.remove(2));
        System.out.println(randomizedCollection.remove(2));
        System.out.println(randomizedCollection.remove(2));
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println();
    }



}

//leetcode submit region begin(Prohibit modification and deletion)


class RandomizedCollection {
    // 用一个数组保存所有元素
    List<Integer> list;
    // key: list中元素
    // value: key在list中出现位置
    Map<Integer, Set<Integer>> positions;
    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        list = new ArrayList<>();
        positions = new HashMap<>();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        list.add(val); // 向list中添加
        if (!positions.containsKey(val)) {
            positions.put(val, new HashSet<>());
            positions.get(val).add(list.size() - 1);
            return true;
        } else {
            positions.get(val).add(list.size() - 1);
            return false;
        }
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {

        if (!positions.containsKey(val)) {
            return false;
        } else {
            // 选取val对应set中一个元素移除
            int removePos =-1;
            for (Integer e : positions.get(val)) {
                removePos = e;
                break;
            }
            // 移除position中对应的位置
            positions.get(val).remove(removePos);
            // 找到list中最后一个元素与要移除的交换
            int lastNum = list.get(list.size() - 1);
            // 最后一个元素的位置由最后到移除的位置
            positions.get(lastNum).add(removePos);
            positions.get(lastNum).remove(list.size() - 1);
            // 若被移除的元素不存在于list中 移除
            if (positions.get(val).size() == 0) {
                positions.remove(val);
            }
            // 修改list
            list.set(removePos, lastNum);
            list.remove(list.size() - 1);
            return true;
        }
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        int pos = (int) (Math.random() * list.size());
        return list.get(pos);
    }
}


/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)