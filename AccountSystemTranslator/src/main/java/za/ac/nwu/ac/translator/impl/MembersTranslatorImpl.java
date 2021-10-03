package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MembersDto;
import za.ac.nwu.ac.domain.persistence.Members;
import za.ac.nwu.ac.repo.persistence.MembersRepository;
import za.ac.nwu.ac.translator.MembersTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class MembersTranslatorImpl implements MembersTranslator {

    private final MembersRepository membersRepository;

    @Autowired
    public MembersTranslatorImpl(MembersRepository membersRepository) {
        this.membersRepository = membersRepository;
    }

    @Override
    public List<MembersDto> getAllMembers() {
        List<MembersDto> membersDtos = new ArrayList<>();
        try {
            for (Members members : membersRepository.findAll()) {
                membersDtos.add(new MembersDto((members)));
            }
        } catch (Exception e) {
            // TODO: log
            throw new RuntimeException("Unable to read from the DB", e);
        }

        return membersDtos;
    }

    @Override
    public MembersDto create(MembersDto membersDto){
        try{
            Members members = membersRepository.save(membersDto.getMembers());
            return new MembersDto(members);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }
}
