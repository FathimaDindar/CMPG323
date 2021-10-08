package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.MembersDto;
import za.ac.nwu.ac.domain.persistence.Members;

import java.util.List;

public interface FetchMembersFlow {
    List<MembersDto> getAllMembers();

    Members getMembersByUsername(String username);
}
