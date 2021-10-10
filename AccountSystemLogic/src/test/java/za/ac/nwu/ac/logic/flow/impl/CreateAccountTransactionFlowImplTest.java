package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.persistence.Members;
import za.ac.nwu.ac.logic.flow.FetchAccountTransactionFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.FetchMembersFlow;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import javax.persistence.SequenceGenerator;
import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateAccountTransactionFlowImplTest {

    @Mock
    private AccountTransactionTranslator translator;

    @Mock
    private FetchAccountTypeFlow fetchType;

    @Mock
    private FetchMembersFlow fetchMembers;

    @InjectMocks
    private CreateAccountTransactionFlowImpl flow;

    @Before
    public void setUp() throws Exception {
        translator = Mockito.mock(AccountTransactionTranslator.class);
        flow = new CreateAccountTransactionFlowImpl(translator,fetchType,fetchMembers);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() throws Exception{

        AccountTransactionDto accountTransactionDto = new AccountTransactionDto(null,"MILES","FDindar",200,LocalDate.now(),"add/subtract");
        AccountType accountType = fetchType.getAccountTypeDbByMnemonic((
                accountTransactionDto.getAccountTypeMnemonic()));
//        Members member = fetchMembers.getMembersDbByUsername((accountTransactionDto.getUsername()));
//        AccountTransaction accountTransaction = accountTransactionDto.buildAccountTransaction(accountType,member);
//        AccountTransaction createdAccountTransaction = translator.save(accountTransaction);
//        AccountTransactionDto created = new AccountTransactionDto(createdAccountTransaction);
//        when(translator.create(eq(accountTransactionDto))).thenReturn(created);
//        AccountTransactionDto result = flow.create((created));
//        verify(translator,times(1)).create(eq((created)));
       }
}