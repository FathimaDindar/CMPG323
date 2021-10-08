package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.dto.MilesAccountDto;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.persistence.MilesAccount;
import za.ac.nwu.ac.repo.persistence.MilesAccountRepository;
import za.ac.nwu.ac.translator.MilesAccountTranslator;

import java.time.LocalDate;
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
    public MilesAccount save(MilesAccount milesAccount) {
        {
            try{
                return milesAccountRepository.save(milesAccount);
            }catch (Exception e){
                throw new RuntimeException("Unable to save to the DB", e);
            }
        }
    }

    @Override
    public MilesAccountDto create(MilesAccountDto milesAccountDto){
//        try{
//            MilesAccount milesAccount = milesAccountRepository.save(milesAccount.getMiles());
//            return new MilesAccountDto(milesAccount);
//        }catch (Exception e){
//            throw new RuntimeException("Unable to save to the DB", e);
//        }
        return null;
    }


    @Override
    public MilesAccountDto getMilesAccountByUsername(String username) {
        try{
                return milesAccountRepository.getMilesAccountByUsername(username);
        }catch(Exception e){
            throw new RuntimeException("Unable to read data from the DB", e);
        }
    }
//
//    @Override
//    public int addMilesByUsername(String username, Integer miles) {
//        try {
//            return milesAccountRepository.addMilesByUsername(username, miles);
//        }catch (Exception e){
//            throw new RuntimeException("Unable to read from the DB", e);
//        }
//    }


//    @Override
//    public int subtractMilesByUsername(String username, Integer miles) {
//        try {
//            return milesAccountRepository.subtractMilesByUsername(username, miles);
//        }catch (Exception e){
//            throw new RuntimeException("Unable to read from the DB", e);
//        }
//    }
//
//    @Override
//    public MilesAccountDto addMilesByUsernames(String username, Integer miles) {
//        try {
//            milesAccountRepository.addMilesByUsername(username, miles);
//            MilesAccount milesAccount = milesAccountRepository.getMilesAccountByUsername(username);
//            return new MilesAccountDto(milesAccount);
//        }catch (Exception e){
//            throw new RuntimeException("Unable to read from the DB", e);
//        }
//    }
//
//    @Override
//    public MilesAccountDto subtractMilesByUsernames(String username, Integer miles) {
//        try {
//            milesAccountRepository.subtractMilesByUsername(username, miles);
//            MilesAccount milesAccount = milesAccountRepository.getMilesAccountByUsername(username);
//            return new MilesAccountDto(milesAccount);
//        }catch (Exception e){
//            throw new RuntimeException("Unable to read from the DB", e);
//        }
//    }


}
