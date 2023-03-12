import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String address;

    public Person (String name, String surname){
        this.name = name;
        this.surname = surname;
    }
    public Person (String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
    }
    public Person (String name, String surname, int age, String address){
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
        this.address = address;
    }
       public boolean hasAge(){
        return age.isPresent();
    }
    public boolean hasAddress(){
        if (address != null){
            return true;
        }
        return false;
    }
    public String getName() {return name;}
    public String getSurname() {return surname;}
    public OptionalInt getAge() {return age;}
    public String getAddress() {return address;}
    public void setAddress(String address){
        this.address = address;
    }
    public void happyBirthday(){
        if (age.isPresent()) {
            age = OptionalInt.of(age.getAsInt() + 1);
        }
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    public PersonBuilder newChildBuilder(){
        return new PersonBuilder()
                .setSurname(surname)
                .setAddress(address)
                .setAge(0);
    }
}
