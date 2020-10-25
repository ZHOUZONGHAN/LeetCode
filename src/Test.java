/**
 * @author zhoudawang
 */
public class Test {
    public static void main(String[] args) {
        Person a = new Person();
        test(a);
        System.out.println(a);
    }

    public static void test(Person b) {
        b = new Person();
        b.setName("zhou");
        b.setAge(20);
    }
}
class Person {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}