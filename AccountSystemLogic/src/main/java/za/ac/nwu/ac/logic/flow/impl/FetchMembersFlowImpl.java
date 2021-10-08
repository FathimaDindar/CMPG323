package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MembersDto;
import za.ac.nwu.ac.domain.persistence.Members;
import za.ac.nwu.ac.logic.flow.FetchMembersFlow;
import za.ac.nwu.ac.translator.MembersTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchMembersFlowImpl implements FetchMembersFlow {

    private final MembersTranslator membersTranslator;

    @Autowired
    public FetchMembersFlowImpl(MembersTranslator membersTranslator){
        this.membersTranslator = membersTranslator;
    }

    @Override
    public List<MembersDto> getAllMembers() {
        return membersTranslator.getAllMembers();
    }

    @Override
    public Members getMembersByUsername(String username) {
        return membersTranslator.getMembersByUsername(username);
    }

}
