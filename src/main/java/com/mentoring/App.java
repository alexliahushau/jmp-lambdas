package com.mentoring;

import com.mentoring.entity.Person;
import com.mentoring.functional.CustomInterface;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        /** 1. Create instances of runnable interface */
        final Comparator<Person> byName = (p1, p2) -> {
            return p1.getName().compareTo(p2.getName());
        };

        final Comparator<Person> byAge = (p1, p2) -> {
            return p1.getAge() > p2.getAge() ? +1 : p1.getAge() < p2.getAge() ? -1 : 0;
        };

        final Person alex = new Person("alex", 24);
        final Person lesha = new Person("lesha", 34);
        final Person dasha = new Person("dasha", 17);

        final Runnable task1 = () -> {
            System.out.println("Sort by name: ");
            Arrays.asList(alex, lesha, dasha)
                    .stream()
                    .sorted(byName)
                    .forEach(System.out::println);
        };

        final Runnable task2 = () -> {
            System.out.println("Sort by age: ");
            Arrays.asList(alex, lesha, dasha)
                    .stream()
                    .sorted(byAge)
                    .forEach(System.out::println);
        };

        task1.run();

        task2.run();


        /** 2. Implement functional interface */
        Supplier<Person> getPerson = ()-> new Person("supplier", 1);
        Predicate<Person> olderThan10 = (p) -> p.getAge() > 10;
        Function<Person, String> getNamePlusAge = (p) -> p.getName() + p.getAge();
        BiConsumer<Person, String> biConsumer = (person, newName) -> person.setName(newName);


        /** 3. Create functional interface */
        final CustomInterface<Person> customInterface = Person::new;

        final CustomInterface<Person> customInterfaceLambda = () -> {
            return new Person("new_lambda_name", 33);
        };

        final CustomInterface<Person> customAnonymousLambda = new CustomInterface<Person>() {
            @Override
            public Person make() {
                return new Person("new_anonymous_name", 33);
            }
        };

        System.out.println(customInterface.make());

        /** 4. Use default method */
        customInterface.sayDefaultHello();

        /** 5. Use static method */
        CustomInterface.sayStaticHello();

        System.out.println(customInterfaceLambda.make());
        System.out.println(customAnonymousLambda.make());




    }
}
