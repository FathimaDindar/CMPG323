package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.dto.MilesAccountDto;
import za.ac.nwu.ac.domain.persistence.MilesAccount;

public interface CreateMilesAccountFlow {
    MilesAccountDto create(MilesAccountDto milesAccount);
}
