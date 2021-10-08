package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class FetchAccountTypeFlowImplTest {

    @Mock
    private AccountTypeTranslator translator;

    @InjectMocks
    private FetchAccountTypeFlowImpl flow;

    @Before
    public void setUp() throws Exception {
        translator = Mockito.mock(AccountTypeTranslator.class);
        flow = new FetchAccountTypeFlowImpl(translator);
    }

    @After
    public void tearDown() throws Exception{
    }

    @Test
    public void getAllAccountTypes() throws Exception{
    }


}