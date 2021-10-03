package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.MembersDto;

public interface CreateMembersFlow {
    MembersDto create(MembersDto members);
}
