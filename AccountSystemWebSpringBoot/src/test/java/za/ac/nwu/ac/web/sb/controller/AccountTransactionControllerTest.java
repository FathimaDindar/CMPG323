package za.ac.nwu.ac.web.sb.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTransactionFlow;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountTransactionControllerTest {

    private static final String APP_URL = "/account-system/mvc";
    private static final String ACCOUNT_TRANSACTION_CONTROLLER_URL = APP_URL + "/account-transaction";

    @Mock
    private FetchAccountTransactionFlow fetchAccountTransactionFlow;

    @Mock
    private CreateAccountTransactionFlow createAccountTransactionFlow;


    @InjectMocks
    private AccountTransactionController controller;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void getAll() throws Exception {
        String expectedResponse = "{\"successful\":true,\"payload\":[" +
                "{\"transactionId\":null,\"accountTypeMnemonic\":\"MILES\",\"username\":\"FDindar\",\"amount\":200,\"transactionDate\":null,\"details\":\"Details of the transaction\"}," +
                "{\"transactionId\":null,\"accountTypeMnemonic\":\"MILES\",\"username\":\"TDindar\",\"amount\":400,\"transactionDate\":null,\"details\":\"Details of the transaction\"}]}";
        List<AccountTransactionDto> accountTransactions = new ArrayList<>();
        accountTransactions.add(new AccountTransactionDto(null, "MILES", "FDindar", 200, null, "Details of the transaction"));
        accountTransactions.add(new AccountTransactionDto(null, "MILES", "TDindar", 400, null, "Details of the transaction"));
        when(fetchAccountTransactionFlow.getAllAccountTransactions()).thenReturn(accountTransactions);
        MvcResult mvcResult = mockMvc.perform(get((String.format("%s/%s",
                        ACCOUNT_TRANSACTION_CONTROLLER_URL, "all")))
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        verify(fetchAccountTransactionFlow, times(1)).getAllAccountTransactions();
        assertEquals(expectedResponse,
                mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void create() throws Exception {
        String accountTransactionToBeCreated =
                "{\"transactionId\":null,\"accountTypeMnemonic\":\"MILES\",\"username\":\"TDindar\",\"amount\":400,\"transactionDate\":null,\"details\":\"Details of the transaction\"}]}";
        String expectedResponse = "{\"successful\":true,\"payload\":" +
                "{\"transactionId\":null,\"accountTypeMnemonic\":\"MILES\",\"username\":\"TDindar\",\"amount\":400,\"transactionDate\":null,\"details\":\"Details of the transaction\"}}";

        AccountTransactionDto accountTransaction = new AccountTransactionDto(null, "MILES", "TDindar", 400, null, "Details of the transaction");

        when(createAccountTransactionFlow.create(eq(accountTransaction))).then(returnsFirstArg());
        MvcResult mvcResult =
                mockMvc.perform(post(ACCOUNT_TRANSACTION_CONTROLLER_URL)
                                .servletPath(APP_URL)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(accountTransactionToBeCreated)
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isCreated())
                        .andReturn();
        verify(createAccountTransactionFlow, times(1)).create(eq(accountTransaction));
        assertEquals(expectedResponse,
                mvcResult.getResponse().getContentAsString());
    }


    @Test
    public void getById() {
    }
}