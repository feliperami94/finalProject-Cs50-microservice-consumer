package com.santiagoposadag.cs50.receiverconsumer.usecases;

import com.santiagoposadag.cs50.receiverconsumer.dto.UserDto;
import com.santiagoposadag.cs50.receiverconsumer.helpers.CryptoCurrencyMappers;
import com.santiagoposadag.cs50.receiverconsumer.repository.UserActionRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class GetAllUserActionsFromUserUseCase {

    private final UserActionRepository repository;
    private final CryptoCurrencyMappers mapper;

    public GetAllUserActionsFromUserUseCase(UserActionRepository repository, CryptoCurrencyMappers mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Flux<UserDto> apply() {
        return repository.findAll()
                .map(mapper.fromUserToDto());
    }
}
