package net.woniper.learning.assertj.test;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created by woniper on 2016. 12. 5..
 * http://joel-costigliola.github.io/assertj/index.html
 * http://joel-costigliola.github.io/assertj/assertj-core.html
 */
public class AssertjTest {

    private String foo;
    private String bar;

    @Before
    public void setUp() throws Exception {
        foo = "foo";
        bar = "foo";
    }

    @Test
    public void badUsage() throws Exception {
        assertThat(foo.equals(bar));
    }

    @Test
    public void doThis() throws Exception {
        assertThat(foo).isEqualTo(bar);
        assertThat(foo).isNotEqualTo("bar");
        assertThat(foo).isNotBlank();
        assertThat(foo).isNotEmpty();
        assertThat(foo).startsWith("fo")
                .endsWith("oo")
                .isEqualToIgnoringCase("FOO");

        assertThat(foo).hasSize(3)
                .contains("f", "o", "o")
                .doesNotContain("b");
    }

    @Test
    public void testThrownExceptionMessage() throws Exception {
        RuntimeException exception = new RuntimeException("hi assertj");

        assertThatThrownBy(() -> { throw exception; }).hasMessage("hi assertj");
        assertThat(exception).hasMessage("hi assertj");
        assertThat(exception).hasMessageContaining("hi");
    }

    @Test
    public void orThis() throws Exception {
        assertThat(foo.equals(bar)).isTrue();
        assertThat(foo.equals("bar")).isFalse();
    }
}
