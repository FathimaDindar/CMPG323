package za.ac.nwu.ac.logic.flow.impl;


import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.dto.MilesAccountDto;
import za.ac.nwu.ac.domain.persistence.Members;
import za.ac.nwu.ac.domain.persistence.MilesAccount;
import za.ac.nwu.ac.logic.flow.CreateMilesAccountFlow;
import za.ac.nwu.ac.logic.flow.FetchMembersFlow;
import za.ac.nwu.ac.translator.AccountTypeTranslator;
import za.ac.nwu.ac.translator.MilesAccountTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createMilesAccountFlowName")
public class CreateMilesAccountFlowImpl implements CreateMilesAccountFlow {

    private final FetchMembersFlow fetchMembersFlow;
    private final MilesAccountTranslator milesAccountTranslator;

    public CreateMilesAccountFlowImpl(MilesAccountTranslator milesAccountTranslator,
                                      FetchMembersFlow fetchMembersFlow) {
        this.milesAccountTranslator = milesAccountTranslator;
        this.fetchMembersFlow = fetchMembersFlow;
    }

    @Override
    public MilesAccountDto create(MilesAccountDto milesAccountDto) {
        milesAccountDto.setAccountId(null);

        Members member = fetchMembersFlow.getMembersByUsername((
                milesAccountDto.getUsername()));
        MilesAccount milesAccount = milesAccountDto.buildMilesAccount(member);

        MilesAccount createdMilesAccount = milesAccountTranslator.save(milesAccount);

        return new MilesAccountDto(milesAccount);
    }
}
