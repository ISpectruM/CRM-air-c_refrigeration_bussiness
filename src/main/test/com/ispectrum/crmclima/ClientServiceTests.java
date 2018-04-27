package com.ispectrum.crmclima;

import com.ispectrum.crmclima.areas.clients.entities.Client;
import com.ispectrum.crmclima.areas.clients.models.bindingModels.AddClientModel;
import com.ispectrum.crmclima.areas.clients.repository.ClientRepository;
import com.ispectrum.crmclima.areas.clients.service.ClientServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ClientServiceTests {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    private AddClientModel testModel;

    @Before
    public void setUp(){
        this.testModel = new AddClientModel();
        this.testModel.setName("Mocko");
        this.testModel.setAddress("Strasse str. ");
        this.testModel.setCity("Honolulu");
        this.testModel.setEmail("asd@gmail.com");
        this.testModel.setPhone("555-555");

        when(this.clientRepository.save(any()))
                .thenAnswer(a -> a.getArgument(0));
    }

//Test add client method
    @Test
    public void testAddClient_WithValidClient_ShouldNotReturnNull(){
        Client client = this.clientService.addClient(this.testModel);
        Assert.assertNotEquals("Client is null after creation.",null,client);
    }

    @Test
    public void testAddClient_WithValidClient_ShouldBeMappedCorrectly(){
        Client client = this.clientService.addClient(this.testModel);

        Assert.assertEquals("Client name not mapped correctly",
                this.testModel.getName(), client.getName());
        Assert.assertEquals("Client city not mapped correctly",
                this.testModel.getCity(), client.getCity());
        Assert.assertEquals("Client address not mapped correctly",
                this.testModel.getAddress(), client.getAddress());
        Assert.assertEquals("Client email not mapped correctly",
                this.testModel.getEmail(), client.getEmail());
        Assert.assertEquals("Client phone not mapped correctly",
                this.testModel.getPhone(), client.getPhone());
    }

//Test get all clients method
    @Test
    public void testGetAllClients_WithClients_ShouldNotReturnNull(){

    }
}
