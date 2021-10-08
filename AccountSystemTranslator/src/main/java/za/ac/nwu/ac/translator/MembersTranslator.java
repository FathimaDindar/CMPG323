package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.MembersDto;
import za.ac.nwu.ac.domain.persistence.Members;

import java.util.List;

public interface MembersTranslator {
    List<MembersDto> getAllMembers();

    MembersDto create(MembersDto members);

    Members getMembersByUsername(String username);
}
