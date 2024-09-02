package com.pragma.Emazon.infrastructure.configuration;

import com.pragma.Emazon.application.handler.BrandHandler;
import com.pragma.Emazon.application.handler.CategoryHandler;
import com.pragma.Emazon.application.handler.IBrandHandler;
import com.pragma.Emazon.application.handler.ICategoryHandler;
import com.pragma.Emazon.application.mapper.IBrandRequestMapper;
import com.pragma.Emazon.application.mapper.ICategoryRequestMapper;
import com.pragma.Emazon.application.mapper.ICategoryResponseMapper;
import com.pragma.Emazon.domain.api.IBrandServicePort;
import com.pragma.Emazon.domain.api.ICategoryServicePort;
import com.pragma.Emazon.domain.spi.IBrandPersistencePort;
import com.pragma.Emazon.domain.spi.ICategoryPersistencePort;
import com.pragma.Emazon.domain.usecase.BrandUseCase;
import com.pragma.Emazon.domain.usecase.CategoryUseCase;
import com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.adapter.BrandAdapter;
import com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.adapter.CategoryAdapter;
import com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.mapper.IBrandEntityMapper;
import com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.mapper.ICategoryEntityMapper;

import com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.repository.IBrandRepository;
import com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;
    private final IBrandEntityMapper brandEntityMapper;
    private final IBrandRepository brandRepository;



    @Bean
    public ICategoryPersistencePort categoryPersistencePort() {
        return new CategoryAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public ICategoryServicePort categoryServicePort(ICategoryPersistencePort categoryPersistencePort) {
        return new CategoryUseCase(categoryPersistencePort);
    }

    @Bean
    public ICategoryHandler categoryHandler(ICategoryServicePort categoryServicePort, ICategoryRequestMapper categoryRequestMapper,
                                            ICategoryResponseMapper categoryResponseMapper) {
        return new CategoryHandler(categoryServicePort, categoryRequestMapper,categoryResponseMapper);
    }

    @Bean
    public IBrandPersistencePort brandPersistencePort() {
        return new BrandAdapter(brandRepository, brandEntityMapper);
    }
    @Bean
    public IBrandServicePort brandServicePort(IBrandPersistencePort brandPersistencePort) {
        return new BrandUseCase(brandPersistencePort);
    }

    @Bean
    public IBrandHandler brandHandler(IBrandServicePort brandServicePort, IBrandRequestMapper brandRequestMapper) {
        return new BrandHandler(brandServicePort, brandRequestMapper);
    }


}
