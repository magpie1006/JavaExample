package net.woniper.learning.assertj;

import java.util.List;

/**
 * Created by woniper on 2016. 12. 5..
 */
public class Foo {
    private String foo;
    private String bar;
    private List<Integer> numbers;

    public Foo() {}

    public Foo(String foo, String bar, List<Integer> numbers) {
        setFoo(foo);
        setBar(bar);
        setNumbers(numbers);
    }

    public String getFoo() {
        return foo;
    }

    public Foo setFoo(String foo) {
        this.foo = foo;
        return this;
    }

    public String getBar() {
        return bar;
    }

    public Foo setBar(String bar) {
        this.bar = bar;
        return this;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Foo setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
        return this;
    }
}
