package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.MembersDto;

import java.util.List;

public interface FetchMembersFlow {
    List<MembersDto> getAllMembers();
}
