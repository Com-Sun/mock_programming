package com.nhnacademy.temp;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class JsonDiscountPolicyRepository implements DiscountPolicyRepository {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void insert(DiscountPolicy source) {
        Path path = getPath(source.getCode());
        try {
            objectMapper.writeValue(path.toFile(), source);
        } catch (IOException e) {
            throw new RepositoryFailException("Failed save json " + source + ":" + path, e);
        }
    }

    @Override
    public DiscountPolicy findByCode(String code) {
        Path path = getPath(code);
        try {
            return objectMapper.readValue(path.toFile(), DiscountPolicy.class);
        } catch (IOException e) {
            throw new RepositoryFailException("Failed load json " + path, e);
        }
    }

    private Path getPath(String code) {
        return Paths.get("src", "main", "resources", code);
    }

    @Override
    public List<Discountable> findByCodes(List<String> codes) {
        return null;
    }

    @Override
    public void deleteByCode(String code) {
        try {
            Files.deleteIfExists(getPath(code));
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
