package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.dto.MembersDto;
import za.ac.nwu.ac.domain.persistence.Members;
import za.ac.nwu.ac.translator.AccountTypeTranslator;
import za.ac.nwu.ac.translator.MembersTranslator;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateMembersFlowImplTest {

    @Mock
    private MembersTranslator translator;

    @Mock
    private FetchAccountTypeFlowImpl fetch;

    @InjectMocks
    private CreateMembersFlowImpl flow;

    @Before
    public void setUp() throws Exception {
        translator = Mockito.mock(MembersTranslator.class);
        flow = new CreateMembersFlowImpl(translator,fetch);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() throws Exception{

        MembersDto membersDto = new MembersDto("MILES", "FDindar", "Fathima", "Dindar", 200);
        when(translator.create(eq(membersDto))).thenReturn(membersDto);
        MembersDto result = flow.create(membersDto);
        assertNotNull(membersDto);
        verify(translator,times(1)).create(eq(membersDto));
    }
}