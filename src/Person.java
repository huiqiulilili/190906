public class Person implements Comparable<Person> {
    String name;
    int age;

    @Override
    public int compareTo(Person o) {
        if(this.age < o.age){
            return -1;
        }else if(this.age == o.age){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public String toString() {
        return String.format("Person{%d}",age);
    }
}
