package za.ac.nwu.ac.logic.flow.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MembersDto;
import za.ac.nwu.ac.domain.dto.MembersDto;
import za.ac.nwu.ac.domain.persistence.Members;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.persistence.Members;
import za.ac.nwu.ac.logic.flow.CreateMembersFlow;
import za.ac.nwu.ac.translator.AccountTypeTranslator;
import za.ac.nwu.ac.translator.MembersTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Objects;

@Transactional
@Component("createMembersFlowName")
public class CreateMembersFlowImpl implements CreateMembersFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateMembersFlowImpl.class);

    private final MembersTranslator membersTranslator;
    private final FetchAccountTypeFlowImpl fetchAccountTypeFlow;

    public CreateMembersFlowImpl(MembersTranslator membersTranslator,
                                FetchAccountTypeFlowImpl fetchAccountTypeFlow)
    {
        this.membersTranslator = membersTranslator;
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
    }

    @Override
    public MembersDto create(MembersDto membersDto){
        LOGGER.info("The input object was {} ", membersDto);

        AccountType accountType = fetchAccountTypeFlow.getAccountTypeDbByMnemonic((
                membersDto.getMnemonic()));
        LOGGER.info("Got AccountType for {} ", membersDto.getMnemonic());

        Members members = membersDto.buildMember(accountType);

        Members createdMembers = membersTranslator.save(members);

        MembersDto results = new MembersDto(createdMembers);
        LOGGER.info("The return object id {}", results);
        return results;
    }
}
