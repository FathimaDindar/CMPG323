package za.ac.nwu.ac.web.sb.controller;

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
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.dto.MembersDto;
import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.CreateMembersFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.FetchMembersFlow;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MembersControllerTest {

    private static final String APP_URL = "/account-system/mvc";
    private static final String MEMBERS_CONTROLLER_URL = APP_URL + "/member";

    @Mock
    private FetchMembersFlow fetchMembersFlow;

    @Mock
    private CreateMembersFlow createMembersFlow;

    @InjectMocks
    private MembersController controller;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAll() throws Exception {
        String expectedResponse = "{\"successful\":true,\"payload\":[" +
                "{\"username\":\"FDindar\",\"name\":\"Fathima\",\"surname\":\"Dindar\", \"miles\":200}," +
                "{\"username\":\"TDindar\",\"name\":\"Talha\",\"surname\":\"Dindar\", \"miles\":200}]}";
        List<MembersDto> members = new ArrayList<>();
        members.add(new MembersDto("FDindar", "Fathima", "Dindar",200));
        members.add(new MembersDto("TDindar", "Talha", "Dindar",200));
        when(fetchMembersFlow.getAllMembers()).thenReturn(members);
        MvcResult mvcResult = mockMvc.perform(get((String.format("%s/%s",
                        MEMBERS_CONTROLLER_URL, "all")))
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        verify(fetchMembersFlow, times(1)).getAllMembers();
        assertEquals(expectedResponse,
                mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void create() throws Exception{
        String accountTypeToBeCreated =
                "{\"username\":\"FDindar\",\"name\":\"Fathima\",\"surname\":\"Dindar\", \"miles\":200}";
        String expectedResponse = "{\"successful\":true,\"payload\":" +
                "{\"username\":\"FDindar\",\"name\":\"Fathima\",\"surname\":\"Dindar\", \"miles\":200}}";

        MembersDto members = new MembersDto("FDindar", "Fathima", "Dindar", 200);

        when(createMembersFlow.create(eq(members))).then(returnsFirstArg());
        MvcResult mvcResult =
                mockMvc.perform(post(MEMBERS_CONTROLLER_URL)
                                .servletPath(APP_URL)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(accountTypeToBeCreated)
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isCreated())
                        .andReturn();
        verify(createMembersFlow, times(1)).create(eq(members));
        assertEquals(expectedResponse,
                mvcResult.getResponse().getContentAsString());
    }
}