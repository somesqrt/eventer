package com.example.eventer.services.impl;

import com.example.eventer.entity.Sequence;
import com.example.eventer.repos.SequenceRepository;
import com.example.eventer.services.services.IdGeneratorService;
import org.springframework.stereotype.Service;

@Service
public class IdGeneratorServiceImpl implements IdGeneratorService {
    private final SequenceRepository sequenceRepository;

    public IdGeneratorServiceImpl(SequenceRepository sequenceRepository) {
        this.sequenceRepository = sequenceRepository;
    }

    @Override
    public long generateNextId(String sequenceName) {
        Sequence sequence = sequenceRepository.findById(sequenceName)
                .orElse(new Sequence(sequenceName, 0));

        long nextId = sequence.getSeq() + 1;
        sequence.setSeq(nextId);
        sequenceRepository.save(sequence);

        return nextId;
    }

    public long giveNextId(String sequenceName){
        Sequence sequence = sequenceRepository.findById(sequenceName)
                .orElse(new Sequence(sequenceName, 0));

        long nextId = sequence.getSeq() + 1;
        sequence.setSeq(nextId);

        return nextId;
    }

}