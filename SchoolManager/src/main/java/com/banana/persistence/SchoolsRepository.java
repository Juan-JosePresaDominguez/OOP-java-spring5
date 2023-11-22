package com.banana.persistence;

import com.banana.models.School;

import java.util.HashSet;
import java.util.Set;

public class SchoolsRepository {
    //SET(conjunto): no permite duplicados ni tiene un orden específico.
    private Set<School> escuelas = new HashSet<>();

    public SchoolsRepository() {
        escuelas.add(new School(1L, "Mariposa"));
    }
}
