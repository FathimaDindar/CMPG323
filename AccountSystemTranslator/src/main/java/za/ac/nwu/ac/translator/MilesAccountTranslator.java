package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.MilesAccountDto;
import za.ac.nwu.ac.domain.persistence.MilesAccount;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.List;

public interface MilesAccountTranslator {
    List<MilesAccountDto> getAllMilesAccounts();

    MilesAccount save(MilesAccount milesAccount);

    MilesAccountDto create(MilesAccountDto milesAccount);

    MilesAccountDto getMilesAccountByUsername(String username);

//    MilesAccountDto getMilesAccountByUsername(String username);
//
//    int addMilesByUsername( String username, Integer miles);
//
//    int subtractMilesByUsername(String username, Integer miles);
//
//    MilesAccountDto addMilesByUsernames(String username, Integer miles);
//
//    MilesAccountDto subtractMilesByUsernames(String username, Integer miles);

}
