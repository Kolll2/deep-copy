package com.kosh;

import com.kosh.domain.Man;
import com.kosh.service.Cloner;
import org.junit.jupiter.api.*;

import java.util.ArrayList;


class ManTest  {
    private Man man = null;
    private Cloner cloner = new Cloner();
    @BeforeEach
    void setupThis(){
        ArrayList<String> array = new ArrayList<String>();
        array.add("Кисельные берега");
        array.add("Сказки про Чудище");
        array.add("Если бы коровы были флешками");
        man = new Man("Max", 50, array);
    }

    @Tag("DEV")
    @Test
    void testClone()
    {
        Object clone = null;
        try {
            clone = cloner.clone(man);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Man c = (Man) clone;

        Assertions.assertFalse(man == c);
        Assertions.assertEquals( "Max" , c.getName());
        Assertions.assertEquals( 50 , c.getAge());
        Assertions.assertFalse(man.getFavoriteBooks() == c.getFavoriteBooks());
        Assertions.assertEquals( "Кисельные берега" , c.getFavoriteBooks().get(0));
        Assertions.assertEquals( "Сказки про Чудище" , c.getFavoriteBooks().get(1));
        Assertions.assertEquals( "Если бы коровы были флешками" , c.getFavoriteBooks().get(2));
    }
}