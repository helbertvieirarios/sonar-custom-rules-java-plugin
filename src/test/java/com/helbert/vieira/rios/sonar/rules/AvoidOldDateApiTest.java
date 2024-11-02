package com.helbert.vieira.rios.sonar.rules;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sonar.java.checks.verifier.CheckVerifier;

@ExtendWith(MockitoExtension.class)
class AvoidOldDateApiTest {

    @InjectMocks
    private AvoidOldDateApi check;


    @Test
    void testOldDateApiUsage() {
        CheckVerifier.newVerifier()
                .onFile("src/test/resources/AvoidOldDateApiTest.java")
                .withCheck(check)
                .verifyIssues();
    }

}
