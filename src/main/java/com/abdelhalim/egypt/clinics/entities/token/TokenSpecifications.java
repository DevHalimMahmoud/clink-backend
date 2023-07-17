package com.abdelhalim.egypt.clinics.entities.token;


import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class TokenSpecifications {

    private TokenSpecifications() {
        // hide constructor
    }

    public static Specification<Token> validTokensByUserId(Long userId) {
        return (root, query, criteriaBuilder) -> {
            Predicate idPredicate = criteriaBuilder.equal(root.get("baseUser").get("id"), userId);
            Predicate expiredPredicate = criteriaBuilder.isFalse(root.get("expired"));
            Predicate revokedPredicate = criteriaBuilder.isFalse(root.get("revoked"));

            return criteriaBuilder.and(idPredicate, criteriaBuilder.or(expiredPredicate, revokedPredicate));
        };
    }
}
