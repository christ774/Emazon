package com.pragma.Emazon.infrastructure.configuration;

import com.pragma.Emazon.application.handler.CategoryHandler;
import com.pragma.Emazon.application.handler.ICategoryHandler;
import com.pragma.Emazon.application.mapper.ICategoryRequestMapper;
import com.pragma.Emazon.domain.api.ICategoryServicePort;
import com.pragma.Emazon.domain.spi.ICategoryPersistencePort;
import com.pragma.Emazon.domain.usecase.CategoryUseCase;
import com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.adapter.CategoryAdapter;
import com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.mapper.ICategoryEntityMapper;
import com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;
    //private final ICategoryRequestMapper categoryRequestMapper;

    @Bean
    public ICategoryPersistencePort categoryPersistencePort() {
        return new CategoryAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public ICategoryServicePort categoryServicePort(ICategoryPersistencePort categoryPersistencePort) {
        return new CategoryUseCase(categoryPersistencePort);
    }

    @Bean
    public ICategoryHandler categoryHandler(ICategoryServicePort categoryServicePort, ICategoryRequestMapper categoryRequestMapper) {
        return new CategoryHandler(categoryServicePort, categoryRequestMapper);
    }
}
