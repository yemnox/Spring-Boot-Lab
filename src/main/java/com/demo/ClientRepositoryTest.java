package com.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
public class ClientRepositoryTest {

    @Autowired
    ClientRepository repository ;
    @Test
    public void testRepository(){

        Client Client =new Client();
        Client.setNom("Tom");
        Client.setAge(40);

        repository.save(Client);

        assertEquals(1,repository.findAll().size()) ; //confirm save

        Client loadedClient = repository.findById(Client.getId()).get();
        assertEquals("Tom",loadedClient.getNom());
        assertEquals(40,loadedClient.getAge());

        Client.setNom("Peter"); //change the name
        repository.save(Client);

        Client updatedClient = repository.findById(Client.getId()).get();
        assertEquals("Peter",updatedClient.getNom()); //check name update
        assertEquals(40,updatedClient.getAge()); // check age  change

        repository.delete(Client);
        assertEquals(0,repository.findAll().size()); // confirm deletion

    }

}
