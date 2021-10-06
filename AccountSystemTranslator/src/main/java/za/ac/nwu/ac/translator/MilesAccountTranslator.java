package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.MilesAccountDto;

import java.util.List;

public interface MilesAccountTranslator {
    List<MilesAccountDto> getAllMilesAccounts();

    MilesAccountDto create(MilesAccountDto milesAccount);

    MilesAccountDto getMilesAccountByUsername(String username);

    int addMilesByUsername(Integer miles, String username);

    int subtractMilesByUsername(Integer miles, String username);
}
