package com.company;

import java.util.Arrays;
import java.util.Comparator;

//Написать класс PersonSuperComparator,
//который реализует Comparator, но умеет сравнивать по двум параметрам , возраст и имя.
//Класс Person теперь содержит два поля int age и String name
class Person{
    private String name;
    private int age;
    public Person(String name, int age) {//конструктор
        this.name=name;
        this.age=age;
    }
    public String getName() {//метод получения имени
        return name;
    }
    public Integer getAge() {//метод получения возраста
        return age;
    }
    @Override//переопределение метода toString
    public String toString()
    {
        return name + " " + age;}
}
class PersonSuperComparator implements Comparator<Person>{//класс реализующий Comparator

    @Override//переопределение метода сompare
    public int compare(Person o1, Person o2) {
        if (o1.getName().compareTo(o2.getName()) == 0){//сравнение по имени
            return o1.getAge().compareTo(o2.getAge());//дополнительное сравнение по возрасту и возврат результата сравнения
        }
        else return o1.getName().compareTo(o2.getName());//возвращаем результат сравнения
    }

}
public class Main {

    public static void main(String[] args) {
        Person[] Persons = new Person[5];
        Persons[0]=new Person("Федя ",18 );
        Persons[1]=new Person("Анна ",22 );
        Persons[2]=new Person("Михаил ",30 );
        Persons[3]=new Person("Ирина ",22 );
        Persons[4]=new Person("Михаил ",25 );
        Arrays.sort(Persons, new PersonSuperComparator());//запуск сортировки
        for(Person person : Persons)
            System.out.println(person.toString());
    }
}