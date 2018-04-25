package com.ispectrum.crmclima;

import com.ispectrum.crmclima.areas.clients.entities.Client;
import com.ispectrum.crmclima.areas.clients.models.bindingModels.AddClientModel;
import com.ispectrum.crmclima.areas.clients.models.dtos.ClientDto;
import com.ispectrum.crmclima.areas.clients.repository.ClientRepository;
import com.ispectrum.crmclima.areas.clients.service.ClientService;
import com.ispectrum.crmclima.areas.clients.service.ClientServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static junit.framework.TestCase.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ClientServiceTests {

    @Mock
    private ClientRepository repoMock;

    @InjectMocks
    private ClientServiceImpl clientService;

    @Test
    public void  testAddClient_onAddClient_ShouldBeSavedToDb(){
        AddClientModel newClient = new AddClientModel();
        newClient.setName("mocko");


        this.clientService.addClient(newClient);

        assertEquals("Client not saved to db",
                1,
                this.clientService.getAllClients().size());
    }
}
