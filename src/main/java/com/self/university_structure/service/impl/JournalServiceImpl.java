package com.self.university_structure.service.impl;

import com.self.university_structure.dto.ResponseDto;
import com.self.university_structure.dto.request.JournalRequestDto;
import com.self.university_structure.entity.Journal;
import com.self.university_structure.exception.ResourceNotFoundException;
import com.self.university_structure.repository.GroupRepository;
import com.self.university_structure.repository.JournalRepository;
import com.self.university_structure.service.JournalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JournalServiceImpl implements JournalService {

    private final JournalRepository repository;
    private final GroupRepository groupRepository;

    @Override
    public ResponseDto<Long> create(JournalRequestDto journal) {
        var group = groupRepository.findById(journal.getGroupId());
        if (group.isEmpty())
            throw new ResourceNotFoundException("Group not found");
        Journal journalS = new Journal();
        journalS.setName(journal.getName());
        journalS.setGroup(group.get());
        journalS = repository.save(journalS);
        return new ResponseDto<>(true, 1, "created", journalS.getId());
    }

    @Override
    public ResponseDto<Journal> getById(Long id) {
        var journal = repository.findById(id);
        if (journal.isPresent())
            return new ResponseDto<>(true, 1, "success", journal.get());
        else
            throw new ResourceNotFoundException("Journal not found");
    }

    @Override
    public ResponseDto<Long> update(JournalRequestDto journal) {
        var byId = repository.findById(journal.getId());
        if(byId.isEmpty())
            throw new ResourceNotFoundException("Journal not found");
        var group = groupRepository.findById(journal.getGroupId());
        if (group.isEmpty())
            throw new ResourceNotFoundException("Group not found");

        var journal1 = byId.get();
        journal1.setGroup(group.get());
        journal1.setName(journal.getName());
        repository.save(journal1);
        return new ResponseDto<>(true, 1, "success", journal1.getId());
    }

    @Override
    public ResponseDto<Long> delete(Long id) {
        repository.deleteById(id);
        return new ResponseDto<>(true, 1, "success", id);
    }
}
