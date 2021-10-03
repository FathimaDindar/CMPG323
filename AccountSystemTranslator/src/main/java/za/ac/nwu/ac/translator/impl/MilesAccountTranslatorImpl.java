package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MilesAccountDto;
import za.ac.nwu.ac.domain.persistence.MilesAccount;
import za.ac.nwu.ac.repo.persistence.MilesAccountRepository;
import za.ac.nwu.ac.translator.MilesAccountTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class MilesAccountTranslatorImpl implements MilesAccountTranslator {

    private final MilesAccountRepository milesAccountRepository;

    @Autowired
    public MilesAccountTranslatorImpl(MilesAccountRepository milesAccountRepository) {
        this.milesAccountRepository = milesAccountRepository;
    }

    @Override
    public List<MilesAccountDto> getAllMilesAccounts() {
        List<MilesAccountDto> milesAccountDtos = new ArrayList<>();
        try {
            for (MilesAccount milesAccount : milesAccountRepository.findAll()) {
                milesAccountDtos.add(new MilesAccountDto((milesAccount)));
            }
        } catch (Exception e) {
            // TODO: log
            throw new RuntimeException("Unable to read from the DB", e);
        }

        return milesAccountDtos;
    }

    @Override
    public MilesAccountDto create(MilesAccountDto milesAccountDto){
        try{
            MilesAccount milesAccount = milesAccountRepository.save(milesAccountDto.getMilesAccount());
            return new MilesAccountDto(milesAccount);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }
}
