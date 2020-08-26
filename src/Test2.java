import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouzh6
 * @date 2020-08-26
 */
public class Test2<T> {
    T ele;
    void add(T ele){
        this.ele = ele;
    }

    public <T> T[] test(List<T> list) {
        if (list.size() == 0) {
            return (T[]) list.toArray();
        }
        return null;
    }

    public static void main(String[] args) {
        Test2<String> test2 = new Test2();
        String[] str = test2.test(new ArrayList<String>());
    }
}
