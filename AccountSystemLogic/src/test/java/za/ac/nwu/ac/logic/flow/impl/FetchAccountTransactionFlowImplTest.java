package za.ac.nwu.ac.logic.flow.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class FetchAccountTransactionFlowImplTest {
    
    @Mock
    private AccountTransactionTranslator translator;

    @InjectMocks
    private FetchAccountTransactionFlowImpl flow;

    @Before
    public void setUp() throws Exception {
        translator = Mockito.mock(AccountTransactionTranslator.class);
        flow = new FetchAccountTransactionFlowImpl(translator);
    }

    @After
    public void tearDown() throws Exception{
    }

    @JsonIgnore
    @Test
    public void getAllAccountTransactions() throws Exception{
        List<AccountTransactionDto> accountTransaction = new ArrayList<>();
        AccountTransactionDto accountTransactionDto = new AccountTransactionDto(null,"MILES","FDindar",200,LocalDate.now(),"add/subtract");
        AccountTransactionDto accountTransactionDtos = new AccountTransactionDto(null,"MILES","FDindar",200,LocalDate.now(),"add/subtract");

        accountTransaction.add(accountTransactionDto);

        when(translator.getAllAccountTransactions()).thenReturn(accountTransaction);
        List<AccountTransactionDto> result = flow.getAllAccountTransactions();
        assertNotNull(accountTransaction);
        verify(translator,times(1)).getAllAccountTransactions();
    }

    @Test
    public void getAccountTypeByMnemonic() throws Exception{
//        AccountTypeDto accountTypeDto = new AccountTypeDto("mnemonic", "Name", LocalDate.now());
//        AccountTypeDto accountTypeDtos = new AccountTypeDto("MILES", "FDindar", LocalDate.now().plusDays(2));
//
//        when(translator.getAccountTypeByMnemonic(accountTypeDto.getMnemonic())).thenReturn(accountTypeDto);
//        AccountTypeDto result = flow.getAccountTypeByMnemonic(accountTypeDto.getMnemonic());
//        assertNotNull(accountTypeDto);
//        verify(translator,times(1)).getAccountTypeByMnemonic(accountTypeDto.getMnemonic());
    }

}