package za.ac.nwu.ac.logic.flow.impl;


import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.dto.MilesAccountDto;
import za.ac.nwu.ac.domain.persistence.MilesAccount;
import za.ac.nwu.ac.logic.flow.CreateMilesAccountFlow;
import za.ac.nwu.ac.translator.AccountTypeTranslator;
import za.ac.nwu.ac.translator.MilesAccountTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createMilesAccountFlowName")
public class CreateMilesAccountFlowImpl implements CreateMilesAccountFlow {

    private final MilesAccountTranslator milesAccountTranslator;

    public CreateMilesAccountFlowImpl(MilesAccountTranslator milesAccountTranslator) {
        this.milesAccountTranslator = milesAccountTranslator;
    }

    @Override
    public MilesAccountDto create(MilesAccountDto milesAccount) {
        return milesAccountTranslator.create(milesAccount);
    }
}
