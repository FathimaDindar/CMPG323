package za.ac.nwu.ac.logic.flow.impl;


import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MembersDto;
import za.ac.nwu.ac.logic.flow.CreateMembersFlow;
import za.ac.nwu.ac.translator.MembersTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createMembersFlowName")
public class CreateMembersFlowImpl implements CreateMembersFlow {

    private final MembersTranslator membersTranslator;

    public CreateMembersFlowImpl(MembersTranslator membersTranslator) {
        this.membersTranslator = membersTranslator;
    }

    @Override
    public MembersDto create(MembersDto members) {
        return membersTranslator.create(members);
    }
}
