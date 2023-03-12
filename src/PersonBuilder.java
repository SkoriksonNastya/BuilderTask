public class PersonBuilder {

    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder (){

    }

    public PersonBuilder setName (String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть меньше нуля!");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress (String address) {
        this.address = address;
        return this;
    }

    public Person build(){
        if (name == null || surname == null) {
            throw new IllegalStateException("Поля имени и фамилии не могут быть пустыми!");
        }
        Person person;
        if ( age == 0){
            person = new Person(name,surname);
        } else person = new Person(name,surname, age);
        person.setAddress(address);
        return person;
    }

}
