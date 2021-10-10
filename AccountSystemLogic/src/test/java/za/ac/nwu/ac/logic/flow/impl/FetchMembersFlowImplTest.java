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
import za.ac.nwu.ac.translator.AccountTransactionTranslator;
import za.ac.nwu.ac.translator.AccountTypeTranslator;
import za.ac.nwu.ac.translator.MembersTranslator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class FetchMembersFlowImplTest {

    @Mock
    private MembersTranslator translator;

    @InjectMocks
    private FetchMembersFlowImpl flow;

    @Before
    public void setUp() throws Exception {
        translator = Mockito.mock(MembersTranslator.class);
        flow = new FetchMembersFlowImpl(translator);
    }

    @After
    public void tearDown() throws Exception{
    }

    @Test
    public void getAllMembers() throws Exception{
        List<MembersDto> accountType = new ArrayList<>();
        MembersDto accountTypeDto = new MembersDto("MILES", "FDindar", "Fathima", "Dindar", 200);
        MembersDto accountTypeDtos = new MembersDto("MILES", "TDindar", "Talha", "Dindar", 400);
        accountType.add(accountTypeDto);
        accountType.add(accountTypeDtos);
        when(translator.getAllMembers()).thenReturn(accountType);
        List<MembersDto> result = flow.getAllMembers();
        assertNotNull(accountTypeDto);
        verify(translator,times(1)).getAllMembers();
    }

    @Test
    public void getMembersByUsername() throws Exception{
        MembersDto memberDto = new MembersDto("MILES", "FDindar", "Fathima", "Dindar", 200);
        MembersDto memberDtos = new MembersDto("MILES", "TDindar", "Talha", "Dindar", 400);
        
        when(translator.getMembersByUsername(memberDto.getUsername())).thenReturn(memberDto);
        MembersDto result = flow.getMembersByUsername(memberDto.getUsername());
        assertNotNull(memberDto);
        verify(translator,times(1)).getMembersByUsername(memberDto.getUsername());
    }
}