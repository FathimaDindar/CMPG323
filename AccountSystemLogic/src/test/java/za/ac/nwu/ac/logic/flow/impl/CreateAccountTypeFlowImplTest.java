package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateAccountTypeFlowImplTest {

    @Mock
    private AccountTypeTranslator translator;

    @InjectMocks
    private CreateAccountTypeFlowImpl flow;

    @Before
    public void setUp() throws Exception {
        translator = Mockito.mock(AccountTypeTranslator.class);
        flow = new CreateAccountTypeFlowImpl(translator);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {

//        when(translator.create(any(AccountTypeDto.class))).thenReturn(null);
//        when(translator.create(eq(new AccountTypeDto()))).thenReturn(new AccountTypeDto());

//        AccountTypeDto result = flow.create(new AccountTypeDto());
//        assertNull(result);
//        assertNotNull(result);
//        verify(translator,atLeastOnce() ).create(any(AccountTypeDto.class));
//        verify(translator,atLeastOnce()).create(eq(new AccountTypeDto()));
//        verify(translator,times(1)).create(eq(null));
//        AccountTypeDto accountTypeDto2 = new AccountTypeDto("mnemonic", "Name", LocalDate.now());

        AccountTypeDto accountTypeDto = new AccountTypeDto("mnemonic", "Name", LocalDate.now());
        when(translator.create(eq(accountTypeDto))).thenReturn(accountTypeDto);
        AccountTypeDto result = flow.create(accountTypeDto);
        assertNotNull(accountTypeDto);
        verify(translator,times(1)).create(eq(accountTypeDto));
    }
}