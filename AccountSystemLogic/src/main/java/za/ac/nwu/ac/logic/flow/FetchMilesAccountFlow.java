package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.MilesAccountDto;

import java.util.List;

public interface FetchMilesAccountFlow {
    List<MilesAccountDto> getAllMilesAccounts();

    MilesAccountDto getMilesAccountByUsername(String username);

    int addMilesByUsername(Integer miles, String username);

    int subtractMilesByUsername(Integer miles, String username);
}
