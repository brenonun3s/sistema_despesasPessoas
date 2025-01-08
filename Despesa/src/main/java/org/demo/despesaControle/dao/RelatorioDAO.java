package org.demo.despesaControle.dao;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RelatorioDAO {

        private static final String PERSISTENCE_UNIT_NAME = "despesasPUSQLite"; // Nome da unidade de persistência
        private final EntityManagerFactory emf;

        public RelatorioDAO() {
                this.emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }

}
