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
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
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
        List<AccountTypeDto> accountType = new ArrayList<>();
        AccountTypeDto accountTypeDto = new AccountTypeDto("mnemonic", "Name", LocalDate.now());
        AccountTypeDto accountTypeDtos = new AccountTypeDto("MILES", "FDindar", LocalDate.now().plusDays(2));
        accountType.add(accountTypeDto);
        accountType.add(accountTypeDtos);
        when(translator.getAllAccountTypes()).thenReturn(accountType);
        List<AccountTypeDto> result = flow.getAllAccountTypes();
        assertNotNull(accountTypeDto);
        verify(translator,times(1)).getAllAccountTypes();
    }

    @Test
    public void getAccountTypeByMnemonic() throws Exception{
        AccountTypeDto accountTypeDto = new AccountTypeDto("mnemonic", "Name", LocalDate.now());
        AccountTypeDto accountTypeDtos = new AccountTypeDto("MILES", "FDindar", LocalDate.now().plusDays(2));

        when(translator.getAccountTypeByMnemonic(accountTypeDto.getMnemonic())).thenReturn(accountTypeDto);
        AccountTypeDto result = flow.getAccountTypeByMnemonic(accountTypeDto.getMnemonic());
        assertNotNull(accountTypeDto);
        verify(translator,times(1)).getAccountTypeByMnemonic(accountTypeDto.getMnemonic());
    }

    @Test
    public void getAccountTypeDbByMnemonic() throws Exception{
        AccountType accountType = new AccountType("mnemonic", "Name", LocalDate.now());
        AccountType accountTypes = new AccountType("MILES", "FDindar", LocalDate.now().plusDays(2));

        when(translator.getAccountTypeDbByMnemonic(accountType.getMnemonic())).thenReturn(accountType);
        AccountType result = flow.getAccountTypeDbByMnemonic(accountType.getMnemonic());
        assertNotNull(accountType);
        verify(translator,times(1)).getAccountTypeDbByMnemonic(accountType.getMnemonic());
    }

}