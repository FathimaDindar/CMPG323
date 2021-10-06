package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MilesAccountDto;
import za.ac.nwu.ac.logic.flow.FetchMilesAccountFlow;
import za.ac.nwu.ac.translator.MilesAccountTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchMilesAccountFlowImpl implements FetchMilesAccountFlow {

    private final MilesAccountTranslator milesAccountTranslator;

    @Autowired
    public FetchMilesAccountFlowImpl(MilesAccountTranslator milesAccountTranslator){
        this.milesAccountTranslator = milesAccountTranslator;
    }

    @Override
    public List<MilesAccountDto> getAllMilesAccounts() {
        return milesAccountTranslator.getAllMilesAccounts();
    }

    @Override
    public MilesAccountDto getMilesAccountByUsername(String username) {
        return milesAccountTranslator.getMilesAccountByUsername(username);
    }

    @Override
    public int addMilesByUsername(Integer miles, String username) {
        return milesAccountTranslator.addMilesByUsername(miles, username);
    }

    @Override
    public int subtractMilesByUsername(Integer miles, String username) {
        return milesAccountTranslator.subtractMilesByUsername(miles, username);
    }

}
