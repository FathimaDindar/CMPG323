package za.ac.nwu.ac.web.sb.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import za.ac.nwu.ac.domain.dto.MilesAccountDto;
import za.ac.nwu.ac.logic.flow.CreateMilesAccountFlow;
import za.ac.nwu.ac.logic.flow.FetchMilesAccountFlow;
import za.ac.nwu.ac.logic.flow.ModifyMilesAccountFlow;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MilesAccountControllerTest {

    private static final String APP_URL = "/account-system/mvc";
    private static final String MILES_ACCOUNT_CONTROLLER_URL = APP_URL + "/miles-account";

    @Mock
    private FetchMilesAccountFlow fetchMilesAccountFlow;

    @Mock
    private CreateMilesAccountFlow createMilesAccountFlow;

    @Mock
    private ModifyMilesAccountFlow modifyMilesAccountFlow;

    @InjectMocks
    private MilesAccountController controller;

    private MockMvc mockMvc;
    
    @Before
    public void setUp() throws Exception {
            mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

    }

    @After
    public void tearDown() throws Exception {
    }

    @Ignore
    @Test
    public void getAll() throws Exception {
        String expectedResponse = "{\"successful\":true,\"payload\":[" +
                "{\"accountId\"null,\"username\":\"FDindar\",\"miles\":200}," +
                "{\"accountId\"null,\"username\":\"TDindar\",\"miles\":300}]}";
        List<MilesAccountDto> milesAccounts = new ArrayList<>();
        milesAccounts.add(new MilesAccountDto(null,"FDindar", 200));
        milesAccounts.add(new MilesAccountDto(null,"TDindar", 300));
        when(fetchMilesAccountFlow.getAllMilesAccounts()).thenReturn(milesAccounts);
        MvcResult mvcResult = mockMvc.perform(get((String.format("%s/%s",
                        MILES_ACCOUNT_CONTROLLER_URL, "all")))
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        verify(fetchMilesAccountFlow, times(1)).getAllMilesAccounts();
        assertEquals(expectedResponse,
                mvcResult.getResponse().getContentAsString());
    }

    @Ignore
    @Test
    public void create() throws Exception{
        String milesAccountToBeCreated =
                "{\"accountId\"null,\"username\":\"FDindar\",\"miles\":200},";
        String expectedResponse = "{\"successful\":true,\"payload\":" +
                "{\"accountId\"null,\"username\":\"FDindar\",\"miles\":200}}";

        MilesAccountDto milesAccount = new MilesAccountDto(null,"FDindar", 200);

        when(createMilesAccountFlow.create(eq(milesAccount))).then(returnsFirstArg());
        MvcResult mvcResult =
                mockMvc.perform(post(MILES_ACCOUNT_CONTROLLER_URL)
                                .servletPath(APP_URL)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(milesAccountToBeCreated)
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isCreated())
                        .andReturn();
        verify(createMilesAccountFlow, times(1)).create(eq(milesAccount));
        assertEquals(expectedResponse,
                mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void addMilesByUsernames() throws Exception{
//        String expectedResponse = "{\"successful\":true,\"payload\":" +
//                "{\"username\":\"FDindar\",\"miles\":400,\"milesAddedDate\":null}}";
//        MilesAccountDto milesAccount = new MilesAccountDto("FDindar", 200, null);
//
//        when(modifyMilesAccountFlow.addMilesByUsernames(anyString(),anyInt(),isNull())).thenReturn(milesAccount);
//        MvcResult mvcResult = mockMvc.perform(put((String.format("%s/%s",
//            MILES_ACCOUNT_CONTROLLER_URL, "Add Miles to the specified account")))
//                                .servletPath(APP_URL)
//                                .accept(MediaType.APPLICATION_JSON)
//                                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andReturn();
//        verify(modifyMilesAccountFlow, times(1)).addMilesByUsernames(eq("FDindar"),
//                eq(200), eq(null));
//        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void subtractMilesByUsername() throws Exception{
    }
}