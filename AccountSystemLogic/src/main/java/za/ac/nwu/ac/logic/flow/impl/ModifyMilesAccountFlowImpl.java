package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.MilesAccount;
import za.ac.nwu.ac.logic.flow.ModifyMilesAccountFlow;
import za.ac.nwu.ac.domain.dto.MilesAccountDto;
import za.ac.nwu.ac.translator.MilesAccountTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component
public class ModifyMilesAccountFlowImpl implements ModifyMilesAccountFlow {

    private final MilesAccountTranslator milesAccountTranslator;

    @Autowired
    public ModifyMilesAccountFlowImpl(MilesAccountTranslator milesAccountTranslator) {
        this.milesAccountTranslator = milesAccountTranslator;
    }
//
//    @Override
//    public int addMilesByUsername(String username, Integer miles) {
//        return 0;
//    }
//
//
//    @Override
//    public int subtractMilesByUsername(String username , Integer miles) {
//        return milesAccountTranslator.subtractMilesByUsername(username, miles);
//    }
//
//    @Override
//    public MilesAccountDto addMilesByUsernames(String username, Integer miles) {
//        MilesAccount milesAccount = new MilesAccount();
//
//        milesAccountTranslator.addMilesByUsername(username, miles);
//
//        return milesAccountTranslator.getMilesAccountByUsername(username);
//    }
//
//    @Override
//    public MilesAccountDto subtractMilesByUsernames(String username, Integer miles) {
//        milesAccountTranslator.subtractMilesByUsername(username, miles);
//        return milesAccountTranslator.getMilesAccountByUsername(username);
//    }
//

}