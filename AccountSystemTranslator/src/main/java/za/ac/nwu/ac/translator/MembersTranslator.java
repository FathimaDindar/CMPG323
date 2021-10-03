package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.MembersDto;

import java.util.List;

public interface MembersTranslator {
    List<MembersDto> getAllMembers();

    MembersDto create(MembersDto members);
}
