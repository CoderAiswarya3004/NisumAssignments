public class ObjectClassDemo{

    private String name;

    public ObjectClassDemo(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "ObjectClassDemo{name='" + name + "'}";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ObjectClassDemo other = (ObjectClassDemo) obj;
        return this.name.equals(other.name);
    }
    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public static void main(String[] args) {
        ObjectClassDemo obj1 = new ObjectClassDemo("Java");
        ObjectClassDemo obj2 = new ObjectClassDemo("Java");
        ObjectClassDemo obj3 = new ObjectClassDemo("Python");
        // Using toString()
        System.out.println("toString() output: " + obj1);
        // Using equals()
        System.out.println("obj1 equals obj2? " + obj1.equals(obj2)); // true
        System.out.println("obj1 equals obj3? " + obj1.equals(obj3)); // false
        //using hashcode()
        System.out.println("obj1 hashCode: " + obj1.hashCode());
        System.out.println("obj2 hashCode: " + obj2.hashCode());
        System.out.println("obj3 hashCode: " + obj3.hashCode());
    }
}
