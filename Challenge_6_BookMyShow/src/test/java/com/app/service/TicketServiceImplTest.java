package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.app.repository.ShowRepository;
import com.app.repository.ShowSeatRepository;
import com.app.repository.TicketRepository;
import com.app.repository.UserRepository;

@SpringBootTest
public class TicketServiceImplTest {

	@MockBean
    private UserRepository userRepository;
    @MockBean
    private ShowRepository showRepository;
    @MockBean
    private ShowSeatRepository showSeatRepository;
    @MockBean
    private TicketRepository ticketRepository;
    @Autowired
    private TicketService ticketService;
}
